package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntFunction;
import javax.swing.JOptionPane;
import model.Buscador;
import model.GerenciadorArquivos;
import model.Ordenador;
import model.Produto;
import model.Relatorio;
import view.TelaPrincipal;

// Liga a tela aos algoritmos
public class ControladorProdutos {

    private final TelaPrincipal tela;

    private ArrayList<Produto> produtos = new ArrayList<>();
    private List<Produto> resultado = new ArrayList<>();
    private HashMap<Integer, Produto> mapaId = new HashMap<>();
    private HashMap<String, List<Produto>> mapaCategoria = new HashMap<>();
    private boolean ordenadoPorId = false;

    public ControladorProdutos(TelaPrincipal tela) {
        this.tela = tela;
        tela.setControlador(this);
    }

    // Chamados pela tela
    public void carregar() {
        executar(() -> carregar((String) tela.getCbArquivo().getSelectedItem()));
    }

    public void exportar() {
        executar(() -> exportar("produtos_exportados.txt"));
    }

    public void ordenar() {
        executar(() -> ordenar((String) tela.getCbCampo().getSelectedItem(),
                (String) tela.getCbAlgoritmo().getSelectedItem()));
    }

    public void buscar() {
        executar(() -> buscar((String) tela.getCbTecnica().getSelectedItem(), tela.getTxtBusca().getText()));
    }

    public void gerarRelatorio() {
        executar(() -> {
            Relatorio.gerar("relatorio.txt");
            return "relatorio.txt gerado na pasta do projeto";
        });
    }

    // Executa e mostra o resultado
    private void executar(Operacao operacao) {
        try {
            String mensagem = operacao.rodar();
            tela.getLblTempo().setText(mensagem);
            tela.getModeloTabela().setProdutos(resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private interface Operacao {
        String rodar() throws Exception;
    }

    private String carregar(String arquivo) throws IOException {
        produtos = GerenciadorArquivos.ler(arquivo);
        long t0 = System.nanoTime();
        mapaId = Buscador.mapaPorId(produtos);
        long t = System.nanoTime() - t0;
        mapaCategoria = Buscador.mapaPorCategoria(produtos);
        ordenadoPorId = false;
        resultado = produtos;
        return produtos.size() + " produtos carregados | construção do HashMap: " + Relatorio.ms(t);
    }

    private String exportar(String arquivo) throws IOException {
        GerenciadorArquivos.salvar(produtos, arquivo);
        return produtos.size() + " produtos exportados para " + arquivo;
    }

    // Ordena e mede o tempo
    private String ordenar(String campo, String algoritmo) {
        Comparator<Produto> comparador = switch (campo) {
            case "Nome" -> Ordenador.POR_NOME;
            case "Preço" -> Ordenador.POR_PRECO;
            default -> Ordenador.POR_ID;
        };
        ArrayList<Produto> copia = new ArrayList<>(produtos);
        long t0 = System.nanoTime();
        if (algoritmo.equals("Insertion Sort")) {
            if (!Ordenador.insertionSort(copia, comparador, Relatorio.DOIS_MINUTOS)) {
                return algoritmo + " por " + campo + ": não concluído (> 2 min)";
            }
        } else {
            Ordenador.mergeSort(copia, comparador);
        }
        long t = System.nanoTime() - t0;
        produtos = copia;
        resultado = produtos;
        ordenadoPorId = campo.equals("Id");
        return algoritmo + " por " + campo + ": " + Relatorio.ms(t);
    }

    private String buscar(String tecnica, String texto) {
        if (tecnica.equals("Categoria")) {
            String chave = texto.trim().toLowerCase();
            double t = Buscador.tempoMedio(x -> {
                List<Produto> l = mapaCategoria.get(chave);
                return l == null ? null : l.get(0);
            }, new int[1000]);
            resultado = mapaCategoria.getOrDefault(chave, new ArrayList<>());
            return resultado.size() + " produtos na categoria | tempo médio: " + Relatorio.ns(t);
        }

        int id;
        try {
            id = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Informe um id numérico.");
        }
        // A binária precisa da lista ordenada por id
        if (tecnica.equals("Binária") && !ordenadoPorId) {
            throw new IllegalStateException("Ordene a lista por Id antes de usar a busca binária.");
        }

        IntFunction<Produto> busca = switch (tecnica) {
            case "Linear" -> x -> Buscador.linear(produtos, x);
            case "Binária" -> x -> Buscador.binaria(produtos, x);
            default -> x -> mapaId.get(x);
        };
        // Repete 1000 vezes e tira a média
        int[] ids = new int[1000];
        Arrays.fill(ids, id);
        double t = Buscador.tempoMedio(busca, ids);
        Produto p = busca.apply(id);
        resultado = p == null ? new ArrayList<>() : List.of(p);
        return (p == null ? "Id " + id + " não encontrado" : "Encontrado: " + p.getNome())
                + " | " + tecnica + " - tempo médio (1000 buscas): " + Relatorio.ns(t);
    }
}

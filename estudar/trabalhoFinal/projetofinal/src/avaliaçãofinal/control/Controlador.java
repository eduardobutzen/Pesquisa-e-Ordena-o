package avaliaçãofinal.control;

import avaliaçãofinal.model.Buscador;
import avaliaçãofinal.model.GerenciadorArquivos;
import avaliaçãofinal.model.Ordenador;
import avaliaçãofinal.model.Produto;
import avaliaçãofinal.model.Relatorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntFunction;

public class Controlador {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private List<Produto> resultado = new ArrayList<>();
    private HashMap<Integer, Produto> mapaId = new HashMap<>();
    private HashMap<String, List<Produto>> mapaCategoria = new HashMap<>();
    private boolean ordenadoPorId = false;

    public String carregar(String arquivo) throws IOException {
        produtos = GerenciadorArquivos.ler(arquivo);
        long t0 = System.nanoTime();
        mapaId = Buscador.mapaPorId(produtos);
        long t = System.nanoTime() - t0;
        mapaCategoria = Buscador.mapaPorCategoria(produtos);
        ordenadoPorId = false;
        resultado = produtos;
        return produtos.size() + " produtos carregados | construção do HashMap: " + Relatorio.ms(t);
    }

    public String exportar(String arquivo) throws IOException {
        GerenciadorArquivos.salvar(produtos, arquivo);
        return produtos.size() + " produtos exportados para " + arquivo;
    }

    public String ordenar(String campo, String algoritmo) {
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

    public String buscar(String tecnica, String texto) {
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
        if (tecnica.equals("Binária") && !ordenadoPorId) {
            throw new IllegalStateException("Ordene a lista por Id antes de usar a busca binária.");
        }

        IntFunction<Produto> busca = switch (tecnica) {
            case "Linear" -> x -> Buscador.linear(produtos, x);
            case "Binária" -> x -> Buscador.binaria(produtos, x);
            default -> x -> mapaId.get(x);
        };
        int[] ids = new int[1000];
        Arrays.fill(ids, id);
        double t = Buscador.tempoMedio(busca, ids);
        Produto p = busca.apply(id);
        resultado = p == null ? new ArrayList<>() : List.of(p);
        return (p == null ? "Id " + id + " não encontrado" : "Encontrado: " + p.getNome())
                + " | " + tecnica + " - tempo médio (1000 buscas): " + Relatorio.ns(t);
    }

    public String gerarRelatorio() throws IOException {
        Relatorio.gerar("relatorio.txt");
        return "relatorio.txt gerado na pasta do projeto";
    }

    public List<Produto> getResultado() {
        return resultado;
    }
}

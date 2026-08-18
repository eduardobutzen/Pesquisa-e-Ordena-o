package controller;

import java.util.ArrayList;
import java.util.List;
import model.Agitacao;
import model.Bolha;
import model.GeradorLista;
import model.Insercao;
import model.Resultado;
import model.Selecao;
import view.OrdenacaoView;

public class OrdenacaoController {

    private static final int TAMANHO_LISTA = 10000;

    private final OrdenacaoView view = new OrdenacaoView();

    public void executar() {
        List<Integer> listaBase = GeradorLista.gerar(TAMANHO_LISTA);
        view.exibirMensagem("Ordenando " + TAMANHO_LISTA + " itens, aguarde...");

        List<Resultado> resultados = new ArrayList<>();
        resultados.add(Bolha.ordenar(GeradorLista.copiar(listaBase)));
        resultados.add(Selecao.ordenar(GeradorLista.copiar(listaBase)));
        resultados.add(Insercao.ordenar(GeradorLista.copiar(listaBase)));
        resultados.add(Agitacao.ordenar(GeradorLista.copiar(listaBase)));

        view.exibirResultados(resultados);
    }
}

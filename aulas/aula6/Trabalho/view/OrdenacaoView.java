package view;

import java.util.List;
import model.Resultado;

public class OrdenacaoView {

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirResultados(List<Resultado> resultados) {
        System.out.println();
        for (Resultado resultado : resultados) {
            System.out.printf("%s - comparacoes: %d - trocas: %d - tempo (ms): %.3f%n",
                    resultado.getAlgoritmo(),
                    resultado.getQtdComparacoes(),
                    resultado.getQtdTrocas(),
                    resultado.getTempoMilissegundos());
        }
    }
}

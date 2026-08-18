package model;

import java.util.List;

public class Bolha {

    public static Resultado ordenar(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        long qtdComparacoes = 0, qtdTrocas = 0;

        long inicio = System.nanoTime();
        do {
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                }
            }
        } while (houveTroca);
        long tempo = System.nanoTime() - inicio;

        return new Resultado("Bolha", qtdComparacoes, qtdTrocas, tempo);
    }
}

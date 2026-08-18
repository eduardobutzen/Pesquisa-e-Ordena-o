package model;

import java.util.List;

public class Agitacao {

    public static Resultado ordenar(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        int ini = 0;
        int fim = lista.size();
        long qtdComparacoes = 0, qtdTrocas = 0;

        long inicio = System.nanoTime();
        do {
            houveTroca = false;
            for (int i = ini; i < fim - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                }
            }

            if (!houveTroca) {
                break;
            }
            fim--;

            houveTroca = false;
            for (int i = fim; i >= ini + 1; i--) {
                qtdComparacoes++;
                if (lista.get(i) < lista.get(i - 1)) {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i - 1));
                    lista.set(i - 1, tmp);
                }
            }
            ini++;

        } while (houveTroca);
        long tempo = System.nanoTime() - inicio;

        return new Resultado("Agitacao", qtdComparacoes, qtdTrocas, tempo);
    }
}

package model;

import java.util.List;

public class Insercao {

    public static Resultado ordenar(List<Integer> lista) {
        int i, j;
        int tmp;
        long qtdComparacoes = 0, qtdTrocas = 0;

        long inicio = System.nanoTime();
        for (i = 1; i < lista.size(); i++) {
            tmp = lista.get(i);
            for (j = i - 1; j >= 0; j--) {
                qtdComparacoes++;
                if (tmp < lista.get(j)) {
                    lista.set(j + 1, lista.get(j));
                    qtdTrocas++;
                } else {
                    break;
                }
            }
            lista.set(j + 1, tmp);
            qtdTrocas++;
        }
        long tempo = System.nanoTime() - inicio;

        return new Resultado("Insercao", qtdComparacoes, qtdTrocas, tempo);
    }
}

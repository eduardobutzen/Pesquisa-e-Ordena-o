package model;

import java.util.List;

public class Selecao {

    public static Resultado ordenar(List<Integer> lista) {
        int posMenor;
        int tmp;
        long qtdComparacoes = 0, qtdTrocas = 0;

        long inicio = System.nanoTime();
        for (int i = 0; i < lista.size() - 1; i++) {
            posMenor = i;
            for (int j = i + 1; j < lista.size(); j++) {
                qtdComparacoes++;
                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (i != posMenor) {
                qtdTrocas++;
                tmp = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, tmp);
            }
        }
        long tempo = System.nanoTime() - inicio;

        return new Resultado("Selecao", qtdComparacoes, qtdTrocas, tempo);
    }
}

package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntFunction;

public class Buscador {

    // Evita que o Java pule as buscas
    private static volatile int resultadoIgnorado;

    public static Produto linear(List<Produto> lista, int id) {
        for (Produto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static Produto binaria(List<Produto> listaOrdenadaPorId, int id) {
        int ini = 0;
        int fim = listaOrdenadaPorId.size() - 1;
        while (ini <= fim) {
            int meio = (ini + fim) / 2;
            Produto p = listaOrdenadaPorId.get(meio);
            if (p.getId() == id) {
                return p;
            } else if (p.getId() < id) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return null;
    }

    public static HashMap<Integer, Produto> mapaPorId(List<Produto> lista) {
        HashMap<Integer, Produto> mapa = new HashMap<>();
        for (Produto p : lista) {
            mapa.put(p.getId(), p);
        }
        return mapa;
    }

    public static HashMap<String, List<Produto>> mapaPorCategoria(List<Produto> lista) {
        HashMap<String, List<Produto>> mapa = new HashMap<>();
        for (Produto p : lista) {
            mapa.computeIfAbsent(p.getCategoria().toLowerCase(), k -> new ArrayList<>()).add(p);
        }
        return mapa;
    }

    public static double tempoMedio(IntFunction<Produto> busca, int[] ids) {
        int soma = 0;
        long melhor = Long.MAX_VALUE;
        for (int rodada = 0; rodada < 10; rodada++) {
            long inicio = System.nanoTime();
            for (int id : ids) {
                soma += busca.apply(id) == null ? 0 : 1;
            }
            melhor = Math.min(melhor, System.nanoTime() - inicio);
        }
        resultadoIgnorado = soma;
        return (double) melhor / ids.length;
    }
}

package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Algoritmos de ordenação
public class Ordenador {

    public static final Comparator<Produto> POR_NOME = (a, b) -> a.getNome().compareToIgnoreCase(b.getNome());
    public static final Comparator<Produto> POR_PRECO = (a, b) -> Double.compare(a.getPreco(), b.getPreco());
    public static final Comparator<Produto> POR_ID = (a, b) -> Integer.compare(a.getId(), b.getId());

    // Insertion Sort: para se passar do limite
    public static boolean insertionSort(List<Produto> v, Comparator<Produto> c, long limiteNanos) {
        long inicio = System.nanoTime();
        for (int i = 1; i < v.size(); i++) {
            Produto chave = v.get(i);
            int j = i - 1;
            // Abre espaço para a chave
            while (j >= 0 && c.compare(v.get(j), chave) > 0) {
                v.set(j + 1, v.get(j));
                j--;
            }
            v.set(j + 1, chave);
            if (System.nanoTime() - inicio > limiteNanos) {
                return false;
            }
        }
        return true;
    }

    // Merge Sort: divide ao meio e junta em ordem
    public static void mergeSort(List<Produto> v, Comparator<Produto> c) {
        if (v.size() < 2) {
            return;
        }
        int meio = v.size() / 2;
        List<Produto> esq = new ArrayList<>(v.subList(0, meio));
        List<Produto> dir = new ArrayList<>(v.subList(meio, v.size()));
        mergeSort(esq, c);
        mergeSort(dir, c);

        // Junta as duas metades em ordem
        int i = 0, j = 0, k = 0;
        while (i < esq.size() && j < dir.size()) {
            if (c.compare(esq.get(i), dir.get(j)) <= 0) {
                v.set(k++, esq.get(i++));
            } else {
                v.set(k++, dir.get(j++));
            }
        }
        while (i < esq.size()) {
            v.set(k++, esq.get(i++));
        }
        while (j < dir.size()) {
            v.set(k++, dir.get(j++));
        }
    }
}

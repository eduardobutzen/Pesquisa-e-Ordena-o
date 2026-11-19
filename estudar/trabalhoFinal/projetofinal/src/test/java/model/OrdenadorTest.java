package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class OrdenadorTest {

    @Test
    void insertionEMergeOrdenamIgualAoJava() {
        List<Comparator<Produto>> criterios = List.of(Ordenador.POR_NOME, Ordenador.POR_PRECO, Ordenador.POR_ID);
        Random sorteio = new Random(7);
        for (int rodada = 0; rodada < 50; rodada++) {
            List<Produto> lista = aleatorios(sorteio, sorteio.nextInt(300));
            for (Comparator<Produto> c : criterios) {
                List<Produto> esperado = new ArrayList<>(lista);
                esperado.sort(c);

                List<Produto> insertion = new ArrayList<>(lista);
                assertTrue(Ordenador.insertionSort(insertion, c, Relatorio.DOIS_MINUTOS));
                assertEquals(esperado, insertion);

                List<Produto> merge = new ArrayList<>(lista);
                Ordenador.mergeSort(merge, c);
                assertEquals(esperado, merge);
            }
        }
    }

    @Test
    void insertionParaQuandoPassaDoLimite() {
        List<Produto> lista = aleatorios(new Random(1), 100);
        assertFalse(Ordenador.insertionSort(lista, Ordenador.POR_PRECO, -1));
    }

    static List<Produto> aleatorios(Random sorteio, int quantidade) {
        List<Produto> lista = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            lista.add(new Produto(1000 + sorteio.nextInt(5000), "Produto " + sorteio.nextInt(50), "Categoria",
                    sorteio.nextInt(1000) / 10.0, sorteio.nextInt(500)));
        }
        return lista;
    }
}

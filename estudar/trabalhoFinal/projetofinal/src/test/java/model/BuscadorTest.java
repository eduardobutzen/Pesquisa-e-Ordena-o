package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class BuscadorTest {

    @Test
    void asTresBuscasConcordam() {
        List<Produto> lista = new ArrayList<>();
        for (int id = 1000; id < 1500; id += 3) {
            lista.add(new Produto(id, "P" + id, "Cat", 1.0, 1));
        }
        HashMap<Integer, Produto> mapa = Buscador.mapaPorId(lista);

        for (int id = 990; id < 1510; id++) {
            Produto esperado = Buscador.linear(lista, id);
            assertSame(esperado, Buscador.binaria(lista, id), "id " + id);
            assertSame(esperado, mapa.get(id), "id " + id);
            if ((id - 1000) % 3 != 0 || id < 1000 || id >= 1500) {
                assertNull(esperado);
            }
        }
    }

    @Test
    void mapaPorCategoriaIgnoraMaiusculas() {
        List<Produto> lista = List.of(
                new Produto(1, "A", "Livros", 1, 1),
                new Produto(2, "B", "Esportes", 1, 1),
                new Produto(3, "C", "Livros", 1, 1));
        HashMap<String, List<Produto>> mapa = Buscador.mapaPorCategoria(lista);
        assertEquals(2, mapa.get("livros").size());
        assertEquals(1, mapa.get("esportes").size());
    }
}

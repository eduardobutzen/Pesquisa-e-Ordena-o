package model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class BuscaKMPTest {

    private final BuscaKMP busca = new BuscaKMP();

    @Test
    void tabelaDeFalhaDoExemploClassico() {
        assertArrayEquals(new int[]{0, 0, 1, 2, 3, 0, 1},
                BuscaKMP.tabelaDeFalha("ababaca".toCharArray()));
    }

    @Test
    void encontraOcorrenciasSobrepostas() {
        List<Ocorrencia> r = busca.procurar("ararara", "arara", false);
        assertEquals(List.of(new Ocorrencia(0, 5), new Ocorrencia(2, 7)), r);
    }

    @Test
    void ignoraMaiusculasQuandoPedido() {
        assertEquals(3, busca.procurar("Casa casa CASA", "casa", false).size());
        assertEquals(1, busca.procurar("Casa casa CASA", "casa", true).size());
    }

    @Test
    void casosVazios() {
        assertTrue(busca.procurar("abc", "", false).isEmpty());
        assertTrue(busca.procurar("ab", "abc", false).isEmpty());
        assertTrue(busca.procurar(null, "a", false).isEmpty());
    }

    @Test
    void mesmoResultadoQueForcaBruta() {
        Random sorteio = new Random(42);
        for (int rodada = 0; rodada < 5000; rodada++) {
            String texto = aleatoria(sorteio, sorteio.nextInt(40));
            String padrao = aleatoria(sorteio, 1 + sorteio.nextInt(5));
            assertEquals(forcaBruta(texto, padrao), busca.procurar(texto, padrao, true),
                    "texto=" + texto + " padrao=" + padrao);
        }
    }

    private static String aleatoria(Random sorteio, int tamanho) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append("ab".charAt(sorteio.nextInt(2)));
        }
        return sb.toString();
    }

    private static List<Ocorrencia> forcaBruta(String texto, String padrao) {
        List<Ocorrencia> r = new ArrayList<>();
        for (int i = 0; i + padrao.length() <= texto.length(); i++) {
            if (texto.startsWith(padrao, i)) {
                r.add(new Ocorrencia(i, i + padrao.length()));
            }
        }
        return r;
    }
}

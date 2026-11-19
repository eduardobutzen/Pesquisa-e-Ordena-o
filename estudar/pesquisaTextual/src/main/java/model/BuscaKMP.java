package model;

import java.util.ArrayList;
import java.util.List;

public class BuscaKMP {

    public List<Ocorrencia> procurar(String texto, String padrao, boolean diferenciarMaiusculas) {
        List<Ocorrencia> encontradas = new ArrayList<>();
        if (texto == null || padrao == null || padrao.isEmpty() || padrao.length() > texto.length()) {
            return encontradas;
        }

        char[] t = preparar(texto, diferenciarMaiusculas);
        char[] p = preparar(padrao, diferenciarMaiusculas);
        int[] falha = tabelaDeFalha(p);

        // Quantas letras do padrão já batem
        int casados = 0;
        for (int i = 0; i < t.length; i++) {
            // Se não bate, volta no padrão usando a tabela
            while (casados > 0 && t[i] != p[casados]) {
                casados = falha[casados - 1];
            }
            if (t[i] == p[casados]) {
                casados++;
            }
            if (casados == p.length) {
                encontradas.add(new Ocorrencia(i - p.length + 1, i + 1));
                casados = falha[casados - 1];
            }
        }
        return encontradas;
    }

    public static int[] tabelaDeFalha(char[] padrao) {
        int[] falha = new int[padrao.length];
        int k = 0;
        for (int i = 1; i < padrao.length; i++) {
            while (k > 0 && padrao[i] != padrao[k]) {
                k = falha[k - 1];
            }
            if (padrao[i] == padrao[k]) {
                k++;
            }
            falha[i] = k;
        }
        return falha;
    }

    private char[] preparar(String s, boolean diferenciarMaiusculas) {
        char[] c = s.toCharArray();
        if (!diferenciarMaiusculas) {
            for (int i = 0; i < c.length; i++) {
                c[i] = Character.toLowerCase(c[i]);
            }
        }
        return c;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

// Busca de texto com o algoritmo KMP (Knuth-Morris-Pratt)
public class BuscaKMP {

    // Retorna todas as ocorrências do padrão no texto
    public List<Ocorrencia> procurar(String texto, String padrao, boolean diferenciarMaiusculas) {
        List<Ocorrencia> encontradas = new ArrayList<>();
        if (texto == null || padrao == null || padrao.isEmpty() || padrao.length() > texto.length()) {
            return encontradas;
        }

        char[] t = preparar(texto, diferenciarMaiusculas);
        char[] p = preparar(padrao, diferenciarMaiusculas);
        int[] falha = tabelaDeFalha(p);

        // casados = quantas letras do padrão já batem até a posição i
        int casados = 0;
        for (int i = 0; i < t.length; i++) {
            // Deu diferença: volta só no padrão, pela tabela de falha (o i nunca volta)
            while (casados > 0 && t[i] != p[casados]) {
                casados = falha[casados - 1];
            }
            if (t[i] == p[casados]) {
                casados++;
            }
            // Achou: continua de falha[] para também pegar ocorrências sobrepostas
            if (casados == p.length) {
                encontradas.add(new Ocorrencia(i - p.length + 1, i + 1));
                casados = falha[casados - 1];
            }
        }
        return encontradas;
    }

    // falha[i] = tamanho do maior prefixo do padrão que também é sufixo de padrao[0..i]
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

    // Minúsculas caractere por caractere para as posições baterem com o texto da tela
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

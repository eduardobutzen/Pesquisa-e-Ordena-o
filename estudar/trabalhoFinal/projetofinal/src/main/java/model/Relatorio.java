package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Gera o relatorio.txt
public class Relatorio {

    public static final long DOIS_MINUTOS = 120_000_000_000L;
    private static final String[] ARQUIVOS = {"produtos_1000.txt", "produtos_10000.txt", "produtos_50000.txt"};
    private static final String[] OPERACOES = {
        "Ordenação simples (por preço)",
        "Ordenação eficiente (por preço)",
        "Busca linear por id (média)",
        "Busca binária por id (média)",
        "Busca por HashMap (média)",
        "Construção do HashMap"
    };

    public static String ms(double nanos) {
        return String.format("%.3f ms", nanos / 1_000_000);
    }

    public static String ns(double nanos) {
        return String.format("%.0f ns", nanos);
    }

    public static void gerar(String saida) throws IOException {
        // Aquece o Java antes de medir
        for (int i = 0; i < 3; i++) {
            medir(ARQUIVOS[1]);
        }

        double[][] r = new double[ARQUIVOS.length][];
        for (int i = 0; i < ARQUIVOS.length; i++) {
            r[i] = medir(ARQUIVOS[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("RELATÓRIO DE TEMPOS\n\n");
        sb.append("Este relatório compara o tempo de ordenação por preço (Insertion Sort e Merge Sort)\n");
        sb.append("e o tempo de busca por id (linear, binária e HashMap) com 1.000, 10.000 e 50.000 produtos.\n");
        sb.append("Os tempos de busca são a média de 1000 buscas. ms = milissegundos, ns = nanossegundos.\n\n");
        String formato = "%-33s %-15s %-15s %s%n";
        sb.append(String.format(formato, "Operação", "1.000", "10.000", "50.000"));
        for (int op = 0; op < OPERACOES.length; op++) {
            String[] c = new String[3];
            for (int i = 0; i < 3; i++) {
                boolean busca = op >= 2 && op <= 4;
                c[i] = r[i][op] < 0 ? "não concluído (> 2 min)" : busca ? ns(r[i][op]) : ms(r[i][op]);
            }
            sb.append(String.format(formato, OPERACOES[op], c[0], c[1], c[2]));
        }

        Files.writeString(Path.of(saida), sb.toString(), StandardCharsets.UTF_8);
    }

    private static double[] medir(String arquivo) throws IOException {
        ArrayList<Produto> lista = GerenciadorArquivos.ler(arquivo);
        double[] r = new double[6];

        ArrayList<Produto> copia = new ArrayList<>(lista);
        long t0 = System.nanoTime();
        boolean concluiu = Ordenador.insertionSort(copia, Ordenador.POR_PRECO, DOIS_MINUTOS);
        r[0] = concluiu ? System.nanoTime() - t0 : -1;

        copia = new ArrayList<>(lista);
        t0 = System.nanoTime();
        Ordenador.mergeSort(copia, Ordenador.POR_PRECO);
        r[1] = System.nanoTime() - t0;

        int[] ids = new int[1000];
        Random sorteio = new Random(42);
        for (int i = 0; i < ids.length; i++) {
            ids[i] = lista.get(sorteio.nextInt(lista.size())).getId();
        }

        r[2] = Buscador.tempoMedio(id -> Buscador.linear(lista, id), ids);

        ArrayList<Produto> porId = new ArrayList<>(lista);
        Ordenador.mergeSort(porId, Ordenador.POR_ID);
        r[3] = Buscador.tempoMedio(id -> Buscador.binaria(porId, id), ids);

        HashMap<Integer, Produto> mapa = null;
        t0 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            mapa = Buscador.mapaPorId(lista);
        }
        r[5] = (System.nanoTime() - t0) / 10.0;

        HashMap<Integer, Produto> m = mapa;
        r[4] = Buscador.tempoMedio(id -> m.get(id), ids);
        return r;
    }
}

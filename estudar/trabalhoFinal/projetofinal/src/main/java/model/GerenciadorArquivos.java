package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Lê e salva os arquivos
public class GerenciadorArquivos {

    public static ArrayList<Produto> ler(String arquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Path.of(arquivo), StandardCharsets.UTF_8);
        ArrayList<Produto> lista = new ArrayList<>();
        // Pula o cabeçalho
        for (int i = 1; i < linhas.size(); i++) {
            String[] c = linhas.get(i).split(";");
            if (c.length == 5) {
                lista.add(new Produto(Integer.parseInt(c[0]), c[1], c[2],
                        Double.parseDouble(c[3]), Integer.parseInt(c[4])));
            }
        }
        return lista;
    }

    public static void salvar(List<Produto> lista, String arquivo) throws IOException {
        List<String> linhas = new ArrayList<>();
        linhas.add("id;nome;categoria;preco;estoque");
        for (Produto p : lista) {
            linhas.add(p.toLinha());
        }
        Files.write(Path.of(arquivo), linhas, StandardCharsets.UTF_8);
    }
}

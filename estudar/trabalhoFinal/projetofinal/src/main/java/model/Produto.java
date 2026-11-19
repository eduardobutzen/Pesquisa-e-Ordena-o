package model;

import java.util.Locale;

// Dados de um produto
public class Produto {
    private final int id;
    private final String nome;
    private final String categoria;
    private final double preco;
    private final int estoque;

    public Produto(int id, String nome, String categoria, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    // Linha no formato do arquivo
    public String toLinha() {
        return String.format(Locale.US, "%d;%s;%s;%.2f;%d", id, nome, categoria, preco, estoque);
    }
}

package model;

// Início e fim de um resultado
public record Ocorrencia(int inicio, int fim) {

    public int tamanho() {
        return fim - inicio;
    }
}

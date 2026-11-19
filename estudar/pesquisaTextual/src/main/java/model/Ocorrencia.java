package model;

public record Ocorrencia(int inicio, int fim) {

    public int tamanho() {
        return fim - inicio;
    }
}

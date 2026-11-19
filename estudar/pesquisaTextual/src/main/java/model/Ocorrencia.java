package model;

// Posição de um resultado no texto (início e fim)
public record Ocorrencia(int inicio, int fim) {

    public int tamanho() {
        return fim - inicio;
    }
}

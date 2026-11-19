package model;

// Posição de um resultado no texto (início e fim)
public record Ocorrencia(int inicio, int fim) {

    // Quantidade de caracteres da ocorrência
    public int tamanho() {
        return fim - inicio;
    }
}

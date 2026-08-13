public class Agitacao {

    public static void ordenar(int[] vetor) {
        int inicio = 0;
        int fim = vetor.length - 1;
        boolean trocou = true;

        while (trocou) {
            trocou = false;

            // Esquerda → direita
            for (int i = inicio; i < fim; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;

                    trocou = true;
                }
            }

            fim--;

            // Direita → esquerda
            for (int i = fim; i > inicio; i--) {
                if (vetor[i] < vetor[i - 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = temp;

                    trocou = true;
                }
            }

            inicio++;
        }
    }

    public static void main(String[] args) {

        int[] vetor = {5, 2, 8, 1, 3};

        ordenar(vetor);

        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
    }
}

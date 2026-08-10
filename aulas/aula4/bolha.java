public static void bolhaSimples(int[] vetor) {
    boolean trocou = true;

    while (trocou) {
        trocou = false;

        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                int temp = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = temp;

                trocou = true;
            }
        }
    }
}
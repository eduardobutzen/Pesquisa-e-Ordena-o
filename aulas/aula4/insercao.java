public static void insercao(int[] lista) {
    int i, j;
    int tmp;
    int qtdComparacoes = 0, qtdTrocas = 0;

    for (i = 1; i < lista.length; i++) {
        tmp = lista[i];

        for (j = i - 1; j >= 0; j--) {
            qtdComparacoes++;

            if (tmp < lista[j]) {
                lista[j + 1] = lista[j];
                qtdTrocas++;
            } else {
                break;
            }
        }

        lista[j + 1] = tmp;
        qtdTrocas++;
    }
}
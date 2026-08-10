public static void selecao(int[] lista) {
    int posMenor;
    int qtd_comparacoes = 0;
    int qtd_trocas = 0;

    for (int i = 0; i < lista.length - 1; i++) {
        posMenor = i;

        for (int j = i + 1; j < lista.length; j++) {
            qtd_comparacoes++;

            if (lista[j] < lista[posMenor]) {
                posMenor = j;
            }
        }

        if (i != posMenor) {
            qtd_trocas++;

            int tmp = lista[i];
            lista[i] = lista[posMenor];
            lista[posMenor] = tmp;
        }
    }
}
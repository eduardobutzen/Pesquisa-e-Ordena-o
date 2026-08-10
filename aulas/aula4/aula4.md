# Pesquisa e Ordenação (Continuação da Estrutura de dados)

## 10/08/2026

### Métodos de ordenação simples:

#### Bolha simples:
- Estável.
- Parte ordenada está no final da lista.
- Maior valor a cada passada passa para o final.

- __Exemplo:__
    - 1) while
    - 2) for

```
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
```

#### Seleção simples:
- Instável.
- Parte ordenada está no início da lista.
- A cada passada o, cada célula se seleciona ao menor valor.

- __Exemplo:__
    - 1) for
    - 2) for
```
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
```


#### Inserção simples:
- Instável.
- Parte ordenada está no início da lista.
- A cada valor da porção da direita é inserido na sua posição correta na porção da esquerda.

- __Exemplo:__
    - 1) for 
    - 2) while

```
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
```


### Teoria do caos:
- " Métodos instáveis constumam ser melhores que estáveis "
- A teoria do caos é um campo da matemática e da ciência que estuda sistemas dinâmicos regidos por leis determinísticas, mas que são altamente sensíveis a pequenas variações iniciais. Mudanças mínimas no ponto de partida podem gerar resultados imprevisíveis a longo prazo.

### MVC (Model, View, Controller)

- Model
    - Utilidade
        - popularLista

- View
    - ListaView
        - exibirLista
        - exibitTempo

- Controller
    - ListaController
        - listaBolha
        - listaSelecao
        - listaInsercao

    - Metodos:
        - popularLista(listaBolha)
        - popularLista(listaSelecao)
        - popularLista(ListaInsercao)
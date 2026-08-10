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
public static void selecaoSimples(int[] vetor) {
    for (int i = 0; i < vetor.length - 1; i++) {
        int menor = i;

        for (int j = i + 1; j < vetor.length; j++) {
            if (vetor[j] < vetor[menor]) {
                menor = j;
            }
        }

        int temp = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = temp;
    }
}
```


#### Insenção simples:
- Instável.
- Parte ordenada está no início da lista.
- A cada valor da porção da direita é inserido na sua posição correta na porção da esquerda.

- __Exemplo:__
    - 1) for 
    - 2) while

```
public static void insercaoSimples(int[] vetor) {
    for (int i = 1; i < vetor.length; i++) {
        int chave = vetor[i];
        int j = i - 1;

        while (j >= 0 && vetor[j] > chave) {
            vetor[j + 1] = vetor[j];
            j--;
        }

        vetor[j + 1] = chave;
    }
}
```


#### Teoria do caos:
- " Métodos instáveis constumam ser melhores que estáveis "
- A teoria do caos é um campo da matemática e da ciência que estuda sistemas dinâmicos regidos por leis determinísticas, mas que são altamente sensíveis a pequenas variações iniciais. Mudanças mínimas no ponto de partida podem gerar resultados imprevisíveis a longo prazo.
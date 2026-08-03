# Atividade de fixação
    1) pesquisar na literatura, internet ou IA Generativa sobre os métodos de ordenação e categoriza-los em:
        - algoritmo de memória interna ou memória externa
        - estabilidade (estável ou instável)
        - complexidade
        - porções de ordenação


### Bubble Sort (Bolha):
- Memória Interna
- Estável
- Complexidade: O(n²)
- Porção Ordenada: Final (maiores elementos vão para o final)

### Selection sort (Seleção):
- Memória interna
- Instável
- Complexidade: O(n²)
- Porção ordenada: Início (menores elementos vão sendo colocados no início)

### Inserction sort (Inserção):
- Memória interna
- Estável 
- Complexidade: O(n²)
- Porção ordenada: Início (mantém um prefixo já ordenado)

### Comb Sort (pente):
- Memória Interna
- Instável
- Complexidade: O(n²) (média melhor que Bubble)
- Porção ordenada: Final (semelhante ao Bubble, usando intervalos maiores)

### Shaker sor (Cocktail sort):
- Memória interna
- Estável 
- Complexidade: O(n²)
- Porção ordenada: Início e final (ordena nos dois sentidos)

### Shell short:
- Memória interna
- Instável
- Complexidade: Entre O(n log² n) e O(n²), dependendo da sequência de gaps
- Porção ordenada: Sublistas parciais; aproxima a ordenação até finalizar toda a lista

### Bucket sort:
- Memória interna (Ou externa em grandes volumes)
- Estável
- Complexidade: O(n + k) (caso médio)
- Porção ordenada: Baldes são ordenados individualmente e depois concatenados

### Radix sort:
- Memória interna
- Estável
- Complexidade: O(d(n + k))
- Porção ordenada: Ordena por dígitos, da menor para a maior significância (ou vice-versa)

### Heap sort: 
- Memória interna
- Instável
- Complexidade: O(n log n)
- Porção ordenada: Final (maior elemento é colocado no final a cada etapa)

### Merge Sort:
- Memória Interna (usa memória auxiliar)
- Estável 
- Complexidade: O(n log n)
- Porção ordenada: Mescla sublistas ordenadas até formar a lista completa

### Quick Sort:
- Memória interna
- Instável
- Complexidade: O(n log n) (médio), O(n²) (pior caso)
- Porção ordenada: Particiona a lista em torno de pivôs; não há uma extremidade fixa sendo ordenada
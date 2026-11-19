# Catálogo de Produtos (ordenação e busca)

Programa em Java Swing que carrega milhares de produtos de um arquivo texto, ordena com algoritmos
feitos à mão, busca por id e por categoria e mede o tempo de cada operação.

- **Carregar / Exportar**: lê `produtos_1000.txt`, `produtos_10000.txt` ou `produtos_50000.txt` e salva a lista na ordem atual em `produtos_exportados.txt`.
- **Ordenar** por nome, preço ou id, com **Insertion Sort** ou **Merge Sort**.
- **Buscar** por id com busca **linear**, **binária** ou **HashMap**, ou listar uma **categoria**.
- **Gerar relatório** cria o `relatorio.txt` com os tempos dos 3 arquivos.

## Estrutura (MVC)

```
src/main/java/
├── app/App.java                          ponto de entrada: cria a tela e o controlador
├── model/Produto.java                    um produto (id, nome, categoria, preço, estoque)
├── model/GerenciadorArquivos.java        leitura e escrita dos arquivos texto
├── model/Ordenador.java                  Insertion Sort e Merge Sort
├── model/Buscador.java                   busca linear, binária e por HashMap
├── model/Relatorio.java                  medições e geração do relatorio.txt
├── controller/ControladorProdutos.java   recebe os eventos e chama o model
├── view/TelaPrincipal.java               a tela, criada no editor visual do NetBeans
└── view/ProdutoTableModel.java           colunas da JTable
src/test/java/
└── model/                                testes (JUnit 5)
```

A tela (`view/TelaPrincipal`) é um JFrame Form do NetBeans e pode ser editada na aba **Design**.
Os eventos de cada botão ficam na parte **Source** dela e só chamam o controlador.

`GeradorProdutos.java`, na pasta do projeto, é o gerador dos arquivos de dados fornecido junto com o trabalho.

## Custo dos algoritmos

| | Melhor caso | Pior caso |
|---|---|---|
| Insertion Sort | O(n) | O(n²) |
| Merge Sort | O(n log n) | O(n log n) |
| Busca linear | O(1) | O(n) |
| Busca binária (lista ordenada por id) | O(1) | O(log n) |
| HashMap | O(1) em média | — (montar o mapa custa O(n)) |

## Como rodar

No NetBeans: abra a pasta `projetofinal` como projeto, depois use **F6** para rodar e **Alt+F6** para os testes.

Pelo terminal, se você tiver o Maven instalado:

```
mvn test
mvn compile exec:java
```

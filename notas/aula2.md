# Pesquisa e Ordenação (Continuação da Estrutura de dados) - aula 2.
# 30/07/2026

### Ordenação:

- Ordenar é organizar uma estrutura a partir de um ou mais índices ou chaves.
- Por que ordenar?
  - A ordenação é um recurso que adicione velocidade à pesquisa (otimização).
- Pesquisar: Localizar algum dado dentro de uma estrutura por meio de uma chave.
- Recuperar: significa o processo de buscar dados com relevância (semântica ou significado).

- Em computação, Search e Retrieve representam etapas diferentes da recuperação de informações:

#### Search (Busca):                                                                     
- Localiza documentos ou registros potencialmente relevantes para uma consulta.
- Enfatiza a descoberta.                                            
- Exemplo: pesquisar por "redes neurais".
                   
#### Retrieve (Recuperação):
- Obtém o conteúdo dos documentos encontrados ou seus trechos relevantes.
- Enfatiza o acesso e retorno da informação.
- Exemplo: abrir o artigo encontrado e recuperar os parágrafos correspondentes.
- Cria uma semântica/ligação entre palavras para não ser necessário escrever exatamente a palavra pesquisada (pesquisa com relevância)

### CRUD:
- Create
- Retrieve
- Uptade
- Delete

### Complexidade:
- é o esforço computacional de um algoritmo, ou seja, quanto de recurso ele aloca para realizar sua ou suas tarefas.
    - alta complexidade: mais esforço  
    - baixa complexidade: menos esforço
    - Como medir complexidade?
      - __EM ORDENAÇÃO:__ Se mede pela __Quantidade de comparações + quantidade de trocas__.
      - __EM PESQUISA:__ Se mede pela __quantidade comparações__.
     
    - Notação Big O:
      - O(n!) ------------------------------ __Maior complexidade__
      - O(n^x) 
      - O(log n + n) 
      - O(n)
      - O(log n)----------------------------__Menor complexidade__
     
  ### Estabilidade:
  - Estabilidade é o quanto a estrutura é desordenada até chegar a ordenação (O quanto bagunça).
  - Se o método esculhamba o vetor, ele tem menor estabilidade.
  - Em sua grande maioria, os __melhores__ algoritmos de ordenação são __instáveis__.
  

     

Pesquisa e Ordenação (Continuação da Estrutura de dados)
14/10/2026
HashSet e HashMap em Java

A principal diferença entre HashSet e HashMap está na forma como armazenam os dados:

HashSet: armazena elementos únicos, sem permitir duplicatas.
HashMap: armazena pares de chave e valor (key-value), em que as chaves são únicas.

Ambos fazem parte do Java Collections Framework e utilizam tabelas hash para realizar operações de inserção, busca e remoção geralmente em tempo O(1).

1. HashSet

O HashSet é utilizado quando precisamos armazenar uma coleção de elementos sem repetições.

Exemplo: armazenar nomes de alunos sem duplicatas.

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();

        alunos.add("Ana");
        alunos.add("João");
        alunos.add("Maria");
        alunos.add("Ana"); // Elemento duplicado

        System.out.println(alunos);
        System.out.println(alunos.contains("João"));
    }
}


Possível saída:

[Ana, João, Maria]
true


Observe que "Ana" foi adicionada duas vezes, mas aparece apenas uma vez no conjunto.

Principais características do HashSet
Não permite elementos duplicados.
Não garante a ordem de inserção dos elementos.
Permite um elemento null.
Utiliza add() para adicionar elementos.
Utiliza contains() para verificar se um elemento existe.
Utiliza remove() para remover um elemento.
2. HashMap

O HashMap é utilizado quando precisamos associar uma chave a um valor.

Exemplo: armazenar o nome de um aluno e sua nota.

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> notas = new HashMap<>();

        notas.put("Ana", 9.5);
        notas.put("João", 7.0);
        notas.put("Maria", 8.5);

        System.out.println(notas.get("Ana"));

        notas.put("Ana", 10.0); // Atualiza a nota

        System.out.println(notas.get("Ana"));
    }
}


Saída:

9.5
10.0


Nesse exemplo:

"Ana" é a chave.
9.5 é o valor inicialmente associado à chave.
Ao inserir novamente a chave "Ana", o valor anterior é substituído por 10.0.
Principais características do HashMap
Armazena pares de chave e valor.
Não permite chaves duplicadas.
Permite valores repetidos.
Não garante a ordem de inserção dos elementos.
Permite uma chave null e vários valores null.
Utiliza put() para inserir ou atualizar um par.
Utiliza get() para consultar um valor pela chave.
Utiliza containsKey() para verificar se uma chave existe.
Utiliza remove() para remover um par pela chave.
3. Comparação entre HashSet e HashMap
Característica	HashSet	HashMap
Armazenamento	Elementos únicos	Pares de chave e valor
Duplicatas	Não permite elementos repetidos	Não permite chaves repetidas
Valores repetidos	Não se aplica	Permitidos
Inserção	add(elemento)	put(chave, valor)
Consulta	contains(elemento)	get(chave)
Verificação de existência	contains(elemento)	containsKey(chave)
Remoção	remove(elemento)	remove(chave)
Ordem garantida	Não	Não
Elementos ou chaves null	Um elemento null	Uma chave null
4. Exemplo prático

Imagine que precisamos controlar os produtos de uma loja.

Caso A: armazenar produtos sem repetição

Podemos utilizar um HashSet quando queremos guardar apenas os nomes dos produtos cadastrados.

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> produtos = new HashSet<>();

        produtos.add("Notebook");
        produtos.add("Mouse");
        produtos.add("Teclado");
        produtos.add("Mouse");

        System.out.println(produtos);
    }
}


O conjunto terá três produtos únicos: Notebook, Mouse e Teclado.

Caso B: armazenar a quantidade em estoque

Podemos utilizar um HashMap quando precisamos associar cada produto à sua quantidade.

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> estoque = new HashMap<>();

        estoque.put("Notebook", 10);
        estoque.put("Mouse", 25);
        estoque.put("Teclado", 15);

        System.out.println(estoque.get("Mouse"));
    }
}


Saída:

25


Nesse caso, o nome do produto é a chave e a quantidade em estoque é o valor.

5. Relação entre HashSet e HashMap

Um detalhe importante é que o HashSet utiliza internamente um HashMap para armazenar seus elementos.

Quando adicionamos um elemento ao HashSet, ele é utilizado como chave no mapa interno, associado a um objeto auxiliar.

Isso permite aproveitar a estrutura de tabela hash para verificar a existência de elementos e impedir duplicatas.

Normalmente, não precisamos implementar essa lógica manualmente: basta utilizar o HashSet.

6. Complexidade das operações

Em condições normais, considerando uma boa distribuição dos códigos hash, as operações apresentam as seguintes complexidades médias:

Operação	HashSet	HashMap
Inserção	O(1)	O(1)
Busca	O(1)	O(1)
Remoção	O(1)	O(1)

Essas complexidades são médias, não garantias para todas as situações. Colisões de hash e outros fatores podem afetar o desempenho.

7. Quando utilizar cada estrutura?

Utilize o HashSet quando precisar:

Armazenar elementos únicos.
Eliminar duplicatas de uma coleção.
Verificar rapidamente se um elemento já existe.
Controlar IDs ou códigos que não devem se repetir.

Utilize o HashMap quando precisar:

Associar uma chave a um valor.
Consultar informações por meio de uma chave.
Contabilizar ocorrências de elementos.
Armazenar relações como produto → quantidade ou aluno → nota.
8. Outras estruturas relacionadas

Caso seja necessário manter uma ordem específica, existem outras implementações:

LinkedHashSet: mantém a ordem de inserção dos elementos.
LinkedHashMap: mantém a ordem de inserção das chaves.
TreeSet: mantém os elementos ordenados.
TreeMap: mantém as chaves ordenadas.
Resumo

A principal diferença é:

HashSet: armazena elementos únicos.
HashMap: armazena associações entre chaves únicas e valores.

Ambas as estruturas são úteis quando precisamos realizar buscas eficientes, mas a escolha depende da forma como os dados serão organizados e consultados.
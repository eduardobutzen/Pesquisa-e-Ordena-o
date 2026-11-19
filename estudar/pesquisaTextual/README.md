# Pesquisa Textual (KMP)

Programa em Java Swing que procura uma palavra ou trecho dentro de um texto enquanto você digita.
Ele destaca todas as ocorrências e permite navegar entre elas.

- Todas as ocorrências ficam em **amarelo**. A selecionada fica em **laranja**.
- **Anterior / Próxima** (ou **Enter** no campo de busca) passam de uma ocorrência para outra e voltam ao começo no fim.
- A busca é refeita quando muda o **termo** *e também* quando muda o **texto**.
- A opção **Diferenciar maiúsculas** liga ou desliga a diferença entre `Casa` e `casa`.
- Ocorrências **sobrepostas** contam: `arara` aparece 2 vezes em `ararara`.

## Estrutura (MVC)

```
src/main/java/
├── app/App.java                     ponto de entrada: cria tela, modelo e controlador
├── model/BuscaKMP.java              o algoritmo de busca (Knuth-Morris-Pratt)
├── model/Ocorrencia.java            posição (início, fim) de cada resultado
├── controller/ControladorBusca.java eventos, destaque e navegação
└── view/TelaBusca.java              a tela, criada no editor visual do NetBeans
src/test/java/
└── model/BuscaKMPTest.java          testes (JUnit 5)
```

A tela (`view/TelaBusca`) é um JFrame Form do NetBeans e pode ser editada na aba **Design**.

## O algoritmo: Knuth-Morris-Pratt (KMP)

### Por que não a busca ingênua?

A busca ingênua (força bruta) testa o padrão em cada posição do texto. Quando encontra uma diferença,
anda uma casa e recomeça a comparar do início do padrão. No pior caso faz **n × m** comparações
(n = tamanho do texto, m = tamanho do padrão).

Exemplo ruim: procurar `aaaab` em `aaaaaaaaaa...`. Em cada posição ela compara 4 letras `a` antes de falhar.

### A ideia do KMP

Quando dá diferença, as letras que já casaram estão no próprio padrão, então já são conhecidas.
O KMP usa isso para **nunca voltar no texto**: ele só volta no padrão, até o maior trecho que ainda serve.

Essa informação fica pré-calculada na **tabela de falha**:

> `falha[k]` = tamanho do maior prefixo do padrão que também é sufixo de `padrao[0..k]`
> (sem contar o próprio trecho inteiro).

Exemplo com `ababaca`:

| k | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|---|
| padrão | a | b | a | b | a | c | a |
| falha[k] | 0 | 0 | 1 | 2 | 3 | 0 | 1 |

Em `k = 4` o trecho é `ababa`. O prefixo `aba` também é sufixo, então `falha[4] = 3`.
Se der diferença logo depois desse ponto, o algoritmo continua considerando que `aba` já casou,
em vez de recomeçar do zero.

### Custo

| | Pré-processamento | Busca | Total |
|---|---|---|---|
| Força bruta | — | O(n · m) | O(n · m) |
| KMP | O(m) | O(n) | **O(n + m)** |

### Maiúsculas e minúsculas

Para ignorar maiúsculas, o texto é convertido **caractere por caractere** com `Character.toLowerCase`.
Assim as posições encontradas continuam batendo com as do texto na tela.
`String.toLowerCase()` pode mudar o tamanho da string em alguns idiomas: o `İ` turco, por exemplo, vira 2 caracteres.

## Como rodar

No NetBeans: abra a pasta `pesquisaTextual` como projeto, depois use **F6** para rodar e **Alt+F6** para os testes.

Pelo terminal, se você tiver o Maven instalado:

```
mvn test
mvn compile exec:java
```

# Pesquisa e Ordenação (Continuação da Estrutura de dados)

## 12/11/2026


#### Sistema encurtador

1) Entrar link original (www.uf.edu.com.br)
2) Gerar hash (revisão) do link original
3) Armazenar em hashmap:
    - chave: hash de geração
    - Conteúdo: {Link original; cliques}

4) Acessar link encurtado: http://<DOMINIO>/hash
    - Informar o link encurtado
    - Pesquisar o hashmap pelo hash
    - Devolver o link original 

from Pente import pente

lista = [5, 3, 8, 1, 9, 2, 7, 4, 6, 0]

print("Antes......: " + str(lista))

qtd_comparacoes, qtd_trocas = pente(lista)

print("Depois.....: " + str(lista))
print("Comparacoes: " + str(qtd_comparacoes))
print("Trocas.....: " + str(qtd_trocas))

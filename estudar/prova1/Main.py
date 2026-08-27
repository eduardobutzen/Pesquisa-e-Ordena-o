from Pente import pente

lista = [5, 3, 8, 1, 9, 2, 7, 4, 6, 0]

print("Antes: " + str(lista))

qnt_comparacoes, qnt_trocas = pente(lista)

print("depois: " + str(lista))
print("Comparações: " + str(comparacoes))
print("Trocas: " + str(trocas))

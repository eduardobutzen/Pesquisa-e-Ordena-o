def pente(lista):
    houve_troca = True
    comparacoes = 0
    trocas = 0
    distancia = len(lista)
    while (houve_troca or distancia < 1):
        distancia = int(distancia / 1.3)
        if(distancia < 1):
            distancia = 1
        houve_troca = False
        for i in range(0, len(lista) - distancia):
            comparacoes += 1
            if(lista[i] > lista [i + distancia]):
                trocas += 1
                houve_troca = True
                tmp = lista[i]
                lista[i] = lista[i + distancia]
                lista[i + distancia] = tmp

    return comparacoes, trocas


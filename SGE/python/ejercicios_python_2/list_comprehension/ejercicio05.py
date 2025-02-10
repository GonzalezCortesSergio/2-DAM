def incide_valor():

    lista = ["hi", 4, 8.99, "apple", ('t, b', 'n')]
    lista_indice_valor = []

    for elemento in lista:

        lista_indice_valor.append((lista.index(elemento), elemento))

    lista_indice_valor = list(map(lambda elemento: (lista.index(elemento), elemento), lista))

    return lista_indice_valor

print(incide_valor())

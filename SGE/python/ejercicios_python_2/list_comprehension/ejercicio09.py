def numeros_coincidentes():

    list_a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    list_b = [2, 7, 1, 12]

    lista = list(map(lambda numero: (numero, list_b[list_b.index(numero)]) if numero in list_b else None, list_a))
    lista = list(filter(lambda numero: numero != None, lista))

    return lista

print(numeros_coincidentes())
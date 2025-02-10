def numeros_comunes():

    lista_a = [1, 2, 3, 4]
    lista_b = [2, 3, 4, 5]

    return list(filter(lambda numero: lista_b.__contains__(numero), lista_a))

print(numeros_comunes())



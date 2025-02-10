def numeros_con_3():

    lista = [i for i in range(1, 1001)]

    numeros = list(filter(lambda numero: str(numero).__contains__("3"), lista))

    return numeros

print(numeros_con_3())
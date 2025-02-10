def numeros_divisibles():

    numeros = range(1, 1001)

    divisibles = [num for num in numeros if num % 1 != 0]

    return divisibles

print(numeros_divisibles())
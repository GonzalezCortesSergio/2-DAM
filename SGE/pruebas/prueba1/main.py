
import math

numeros = [1, 2, 3, 4]
print(numeros)

datos = [4, "una cadena", -15, 3.14, math.pi]
print(datos)

a = [1, 2, 3]
b = [4, 5, 6]
c = [7, 8, 9]

r = [a, b, c]

for element in r:
    for sub_element in element:
        print(sub_element)
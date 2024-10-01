import math

# Ejercicio 1

def area_rectangulo(base, altura):

    return base * altura

print(f"El área del rectángulo es {area_rectangulo(15, 10)}")


# Ejercicio 2

def area_circulo(radio) :

    return math.pi * radio**2

print(f"El área del círculo es: {area_circulo(5)}")



# Ejercicio 3

def relacion(a, b) :

    if(a > b):
        return 1
    

    if (a < b):

        return -1
    
    else:
        return 0
    
print(relacion(5, 10), relacion(10, 5), relacion(5, 5))



# Ejercicio 4

def intermedio(a, b):

    return (a + b) / 2

print(f"El número intermedio de -12 y 24 es {intermedio(-12, 24)}")


# Ejercicio 5

def recortar(numero, minimo, maximo) :

    if(numero < minimo):
        return minimo

    if(numero > maximo):
        return maximo

    else:
        return numero 

print(f"El resultado es {recortar(15, 0, 10)}") 

# Ejercicio 6

def separar(lista: list) :

    lista.sort()
    
    pares = []
    impares = []

    for num in lista:
        if(num % 2 == 0):
            pares.append(num)

        elif(num % 2 == 1):
            impares.append(num)

    return pares, impares

pares, impares = separar([6, 5, 2, 1, 7])

print(pares)
print(impares)

import math

def numeros_oracion():

    oracion = "En 1984 hubo 13 casos de protesta con más de 1000 asistentes"

    numeros = [numero for numero in oracion if numero.isnumeric()]

    return numeros

print(numeros_oracion())
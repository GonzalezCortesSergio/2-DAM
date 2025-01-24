from main import *

lista_pares = [("R", "S"), ("S", "R"), ("P", "S")]

lista_pares_2 = [("S", "S"), ("S", "S"), ("S", "S")]

lista_pares_3 = [("S", "R"), ("R", "S"), ("S", "P")]

print(ganador(lista_pares))
print(ganador(lista_pares_2))
print(ganador(lista_pares_3))
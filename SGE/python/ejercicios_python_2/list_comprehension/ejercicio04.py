import re

def lista_consonantes():

    cadena = "A los yaks amarillos les gusta gritar y bostezar y ayer cantaban mientras comían ñames asquerosos"

    expresion = r'[^AEIOU|aeiou|ÁÉÍÓÚ|áéíóú\s*]'

    return re.findall(expresion, cadena)


print(lista_consonantes())
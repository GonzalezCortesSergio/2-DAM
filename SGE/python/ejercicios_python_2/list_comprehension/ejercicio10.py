def palabras_menos_4_letras(string: str):

    palabras = string.split(" ")

    palabras_menos_4_letras = list(filter(lambda palabra: len(palabra) < 4, palabras))

    return palabras_menos_4_letras

print(palabras_menos_4_letras("Altramuz hola as pas mas paz ladras"))
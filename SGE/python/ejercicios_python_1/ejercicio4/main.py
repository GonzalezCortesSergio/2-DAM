def una_palabra_mayuscula(str: str):

    str = str[0].upper() + str[1:len(str)]

    return str


def poner_palabras_mayuscula(str: str):

    str = str.split(" ")

    for cadena in str:
        str[str.index(cadena)] = una_palabra_mayuscula(cadena)
    
    str = " ".join(str)

    return str


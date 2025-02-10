def contar_espacios(string: str):

    return len(list(string.split(" "))) - 1

print(contar_espacios("Hola como estás Manolo Jacinto"))
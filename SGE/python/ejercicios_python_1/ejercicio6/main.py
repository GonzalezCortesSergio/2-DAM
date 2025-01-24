def elementos_comunes(array_1: list, array_2: list, booleano: bool):
    
    array_devuelto = set()

    if(booleano):

        for elemento_1 in array_1:

            if(elemento_1 in array_2):
                array_devuelto.add(elemento_1)
            
        for elemento_2 in array_2:

            if(elemento_2 in array_1):

                array_devuelto.add(elemento_2)

    if(not booleano):

        for elemento_1 in array_1:

            if(elemento_1 not in array_2):
                array_devuelto.add(elemento_1)
            
        for elemento_2 in array_2:

            if(elemento_2 not in array_1):
                array_devuelto.add(elemento_2)
    
    array_devuelto = list(array_devuelto)
    
    return array_devuelto
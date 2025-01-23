def comprobar_expresion(expresion: str):

    correcto = True
    expresion_reves = expresion[::-1]

    if(expresion[0] + expresion[-1] != "{}"):
        return False
    
    if(expresion.__contains__("[") and expresion.find("]") == -1
       and correcto == True):

        correcto = False
    
    if (expresion.__contains__("(") and expresion.find(")") == -1
        and correcto == True):

        correcto = False

    if (expresion_reves.__contains__("]") and expresion.find("[") == -1
       and correcto == True):
        correcto = False
    
    if (expresion_reves.__contains__(")") and expresion.find("(") == -1
       and correcto == True):
        correcto = False
    
    return correcto

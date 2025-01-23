
def evaluar_atleta(acciones: list, pista: str):

    superado = True
    pista_list = list(pista)

    for parte in pista_list:

        if(acciones[pista_list.index(parte)] == "run" and parte == "|"):
            superado = False
            pista_list[pista_list.index(parte)] = "/"

        if(acciones[pista_list.index(parte)] == "jump" and parte == "_"):
            superado = False
            pista_list[pista_list.index(parte)] = "x"
    
    pista = "".join(pista_list)
    print(pista)

    return superado

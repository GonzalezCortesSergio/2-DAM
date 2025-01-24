

def ganador(lista_pares: list):

    victoria_1 = 0
    vitoria_2 = 0

    for par in lista_pares:

        match(par):
            case ("R", "S"):
                victoria_1+=1
            case ("S", "R"):
                vitoria_2+=1
            case ("S", "P"):
                victoria_1+=1
            case ("P", "S"):
                vitoria_2+=1
            case ("P", "R"):
                victoria_1+=1
            case ("R", "P"):
                vitoria_2+=1
    
    if(victoria_1 > vitoria_2):

        return "Player 1"
    
    if(vitoria_2 > victoria_1):

        return "Player 2"
    
    return "Tie"
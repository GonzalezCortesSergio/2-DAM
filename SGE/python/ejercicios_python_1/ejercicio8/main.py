
def calcular_resultado(ejercito_1: list, ejercito_2: list):

    razas_bondadosas = {

        "Peloso": 1,
        "Sureño bueno": 2,
        "Enano": 3,
        "Númenóreano": 4,
        "Elfo": 5
    }

    razas_malvadas = {

        "Sureño malo": 2,
        "Orco": 2,
        "Goblin": 2,
        "Huargo": 3,
        "Troll": 5
    }

    valor_ejercito_1 = sum(list(map(lambda raza: razas_bondadosas[raza], ejercito_1)))

    valor_ejercito_2 = sum(list(map(lambda raza: razas_malvadas[raza], ejercito_2)))

    if(valor_ejercito_1 > valor_ejercito_2):
        return "Gana el bien"
    
    if(valor_ejercito_2 > valor_ejercito_1):
        return "Gana el mal"
    
    return "Empate"
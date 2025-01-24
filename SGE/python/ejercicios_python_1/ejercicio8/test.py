from main import *

ejercito_bueno_1, ejercito_malo_1 = ["Sureño bueno", "Enano", "Peloso", "Elfo"], ["Orco", "Troll", "Goblin"]

print(calcular_resultado(ejercito_bueno_1, ejercito_malo_1))


ejercito_bueno_2, ejercito_malo_2 = ["Enano"], ["Troll", "Huargo"]

print(calcular_resultado(ejercito_bueno_2, ejercito_malo_2))

print(calcular_resultado([], []))
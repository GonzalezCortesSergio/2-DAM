import csv

def cargar_fichero(fichero):

    result = []

    with open(fichero, "r+", encoding="utf-8") as csv_file:
        
        lector = csv.reader(csv_file)

        next(lector)

        for x in lector:
          
            nombre = x[0]
            final = x[1]
            maximo = x[2]
            minimo = x[3]
            volumen = x[4]
            efectivo = x[5]

            result.append(
                {
                    "nombre": nombre,
                    "final": final,
                    "maximo": maximo,
                    "minimo": minimo,
                    "volumen": volumen,
                    "efectivo": efectivo
                }
            )
    return result

print(cargar_fichero("ficheros/ejercicio02/cotizacion.csv"))


def crear_fichero():

    lista = cargar_fichero("ficheros/ejercicio02/cotizacion.csv")

    fichero_nuevo = open("ficheros/ejercicio02/media.csv", "w+", encoding="utf-8")

    writer = csv.writer(fichero_nuevo)
    writer.writerow(["Mínimo", "Máximo", "Media_Máximo", "Media_Mínimo"])

    minimos = list(map(lambda valor: float(valor["minimo"]), lista))
    maximos = list(map(lambda valor: float(valor["minimo"]), lista))

    minimo = min(minimos)
    maximo = max(maximos)

    media_minimos = (sum(minimos)) / len(minimos)
    media_maximos = (sum(maximos)) / len(maximos)


    writer.writerow([minimo, maximo, media_minimos, media_maximos])

    fichero_nuevo.close()

crear_fichero()
        

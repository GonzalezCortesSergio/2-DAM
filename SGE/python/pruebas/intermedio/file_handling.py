### File handling ###

# .txt file

import os
import json
import csv

fichero = open("intermedio/my_file.txt", "w+")
fichero.write("Mi nombre es Sergio\n Tengo 19 años\n Mi lenguaje preferido es Python")

#print(fichero.read())
#print(fichero.read(10))
#print(fichero.readline())
#print(fichero.readline())
#print(fichero.readlines())

for linea in fichero.readlines():
    print(linea)

fichero.write("\nAunque también me gusta java")

for line in fichero.readlines():

    print(line)

fichero.close()

with open("intermedio/my_file.txt", "a") as otro_fichero:

    otro_fichero.write("\nY kotlin")

os.remove("intermedio/my_file.txt")


#.json

json_file = open("intermedio/my_file.json", "w+")

json_text = {
    "nombre": "Sergio",
    "apellido": "González",
    "edad": 19,
    "lenguajes": ["Python", "Java", "Kotlin", "JavaScrtipt"]
}

json.dump(json_text, json_file, indent=4, )

json_file.close()



json_dict = json.load(open("intermedio/my_file.json"))
print(json_dict)

print(json_dict["nombre"])


#.csv file

csv_file = open("intermedio/my_file.csv", "w+")

csv_writer = csv.writer(csv_file)

csv_writer.writerow(["Nombre", "Apellidos", "Edad", "Idiomas"])
csv_writer.writerow(["Sergio", "González Cortés", "19", ["Español", "Inglés", "Catalán"]])
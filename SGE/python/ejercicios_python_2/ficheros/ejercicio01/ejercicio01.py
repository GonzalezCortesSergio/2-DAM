import csv


class Alumno:

    def __init__(self, nombre, apellidos, curso, notas: dict):
        self.nombre = nombre
        self.apellidos = apellidos
        self.curso = curso
        self.notas = notas

    def get_nota_media(self):

        return (sum(self.notas.values())) / len(list(self.notas.values()))


    def __str__(self):

        return f"Alumno: [Nombre: {self.nombre}, Apellidos: {self.apellidos}, Curso: {self.curso}, Nota media: {self.get_nota_media()}]"



def cargar_listado():

    alumnos = []

    with open("ficheros/ejercicio01/notas.csv", encoding="utf-8") as fichero:

        lector = csv.reader(fichero)

        next(lector)

        for alumno in lector:

            alumnos.append(Alumno(alumno[1], alumno[0], alumno[2], 
                                  {"FH": int(alumno[3]), 
                                   "LM": int(alumno[4]), 
                                   "ISO": int(alumno[5]), 
                                   "FOL": int(alumno[6]), 
                                   "PAR": int(alumno[7]), 
                                   "SGBD": int(alumno[8])}))
            

    return alumnos


def mostrar_listado(lista):

    for alumno in lista:

        print(alumno)


def buscar_por_curso_asignatura(curso: str, asignatura: str):

    lista = [alumno for alumno in cargar_listado() if alumno.curso == curso]

    lista = list(filter(lambda alumno: alumno.notas[asignatura] != 0, lista))

    lista = list(map(lambda alumno: (alumno.__str__(), f"Nota {asignatura}: {alumno.notas[asignatura]}"), lista))

    return lista


def porcentaje_aprobados_curso(curso: str):

    lista_alumnos = cargar_listado()

    aprobados_fh = [alumno for alumno in lista_alumnos if alumno.curso == curso and alumno.notas["FH"] >= 5]
    aprobados_fh = (len(aprobados_fh) / len(lista_alumnos)) * 100

    aprobados_lm = [alumno for alumno in lista_alumnos if alumno.curso == curso and alumno.notas["LM"] >= 5]
    aprobados_lm = (len(aprobados_lm) / len(lista_alumnos)) * 100 

    aprobados_iso = [alumno for alumno in lista_alumnos if alumno.curso == curso and alumno.notas["ISO"] >= 5]
    aprobados_iso = (len(aprobados_iso) / len(lista_alumnos)) * 100

    aprobados_fol = [alumno for alumno in lista_alumnos if alumno.curso == curso and alumno.notas["FOL"] >= 5]
    aprobados_fol = (len(aprobados_fol) / len(lista_alumnos)) * 100

    aprobados_par = [alumno for alumno in lista_alumnos if alumno.curso == curso and alumno.notas["PAR"] >= 5]
    aprobados_par = (len(aprobados_par) / len(lista_alumnos)) * 100

    aprobados_sgbd = [alumno for alumno in lista_alumnos if alumno.curso == curso and alumno.notas["SGBD"] >= 5]
    aprobados_sgbd = (len(aprobados_sgbd) / len(lista_alumnos)) * 100

    return f"En el curso {curso}, un {aprobados_fh}% han aprobado FH, un {aprobados_lm}% han aprobado LM, un {aprobados_iso}% han aprobado ISO, un {aprobados_fol}% han aprobado FOL, un {aprobados_par}% han aprobado PAR, y un {aprobados_sgbd}% han aprobado SGBD"


def crear_fichero_curso(curso: str):

    fichero_curso = open(f"ficheros/ejercicio01/{curso}.txt", "w+", encoding="utf-8")

    alumnos_curso = [alumno for alumno in cargar_listado() if alumno.curso == curso]

    for alumno in alumnos_curso:

        fichero_curso.write(alumno.__str__() + "\n")

    fichero_curso.close()


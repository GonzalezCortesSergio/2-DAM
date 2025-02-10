import ejercicio01 as e

while(True):

    opcion = input("""
        -------------------------------------------------------------
                   Opción 1: Mostrar listado de alumnos
                   Opción 2: Ver alumnos de un curso y una asignatura
                   Opción 3: Ver porcentaje aprobados por curso
                   Opción 4: Crear fichero curso
                   Opción 0: Salir
        -------------------------------------------------------------
                    """)
    
    try:
        match(int(opcion)):

            case 1:

                e.mostrar_listado(e.cargar_listado())

            case 2:

                curso = input("Diga el curso que quiere ver ")

                asignatura = input("De qué asignatura?")

                e.mostrar_listado(e.buscar_por_curso_asignatura(curso, asignatura))

            case 3:

                print(e.porcentaje_aprobados_curso("1C"))

            case 4:

                curso = input("Diga de qué curso quiere que se haga el fichero: ")

                if curso not in ("1A", "1B", "1C", "1D"):
                    print("No existe ese curso")

                else:
                    e.crear_fichero_curso(curso)
                    print("Se ha creado el fichero correctamente")
                

            case 0:

                break
            
            case _:
                print("Opción no válida")

    except:
        print("Introduzca un número porfavor")
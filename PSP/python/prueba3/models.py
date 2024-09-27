
class Alumno:
    
    nombre: str
    apellidos: str
    edad: int
    curso: str

    def __init__(self, nombre: str, apellidos: str, edad: int, curso: str):
        self.nombre = nombre
        self.apellidos = apellidos
        self.edad = edad
        self.curso = curso


    def get_nombre(self) :
        return self.nombre
    

    def set_nombre(self, nombre):
        self.nombre = nombre

    def get_apellidos(self):
        return self.apellidos
    
    def set_apellidos(self, apellidos):

        self.apellidos = apellidos

    def get_edad(self):

        return self.edad
    
    def set_edad(self, edad):
        self.edad = edad


    def get_curso(self):
        return self.curso
    

    def set_curso(self, curso):

        self.curso = curso



    def saludo(self):

        print(f"Hola soy {self.nombre}")

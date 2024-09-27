class Alumno:
    
    nombre: str
    apellidos: str
    edad: int
    curso: str

    def __init__(self, nombre, apellidos, edad, curso):
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

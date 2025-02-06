class Noseque:

    def __init__(self, name: str, surname: str):
        self.__name = name # Propiedad privada
        self.__surname = surname

    def get_name(self):
        return self.__name
    
    def get_surname(self):
        return self.__surname

persona = Noseque("Siombre", "Claro que sí")

print(persona.get_name(), persona.get_surname())
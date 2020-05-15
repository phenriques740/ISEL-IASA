from ecr.hierarquia import Hierarquia



class Recolher(Hierarquia):
    def __init__(self):
        #ativar construtor super class com instancia de evitar e instnacia de explorar
        super().__init__([Evitar(), Explorar()])
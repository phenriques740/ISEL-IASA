from psa.util import dist
from pee.modprob.problema_heur import ProblemaHeur

class ProblemaPlan(ProblemaHeur):
    def __init__(self,estado_inicial,estado_final,operadores):
        super().__init__(estado_inicial,operadores)
        self.__estado_final=estado_final
        

    def objectivo(self,estado):
        return estado == self.__estado_final


    def heuristica(self,estado):
        return dist(estado, self.__estado_final)
        


    
        

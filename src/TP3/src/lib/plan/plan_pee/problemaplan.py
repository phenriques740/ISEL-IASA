from pee.modprob.problema_heur import ProblemaHeur
from psa.util import dist


class ProblemaPlan(ProblemaHeur):

    def __init__(self, estado_inicial, estado_final, operadores):
        '''
        @param estado_inicial: Estado
        @param estado_final: Estado
        @param operadores: List<Operador>
        '''
        super().__init__(estado_inicial, operadores)
        self.__estado_final = estado_final

    def objectivo(self, estado):
        '''
        @param estado: Estado
        @return: boolean
        '''
        return estado == self.__estado_final

    def heuristica(self, estado):
        '''
        @param estado: Estado
        @return: double
        '''
        return dist(estado, self.__estado_final)
        

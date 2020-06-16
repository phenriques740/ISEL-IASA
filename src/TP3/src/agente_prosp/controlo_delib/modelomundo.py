from lib.plan.modeloplan import ModeloPlan

from agente_prosp.controlo_delib.operadormover import OperadorMover
from psa.elementos import ALVO, OBST
from psa.util import dirmov


class ModeloMundo(ModeloPlan):
    
    def __init__(self):
        self.__alterado = False
        self.__estado = None
        self.__estados = {}
        self.__elementos = {}
        self.__operadores = [OperadorMover(self, ang) for ang in dirmov()]

    def mostrar(self, vis):
        '''
        utilizado pela psa
        '''
        alvos_obst = {k:v for(k, v) in self.__elementos.items()
                    if v in [ALVO, OBST]}
        vis.elementos(alvos_obst)

    def estados(self):
        '''
        @return: List<Estado>
        '''
        return self.__estados

    @property
    def alterado(self):
        '''
        @return: Boolean
        '''
        
        return self.__alterado
    
    def obter_elem(self, estado):
        '''
        @param estado: Estado
        @return: Elemento
        '''
        
        return self.__elementos.get(estado)
        
    def actualizar(self, percepcao):
        '''
        Atualizar o modelo do mundo, consoante a posicao do agente
        @param percepcao: Percepcao
        '''
        self.__estado = percepcao.posicao
        if self.__elementos != percepcao.imagem:
            self.__elementos = percepcao.imagem
            self.__estados = percepcao.imagem.keys()
            self.__alterado = True
        else:
            self.__alterado = False

    def operadores(self):
        '''
        @return: List<Operador>
        '''
        return self.__operadores

    @property
    def estado(self):
        return self.__estado
    

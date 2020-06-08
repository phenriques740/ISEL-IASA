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
        alvos_obst = {k:v for(k, v) in self.__elementos.items()
                    if v in [ALVO, OBST]}
        vis.elementos(alvos_obst)

    def estados(self):
        return self.__estados

    @property
    def alterado(self):
        return self.__alterado
    
    def obter_elem(self, estado):
        return self.__elementos.get(estado)
        
    def actualizar(self, percepcao):
        self.__estado = percepcao.posicao
        if self.__elementos != percepcao.imagem:
            self.__elementos = percepcao.imagem
            self.__estados = percepcao.imagem.keys()
            self.__alterado = True
        else:
            self.__alterado = False

    def operadores(self):
        return self.__operadores

    @property
    def estado(self):
        return self.__estado
    

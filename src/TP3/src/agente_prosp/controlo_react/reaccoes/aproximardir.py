from ecr.reaccao import Reaccao
from ecr.resposta import Resposta

from psa.accao import Mover


class AproximarDir(Reaccao):
    def __init__(self,angulo):
        self.__angulo=angulo
        self.__gama=0.9

    def detectar_estimulo(self,percepcao):
        if percepcao[self.__angulo].alvo:
            return percepcao[self.__angulo].distancia

    def gerar_resposta(self,estimulo):
        dist = estimulo
        prioridade = self.__gama ** dist
        accao = Mover(self.__angulo)
        return Resposta(accao,prioridade)
        

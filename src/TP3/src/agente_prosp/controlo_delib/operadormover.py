from psa.util import mover,dist
from psa.accao import Mover
from pee.modprob.operador import Operador
from psa.elementos import ALVO, VAZIO
class OperadorMover(Operador):
    def __init__(self,modelo_mundo,ang):
        self.__ang=ang
        self.__accao = Mover(self.__ang, ang_abs = True)
        self.modelo_mundo=modelo_mundo
        

    @property
    def accao(self):
        return self.__accao
    @property
    def ang(self):
        return self.__ang
    
    def aplicar(self,estado):
        posicao=mover(estado,self.__ang)
        elemento=self.modelo_mundo.obter_elem(posicao)
        if elemento in [VAZIO,ALVO]:
            return posicao
        else:
            return None

    def custo(self,estado,novo_estado):
        return max(dist(estado,novo_estado),1)

    def mostrar(self,vis,estado):
        vis.plano(estado,self.__plano)
        vis.marcar([estado],linha=1)
        
    

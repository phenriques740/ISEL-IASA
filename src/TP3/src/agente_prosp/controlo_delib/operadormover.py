from pee.modprob.operador import Operador
from psa.accao import Mover
from psa.elementos import ALVO, VAZIO
from psa.util import mover, dist


class OperadorMover(Operador):

    def __init__(self, modelo_mundo, ang):
        '''
        @param modelo_mundo: ModeloMundo
        @param ang: Double
        '''
        self.__ang = ang
        self.__accao = Mover(self.__ang, ang_abs=True)
        self.modelo_mundo = modelo_mundo

    @property
    def accao(self):
        return self.__accao

    @property
    def ang(self):
        return self.__ang
    
    def aplicar(self, estado):
        '''
            Se este operador for selecionado, altera a posicao do agente.
            @param estado: Estado
                                estado atual do agente
            @return: Estado
                        estado futuro do agente, depois de lhe ser aplicado o movimento
        '''
        posicao = mover(estado, self.__ang)
        elemento = self.modelo_mundo.obter_elem(posicao)
        if elemento in [VAZIO, ALVO]:
            return posicao
        else:
            return None

    def custo(self, estado, novo_estado):
        '''
        @param estado: Estado
        @param novo_estado: Estado
        @return: double
        '''
        
        return max(dist(estado, novo_estado), 1)

    def mostrar(self, vis, estado):
        vis.plano(estado, self.__plano)
        vis.marcar([estado], linha=1)
    

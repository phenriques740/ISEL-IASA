from agente_prosp.controlo import Controlo
from agente_prosp.controlo_aprend.mec_aprend import MecAprend

from psa.accao import Mover
from psa.util import dirmov


class ControloAprendRef(Controlo):
    '''
    classdocs
    '''

    def __init__(self):
        '''
        Constructor
        '''
        
        self.__rmax = 100
        accoes = [Mover(ang, ang_abs=True) for ang in dirmov()]
        self.__mec_aprend = MecAprend(accoes)
        
        self.__s = None
        self.__a = None
        
    def processar(self, percepcao):
        '''
        Processa o ambiente como o agente o percebe, selecionando e aplicando a melhor accao
        @param percepcao: Percepcao
        @return: Accao
        '''
        
        sn = percepcao.posicao
        an = self.__mec_aprend.selecionar_acao(sn)
        
        if(self.__s != None):
            r = self.__gerar_reforco(percepcao)
            self.__mec_aprend.aprender(self.__s, self.__a, r, sn)
            
        self.__a = an
        self.__s = sn
        
        return an
    
    def __gerar_reforco(self, percepcao):
        '''
        gera o reforco associado ao movimento
        @param percepcao: Percepcao
        @return: double
        '''
        
        # # deve gerar um reforco, tendo em conta o custo do movimento (negativo), recompensa maxima (ao atingir o alvo), recompensa maxima (colisao, negativo)
        
        custo = percepcao.custo_mov * -1.0
        if(percepcao.carga):
            custo += self.__rmax
        if(percepcao.colisao):
            custo -= self.__rmax
            
        return custo

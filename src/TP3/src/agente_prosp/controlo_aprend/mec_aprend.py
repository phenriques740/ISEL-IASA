from lib.aprend_ref.memoria_esparca import MemoriaEsparca
from lib.aprend_ref.sel_acao_EGreedy import SelAccaoEGreedy
from lib.aprend_ref.aprend_q import AprendQ

import psa


class MecAprend:

    def __init__(self, accoes):
        '''
        Constructor
        '''
        alfa = 0.5
        gama = 0.9
        epsilon = 0.01
        
        self.__accoes = accoes
        self.__mem_aprend = MemoriaEsparca(epsilon)
        
        self.__sel_acao = SelAccaoEGreedy(self.__mem_aprend, self.__accoes, epsilon)
        self.__aprend_ref = AprendQ(self.__mem_aprend, self.__sel_acao, alfa, gama)
    
    def aprender(self, s, a, r, sn):
        '''
        Associa a um par estado-accao um custo ou recompensa á transicao para o estado seguinte 
        '''
        
        self.__aprend_ref.aprender(s, a, r, sn)
        
        self.mostrar(sn)
    
    def selecionar_acao(self, s):
        return self.__sel_acao.selecionar_acao(s)
    
    def mostrar(self, s):
        psa.vis(1).limpar()
        psa.vis(1).aprendref(self.__aprend_ref)
        psa.vis(2).accoesestado(s, self.__accoes, self.__mem_aprend.memoria)
        

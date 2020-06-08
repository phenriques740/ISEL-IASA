'''
Created on 5 Jun 2020

@author: pedro
'''
from lib.aprend_ref.aprend_ref import AprendRef


class AprendQ(AprendRef):
    '''
    classdocs
    '''

    def __init__(self, mem_aprend, sel_accao, alfa, gama):
        '''
        Constructor
        '''
        super().__init__(mem_aprend, sel_accao)
               
        self._alfa = alfa
        self._gama = gama
    
    def aprender(self, s, a, r, sn):
        mem = self.__mem_aprend
        
        An = self.__sel_accao.max_acao(sn)
        maxA = self._mem_aprend.obter(An)
        Qant = mem.obter(s, a)
        
        q = Qant + self._alfa * (r + self._gama * maxA - Qant)
        mem.atualizar(s, a, q)





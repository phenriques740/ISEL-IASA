from lib.aprend_ref.sel_acao import SelAcao
from random import random
from random import shuffle
from random import choice


class SelAccaoEGreedy(SelAcao):
    '''
    classdocs
    '''

    def __init__(self, mem_aprend, accoes, epsilon):
        '''
        Constructor
        
        @param mem_aprend: MemoriaAprend
        @param accoes: List<Accao>
        @param epsilon: double
        '''
        self.__mem_aprend = mem_aprend
        self.__accoes = accoes
        self.__epsilon = epsilon

    def selecionar_acao(self, s):
        '''
        Seleciona uma acao a aplicar em relacao ao estado. A acao pode ou nao ser aleatoria.
        @param s: Estado
        '''
        return self.max_acao(s) if random() > self.__epsilon else self.explorar(s)
        
    def max_acao(self, s):
        '''
        Acao nao aleatoria, associada á acao oposta de explorar
        '''
        shuffle(self.__accoes)
        return max(self.__accoes, key=lambda a : self.__mem_aprend.obter(s, a))
    
    def explorar(self, s):
        '''
        Acao aleatoria, explorar
        '''
        return choice(self.__accoes)
    
    @property
    def accoes(self):
        return self.__accoes

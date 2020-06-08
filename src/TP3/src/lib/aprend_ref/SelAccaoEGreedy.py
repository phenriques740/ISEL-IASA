from lib.aprend_ref.SelAcao import SelAcao

class SelAccaoEGreedy(SelAcao):
    '''
    classdocs
    '''


    def __init__(self, mem_aprend, accoes, epsilon):
        '''
        Constructor
        '''
        self.__mem_aprend= mem_aprend
        self.__accoes = accoes
        self.__epsilon = epsilon


    def selecionar_acao(self, s):
        # TODO
        return
    
    def max_acao(self, s):
        return max([ self.__mem_aprend.obter(s, a) for a in self.__accoes ])
    
    def explorar(self, s):
from lib.aprend_ref.memoria_aprend import MemoriaAprend


class MemoriaEsparca(MemoriaAprend):
    '''
    classdocs
    '''

    def __init__(self, valor_omissao=0):
        '''
        @param valor_omissao : double
        '''
        self.__valor_omissao = valor_omissao
        self.__memoria = {}
    
    def atualizar(self, s, a, q):
        '''
        @param s : Estado
        @param a: Accao
        @param q: double
        '''
        self.__memoria[(s, a)] = q
        
    def obter(self, s, a):
        '''
        Devolve o valor associado á transicao
        
        @param s: Estado
        @param a: Accao
        @return: double
        '''
        return self.__memoria.get((s, a), self.__valor_omissao)

    @property
    def memoria(self):
        return self.__memoria    

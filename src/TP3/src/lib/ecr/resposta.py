class Resposta:
    def __init__(self, accao, prioridade=0):
        '''
        @param Accao: accao
        @param Number : prioridade, default value is 0
        '''
        self.__accao = accao
        self.__prioridade = prioridade

    @property 
    def accao(self):
        '''
        @return: Accao
        '''
        return self.__accao

    @property
    def prioridade(self):
        '''
        @return: Prioridade
        '''
        return self.__prioridade
    

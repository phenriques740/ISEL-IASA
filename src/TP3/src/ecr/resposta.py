class Resposta:
    
   
    def __init__(self,accao,prioridade=0):
        self.__accao=accao
        self.__prioridade=prioridade

    @property ##readonly
    def accao(self):
        return self.__accao

    @property
    def prioridade(self):
        return self.__prioridade

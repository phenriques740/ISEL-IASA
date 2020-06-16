from lib.ecr.comportamento import Comportamento


class ComportComp(Comportamento):

    def __init__(self, comportamentos):
        '''
        @param List<Comportamento>: comportamentos 
        '''
        self.__comportamentos = comportamentos

    def selecionar_resposta(self, respostas):
        '''Abstract method
        
        Seleciona a resposta dada uma lista de respostas
        
        @param List<Resposta>: respostas 
        @return: Resposta
        '''
        raise NotImplementedError

    def activar(self, percepcao):
        '''
        Dada a representacao do estado do mundo, Percepcao, 
        seleciona a melhor resposta mediante o criterio escolhido pela classe derivada desta
        
        @param Percepcao: percepcao
        @return Resposta
        '''
        respostasf = []
        for comportamento in self.__comportamentos:
            resposta = comportamento.activar(percepcao)
            if resposta is not None:
                respostasf.append(resposta)
        if respostasf:
            return self.selecionar_resposta(respostasf)
    

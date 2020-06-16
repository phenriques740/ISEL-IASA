from lib.ecr.comportamento import Comportamento


class Reaccao(Comportamento):
    
    def detectar_estimulo(self, percepcao):
        '''Abstract method
        Deteta um estimulo no ambiente
        @param Percepcao: percepcao
        @return: Estimulo
        '''
        raise NotImplementedError

    def gerar_resposta(self, estimulo):
        '''Abstract method
        @param Estimulo : estimulo
        @return: Resposta
        '''
        raise NotImplementedError

    def activar(self, percepcao):
        '''
        @param Percepcao: percepcao
        @return: Resposta : resposta
        '''
        estimulo = self.detectar_estimulo(percepcao)
        if estimulo is not None and estimulo is not False:
            resposta = self.gerar_resposta(estimulo)
            return resposta
        

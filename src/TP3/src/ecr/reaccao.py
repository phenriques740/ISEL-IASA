
class Reaccao():
    
    def detectar_estimulo(self,percepcao):
        raise NotImplementedError

    def gerar_resposta(self,estimulo):
        raise NotImplementedError

    def activar(self,percepcao):
        estimulo=self.detectar_estimulo(percepcao)
        if estimulo is not None and estimulo is not False:
            resposta=self.gerar_resposta(estimulo)
            return resposta
        

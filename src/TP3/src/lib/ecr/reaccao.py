from comportamento import Comportamento

class Reaccao(Comportamento):

    def _detectar_estimulo(self, percepcao):
        raise Exception("Not Implemented")

    def _gerar_resposta(self, estimulo):
        raise Exception("Not Implemented")

    def activar(self, percepcao):
        estimulo = self._detectar_estimulo(percepcao)
        if(estimulo is not None and estimulo is not False):
            return self._gerar_resposta(estimulo)
from controlo import Controlo

class ControloReact(Controlo):
    def __init__(self, comportamento):
        self.comportamento = comportamento

    def processar(self, percepcao):
        resposta = self.comportamento.activar(percepcao)
        if(resposta is not None):
            return resposta.accao

from comportamento import Comportamento

def ComportComp(Comportamento):

    def __init__(self, comportamentos):
        self.comportamentos = comportamentos

    def seleccionar_resposta(self, respostas):
        raise Exception("Not Implemented")

    def activar(self, percepcao):
        respostas = []
        for i in range(len(self.comportamentos)):
            resposta = comportamentos[i].activar(percepcao)
            if(resposta is not None):
                respostas.append(resposta)
        
        return self.seleccionar_resposta(respostas)
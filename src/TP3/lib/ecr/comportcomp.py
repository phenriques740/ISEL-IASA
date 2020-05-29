from ecr.comportamento import Comportamento

class ComportComp(Comportamento):
    def __init__(self,comportamentos):
        self.comportamentos=comportamentos

    def selecionar_resposta(self,respostas):
        raise NotImplementedError

    def activar(self,percepcao):
        respostasf=[]
        for comportamento in self.comportamentos:
            resposta=comportamento.activar(percepcao)
            if resposta is not None:
                respostasf.append(resposta)
            if respostasf:
                return self.selecionar_resposta(respostasf)
    

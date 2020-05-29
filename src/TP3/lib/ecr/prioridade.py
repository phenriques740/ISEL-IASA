from ecr.comportcomp import ComportComp

class Prioridade(ComportComp):
    def __init__(self,comportamentos):
        super().__init__(comportamentos)

    def selecionar_respostas(self,respostas):
        return max(respostas, key = lambda resposta : resposta.prioridade)
        
        

from lib.ecr.comportcomp import ComportComp

class Hierarquia(ComportComp):
    def __init__(self, comportamentos):
        super().__init__(comportamentos)

    def selecionar_resposta(self, respostas):
        return respostas[0]


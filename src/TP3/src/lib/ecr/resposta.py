class Resposta():

    def __init__(self, accao, prioridade = 0):
        self._accao = accao
        self._prioridade = prioridade

    @property
    def accao(self):
        return self._accao

    @property
    def prioridade(self):
        return self._prioridade

    
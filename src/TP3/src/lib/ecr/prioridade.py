from comportComp import ComportComp

class Prioridade(ComportComp):

    def seleccionar_resposta(self, respostas):
        resposta = respostas[0]
        for x in range(len(respostas)-1):
            if(resposta.prioridade() < respostas[x+1].prioridade()):
                resposta = respostas[x+1]
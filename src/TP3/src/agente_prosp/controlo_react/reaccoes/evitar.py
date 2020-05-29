from ecr.reaccao import Reaccao
from ecr.resposta import Resposta
from psa.actuador import ESQ,FRT,DIR
from psa.accao import Rodar

class Evitar(Reaccao):
    def gerar_resposta(self,estimulo):
        accao=Rodar(ESQ)
        resposta=Resposta(accao)
        return resposta

    def detectar_estimulo(self,percepcao):
        return percepcao[FRT].contacto and percepcao[FRT].obstaculo

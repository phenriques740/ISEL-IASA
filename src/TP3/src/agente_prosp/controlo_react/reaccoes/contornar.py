from ecr.reaccao import Reaccao
from ecr.resposta import Resposta
from psa.actuador import ESQ,DIR,FRT
from psa.accao import Mover

class Contornar(Reaccao):
    def detectar_estimulo(self,percepcao):
        return (percepcao[ESQ].contacto and percepcao[ESQ].obstaculo) or (percepcao[DIR].contacto and percepcao[DIR].obstaculo)
    def gerar_resposta(self,estimulo):
        accao=Mover(FRT)
        return Resposta(accao)

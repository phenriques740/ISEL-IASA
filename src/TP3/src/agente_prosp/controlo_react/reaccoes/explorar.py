from random import choice

from psa.actuador import ESQ, DIR, FRT

from ecr.comportamento import Comportamento
from ecr.resposta import Resposta
from psa.accao import Mover

class Explorar(Comportamento):
    def activar(self,percepcao):
        seq = choice([ESQ,FRT,DIR])
        accao = Mover(seq)
        return Resposta(accao)

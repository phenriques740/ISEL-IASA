from lib.ecr.comportamento import Comportamento
from lib.ecr.resposta import Resposta
from random import choice

from psa.accao import Mover
from psa.actuador import ESQ, DIR, FRT


class Explorar(Comportamento):
    def activar(self,percepcao):
        seq = choice([ESQ,FRT,DIR])
        accao = Mover(seq)
        return Resposta(accao)

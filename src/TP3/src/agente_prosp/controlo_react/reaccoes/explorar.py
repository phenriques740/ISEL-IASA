from random import choice

from psa.actuador import ESQ, DIR, FRT

from ecr.comportamento import Comportamento
from ecr.resposta import Resposta

class Explorar(Comportamento):
    def activar(self, _):
        accao = choice([(1,ESQ), (1,FRT),(1,DIR)])
        return Resposta(accao)
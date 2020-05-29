from ecr.prioridade import Prioridade

from agente_prosp.controlo_react.reaccoes.aproximardir import AproximarDir
from psa.actuador import ESQ, DIR, FRT


class Aproximar(Prioridade):
    def __init__(self):
        super().__init__([AproximarDir(ESQ),AproximarDir(FRT),AproximarDir(DIR)])

    

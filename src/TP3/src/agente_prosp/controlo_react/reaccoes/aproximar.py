from ecr.prioridade import Prioridade
from psa.actuador import ESQ,DIR,FRT
from agente_prosp.controlo_react.reaccoes.aproximardir import AproximarDir


class Aproximar(Prioridade):
    def __init__(self):
        super().__init__([AproximarDir(ESQ),AproximarDir(FRT),AproximarDir(DIR)])

    

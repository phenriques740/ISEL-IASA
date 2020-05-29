from ecr.hierarquia import Hierarquia

from agente_prosp.controlo_react.reaccoes.aproximar import Aproximar
from agente_prosp.controlo_react.reaccoes.contornar import Contornar
from agente_prosp.controlo_react.reaccoes.evitar import Evitar
from agente_prosp.controlo_react.reaccoes.explorar import Explorar

class Recolher(Hierarquia):
    def __init__(self):
        super().__init__([Aproximar(),Evitar(),Contornar(),Explorar()])
        

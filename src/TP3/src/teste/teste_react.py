import psa
from agente_prosp.agente_prospector import AgenteProspector

from agente_prosp.controlo_react.controlo_react import ControloReact 
from agente_prosp.controlo_react.reaccoes.explorar import Explorar 
from agente_prosp.controlo_react.reaccoes.evitar import Evitar 
from agente_prosp.controlo_react.reaccoes.aproximar.aproximar import Aproximar
from agente_prosp.controlo_react.reaccoes.recolher import Recolher 


Comportamento = Recolher

controlo=ControloReact(Comportamento())
agente = AgenteProspector(controlo)
psa.iniciar("amb/amb1.das")
psa.executar(agente)
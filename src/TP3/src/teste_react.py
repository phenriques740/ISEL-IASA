from agente_prosp.agente_prospector import AgenteProspector
from agente_prosp.controlo_react.controlo_react import ControloReact
from agente_prosp.controlo_react.reaccoes.explorar import Explorar as Comportamento
import psa


##from agente_prosp.controlo_react.reaccoes.evitar import Evitar as Comportamento
##from agente_prosp.controlo_react.reaccoes.recolher import Recolher as Comportamento
controlo=ControloReact(Comportamento())
agente = AgenteProspector(controlo)
psa.iniciar("teste/amb/amb1.das")
psa.executar(agente)

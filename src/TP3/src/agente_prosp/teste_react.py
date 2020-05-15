import psa

from agente_prospector import AgenteProspector

from controlo_react.controloReact import ControloReact
from controlo_react.reaccoes.explorar import Explorar as Comportamento

psa.iniciar("amb/amb1.das")

controlo = ControloReact(Comportamento())
agente = AgenteProspector(controlo)
psa.executar(agente)
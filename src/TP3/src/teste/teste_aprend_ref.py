import psa
from agente_prosp.controlo_aprend.controlo_aprend_ref import ControloAprendRef
from agente_prosp.agente_prospector import AgenteProspector

psa.iniciar("amb/amb3.das", reiniciar=True)
control = ControloAprendRef()
agente = AgenteProspector(control)

psa.executar(agente)

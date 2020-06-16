import psa
from psa.agente import Agente
from agente_prosp.agente_prospector import AgenteProspector

from agente_prosp.controlo_delib.controlodelib import ControloDelib 
from lib.plan.plan_pee.planpee import PlanPEE
from lib.plan.plan_pdm.planpdm import PlanPDM

psa.iniciar("amb/amb2.das")

plan = PlanPDM()
controlo = ControloDelib(plan)
agente = AgenteProspector(controlo)

psa.executar(agente)


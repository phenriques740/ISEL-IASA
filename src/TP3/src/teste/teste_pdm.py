import psa
from psa.agente import Agente
from psa.accao import Avancar
from agente_prosp.agente_prospector import AgenteProspector

from agente_prosp.controlo_delib.controlodelib import ControloDelib 
from lib.plan.plan_pee.planpee import PlanPEE
from lib.plan.plan_pdm.planpdm import PlanPDM
from pee.melhorprim.procura_aa import ProcuraAA
from pee.melhorprim.procura_sofrega import ProcuraSofrega
from pee.melhorprim.procura_melhor_prim import ProcuraMelhorPrim

psa.iniciar("amb/amb1.das")

plan = PlanPDM()
controlo = ControloDelib(plan)
agente = AgenteProspector(controlo)

psa.executar(agente)


from lib.plan.plan_pee.planpee import PlanPEE

from agente_prosp.agente_prospector import AgenteProspector
from agente_prosp.controlo_delib.controlodelib import ControloDelib 

from pee.melhorprim.procura_aa import ProcuraAA
from pee.melhorprim.procura_sofrega import ProcuraSofrega
from pee.melhorprim.procura_custo_unif import ProcuraCustoUnif
import psa
from psa.accao import Avancar
from psa.agente import Agente

psa.iniciar("amb/amb1.das")

mec_pee = ProcuraSofrega()
plan = PlanPEE(mec_pee)
controlo = ControloDelib(plan)
agente = AgenteProspector(controlo)

psa.executar(agente)


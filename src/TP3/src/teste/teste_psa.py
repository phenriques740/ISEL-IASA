import psa
from psa.agente import Agente
from psa.accao import Avancar

#Agente de teste

class AgenteTeste(Agente):
    def executar(self):
        self.actuador.actuar(Avancar())

#Activação

#Iniciar plataforma
psa.iniciar("amb/amb1.das")

#Executar agente
psa.executar(AgenteTeste())


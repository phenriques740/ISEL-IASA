import psa
from psa.accao import Avancar
from psa.agente import Agente


class AgenteTeste(Agente):
    def executar(self):
        self.actuador.actuar(Avancar())




psa.iniciar("teste/amb/amb1.das")

psa.executar(AgenteTeste())

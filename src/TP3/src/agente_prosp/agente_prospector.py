import psa
from psa.agente import Agente

class AgenteProspector(Agente):
    
    def __init__(self,controlo):
        super().__init__()
        self.controlo = controlo

    def executar(self):
        percepcao = self.__percepcionar()
        accao = self.__processar(percepcao)
        self.__actuar(accao)
        #return void
        
    def __percepcionar(self):
        #return Percepcao
        return self.sensor_multiplo.detectar()
        
    def __processar(self,percepcao):
        #return Accao
        return self.controlo.processar(percepcao)

    def __actuar(self, accao):
        #return void
        return self.actuador.actuar(accao)


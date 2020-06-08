from agente_prosp.controlo_delib.modelomundo import ModeloMundo
import psa 
from psa.elementos import ALVO, OBST
from psa.util import dist


class ControloDelib:

    def __init__(self, planeador):
        self.planeador = planeador
        self.__modelo_mundo = ModeloMundo()
        self.__objetivos = None

    def mostrar(self):
        vis = psa.vis(1)
        vis.limpar()
        self.planeador.mostrar(vis, self.__modelo_mundo.estado)
        self.__modelo_mundo.mostrar(vis)
   
    def __reconsiderar(self):
        if(self.__objetivos is None or not self.planeador.plano_pendente() or self.__modelo_mundo.alterado):
            return True
                        
        return False

    def __deliberar(self):
        self.__objetivos = [estado for estado in self.__modelo_mundo.estados()
                        if self.__modelo_mundo.obter_elem(estado) == ALVO]

        estado_agente = self.__modelo_mundo.estado
        self.__objetivos.sort(key=lambda estado : dist(estado, estado_agente))
        
    def __planear(self):
        if self.__objetivos:
            self.planeador.planear(self.__modelo_mundo, self.__modelo_mundo.estado, self.__objetivos)
        else:
            self.planeador.terminar_plano()

    def __executar(self):
        operador = self.planeador.obter_accao(self.__modelo_mundo.estado)
        if operador is not None:
            return operador.accao

    def processar(self, percepcao):
        self.__assimilar(percepcao)
        if(self.__reconsiderar()):
            self.__deliberar()
            self.__planear()
        self.mostrar()
        return self.__executar()

    def __assimilar(self, per):
        self.__modelo_mundo.actualizar(per)  
        

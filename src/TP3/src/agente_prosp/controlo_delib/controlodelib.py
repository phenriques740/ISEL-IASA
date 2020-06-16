from agente_prosp.controlo_delib.modelomundo import ModeloMundo
import psa 
from psa.elementos import ALVO, OBST
from psa.util import dist


class ControloDelib:

    def __init__(self, planeador):
        '''
        @param planeador: Planeador
        '''
        self.planeador = planeador
        self.__modelo_mundo = ModeloMundo()
        self.__objetivos = None

    def mostrar(self):
        '''
        metodo utilizado pela psa
        '''
        vis = psa.vis(1)
        vis.limpar()
        self.planeador.mostrar(vis, self.__modelo_mundo.estado)
        self.__modelo_mundo.mostrar(vis)
   
    def __reconsiderar(self):
        ''' 
        @return: Boolean 
        '''
        
        if(self.__objetivos is None or not self.planeador.plano_pendente() or self.__modelo_mundo.alterado):
            return True
                        
        return False

    def __deliberar(self):
        '''
        Verifica todos os objetivos percepcionados, e procura o melhor, tendo em conta a distancia
        '''
        
        self.__objetivos = [estado for estado in self.__modelo_mundo.estados()
                        if self.__modelo_mundo.obter_elem(estado) == ALVO]

        estado_agente = self.__modelo_mundo.estado
        self.__objetivos.sort(key=lambda estado : dist(estado, estado_agente))
        
    def __planear(self):
        '''
        Auxilia o agente a calcular o melhor percurso de acao para uma recompensa instantanea, 
        caso nao existam mais objetivos no ambiente, termina 
        '''
        
        if self.__objetivos:
            self.planeador.planear(self.__modelo_mundo, self.__modelo_mundo.estado, self.__objetivos)
        else:
            self.planeador.terminar_plano()

    def __executar(self):
        operador = self.planeador.obter_accao(self.__modelo_mundo.estado)
        if operador is not None:
            return operador.accao

    def processar(self, percepcao):
        '''
        Processa o estado do ambiente e devolve a melhor accao a ser tomada
        
        @param percepcao: Percepcao
                estado atual do ambiente 
        @return: Accao
        '''
        self.__assimilar(percepcao)
        if(self.__reconsiderar()):
            self.__deliberar()
            self.__planear()
        self.mostrar()
        return self.__executar()

    def __assimilar(self, per):
        '''
        @param per: Percepcao
        @return: 
        '''
        self.__modelo_mundo.actualizar(per)  
        

from lib.pdm.pdm import PDM
from lib.plan.plan_pdm.modelo_pdm_plan import ModeloPDMPlan
from lib.plan.planeador import Planeador

class PlanPDM(Planeador):

    def __init__(self):
        '''
        Constructor
        '''
        
        self.__gama = 0.85
        self.__delta_max = 1.0
        self.__utilidade = {}
        self.__politica = {}
    
        self.__pdm = PDM(self.__gama, self.__delta_max)
    
    def planear(self,modelo_plan,estado,objectivos):
        self.__utilidade,self.__politica=self.__pdm.resolver(ModeloPDMPlan(modelo_plan,objectivos))

    def obter_accao(self, s):
        '''
            Obtem a proxima acao a ser executada, dado o estado s
            @param s: Estado estado atual
        '''
        if self.__politica:
            return self.__politica.get(s)
    
    def plano_pendente(self):
        return bool(self.__politica)
        
    def terminar_plano(self):
        self.__politica = {}
        
    def mostrar(self, vis, estado):
        if self.__politica:
            vis.campo(self.__utilidade)
            vis.politica(self.__politica)
            vis.marcar([estado], linha=1)

from lib.pdm.pdm import PDM
from lib.plan.plan_pdm.modelo_pdm_plan import ModeloPDMPlan


class PlanPDM(PDM):

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
        # ## obter accao a executar
        # ## dado o estado s, utlizar o metodo get na politica para returnar o operador
        if self.__politica:
            return self.__politica.get(s)
    
    def plano_pendente(self):
        return len(self.__politica) != 0
        
    def terminar_plano(self):
        self.__politica = {}
        
    def mostrar(self, vis, estado):
        if self.__politica:
            vis.campo(self.__utilidade)
            vis.politica(self.__politica)
            vis.marcar([estado], linha=1)

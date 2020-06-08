from lib.plan.modeloplan import ModeloPlan
from lib.pdm.modelo_pdm import ModeloPDM


class ModeloPDMPlan(ModeloPlan, ModeloPDM):

    def __init__(self, modelo_plan, objetivos):
        self.__model_plan = modelo_plan
        self.__objetivos = objetivos
        
        self.__rmax = 100
        
    def estados(self):
        return self.__model_plan.estados()

    def operadores(self):
        return self.__model_plan.operadores()
    
    def S(self):
        return self.estados()
        
    def A(self, s):
        return self.operadores()
        
    def T(self, s, a):
        sn = a.aplicar(s)
        if(sn is None):
            return []
        return [(1, sn)]
        
    def R(self, s, a, sn):
        if(sn in self.__objetivos):
            return self.__rmax + a.custo(s, sn)
        return -1. * a.custo(s, sn)
        

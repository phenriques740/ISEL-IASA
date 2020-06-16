from lib.plan.modeloplan import ModeloPlan
from lib.pdm.modelo_pdm import ModeloPDM


class ModeloPDMPlan(ModeloPlan, ModeloPDM):

    def __init__(self, modelo_plan, objetivos):
        '''
        @param modelo_plan: ModeloPlan
        @param objetivos: List<Estado>
        '''
        
        self.__model_plan = modelo_plan
        self.__objetivos = objetivos
        
        self.__rmax = 100
        
    def estados(self):
        '''
        @return: List<Estado>
        '''
        return self.__model_plan.estados()

    def operadores(self):
        '''
        @return: List<Operador>
        '''        
        return self.__model_plan.operadores()
    
    def S(self):
        '''
        @return: List<Estado>
        '''        
        return self.estados()
        
    def A(self, s):
        '''
        @return: List<Operador>
        '''   
        return self.operadores()
        
    def T(self, s, a):
        '''
            Devolve a transicao do estado s, aplicando uma acao
            @param s: Estado
            @param a: Operador
            @return: List<Transicao>
             
        '''
        sn = a.aplicar(s)
        if(sn is None):
            return []
        return [(1, sn)]
        
    def R(self, s, a, sn):
        '''
        Recompensa da aplicacao de uma acao ao estado, com destino ao estado sn
        @param s: Estado
                    estado atual
        @param a: Operador
        @param sn: Estado
                    estado destino
        '''
        
        if(sn in self.__objetivos):
            return self.__rmax + a.custo(s, sn)
        return -1. * a.custo(s, sn)
        

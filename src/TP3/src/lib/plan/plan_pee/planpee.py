from lib.plan.plan_pee.problemaplan import ProblemaPlan
from lib.plan.planeador import Planeador


class PlanPEE(Planeador):
    def __init__(self,mec_pee):
        self.__mec_pee=mec_pee
        self.__plano = []

    def planear(self,modelo_plan,estado_inicial,objetivos):
        estado_final=objetivos[0]
        operadores = modelo_plan.operadores()
        problema_plan=ProblemaPlan(estado_inicial,estado_final,operadores)
        solucao= self.__mec_pee.resolver(problema_plan)

        if solucao!=None:
            self.__plano=[passo.operador for passo in solucao[1:]]
        
    def obter_accao(self,estado):
        if self.__plano:
            return self.__plano.pop(0)

    def plano_pendente(self):
        return self.__plano
        
    def terminar_plano(self):
        self.__plano = None
    
    def mostrar(self, vis, estado):
        vis.plano(estado, self.__plano)

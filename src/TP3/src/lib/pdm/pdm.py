from lib.pdm.modelo_pdm import ModeloPDM


class PDM(ModeloPDM):

    def __init__(self, gama, delta_max):
        '''
        @param gama: Double
        @param delta_max: int  
        '''
        
        self.__gama = gama
        self.__delta_max = delta_max
    
    def utilidade(self, modelo):
        '''
        @param modelo: MODELOPDM
        @return: Utilidade
        '''
        S, A = modelo.S, modelo.A

        U = {s :0 for s in S()}

        while True:
            Uant = U.copy()
            delta = 0
            
            for s in S():              
                U[s] = max(self.util_accao(s, a, Uant, modelo) for a in A(s))
                delta = max(delta, abs(U[s] - Uant[s]))
            
            if delta < self.__delta_max:
                break
        
        return U
    
    def util_accao(self, s, a, U, modelo):
        '''
        @param s: Estado
        @param a: Operador
        @param U: Utilidade
        @param modelo : ModeloPDM 
        '''
        
        T, R, gama = modelo.T, modelo.R, self.__gama
        return sum(p * (R(s, a, sn) + gama * U[sn]) for (p, sn) in T(s, a))
    
    def politica(self, U, modelo):
        '''
        @param U: Utilidade
        @param modelo: Modelo 
        '''
        S, A = modelo.S, modelo.A
        pol = {}
        
        for s in S():
            pol[s] = max(A(s), key=lambda a: self.util_accao(s, a, U, modelo))
        return pol
            
    def resolver(self, modelo):
        '''
        @param modelo: ModeloPDM
        '''
        U = self.utilidade(modelo)
        return (U, self.politica(U, modelo))

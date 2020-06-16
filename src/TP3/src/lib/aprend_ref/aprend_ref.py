class AprendRef:

    def __init__(self, mem_aprend, sel_accao):
        '''
        Constructor
        
        @param mem_aprend: MemoriaAprend
        @param sel_accao: SelAccao
        '''
        self._mem_aprend = mem_aprend
        self._sel_accao = sel_accao

    def aprender(self, s, a, r, sn):
        '''
        Tendo em conta o estado, a acao, a recompensa, o agente aprende se a acao é ou não vantajosa
        @param s: Estado
        @param a: Accao
        @param r: double
                    recompensa ou custo
        @param sn: Estado
                    estado seguinte
        '''
        raise NotImplementedError
    

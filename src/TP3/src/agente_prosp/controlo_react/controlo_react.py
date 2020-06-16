from agente_prosp.controlo import Controlo


class ControloReact(Controlo):
    def __init__(self, comportamento):
        '''
        @param Recolher: comportamento
        '''
        
        self.__comportamento = comportamento

    def processar(self, percepcao):
        '''
        @param Percepcao: percepcao
        @return: Accao
        '''
        resposta = self.__comportamento.activar(percepcao)
        if resposta is not None:
            return resposta.accao

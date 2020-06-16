import psa
from psa.agente import Agente


class AgenteProspector(Agente):

    def __init__(self, controlo):
        '''
        @param Controlo: controlo , algoritmo de busca do agente
        '''
        self.__controlo = controlo
        
    def executar(self):
        
        percepcao = self.__percepcionar()
        accao = self.__processar(percepcao)
        self.__actuar(accao)

    def __percepcionar(self):
        '''
        Avalia o ambiente em que se encontra o agente, procura alvos e identifica obstaculos

        @param : 
        @return: Percepcao , um modelo do ambiente 
        '''
        return self.sensor_multiplo.detectar()

    def __processar(self, percepcao):
        '''
        @param Percepcao : percepcao  Modelo do ambiente
        @return: Accao , accao que deve ser tomada, tendo em conta a percepcao do ambiente e o controlo definido
        '''
        return self.__controlo.processar(percepcao)

    def __actuar(self, accao):
        '''
        @param Accao: accao a ser tomada
        '''
        if accao is not None:
            self.actuador.actuar(accao)
        
        

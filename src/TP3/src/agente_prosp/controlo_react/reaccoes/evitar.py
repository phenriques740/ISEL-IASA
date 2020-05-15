from ecr.reaccao import Reaccao
from psa.actuador import ESQ, DIR, FRT
from psa.accao import Rodar

class Evitar(Reaccao):
    #percepcao[FRT].obstaculo é booleano -> Estimulo
    #percepcao[FRT].contacto é booleano
    #psa.accao -> Rodar
    #psa.actuador -> ESQ, FRT, DIR
    #Rodar(ESQ)
    def detectar_estimulo(percepcao):
        return percepcao[FRT].obstaculo

    def gerar_resposta(estimulo):
        pass
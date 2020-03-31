package TP1.Jogo.Ambiente;

import TP1.reaccao.reaccao_base.Accao;;

public enum AccaoAmb implements Accao {
	PATRULHAR, APROXIMAR, AVISAR, DEFENDER, ATACAR, PROCURAR, INICIAR;

	@Override
	public void executar() {
		System.out.printf("Accao : %s\n", this);
	}

}

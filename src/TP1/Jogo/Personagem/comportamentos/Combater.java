package TP1.Jogo.Personagem.comportamentos;

import TP1.Jogo.Ambiente.AccaoAmb;
import TP1.Jogo.Ambiente.EventoAmb;
import TP1.reaccao.ComportHieraq;
import TP1.reaccao.Comportamento;
import TP1.reaccao.reaccao_base.Reaccao;

public class Combater extends ComportHieraq {

	public Combater() {
		// TODO
		super(new Comportamento[]{
				new Reaccao(EventoAmb.INIMIGO, AccaoAmb.ATACAR),
				new Reaccao(EventoAmb.DERROTA, AccaoAmb.INICIAR),
				new Reaccao(EventoAmb.VITORIA, null),
				new Reaccao(EventoAmb.FUGA, null)});
	}

}

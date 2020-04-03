package TP1.Jogo.Personagem.comportamentos;

import TP1.Jogo.Ambiente.AccaoAmb;
import TP1.Jogo.Ambiente.EventoAmb;
import TP1.reaccao.ComportHieraq;
import TP1.reaccao.Comportamento;
import TP1.reaccao.reaccao_base.Reaccao;

public class Inspecionar extends ComportHieraq {

	public Inspecionar() {
		// TODO
		super(new Comportamento[]{
				new Reaccao(EventoAmb.INIMIGO, AccaoAmb.APROXIMAR),
				new Reaccao(EventoAmb.RUIDO, AccaoAmb.PROCURAR),
				new Reaccao(EventoAmb.SILENCIO, null)});
	}

}

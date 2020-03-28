package TP1.Jogo.Personagem;

import TP1.Jogo.Ambiente.EventoAmb;
import TP1.MaquinaEstados.Estado;
import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public class Personagem {
	public Personagem() {
		// TODO Auto-generated constructor stub

		// Definir estados
		Estado<Estimulo> patrulha = new Estado<Estimulo>("Patrulha");
		Estado<Estimulo> inspecao = new Estado<Estimulo>("Inspecao");
		Estado<Estimulo> defesa = new Estado<Estimulo>("Defesa");
		Estado<Estimulo> combate = new Estado<Estimulo>("Combate");

		// Definir transicoes patrulha
		patrulha
		.transicao(EventoAmb.INIMIGO, defesa)
		.transicao(EventoAmb.RUIDO, inspecao)
		.transicao(EventoAmb.SILENCIO,patrulha);   
	}

	private Estimulo e;
	private Accao a;

	public void executar() {
		// TODO
		System.out.println("Personagem a executar");
		e = percepcionar();
		a = processar(e);

		actuar(a);

		mostrar();
	}

	private Estimulo percepcionar() {
		// TODO
		return null;
	}

	private Accao processar(Estimulo e) {
		// TODO
		return null;
	}

	private void actuar(Accao a) {
		// TODO
	}

	private void mostrar() {
		// TODO
		System.out.println("PERSONAGEM RECEBEU O ESTIMULO " + e.toString() + " e reagiu com " + a.toString());
	}
}

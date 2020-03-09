package TP1.Jogo.Personagem;

import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public class Personagem {
	public Personagem() {
		// TODO Auto-generated constructor stub
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

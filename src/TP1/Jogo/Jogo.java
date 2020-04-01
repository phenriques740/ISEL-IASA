package TP1.Jogo;

import TP1.Jogo.Ambiente.Ambiente;
import TP1.Jogo.Ambiente.EventoAmb;
import TP1.Jogo.Personagem.Personagem;

class Jogo {
	public static void main(String[] args) {
		Jogo j = new Jogo();
		j.executar();
	}

	private Personagem p;
	private Ambiente a;

	private void executar() {
		a = new Ambiente();
		p = new Personagem(a);

		do {
			a.evoluir();
			p.executar();

		} while (a.getEvento() != EventoAmb.TERMINAR);
		System.out.println("FIM DO JOGO");
	}
}
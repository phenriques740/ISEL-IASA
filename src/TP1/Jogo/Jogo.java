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
		System.out.printf("Controlos\n");
		System.out.printf("\tEvento %s tecla %S\n", EventoAmb.SILENCIO, "s");
		System.out.printf("\tEvento %s tecla %S\n", EventoAmb.FUGA, "f");
		System.out.printf("\tEvento %s tecla %S\n", EventoAmb.INIMIGO, "i");
		System.out.printf("\tEvento %s tecla %S\n", EventoAmb.RUIDO, "r");
		System.out.printf("\tEvento %s tecla %S\n", EventoAmb.FUGA, "f");
		System.out.printf("\tEvento %s tecla %S\n", EventoAmb.TERMINAR, "t");

		do {
			a.evoluir();
			p.executar();
		} while (a.getEvento() != EventoAmb.TERMINAR);
		
		System.out.println("FIM DO JOGO");
	}
}
package TP1.Jogo;

class Jogo {
	public static void main(String[] args) {
		Jogo j = new Jogo();
		j.executar();
	}

	private Personagem p;
	private Ambiente a;

	private void executar() {
		p = new Personagem();
		a = new Ambiente();
		EventoAmb e;

		do {
			p.executar();
			a.evoluir();
			e = a.getEvento();
		} while (e != EventoAmb.TERMINAR);
	}

}
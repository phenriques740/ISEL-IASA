package TP1.Jogo.Ambiente;

public class Ambiente {
	EventoAmb ultimoEventoAmb;

	public Ambiente() {
		// TODO Auto-generated constructor stub
	}

	public void evoluir() {
		// TODO
		System.out.println("Ambiente a evoluir");
	}

	public EventoAmb getEvento() {
		ultimoEventoAmb = gerarEvento();
		return ultimoEventoAmb;
	}

	private EventoAmb gerarEvento() {
		// TODO

		System.out.println("TODO GERAR EVENTO");
		return null;
	}

	private void mostrar() {
		System.out.println(ultimoEventoAmb);
	}
}

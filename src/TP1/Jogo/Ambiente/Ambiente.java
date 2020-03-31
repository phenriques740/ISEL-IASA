package TP1.Jogo.Ambiente;

import java.util.Scanner;

public class Ambiente {
	EventoAmb ultimoEventoAmb;
	private Scanner sc;
	public Ambiente() {
		sc = new Scanner(System.in);

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
		System.out.println("\nEvento? ");
		String comando = sc.next();

		switch (comando.toLowerCase()) {
			case "s" :
				System.out.printf("Evento: %s\n", "SILENCIO");
				return EventoAmb.SILENCIO;
			case "r" :
				System.out.printf("Evento: %s\n", "RUIDO");
				return EventoAmb.RUIDO;
			case "i" :
				System.out.printf("Evento: %s\n", "INIMIGO");
				return EventoAmb.INIMIGO;
			case "f" :
				System.out.printf("Evento: %s\n", "FUGA");
				return EventoAmb.FUGA;
			case "v" :
				System.out.printf("Evento: %s\n", "VITORIA");
				return EventoAmb.VITORIA;
			case "d" :
				System.out.printf("Evento: %s\n", "DERROTA");
				return EventoAmb.DERROTA;
			case "t" :
				System.out.printf("Evento: %s\n", "TERMINAR");
				return EventoAmb.TERMINAR;
			default :
				System.out.println("Comando não reconhecido");
				return null;
		}
	}

	private void mostrar() {
		System.out.println(ultimoEventoAmb);
	}
}

package TP1.MaquinaEstados;

public class Estado<EV> {
	private final String nome;

	public Estado(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Estado<EV> transicao(EV evento, Estado<EV> estado) {
		// TODO
		return null;
	}

	public Estado<EV> processar(EV evento) {
		// TODO

		return null;
	}

	@Override
	public String toString() {
		return "Estado " + getNome();
	}
}

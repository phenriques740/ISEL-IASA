package TP1.MaquinaEstados;

public class Estado<EV> {
	private final String nome;

	public Estado(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Estado<?> transicao(EV evento, Estado<?> estado) {
		// TODO
		return null;
	}

	public Estado<?> processar(EV evento) {
		// TODO
		return null;
	}

	@Override
	public String toString() {
		return "Estado " + getNome();
	}
}

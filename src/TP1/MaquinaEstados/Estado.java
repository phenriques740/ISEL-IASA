package TP1.MaquinaEstados;

import java.util.Map;

public class Estado<EV> {
	private final String nome;
	private Map<EV, Estado<EV>> transicoes;

	public Estado(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Estado<EV> transicao(EV evento, Estado<EV> estado) {
		transicoes.put(evento, estado);
		return this;
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

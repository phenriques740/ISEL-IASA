package TP2.plantraj.modprob;

public abstract class Problema {
	private Estado estadoInicial;
	private Operador[] operadores;

	public Problema(Estado estadoInicial, Operador[] operadores) {
		this.estadoInicial = estadoInicial;
		this.operadores = operadores;
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public Operador[] getOperadores() {
		return operadores;
	}

	public abstract boolean objetivo(Estado estado);
}

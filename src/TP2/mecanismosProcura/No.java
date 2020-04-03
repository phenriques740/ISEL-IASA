package TP2.mecanismosProcura;

public class No {
	private int profundidade = 0;
	private double custo = 0;
	private Estado estado;
	private Operador operador;
	private No antecessor;

	public No(Estado estado) {
		this(estado, null, null);
	}
	public No(Estado estado, Operador operador, No antecessor) {
		this.estado = estado;
	}
	public Estado getEstado() {
		return estado;
	}
	public Operador getOperador() {
		return operador;
	}
	public No getAntecessor() {
		return antecessor;
	}
	public int getProfundidade() {
		return profundidade;
	}

	public double getCusto() {
		return custo;
	}

}

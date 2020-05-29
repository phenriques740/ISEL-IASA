package TP2.pee.mecanismosProcura.mem;

import TP2.PassoSolucao;
import TP2.plantraj.modprob.Estado;
import TP2.plantraj.modprob.Operador;

public class No implements PassoSolucao {
	private int profundidade;
	private double custo;
	private Estado estado;
	private Operador operador;
	private No antecessor;

	public No(Estado estado) {
		this(estado, null, null);
	}
	public No(Estado estado, Operador operador, No antecessor) {
		this.estado = estado;
		this.operador = operador;
		this.antecessor = antecessor;

		if (antecessor == null) {
			profundidade = 0;
			custo = 0;
		} else {
			profundidade = antecessor.getProfundidade() + 1;
			custo = antecessor.getCusto()
					+ operador.custo(antecessor.getEstado(), estado);
		}

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

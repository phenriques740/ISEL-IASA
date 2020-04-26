package TP2;

import TP2.plantraj.modprob.Estado;
import TP2.plantraj.modprob.Operador;

public interface PassoSolucao {
	public Estado getEstado();
	public Operador getOperador();
	public double getCusto();
}

package TP2.plantraj.modprob;

public abstract class ProblemaHeur extends Problema {

	public ProblemaHeur(Estado estadoInicial, Operador[] operadores) {
		super(estadoInicial, operadores);
		// TODO Auto-generated constructor stub
	}

	public abstract double heuristica(Estado estado);

}

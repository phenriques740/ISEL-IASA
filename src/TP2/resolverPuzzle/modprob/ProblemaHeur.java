package TP2.resolverPuzzle.modprob;

import TP2.plantraj.modprob.Estado;
import TP2.plantraj.modprob.Operador;
import TP2.plantraj.modprob.Problema;

public abstract class ProblemaHeur extends Problema {

	public ProblemaHeur(Estado estadoInicial, Operador[] operadores) {
		super(estadoInicial, operadores);
	}

	public abstract double heuristica(Estado estado);

}

package TP2;

import TP2.plantraj.modprob.Problema;

public interface Procura {
	public Solucao resolver(Problema problema);
	public Solucao resolver(Problema problema, int profMax);
	public String tipoDeProcura();
}

package TP2.pee.melhorprim;

import TP2.Solucao;
import TP2.plantraj.modprob.ProblemaHeur;

public interface ProcuraHeur {
	public abstract Solucao resolver(ProblemaHeur problema);
	public abstract Solucao resolver(ProblemaHeur problema, int profMax);
}

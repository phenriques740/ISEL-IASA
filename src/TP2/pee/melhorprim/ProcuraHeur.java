package TP2.pee.melhorprim;

import TP2.Solucao;
import TP2.resolverPuzzle.modprob.ProblemaHeur;

public interface ProcuraHeur {
	public Solucao resolver(ProblemaHeur problema);
	public Solucao resolver(ProblemaHeur problema, int profMax);
	public String tipoDeProcura();
}

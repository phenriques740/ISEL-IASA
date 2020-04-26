package TP2.pee.melhorprim;

import TP2.Solucao;

public interface ProcuraHeur {
	public abstract Solucao resolver(ProcuraHeur problema);
	public abstract Solucao resolver(ProcuraHeur problema, int profMax);
}

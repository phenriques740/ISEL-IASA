package TP2.pee.prof;

import TP2.Solucao;
import TP2.plantraj.modprob.Problema;

public class ProcuraProfIter extends ProcuraProf {
	private int incProf;
	public ProcuraProfIter(int incProf) {
		super();
		setIncProf(incProf);
	}

	public int getIncProf() {
		return incProf;
	}
	public void setIncProf(int incProf) {
		this.incProf = incProf;
	}

	public Solucao resolver(Problema problema, int profMax) {
		return null;
	}

}

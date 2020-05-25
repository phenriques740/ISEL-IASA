package TP2.pee.prof;

import TP2.Solucao;
import TP2.plantraj.modprob.Problema;

public class ProcuraProfIter extends ProcuraProf {
	private int incProf;
	private int profAtual;
	public ProcuraProfIter(int incProf) {
		super();
		setIncProf(incProf);
		profAtual = incProf;
	}

	public int getIncProf() {
		return incProf;
	}
	public void setIncProf(int incProf) {
		this.incProf = incProf;
	}

	public Solucao resolver(Problema problema, int profMax) {
		while (profAtual < profMax) {
			Solucao s = super.resolver(problema, profAtual);
			if (s != null) {
				return s;
			}
			profAtual += getIncProf();
		}
		return null;
	}
	@Override
	public String tipoDeProcura() {
		// TODO Auto-generated method stub
		return "profundidade iterativa";
	}
}

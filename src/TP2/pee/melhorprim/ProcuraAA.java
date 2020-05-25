package TP2.pee.melhorprim;

import TP2.pee.mecanismosProcura.mem.No;
import TP2.resolverPuzzle.modprob.ProblemaHeur;

public class ProcuraAA extends ProcuraMelhorPrim<ProblemaHeur>
		implements
			ProcuraHeur {

	@Override
	protected double f(No no) {
		return problema.heuristica(no.getEstado()) + no.getCusto();
	}

	@Override
	public String tipoDeProcura() {
		// TODO Auto-generated method stub
		return "AA";
	}

}

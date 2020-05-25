package TP2.pee.melhorprim;

import TP2.pee.mecanismosProcura.mem.No;
import TP2.resolverPuzzle.modprob.ProblemaHeur;

public class ProcuraSofrega extends ProcuraMelhorPrim<ProblemaHeur>
		implements
			ProcuraHeur {

	@Override
	protected double f(No no) {
		return problema.heuristica(no.getEstado());
	}

	@Override
	public String tipoDeProcura() {
		// TODO Auto-generated method stub
		return "sofrega";
	}

}

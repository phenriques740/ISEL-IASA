package TP2.pee.melhorprim;

import TP2.pee.mecanismosProcura.mem.No;
import TP2.plantraj.modprob.ProblemaHeur;

public class ProcuraSofrega extends ProcuraMelhorPrim<ProblemaHeur>
		implements
			ProcuraHeur {

	@Override
	protected double f(No no) {
		// TODO Auto-generated method stub
		return problema.heuristica(no.getEstado());
	}

}

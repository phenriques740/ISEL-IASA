package TP2.pee.melhorprim;

import TP2.Procura;
import TP2.pee.mecanismosProcura.mem.No;
import TP2.plantraj.modprob.Problema;

public class ProcuraCustoUnif extends ProcuraMelhorPrim<Problema>
		implements
			Procura {

	@Override
	protected double f(No no) {
		return no.getCusto();
	}

	@Override
	public String tipoDeProcura() {
		return "custo uniforme";
	}

}

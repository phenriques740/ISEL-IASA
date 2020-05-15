package TP2.pee.melhorprim;

import TP2.Procura;
import TP2.pee.mecanismosProcura.mem.MemoriaPrioridade;
import TP2.pee.mecanismosProcura.mem.MemoriaProcura;
import TP2.pee.mecanismosProcura.mem.No;
import TP2.plantraj.modprob.Problema;
public class ProcuraCustoUnif extends ProcuraMelhorPrim<Problema>
		implements
			Procura {

	@Override
	protected MemoriaProcura iniciarMemoria() {
		return new MemoriaPrioridade(this);
	}

	@Override
	protected double f(No no) {
		return no.getCusto();
	}

}

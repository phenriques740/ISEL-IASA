package TP2.pee.melhorprim;

import java.util.Comparator;

import TP2.pee.mecanismosProcura.mem.MecanismoProcura;
import TP2.pee.mecanismosProcura.mem.MemoriaPrioridade;
import TP2.pee.mecanismosProcura.mem.MemoriaProcura;
import TP2.pee.mecanismosProcura.mem.No;
import TP2.plantraj.modprob.Problema;

public abstract class ProcuraMelhorPrim<P extends Problema>
		extends
			MecanismoProcura<P>
		implements
			Comparator<No> {

	@Override
	protected MemoriaProcura iniciarMemoria() {
		return new MemoriaPrioridade(this);
	}

	@Override
	public int compare(No n1, No n2) {
		return Double.compare(f(n1), f(n2));
	}
	protected abstract double f(No no);
}

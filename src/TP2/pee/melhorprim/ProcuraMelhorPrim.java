package TP2.pee.melhorprim;

import java.util.Comparator;

import TP2.pee.mecanismosProcura.mem.MecanismoProcura;
import TP2.pee.mecanismosProcura.mem.MemoriaProcura;
import TP2.pee.mecanismosProcura.mem.No;
import TP2.plantraj.modprob.Problema;

public abstract class ProcuraMelhorPrim<P extends Problema>
		extends
			MecanismoProcura<P>
		implements
			Comparator<No> {

	protected MemoriaProcura iniciarMemoria() {
		//TODO
		return null;

	}
	public int compare(No o1, No o2) {
		return Double.compare(f(o1), f(o2));
	}
	protected abstract double f(No no);
}

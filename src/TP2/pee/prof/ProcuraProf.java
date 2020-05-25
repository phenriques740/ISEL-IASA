package TP2.pee.prof;

import TP2.Procura;
import TP2.pee.mecanismosProcura.mem.MecanismoProcura;
import TP2.pee.mecanismosProcura.mem.MemoriaLIFO;
import TP2.pee.mecanismosProcura.mem.MemoriaProcura;
import TP2.plantraj.modprob.Problema;

public class ProcuraProf extends MecanismoProcura<Problema> implements Procura {

	@Override
	public MemoriaProcura iniciarMemoria() {
		return new MemoriaLIFO();
	}

	@Override
	public String tipoDeProcura() {
		// TODO Auto-generated method stub
		return "profundidade";
	}

}

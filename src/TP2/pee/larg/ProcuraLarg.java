package TP2.pee.larg;

import TP2.Procura;
import TP2.pee.mecanismosProcura.mem.MecanismoProcura;
import TP2.pee.mecanismosProcura.mem.MemoriaFIFO;
import TP2.pee.mecanismosProcura.mem.MemoriaProcura;
import TP2.plantraj.modprob.Problema;

public class ProcuraLarg extends MecanismoProcura<Problema> implements Procura {

	@Override
	public MemoriaProcura iniciarMemoria() {
		return new MemoriaFIFO();
	}

}

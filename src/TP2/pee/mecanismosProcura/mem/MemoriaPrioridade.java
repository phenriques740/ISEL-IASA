package TP2.pee.mecanismosProcura.mem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MemoriaPrioridade extends MemoriaProcura {

	public MemoriaPrioridade(Comparator<No> comparator) {
		super(new PriorityQueue<No>());
	}

}

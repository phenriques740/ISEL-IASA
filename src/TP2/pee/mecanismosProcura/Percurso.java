package TP2.pee.mecanismosProcura;

import java.util.Iterator;
import java.util.LinkedList;

import TP2.PassoSolucao;
import TP2.Solucao;
import TP2.pee.mecanismosProcura.mem.No;

public class Percurso implements Solucao {
	private LinkedList<PassoSolucao> percurso;

	public Percurso() {
		percurso = new LinkedList<PassoSolucao>();
	}

	@Override
	public Iterator<PassoSolucao> iterator() {
		return percurso.iterator();
	}

	@Override
	/**
	 * Devolve o numero de passos que o percurso possui
	 * 
	 */
	public int getDimensao() {
		return percurso.size();
	}

	@Override
	public double getCusto() {
		return percurso.getLast().getCusto();
	}

	public void juntarInicio(No no) {
		percurso.addFirst(no);
	}

}

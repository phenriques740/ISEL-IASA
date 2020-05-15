package TP2.pee.mecanismosProcura.mem;

import java.util.LinkedList;
import java.util.Queue;

public class MemoriaProcura {
	protected Queue<No> fronteira;
	protected LinkedList<No> explorados;

	public MemoriaProcura(Queue<No> fronteira) {
		this.fronteira = fronteira;
		this.explorados = new LinkedList<No>();
	}

	public void limpar() {
		fronteira.clear();
		explorados.clear();
	}

	public void inserir(No no) {
		for (No n : explorados) {
			if (n.getEstado().equals(no.getEstado())) {
				return;
			}
		}

		for (No n : fronteira) {
			if (n.getEstado().equals(no.getEstado())) {
				return;
			}
		}
		fronteira.add(no);
	}

	public No remover() {
		No n = fronteira.poll();
		explorados.add(n);
		return n;
	}

	public boolean fronteiraVazia() {
		return fronteira.isEmpty();
	}
}

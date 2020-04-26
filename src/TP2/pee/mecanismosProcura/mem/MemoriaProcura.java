package TP2.pee.mecanismosProcura.mem;

import java.util.LinkedList;
import java.util.Queue;

public class MemoriaProcura {
	private Queue<No> fronteira;
	private LinkedList<No> expandidos;

	public MemoriaProcura(Queue<No> fronteira) {
		this.fronteira = fronteira;
		this.expandidos = new LinkedList<No>();
	}

	public void limpar() {
		fronteira.clear();
		expandidos.clear();
	}

	public void inserir(No no) {
		for (No n : expandidos) {
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
		expandidos.add(n);
		return n;
	}

	public boolean fronteiraVazia() {
		return fronteira.isEmpty();
	}
}

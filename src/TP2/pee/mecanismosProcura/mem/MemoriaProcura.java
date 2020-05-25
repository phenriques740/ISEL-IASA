package TP2.pee.mecanismosProcura.mem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import TP2.plantraj.modprob.Estado;

public class MemoriaProcura {
	protected Queue<No> fronteira;
	protected HashMap<Estado, No> explorados;

	public MemoriaProcura(Queue<No> fronteira) {
		this.fronteira = fronteira;
		this.explorados = new HashMap<Estado, No>();
	}

	public void limpar() {
		fronteira.clear();
		explorados.clear();
	}

	public void inserir(No no) {
		Estado estado = no.getEstado();
		No noMemoria = explorados.get(estado);

		if (noMemoria == null || no.getCusto() < noMemoria.getCusto()) {
			fronteira.add(no);
			explorados.put(estado, no);
		}
	}

	public No remover() {
		No n = fronteira.poll();
		return n;
	}

	public boolean fronteiraVazia() {
		return fronteira.isEmpty();
	}
}

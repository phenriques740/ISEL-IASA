package TP2.mecanismosProcura;

import java.util.Queue;

public class MemoriaProcura {
	private Queue<No> fronteira;

	public MemoriaProcura(Queue<No> fronteira) {
		this.fronteira = fronteira;
	}

	public void limpar() {
		fronteira.clear();
	}

	public void inserir(No no) {
		fronteira.add(no);
	}

	/**
	 * Remove o primeiro nó
	 * 
	 * @return
	 */
	public No remover() {
		return fronteira.poll();
	}

	public boolean fronteiraVazia() {
		return fronteira.isEmpty();
	}
}

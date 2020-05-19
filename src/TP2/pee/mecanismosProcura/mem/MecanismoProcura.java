package TP2.pee.mecanismosProcura.mem;

import TP2.Solucao;
import TP2.pee.mecanismosProcura.Percurso;
import TP2.plantraj.modprob.Estado;
import TP2.plantraj.modprob.Operador;
import TP2.plantraj.modprob.Problema;

public abstract class MecanismoProcura<P extends Problema> {
	private MemoriaProcura memoria;
	protected P problema;

	public MecanismoProcura() {
		memoria = iniciarMemoria();
	}

	protected abstract MemoriaProcura iniciarMemoria();

	public Solucao resolver(P problema) {
		return resolver(problema, Integer.MAX_VALUE);
	}

	public Solucao resolver(P problema, int profMax) {
		this.problema = problema;
		memoria.limpar();
		No noInicial = new No(problema.getEstadoInicial());
		memoria.inserir(noInicial);

		while (!(memoria.fronteiraVazia())) {
			No no = memoria.remover();
			if (this.problema.objetivo(no.getEstado())) {
				return gerarSolucao(no);
			} else {
				if (no.getProfundidade() < profMax) {
					expandir(no);
				}
			}
		}
		return null;
	}

	/**
	 * Aplica os operadores definidos para o problema no nó.
	 * 
	 * @param no
	 */
	private void expandir(No no) {
		Estado estado = no.getEstado();

		for (Operador operador : problema.getOperadores()) {
			Estado estadoSuc = operador.aplicar(estado);
			if (estadoSuc != null) {
				No noSuc = new No(estadoSuc, operador, no);
				memoria.inserir(noSuc);
			}
		}
	}

	/**
	 * Gera a solucao para um problema apos ter sido achada uma solucao num
	 * determinado nó.
	 * 
	 * Tendo como ponto de partida o nó final, irá navegar pela arvore até
	 * atingir a sua raiz, devolvendo o caminho percorrido como a solucao para o
	 * problema em causa.
	 * 
	 * @param noFinal
	 *            no onde foi encontrada a solucao para o problema
	 * 
	 * @return Solucao neste caso, percurso a percorrer
	 */
	private Solucao gerarSolucao(No noFinal) {
		Percurso p = new Percurso();
		No no = noFinal;
		while (no != null) {
			p.juntarInicio(no);
			no = no.getAntecessor();
		}

		return p;
	}
}

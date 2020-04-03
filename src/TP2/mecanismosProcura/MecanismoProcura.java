package TP2.mecanismosProcura;

public abstract class MecanismoProcura {
	private MemoriaProcura memoria;
	private Problema problema;
	public MecanismoProcura() {
		memoria = iniciarMemoria();
	}

	public abstract MemoriaProcura iniciarMemoria();

	public Solucao resolver(Problema problema) {
		return resolver(problema, Integer.MAX_VALUE);
	}

	public Solucao resolver(Problema problema, int profMax) {
		this.problema = problema;
		memoria.limpar();
		No noInicial = new No(problema.getEstadoInicial());
		memoria.inserir(noInicial);

		while (!(memoria.fronteiraVazia())) {
			No no = memoria.remover();
			if (problema.objetivo(no.getEstado())) {
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

	}
	private Solucao gerarSolucao(No noFinal) {
		return null;
	}
}

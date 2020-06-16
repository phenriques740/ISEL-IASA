package TP2.plantraj;

import TP2.PassoSolucao;
import TP2.Procura;
import TP2.Solucao;
import TP2.pee.larg.ProcuraLarg;
import TP2.pee.melhorprim.ProcuraAA;
import TP2.pee.melhorprim.ProcuraCustoUnif;
import TP2.pee.melhorprim.ProcuraHeur;
import TP2.pee.melhorprim.ProcuraSofrega;
import TP2.pee.prof.ProcuraProf;
import TP2.pee.prof.ProcuraProfIter;
import TP2.plantraj.modprob.OperadorLigacao;
import TP2.plantraj.modprob.ProblemaPlanTraj;

public class PlaneadorTrajecto {
	public static void main(String[] args) {
		if (args.length != 3) {
			throw new IllegalArgumentException("Indique 3 inteiros, \n\t"
					+ "1º entre 0 e 3, que corresponde ao metodo de procura"
					+ "2º entre 0 e 6, que corresponde á localidade de inicio"
					+ "3º entre 0 e 6, que corresponde á localidade de destino");
		}

		OperadorLigacao[] operadores = definirOperadores();

		ProblemaPlanTraj problema = new ProblemaPlanTraj("Loc-" + args[1],
				"Loc-" + args[2], operadores);

		Procura mecProcura = null;
		switch (args[0]) {
			case "0" :
				mecProcura = new ProcuraLarg();
				break;
			case "1" :
				mecProcura = new ProcuraProf();
				break;
			case "2" :
				mecProcura = new ProcuraProfIter(3);
				break;
			case "3" :
				mecProcura = new ProcuraCustoUnif();
				break;
			default :
				throw new IllegalArgumentException(
						"O digito correspondente a metodo de procura, nao informada, deve estar entre 0 e 3");
		}

		// Até aqui funciona, depois já não
		Solucao solucao = mecProcura.resolver(problema);

		mostrarTrajeto(solucao);
	}
	private static OperadorLigacao[] definirOperadores() {
		OperadorLigacao[] operadores = new OperadorLigacao[11];
		operadores[0] = new OperadorLigacao("Loc-0", "Loc-1", 5);
		operadores[1] = new OperadorLigacao("Loc-0", "Loc-2", 25);
		operadores[2] = new OperadorLigacao("Loc-1", "Loc-3", 12);
		operadores[3] = new OperadorLigacao("Loc-1", "Loc-6", 5);
		operadores[4] = new OperadorLigacao("Loc-2", "Loc-4", 30);
		operadores[5] = new OperadorLigacao("Loc-3", "Loc-2", 10);
		operadores[6] = new OperadorLigacao("Loc-3", "Loc-5", 5);
		operadores[7] = new OperadorLigacao("Loc-4", "Loc-3", 2);
		operadores[8] = new OperadorLigacao("Loc-5", "Loc-6", 8);
		operadores[9] = new OperadorLigacao("Loc-5", "Loc-4", 10);
		operadores[10] = new OperadorLigacao("Loc-6", "Loc-3", 15);

		return operadores;

	}

	// Dada uma solucao, segue os passos até á raiz
	private static void mostrarTrajeto(Solucao solucao) {
		if (solucao != null) {
			for (PassoSolucao p : solucao) {
				System.out.println(p.getEstado());
			}
			System.out.println("Custo " + solucao.getCusto());
			System.out.println("Dimensao " + solucao.getDimensao());
			return;
		}
		System.out.println("Nao há solucao");
	}
}
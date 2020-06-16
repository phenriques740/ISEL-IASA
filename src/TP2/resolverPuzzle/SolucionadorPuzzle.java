package TP2.resolverPuzzle;

import java.util.Arrays;
import java.util.Random;

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
import TP2.resolverPuzzle.modprob.MetodoDeProcuraHeuristica;
import TP2.resolverPuzzle.modprob.OperadorPuzzle;
import TP2.resolverPuzzle.modprob.ProblemaPuzzle;
import puzzle.Puzzle;
import puzzle.Puzzle.Movimento;

public class SolucionadorPuzzle {

	public static void main(String[] args) {
		int[] argumentos = new int[4];

		if (!(args.length == 3 || (args.length == 4 && args[1].equals("1")))) {
			throw new IllegalArgumentException(
					"\nPor favor indique tres inteiros, que correspondem a:"
							+ "\n\tPuzzle a ser resolvido [0:1]"
							+ "\n\tMetodos de procura informada? 0-Nao, 1-Sim"
							+ "\n\tMetodo de procura [0:3]"
							+ "\n\tSe procura informada, qual? 0-Distancia Manhattan 1-Numero de pecas fora do lugar");
		}

		for (int i = 0; i < args.length; i++) {
			argumentos[i] = Integer.parseInt(args[i]);
		}

		int[][] grelhaSolucao = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

		int[][] arr1 = {{0, 5, 2}, {4, 3, 1}, {7, 8, 6}};
		int[][] arr2 = {{5, 1, 2}, {3, 0, 4}, {8, 6, 7}};
		OperadorPuzzle[] operadores = definirOperadores();

		Puzzle puzzleSolucao = new Puzzle(grelhaSolucao);
		Puzzle baralhado;
		if (argumentos[0] == 0) {
			baralhado = new Puzzle(arr1);
		} else if (argumentos[0] == 1) {
			baralhado = new Puzzle(arr2);
		} else {
			throw new IllegalArgumentException(
					"O digito correspondente a puzzle deve ser 0 ou 1");
		}

		ProblemaPuzzle problema = null;
		Procura mecProcura = null;
		ProcuraHeur mecProcuraHeur = null;

		if (argumentos[1] == 0) {
			problema = new ProblemaPuzzle(baralhado, puzzleSolucao, operadores);
			switch (argumentos[2]) {
				case 0 :
					mecProcura = new ProcuraLarg();
					break;
				case 1 :
					mecProcura = new ProcuraProf();
					break;
				case 2 :
					mecProcura = new ProcuraProfIter(10);
					break;
				case 3 :
					mecProcura = new ProcuraCustoUnif();
					break;
				default :
					throw new IllegalArgumentException(
							"O digito correspondente a metodo de procura, nao informada, deve estar entre 0 e 3");
			}
		} else if (argumentos[1] == 1) {
			switch (argumentos[2]) {
				case 0 :
					mecProcuraHeur = new ProcuraSofrega();
					break;
				case 1 :
					mecProcuraHeur = new ProcuraAA();

					break;
				default :
					throw new IllegalArgumentException(
							"O digito correspondente, a metodo de procura, informada, deve ser 0 ou 1");
			}
			switch (argumentos[3]) {
				case 0 :
					problema = new ProblemaPuzzle(baralhado, puzzleSolucao,
							operadores,
							MetodoDeProcuraHeuristica.numPecasForaDoLugar);
					break;
				case 1 :
					problema = new ProblemaPuzzle(baralhado, puzzleSolucao,
							operadores,
							MetodoDeProcuraHeuristica.distanciaManhattan);
					break;
				default :
					throw new IllegalArgumentException(
							"O digito correspondente, á funcao heuristica, deve ser 0 ou 1");
			}
		} else {
			throw new IllegalArgumentException(
					"O digito correspondente, ao puzzle, deve ser 0 ou 1");

		}

		System.out.println("Puzzle " + baralhado);
		Solucao solucao;
		if (argumentos[1] == 0) {
			solucao = mecProcura.resolver(problema, 5000);
			System.out.println("Procura " + mecProcura.tipoDeProcura());
		} else {
			solucao = mecProcuraHeur.resolver(problema);
			System.out.println("Procura " + mecProcuraHeur.tipoDeProcura());
		}

		mostrarPassos(solucao);
	}

	@SuppressWarnings("unused")
	private static int[][] gerarArrayPecas(int dimX, int dimY) {
		int[][] out = new int[dimX][dimY];
		int idx = 0;
		Random random = new Random();

		// gerar um puzzle ordenado
		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++) {
				out[i][j] = idx++;
			}
		}

		// baralharArray
		for (int i = out.length - 1; i > 0; i--) {
			for (int j = out[i].length - 1; j > 0; j--) {
				int m = random.nextInt(i + 1);
				int n = random.nextInt(j + 1);

				int temp = out[i][j];
				out[i][j] = out[m][n];
				out[m][n] = temp;
			}
		}
		return out;
	}

	private static OperadorPuzzle[] definirOperadores() {
		OperadorPuzzle[] operador = {new OperadorPuzzle(Movimento.CIMA),
				new OperadorPuzzle(Movimento.BAIXO),
				new OperadorPuzzle(Movimento.DIR),
				new OperadorPuzzle(Movimento.ESQ)};
		return operador;
	}

	private static void mostrarPassos(Solucao solucao) {
		for (PassoSolucao passo : solucao) {
			System.out.println(passo.getEstado());
		}
		System.out.println("Num passos " + solucao.getCusto());
	}
}

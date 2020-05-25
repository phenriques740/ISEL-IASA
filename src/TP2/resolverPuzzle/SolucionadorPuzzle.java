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
		int[][] grelhaSolucao = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

		int[][] arr1 = {{0, 5, 2}, {4, 3, 1}, {7, 8, 6}};
		int[][] arr2 = {{5, 1, 2}, {3, 0, 4}, {8, 6, 7}};

		System.out.println(Arrays.deepToString(arr2));
		OperadorPuzzle[] operadores = definirOperadores();

		Puzzle baralhado = new Puzzle(arr1);
		Puzzle puzzleSolucao = new Puzzle(grelhaSolucao);
		// ProblemaPuzzle problema = new ProblemaPuzzle(baralhado,
		// puzzleSolucao,
		// operadores);

		// ProblemaPuzzle problema = new ProblemaPuzzle(baralhado,
		// puzzleSolucao,
		// operadores, MetodoDeProcuraHeuristica.numPecasForaDoLugar);

		ProblemaPuzzle problema = new ProblemaPuzzle(baralhado, puzzleSolucao,
				operadores, MetodoDeProcuraHeuristica.distanciaManhattan);

		// Procura mecProcura = new ProcuraLarg();
		// Procura mecProcura = new ProcuraProf();
		// Procura mecProcura = new ProcuraProfIter(10);
		// Procura mecProcura = new ProcuraCustoUnif();

		ProcuraHeur mecProcura = new ProcuraSofrega();
		// ProcuraHeur mecProcura = new ProcuraAA();

		Solucao solucao = mecProcura.resolver(problema, 5000);

		System.out.println("Procura " + mecProcura.tipoDeProcura());
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

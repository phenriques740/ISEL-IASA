package TP2.resolverPuzzle.modprob;

import TP2.plantraj.modprob.Estado;
import TP2.plantraj.modprob.Operador;
import puzzle.Puzzle;
import puzzle.Puzzle.Movimento;

public class OperadorPuzzle implements Operador {
	private int custo;
	private Movimento m;
	public OperadorPuzzle(Movimento m) {
		this.m = m;
		this.custo = 1;
	}

	@Override
	public Estado aplicar(Estado estado) {
		EstadoPuzzle estadoAtual = (EstadoPuzzle) estado;

		Puzzle puzzleAnt = estadoAtual.getPuzzle();
		Puzzle puzzleSuc = puzzleAnt.movimentar(m);

		if (puzzleSuc != null) {

			return new EstadoPuzzle(puzzleSuc);
		}
		return null;
	}

	@Override
	public double custo(Estado estado, Estado estadoSuc) {
		return this.custo;
	}

}

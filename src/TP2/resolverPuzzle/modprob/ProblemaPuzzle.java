package TP2.resolverPuzzle.modprob;

import TP2.plantraj.modprob.Estado;
import puzzle.Puzzle;

public class ProblemaPuzzle extends ProblemaHeur {
	private EstadoPuzzle estadoObjetivo;
	private MetodoDeProcuraHeuristica metodoDeProcura;

	public ProblemaPuzzle(Puzzle puzzleInicial, Puzzle puzzleFinal,
			OperadorPuzzle[] operadores) {
		this(puzzleInicial, puzzleFinal, operadores,
				MetodoDeProcuraHeuristica.numPecasForaDoLugar);
	}

	public ProblemaPuzzle(Puzzle puzzleInicial, Puzzle puzzleFinal,
			OperadorPuzzle[] operadores,
			MetodoDeProcuraHeuristica problemaHeur) {

		super(new EstadoPuzzle(puzzleInicial), operadores);
		this.estadoObjetivo = new EstadoPuzzle(puzzleFinal);
		this.metodoDeProcura = problemaHeur;
	}
	@Override
	public boolean objetivo(Estado estado) {
		return estado.equals(estadoObjetivo);
	}
	@Override
	public double heuristica(Estado e) {
		EstadoPuzzle estado = (EstadoPuzzle) e;

		switch (metodoDeProcura) {
			case distanciaManhattan :
				return estado.getPuzzle()
						.distManhattan(estadoObjetivo.getPuzzle());
			default :
				return estado.getPuzzle()
						.numPecasForaLugar(estadoObjetivo.getPuzzle());
		}
	}
}

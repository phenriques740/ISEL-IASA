package TP2.resolverPuzzle.modprob;

import TP2.plantraj.modprob.Estado;
import puzzle.Puzzle;

public class EstadoPuzzle extends Estado {
	private final Puzzle p;

	public EstadoPuzzle(Puzzle p) {
		this.p = p;
	}
	@Override
	public int hashCode() {
		return p.hashCode();
	}
	@Override
	public String toString() {
		return p.toString();
	}

	public Puzzle getPuzzle() {
		return p;
	}
}

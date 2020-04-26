package TP2;

import java.util.Iterator;

public interface Solucao extends Iterable<PassoSolucao> {

	public Iterator<PassoSolucao> iterator();
	public int getDimensao();
	public double getCusto();
}

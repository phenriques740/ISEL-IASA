package TP2.plantraj.modprob;

public interface Operador {
	public Estado aplicar(Estado estado);
	public double custo(Estado estado, Estado estadoSuc);
}

package TP2.mecanismosProcura;

public interface Operador {
	public Estado aplicar(Estado estado);
	public double custo(Estado estado, Estado estadoSuc);
}

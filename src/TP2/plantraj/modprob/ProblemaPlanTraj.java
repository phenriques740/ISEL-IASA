package TP2.plantraj.modprob;

public class ProblemaPlanTraj extends Problema {
	private EstadoLocalidade estadoObjetivo;

	public ProblemaPlanTraj(String localInicial, String localFinal,
			OperadorLigacao[] operadores) {

		super(new EstadoLocalidade(localInicial), operadores);
		this.estadoObjetivo = new EstadoLocalidade(localFinal);

	}

	public boolean objetivo(Estado estado) {
		return estado.equals(estadoObjetivo);
	}
}

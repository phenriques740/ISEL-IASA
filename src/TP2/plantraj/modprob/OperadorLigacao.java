package TP2.plantraj.modprob;

public class OperadorLigacao implements Operador {
	private int custoLigacao;
	private EstadoLocalidade estadoOrigem, estadoDestino;

	public OperadorLigacao(String localizacaoInicial, String localizacaoFinal,
			int custo) {
		estadoOrigem = new EstadoLocalidade(localizacaoInicial);
		estadoDestino = new EstadoLocalidade(localizacaoFinal);
		custoLigacao = custo;
	}

	@Override
	public Estado aplicar(Estado estado) {
		if (estado.equals(estadoOrigem)) {
			return estadoDestino;
		}
		return null;
	}

	@Override
	public double custo(Estado estado, Estado estadoSuc) {
		// TODO Auto-generated method stub
		return custoLigacao;
	}

}

package TP2.plantraj.modprob;

public class EstadoLocalidade extends Estado {
	private final String localidade;

	public EstadoLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@Override
	public int hashCode() {
		return localidade.hashCode();
	}

	@Override
	public String toString() {
		return localidade;
	}

}

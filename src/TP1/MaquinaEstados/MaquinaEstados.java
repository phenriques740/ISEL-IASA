package TP1.MaquinaEstados;

public class MaquinaEstados<EV> {
	private Estado<EV> estado;

	public MaquinaEstados(Estado<EV> estado) {
		this.estado = estado;
	}

	public Estado<EV> getEstado() {
		return estado;
	}

	public void processar(EV evento) {
		Estado<EV> novoEstado = estado.processar(evento);
		if (novoEstado != null)
			estado = novoEstado;
	}
}

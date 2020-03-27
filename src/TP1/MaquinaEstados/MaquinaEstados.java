package TP1.MaquinaEstados;

public class MaquinaEstados<EV> {
	private Estado estado;

	public MaquinaEstados(Estado<?> estado) {
		// TODO fix argumentos
	}

	public Estado<EV> getEstado() {
		// TODO
		return estado;
	}

	public void processar(EV evento) {
		Estado<EV> novoEstado = estado.processar(evento);
		if (novoEstado != null)
			estado = novoEstado;
	}
}

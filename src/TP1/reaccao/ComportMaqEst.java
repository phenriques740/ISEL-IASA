package TP1.reaccao;

import TP1.MaquinaEstados.MaquinaEstados;
import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public class ComportMaqEst implements Comportamento {
	private MaquinaEstados<? extends Estimulo> maqEstados;

	public ComportMaqEst() {
		// TODO Auto-generated constructor stub
	}

	public Estado<? extends Estimulo> getEstado() {
		// TODO
		return null;
	}

	protected MaquinaEstados<? extends Estimulo> iniciar() {
		// TODO
		return null;
	}

	@Override
	public Accao activar(Estimulo estimulo) {
		// TODO fix argumento
		return null;
	}

	public ComportMaqEst comport(Estado<? extends Estimulo> estado, Comportamento comport) {
		// TODO
		return null;
	}

}

package TP1.reaccao;

import java.util.HashMap;
import java.util.Map;

import TP1.MaquinaEstados.Estado;
import TP1.MaquinaEstados.MaquinaEstados;
import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public abstract class ComportMaqEst implements Comportamento {
	private MaquinaEstados<Estimulo> maqEstados;
	private Map<Estado<Estimulo>, Comportamento> comportamentos = new HashMap<Estado<Estimulo>, Comportamento>();
	private Estado<Estimulo> estado;

	public ComportMaqEst() {
		// TODO Auto-generated constructor stub
	}

	public Estado<Estimulo> getEstado() {
		return estado;
	}

	protected abstract MaquinaEstados<Estimulo> iniciar();

	@Override
	public Accao activar(Estimulo estimulo) {
		// TODO fix argumento
		return null;
	}

	public ComportMaqEst comport(Estado<Estimulo> estado, Comportamento comport) {
		// TODO
		return this;
	}

}

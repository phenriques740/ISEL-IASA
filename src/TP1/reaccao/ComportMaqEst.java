package TP1.reaccao;

import java.util.HashMap;
import java.util.Map;

import TP1.MaquinaEstados.Estado;
import TP1.MaquinaEstados.MaquinaEstados;
import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public abstract class ComportMaqEst implements Comportamento {
	private MaquinaEstados<Estimulo> maqEstados;
	private Map<Estado<Estimulo>, Comportamento> comportamentos;

	public ComportMaqEst() {
		comportamentos = new HashMap<Estado<Estimulo>, Comportamento>();
		maqEstados = iniciar();
	}

	public Estado<Estimulo> getEstado() {
		return maqEstados.getEstado();
	}

	protected abstract MaquinaEstados<Estimulo> iniciar();

	/**
	 * Retorna a accao a realizar associada ao estado atual e ao estimulo
	 * passado como argumento.
	 * 
	 * Faz evoluir o estado da maquina de estados associada ao comportamento em
	 * funcao do estimulo.
	 * 
	 * @param Estimulo
	 *            estimulo
	 * 
	 * @return Accao a ser efetuada
	 */
	@Override
	public Accao activar(Estimulo estimulo) {
		Comportamento c = comportamentos.get(maqEstados.getEstado());
		maqEstados.processar(estimulo);

		return c.activar(estimulo);
	}

	public ComportMaqEst comport(Estado<Estimulo> estado,
			Comportamento comport) {

		comportamentos.put(estado, comport);

		return this;
	}

}

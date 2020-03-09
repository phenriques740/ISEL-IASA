package TP1.reaccao;

import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public class ComportHieraq implements Comportamento {

	private Comportamento[] comportamentos;

	public ComportHieraq(Comportamento[] comportamentos) {
		this.comportamentos = comportamentos;
	}

	/*
	 * Este metodo assume que os estimulos introduzidos no construtor estão
	 * ordenados por prioridade
	 */
	public Accao activar(Estimulo estimulo) {
		for (Comportamento comportamento : comportamentos) {
			Accao a = comportamento.activar(estimulo);
			if (a != null) {
				return a;
			}
		}
		return null;
	}
}

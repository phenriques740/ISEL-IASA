package TP1.reaccao.reaccao_base;

import TP1.reaccao.Comportamento;

/**
 * Esta classe corresponde uma reacao a um estimulo, por exemplo, um susto
 * corresponde um salto.
 * 
 * @author Pedro Henriques
 *
 */
public class Reaccao implements Comportamento {
	private Estimulo estimulo;
	private Accao resposta;

	public Reaccao(Estimulo e, Accao a) {
		estimulo = e;
		resposta = a;
	}

	/**
	 * Se o estimulo corresponder, fazer a acao
	 * 
	 * @param e estimulo a avaliar
	 * @return
	 */

	public Accao activar(Estimulo e) {
		return e.equals(estimulo) ? resposta : null;
	}

}

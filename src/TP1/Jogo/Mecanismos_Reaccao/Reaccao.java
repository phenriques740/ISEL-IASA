package TP1.Jogo.Mecanismos_Reaccao;

public class Reaccao {
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

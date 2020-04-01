package TP1.Jogo.Personagem;

import TP1.Jogo.Ambiente.Ambiente;
import TP1.Jogo.Ambiente.EventoAmb;
import TP1.Jogo.Personagem.comportamentos.ComportPersonagem;
import TP1.MaquinaEstados.Estado;
import TP1.reaccao.reaccao_base.Accao;
import TP1.reaccao.reaccao_base.Estimulo;

public class Personagem {

	private Estimulo e;
	private Accao a;
	private ComportPersonagem comportamento;
	private Ambiente ambiente;

	public Personagem(Ambiente ambiente) {
		comportamento = new ComportPersonagem();
		this.ambiente = ambiente;
	}

	public void executar() {
		// TODO
		// System.out.println("Personagem a executar");
		e = percepcionar();
		a = processar(e);

		actuar(a);

		mostrar();
	}

	private Estimulo percepcionar() {
		return ambiente.getEvento();
	}

	private Accao processar(Estimulo estimulo) {
		return comportamento.activar(estimulo);
	}

	private void actuar(Accao accao) {
		if (accao != null)
			accao.executar();
	}

	private void mostrar() {
		// TODO
		System.out.println(comportamento.getEstado());
	}
}

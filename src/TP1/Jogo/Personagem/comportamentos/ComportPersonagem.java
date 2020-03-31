package TP1.Jogo.Personagem.comportamentos;

import TP1.Jogo.Ambiente.EventoAmb;
import TP1.MaquinaEstados.Estado;
import TP1.MaquinaEstados.MaquinaEstados;
import TP1.reaccao.ComportMaqEst;
import TP1.reaccao.reaccao_base.Estimulo;

public class ComportPersonagem extends ComportMaqEst {
	protected MaquinaEstados<Estimulo> iniciar() {
		// Definir estados
		Estado<Estimulo> patrulha = new Estado<Estimulo>("Patrulha");
		Estado<Estimulo> inspecao = new Estado<Estimulo>("Inspecao");
		Estado<Estimulo> defesa = new Estado<Estimulo>("Defesa");
		Estado<Estimulo> combate = new Estado<Estimulo>("Combate");

		patrulha.transicao(EventoAmb.INIMIGO, defesa);
		patrulha.transicao(EventoAmb.RUIDO, inspecao);
		patrulha.transicao(EventoAmb.SILENCIO, patrulha);

		inspecao.transicao(EventoAmb.INIMIGO, defesa);
		inspecao.transicao(EventoAmb.RUIDO, inspecao);
		inspecao.transicao(EventoAmb.SILENCIO, patrulha);

		defesa.transicao(EventoAmb.FUGA, inspecao);
		defesa.transicao(EventoAmb.INIMIGO, combate);

		combate.transicao(EventoAmb.INIMIGO, combate);
		combate.transicao(EventoAmb.VITORIA, patrulha);
		combate.transicao(EventoAmb.DERROTA, patrulha);

		comport(patrulha, new Patrulhar());
		comport(inspecao, new Inspecionar());
		comport(defesa, new Defender());
		comport(combate, new Combater());

		return new MaquinaEstados<Estimulo>(patrulha);
	}
}

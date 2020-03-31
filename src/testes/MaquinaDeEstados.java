package testes;

public interface MaquinaDeEstados {
	public enum estado {
		Init, Pronto, Execucao, Bloqueado, Fim
	};

	public estado estado = null;

	public void nextState(MaquinaDeEstados m);

	public void prevState(MaquinaDeEstados m);

	public void currState(MaquinaDeEstados m);

	public void finish(MaquinaDeEstados m);

	public void start(MaquinaDeEstados m);
}

package TP2.mecanismosProcura;

public abstract class Estado {
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Estado) {
			// TODO arranjar isto
			return (obj.hashCode() == this.hashCode());
		}
		return false;
	}
	@Override
	public abstract int hashCode();
}

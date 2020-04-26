package TP2.plantraj.modprob;

public abstract class Estado {
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Estado) {
			return (obj.hashCode() == this.hashCode());
		}
		return false;
	}
	@Override
	public abstract int hashCode();
}

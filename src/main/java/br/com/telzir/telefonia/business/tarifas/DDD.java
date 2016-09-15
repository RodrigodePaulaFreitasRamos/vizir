package br.com.telzir.telefonia.business.tarifas;

public class DDD {

	private final int ddd;

	public DDD(int ddd) {
		this.ddd = ddd;
	}

	public int getDDD() {
		return ddd;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DDD) {
			DDD parsed = (DDD) obj;
			return ddd == parsed.ddd;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return ddd;
	}
	
	@Override
	public String toString() {
		return String.valueOf(ddd);
	}

}

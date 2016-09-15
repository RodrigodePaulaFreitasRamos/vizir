package br.com.telzir.telefonia.business.tarifas;

import java.math.BigDecimal;

public class Destino {

	private final DDD ddd;
	private final BigDecimal custo;

	public Destino(DDD ddd, BigDecimal custo) {
		if (ddd == null) {
			throw new RuntimeException("ddd não pode ser nulo.");
		}
		if (custo == null) {
			throw new RuntimeException("custo não pode ser nulo.");
		}
		this.ddd = ddd;
		this.custo = custo;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public DDD getDDD() {
		return ddd;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Destino) {
			Destino parsed = (Destino) obj;
			return ddd.equals(parsed.ddd);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return ddd.hashCode();
	}

}

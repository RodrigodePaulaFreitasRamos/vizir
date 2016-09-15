package br.com.telzir.telefonia.business.tarifas;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TarifaDDD {

	private final DDD origem;
	private final Set<Destino> destinos = new HashSet<Destino>();

	public TarifaDDD(DDD origem, Collection<Destino> destinos) {
		this.origem = origem;
		addDestinos(destinos);
	}

	public TarifaDDD(DDD origem) {
		if (origem == null) {
			throw new RuntimeException("origem não pode ser nulo.");
		}
		this.origem = origem;
	}

	public DDD getOrigem() {
		return origem;
	}

	public int getQtdDestinos() {
		return destinos.size();
	}

	public void addDestinos(Collection<Destino> destinos) {
		this.destinos.addAll(destinos);
	}

	public BigDecimal getCusto(DDD ddd) {
		Iterator<Destino> iterator = destinos.iterator();
		while (iterator.hasNext()) {
			Destino destino = iterator.next();
			if (destino.getDDD().equals(ddd)) {
				return destino.getCusto();
			}
		}
		throw new RuntimeException("Destino não cadastrado.");
	}

}

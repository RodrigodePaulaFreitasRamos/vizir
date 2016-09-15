package br.com.telzir.telefonia.business.tarifas.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.telzir.telefonia.business.tarifas.DDD;
import br.com.telzir.telefonia.business.tarifas.Destino;
import br.com.telzir.telefonia.business.tarifas.TarifaDDD;

public class TarifasFactory {

	public static TarifaDDD getTarifa(DDD origem) {
		List<Destino> destinos = new ArrayList<Destino>();
		if (new DDD(11).equals(origem)) {
			destinos.add(new Destino(new DDD(16), new BigDecimal(1.90)));
			destinos.add(new Destino(new DDD(17), new BigDecimal(1.70)));
			destinos.add(new Destino(new DDD(18), new BigDecimal(0.90)));
			return new TarifaDDD(new DDD(11), destinos);
		}
		if (new DDD(16).equals(origem)) {
			destinos.add(new Destino(new DDD(11), new BigDecimal(2.90)));
			return new TarifaDDD(new DDD(16), destinos);
		}
		if (new DDD(17).equals(origem)) {
			destinos.add(new Destino(new DDD(11), new BigDecimal(2.70)));
			return new TarifaDDD(new DDD(17), destinos);
		}
		if (new DDD(18).equals(origem)) {
			destinos.add(new Destino(new DDD(11), new BigDecimal(1.90)));
			return new TarifaDDD(new DDD(18), destinos);
		}
		throw new RuntimeException("Origem não cadastrada.");
	}
	
}

package br.com.telzir.telefonia.business.tarifas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TarifaDDDSpec {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private DDD origem;
	private TarifaDDD tarifa;
	
	@Before
	public void beforeTest() {
		origem = new DDD(11);
		tarifa = new TarifaDDD(origem);
	}
	
	@Test
	public void quandoInstanciadoEntaoManterOrigem() {
		assertSame(origem, tarifa.getOrigem());
		assertEquals(0, tarifa.getQtdDestinos());
	}
	
	@Test
	public void quandoInstanciadoComOrigemNulloEntaoException() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("origem não pode ser nulo.");
		new TarifaDDD(null);
	}
	
	@Test
	public void getTarifa() {
		DDD ddd = new DDD(13);
		BigDecimal custoOrigemDestino = new BigDecimal(1);
		
		Destino destino = new Destino(ddd, custoOrigemDestino);
		List<Destino> destinos = new ArrayList<Destino>();
		destinos.add(destino);
		
		tarifa.addDestinos(destinos);
		
		assertEquals(1, tarifa.getQtdDestinos());
		assertEquals(custoOrigemDestino, tarifa.getCusto(ddd));
	}

}

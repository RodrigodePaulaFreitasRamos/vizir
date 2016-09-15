package br.com.telzir.telefonia.business.tarifas.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.telzir.telefonia.business.tarifas.DDD;
import br.com.telzir.telefonia.business.tarifas.TarifaDDD;

public class TarifasFactorySpec {
	
	private DDD ddd11;
	
	@Before
	public void beforeTest() {
		ddd11 = new DDD(11);
	}
	
	@Test
	public void getTarifasDDD11() {
		TarifaDDD tarifa = TarifasFactory.getTarifa(ddd11);
		
		assertEquals(new BigDecimal(1.90), tarifa.getCusto(new DDD(16)));
		assertEquals(new BigDecimal(1.70), tarifa.getCusto(new DDD(17)));
		assertEquals(new BigDecimal(0.90), tarifa.getCusto(new DDD(18)));
	}
	
	@Test
	public void getTarifasDDD16() {
		TarifaDDD tarifa = TarifasFactory.getTarifa(new DDD(16));
		
		assertEquals(new BigDecimal(2.90), tarifa.getCusto(ddd11));
	}
	
	@Test
	public void getTarifasDDD17() {
		TarifaDDD tarifa = TarifasFactory.getTarifa(new DDD(17));
		
		assertEquals(new BigDecimal(2.70), tarifa.getCusto(ddd11));
	}
	
	@Test
	public void getTarifasDDD18() {
		TarifaDDD tarifa = TarifasFactory.getTarifa(new DDD(18));
		
		assertEquals(new BigDecimal(1.90), tarifa.getCusto(ddd11));
	}

}

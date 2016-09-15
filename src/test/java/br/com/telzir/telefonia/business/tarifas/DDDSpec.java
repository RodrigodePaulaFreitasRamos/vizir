package br.com.telzir.telefonia.business.tarifas;

import org.junit.Test;

import static org.junit.Assert.*;

public class DDDSpec {
	
	@Test
	public void quandoNovoEntaoRetornaDDD() {
		assertEquals(11, new DDD(11).getDDD());
		assertEquals(16, new DDD(16).getDDD());
		assertEquals(17, new DDD(17).getDDD());
	}
	
	@Test
	public void equalsTest() {
		assertEquals(new DDD(11), new DDD(11));
		assertNotEquals(new DDD(11), new DDD(16));
		assertNotEquals(new DDD(11), null);
	}
	
	@Test
	public void hashTest() {
		assertEquals(11, new DDD(11).hashCode());
		assertEquals(16, new DDD(16).hashCode());
		assertNotEquals(new DDD(11).hashCode(), new DDD(16).hashCode());
	}

}

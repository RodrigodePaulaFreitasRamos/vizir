package br.com.telzir.telefonia.business.tarifas;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DestinoSpec {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private BigDecimal custo;
	private DDD ddd;
	private Destino destino;
	
	@Before
	public void beforeTest() {
		ddd = new DDD(11);
		custo = new BigDecimal(1);
		destino = new Destino(ddd, custo);
	}
	
	@Test
	public void quandoDDDNuloEntaoException() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("ddd não pode ser nulo.");
		new Destino(null, custo);
	}
	
	@Test
	public void quandoCustoNuloEntaoException() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("custo não pode ser nulo.");
		new Destino(ddd, null);
	}
	
	@Test
	public void getTarifas() {
		assertEquals(custo, destino.getCusto());
		assertSame(ddd, destino.getDDD());
	}
	
	@Test
	public void equalsTest() {
		assertEquals(new Destino(ddd, custo), destino);
		assertNotEquals(new Destino(new DDD(12), custo), destino);
		assertNotEquals(destino, null);
	}
	
	@Test
	public void hashTest() {
		assertEquals(new Destino(ddd, custo).hashCode(), destino.hashCode());
		assertNotEquals(new Destino(new DDD(12), custo).hashCode(), destino.hashCode());
	}

}

package br.com.telzir.telefonia.business.tarifas;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;

import br.com.telzir.telefonia.business.tarifas.factory.TarifasFactory;

public class CalculadorMinutosExcedentesSpec {
	
	@Test
	public void testMinutosExcedidos() {
		
		DDD destino = new DDD(16);
		BigDecimal porcentagem = new BigDecimal(10);
		Integer minutosPlano = 30;
		Integer minutosConsulta = 10;
		
		TarifaDDD tarifa = TarifasFactory.getTarifa(new DDD(11));
		
		BigDecimal expected = new BigDecimal(0);
		
		CalculadorMinutosExcedentes calculador = new CalculadorMinutosExcedentes(tarifa, porcentagem, minutosPlano, minutosConsulta);
		
		BigDecimal actual = calculador.calcularComPlano(destino);
		
		Assert.assertEquals(expected.setScale(2, RoundingMode.HALF_EVEN), actual);
		
		expected = new BigDecimal(20.90);
		
		actual = calculador.calcularSemPlano(destino);
		
		Assert.assertEquals(expected.setScale(2, RoundingMode.HALF_EVEN), actual);
		
	}

}

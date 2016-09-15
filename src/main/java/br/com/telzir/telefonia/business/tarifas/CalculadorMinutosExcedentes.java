package br.com.telzir.telefonia.business.tarifas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadorMinutosExcedentes {
	
	private final TarifaDDD tarifa;
	private final BigDecimal porcentagem;
	private final Integer minutosPlano;
	private final Integer minutosConsulta;

	public CalculadorMinutosExcedentes(TarifaDDD tarifa, BigDecimal porcentagem, Integer minutosPlano, Integer minutosConsulta) {
		this.tarifa = tarifa;
		this.porcentagem = porcentagem;
		this.minutosPlano = minutosPlano;
		this.minutosConsulta = minutosConsulta;
	}
	
	public BigDecimal calcularComPlano(DDD ddd) {
		Integer minutosExcedentes = minutosConsulta - minutosPlano;
		if (minutosExcedentes < 0) {
			minutosExcedentes = 0;
		}
		return calcular(ddd, minutosExcedentes);
	}
	
	public BigDecimal calcularSemPlano(DDD ddd) {
		return calcular(ddd, minutosConsulta);
	}
	
	private BigDecimal calcular(DDD ddd, Integer minutosConsulta) {
		BigDecimal custo = tarifa.getCusto(ddd);
		BigDecimal resultado = custo.multiply(new BigDecimal(minutosConsulta));
		resultado = resultado.multiply(porcentagem.divide(new BigDecimal(100))).add(resultado);
		return resultado.setScale(2, RoundingMode.HALF_EVEN);
	}

}

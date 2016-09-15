package br.com.telzir.telefonia.web.beans;

import java.text.NumberFormat;

public class ResultadoConsultaBean {
	
	private final NumberFormat nf = NumberFormat.getCurrencyInstance();

	private final ConsultaBean consultaBean;

	private double custoComPlano;
	private double custoSemPlano;

	public ResultadoConsultaBean(ConsultaBean consultaBean) {
		this.consultaBean = consultaBean;
	}

	public ConsultaBean getConsultaBean() {
		return consultaBean;
	}

	public String getCustoComPlano() {
		return nf.format(custoComPlano);
	}

	public void setCustoComPlano(double custoComPlano) {
		this.custoComPlano = custoComPlano;
	}

	public String getCustoSemPlano() {
		return nf.format(custoSemPlano);
	}

	public void setCustoSemPlano(double custoSemPlano) {
		this.custoSemPlano = custoSemPlano;
	}

}

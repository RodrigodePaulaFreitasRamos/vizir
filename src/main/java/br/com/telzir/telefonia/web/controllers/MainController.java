package br.com.telzir.telefonia.web.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import br.com.telzir.telefonia.business.tarifas.CalculadorMinutosExcedentes;
import br.com.telzir.telefonia.business.tarifas.DDD;
import br.com.telzir.telefonia.business.tarifas.TarifaDDD;
import br.com.telzir.telefonia.business.tarifas.factory.TarifasFactory;
import br.com.telzir.telefonia.web.beans.ConsultaBean;
import br.com.telzir.telefonia.web.beans.ResultadoConsultaBean;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}
	
	@ModelAttribute(value = "comboOrigem")
	public List<DDD> origens() {
		List<DDD> origens = new ArrayList<DDD>();
		origens.add(new DDD(11));
		origens.add(new DDD(16));
		origens.add(new DDD(17));
		origens.add(new DDD(18));
		return origens;
	}
	
	@ModelAttribute(value = "minutosPlanoFaleMais")
	public List<Integer> minutosPlanoFaleMais() {
		List<Integer> minutosPlanoFaleMais = new ArrayList<Integer>();
		minutosPlanoFaleMais.add(30);
		minutosPlanoFaleMais.add(60);
		minutosPlanoFaleMais.add(120);
		return minutosPlanoFaleMais;
	}
	
	@RequestMapping(value = "/json/destinos/{origem}", method = RequestMethod.GET)
	public @ResponseBody List<DDD> destinos(@PathVariable("origem") Integer origem) {
		List<DDD> destinos = new ArrayList<DDD>();
		if (new Integer(11).equals(origem)) {
			destinos.add(new DDD(16));
			destinos.add(new DDD(17));
			destinos.add(new DDD(18));
		} else {
			destinos.add(new DDD(11));
		}
		return destinos;
	}
	
	@ModelAttribute(value = "consultaBeanModel")
	public ConsultaBean getConsultaBean() {
		return new ConsultaBean();
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public String consultar(@ModelAttribute ConsultaBean consultaBean, Model model) {
		ResultadoConsultaBean bean = new ResultadoConsultaBean(consultaBean);
		TarifaDDD tarifa = TarifasFactory.getTarifa(new DDD(consultaBean.getOrigem()));
		CalculadorMinutosExcedentes calculador = new CalculadorMinutosExcedentes(tarifa, new BigDecimal(10), consultaBean.getMinutosPlano(), consultaBean.getTempo());
		DDD destino = new DDD(consultaBean.getDestino());
		bean.setCustoComPlano(calculador.calcularComPlano(destino).intValue());
		bean.setCustoSemPlano(calculador.calcularSemPlano(destino).intValue());
		model.addAttribute("bean", bean);
		return "resultado";
	}
	
}

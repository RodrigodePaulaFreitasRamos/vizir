package br.com.telzir.telefonia.web.beans;

public class ConsultaBean {

	private int origem;
	private int destino;
	private int minutosPlano;
	private int tempo;

	public int getOrigem() {
		return origem;
	}

	public void setOrigem(int origem) {
		this.origem = origem;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getMinutosPlano() {
		return minutosPlano;
	}

	public void setMinutosPlano(int minutosPlano) {
		this.minutosPlano = minutosPlano;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

}

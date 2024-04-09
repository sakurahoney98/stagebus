package com.java.stagebus.model;

public class RelatorioModel {
	
	
	private static final String DEFAULT_DIA = "VAZIO";
	private static final String DEFAULT_HORA = "00:00:00";
	private static final String DEFAULT_LINHA = "VAZIO";
	private static final int DEFAULT_CARRO = 0;
	private static final double DEFAULT_LARGURA_CARRO = 0.0;
	private static final double DEFAULT_COMPRIMENTO_CARRO = 0.0;
	private static final String DEFAULT_MOTORISTA = "VAZIO";
	private static final String DEFAULT_COBRADOR = "VAZIO";
	
	private String dia = DEFAULT_DIA;
	private String hora = DEFAULT_HORA;
	private String linha = DEFAULT_LINHA;
	private int carro = DEFAULT_CARRO;
	private double largura_carro = DEFAULT_LARGURA_CARRO;
	private double comprimento_carro = DEFAULT_COMPRIMENTO_CARRO;
	private String motorista = DEFAULT_MOTORISTA;
	private String cobrador = DEFAULT_COBRADOR;
	
	
	
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public int getCarro() {
		return carro;
	}
	public void setCarro(int carro) {
		this.carro = carro;
	}
	public double getLargura() {
		return largura_carro;
	}
	public void setLargura(double largura_carro) {
		this.largura_carro = largura_carro;
	}
	public double getComprimento() {
		return comprimento_carro;
	}
	public void setComprimento(double comprimento_carro) {
		this.comprimento_carro = comprimento_carro;
	}
	public String getMotorista() {
		return motorista;
	}
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	public String getCobrador() {
		return cobrador;
	}
	public void setCobrador(String cobrador) {
		this.cobrador = cobrador;
	}
	
	
	
	

}

package com.java.stagebus.model;

public class GaragemModel {

	private static final int DEFAULT_ID = 1;
	private static final String DEFAULT_NOME = "NOME";
	private static final double DEFAULT_LARGURA = 0.0;
	private static final double DEFAULT_COMPRIMENTO = 0.0;
	private static final double DEFAULT_ALTURA = 0.0;
	private static final String DEFAULT_RESPONSAVEL = "Sem informações";
	private static final String DEFAULT_LOCAL = "Sem informações";
	private static final int DEFAULT_MAX = 1;
	private static final int DEFAULT_ONIBUS = 1;
	
	
	
	private int id = DEFAULT_ID;
	private String nome = DEFAULT_NOME;
	private double largura = DEFAULT_LARGURA;
	private double comprimento = DEFAULT_COMPRIMENTO;
	private double altura = DEFAULT_ALTURA;
	private String responsavel = DEFAULT_RESPONSAVEL;
	private String local = DEFAULT_LOCAL;
	private int max = DEFAULT_MAX;
	private int onibus = DEFAULT_ONIBUS;
	
	
	
	
	
	public int getOnibus() {
		return onibus;
	}
	public void setOnibus(int onibus) {
		this.onibus = onibus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	
	
}

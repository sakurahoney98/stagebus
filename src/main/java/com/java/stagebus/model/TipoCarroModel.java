package com.java.stagebus.model;

public class TipoCarroModel {
	private static final int DEFAULT_ID = 1;
	private static final String DEFAULT_NOME = "NOME";
	private static final double DEFAULT_LARGURA = 0.0;
	private static final double DEFAULT_COMPRIMENTO = 0.0;
	private static final double DEFAULT_ALTURA = 0.0;
	private static final double DEFAULT_PESO = 0.0;
	
	
	private int id = DEFAULT_ID;
	private String nome = DEFAULT_NOME;
	private double largura = DEFAULT_LARGURA;
	private double comprimento = DEFAULT_COMPRIMENTO;
	private double altura = DEFAULT_ALTURA;
	private double peso = DEFAULT_PESO;
	
	
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	

}

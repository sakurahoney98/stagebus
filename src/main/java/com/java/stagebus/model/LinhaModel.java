package com.java.stagebus.model;

public class LinhaModel {

	private static final int DEFAULT_ID = 1;
	private static final String DEFAULT_LINHA = "LINHA";
	private static final String DEFAULT_NOME = "NOME";
	private static final String DEFAULT_IDA = "IDA";
	private static final String DEFAULT_VOLTA = "VOLTA";

	private int id = DEFAULT_ID;
	private String linha = DEFAULT_LINHA;
	private String nome = DEFAULT_NOME;
	private String ida = DEFAULT_IDA;
	private String volta = DEFAULT_VOLTA;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIda() {
		return ida;
	}

	public void setIda(String ida) {
		this.ida = ida;
	}

	public String getVolta() {
		return volta;
	}

	public void setVolta(String volta) {
		this.volta = volta;
	}

}

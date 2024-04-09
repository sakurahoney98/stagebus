package com.java.stagebus.enums;

public enum LogEnum {

	TABELA("log"), USUARIO("usuario"), DESCRICAO("descricao_log"), DATA("data_log"), HORA("hora_log");

	private final String nome;

	LogEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

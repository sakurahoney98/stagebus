package com.java.stagebus.enums;

public enum StatusEnum {

	TABELA("status"), ID("id_status"), DESCRICAO("descricao"), NOVO("1"), EM_ATIVIDADE("2"), RESERVA("3"), PARADO("4"),
	EM_MANUTENCAO("5");

	private final String nome;

	StatusEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

package com.java.stagebus.enums;

public enum GaragemEnum {
	TABELA("garagem"), ID("id_garagem"), NOME("nome_garagem"), COMPRIMENTO("comprimento_garagem"),
	LARGURA("largura_garagem"), ALTURA("altura_garagem"), RESPONSAVEL("responsavel_garagem"), LOCAL("local_garagem"),
	MAXIMO("quantidade_max"), ULTIMO_REGISTRO("count_max_garage");

	private final String nome;

	GaragemEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

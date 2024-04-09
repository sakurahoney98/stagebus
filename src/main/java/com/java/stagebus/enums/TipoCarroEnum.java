package com.java.stagebus.enums;

public enum TipoCarroEnum {

	TABELA("tipo_carro"), ID("id_tipo_car"), NOME("nome_tipo_carro"), COMPRIMENTO("comprimento_carro"), LARGURA("largura_carro"),
	ALTURA("altura_carro"), PESO("peso_carro"), ULTIMO_REGISTRO("count_max_type");

	private final String nome;
	

	TipoCarroEnum(String nome) {
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	
}

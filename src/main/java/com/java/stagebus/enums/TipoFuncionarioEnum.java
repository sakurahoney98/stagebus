package com.java.stagebus.enums;

public enum TipoFuncionarioEnum {
	
	TABELA("tipo_funcionario"), ID("id_tipo_fun"), DESCRICAO("descricao_fun"), MOTORISTA("1"), COBRADOR("2"), MANOBRISTA("3");

	private final String nome;
	

	TipoFuncionarioEnum(String nome) {
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

}

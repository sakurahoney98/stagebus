package com.java.stagebus.enums;

public enum DiaEnum {
	
	TABELA("dia"), ID("id_dia"), DESCRICAO("descricao_dia"),;

	private final String nome;
	

	DiaEnum(String nome) {
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

}

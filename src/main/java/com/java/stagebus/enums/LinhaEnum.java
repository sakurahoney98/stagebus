package com.java.stagebus.enums;

public enum LinhaEnum {

	TABELA("linha"), ID("id_linha"), NUMERO("numero_linha"), NOME("nome_linha"), IDA("roteiro_ida"),
	VOLTA("roteiro_volta"), VIEW_ALL_LINES("all_lines"), ULTIMO_REGISTRO("count_max_line");

	private final String nome;

	LinhaEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

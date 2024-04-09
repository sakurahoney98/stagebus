package com.java.stagebus.enums;

public enum HorarioEnum {

	TABELA("horario"), ID("id_horario"), DIA("dia"), HORA("hora"), LINHA("linha_horario"), CARRO("carro_horario"),
	MOTORISTA("motorista"), COBRADOR("cobrador"), ULTIMO_REGISTRO("count_max_schedule"),
	RELATORIO_CARRROS_LINHAS("report_list_cars_lines"), GARAGEM("garagem_horario");

	private final String nome;

	HorarioEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

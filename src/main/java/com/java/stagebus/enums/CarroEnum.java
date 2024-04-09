package com.java.stagebus.enums;

public enum CarroEnum {

	TABELA("carro"), ID("num_carro"), NOME("nome_carro"), PLACA("placa_carro"), TIPO("tipo_carro"),
	STATUS("status_carro"), GARAGEM("garagem"), VIEW_ALL_CARS("all_cars"), VIEW_LINHAS_DO_CARRO("report_line_of_car");

	private final String nome;

	CarroEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}
	
	

}

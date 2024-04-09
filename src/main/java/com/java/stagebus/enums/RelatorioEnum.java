package com.java.stagebus.enums;

public enum RelatorioEnum {
	
	VIEW_ONIBUS_DIA("report_bus_day_schedule");

	private final String nome;

	RelatorioEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

package com.java.stagebus.enums;

public enum FuncionarioEnum {

	TABELA("funcionario"), ID("id_funcionario"), NOME("nome_completo"), APELIDO("apelido"), TIPO("tipo_funcionario"),
	MATRICULA("matricula_funcionario"), DESCRICAO_FUNCIONARIO("descricao_fun"), ULTIMO_REGISTRO("count_max_employee"),
	VIEW_ALL_EMPLOYEE("all_employee"), HORARIO_FUNCIONARIO("report_employee_schedule");

	private final String nome;

	FuncionarioEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

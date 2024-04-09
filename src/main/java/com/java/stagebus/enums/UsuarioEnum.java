package com.java.stagebus.enums;

public enum UsuarioEnum {
	TABELA("usuario"), ID("id_usuario"), LOGIN("login_usuario"), SENHA("senha_usuario"), NOME("nome_usuario"),
	SOBRENOME("sobrenome_usuario"), CADASTRAR_USUARIO("cad_user"), CADASTRAR_CARRO("cad_car"),
	CADASTRAR_GARAGEM("cad_gar"), CADASTRAR_LINHA("cad_lin"), CADASTRAR_TIPO_CARRO("cad_tip_car"), CADASTRAR_FUNCIONARIO("cad_fun"),
	EDITAR_USUARIO("ed_user"), EDITAR_CARRO("ed_car"), EDITAR_GARAGEM("ed_gar"), EDITAR_LINHA("ed_lin"),
	EDITAR_TIPO_CARRO("ed_tip_car"), EDITAR_FUNCIONARIO("ed_fun"), EMITIR_RELATORIO("em_rel"), CADASTRAR_EDITAR_HORARIO("cad_ed_hor"),
	DAR_PERMISSAO_USUARIO("perm_user"), EXCLUIR_USUARIO("exc_user"), ATIVAR_DESATIVAR_USUARIO("at_des_user"), STATUS("status_ativo"),
	ULTIMO_REGISTRO("count_max_user");

	private final String nome;

	UsuarioEnum(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

}

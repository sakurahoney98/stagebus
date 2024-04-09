package com.java.stagebus.model;

public class LogModel {

	private static final int DEFAULT_USUARIO = 1;
	private static final String DEFAULT_DESCRICAO = "VAZIO";
	private static final String DEFAULT_DATA = "1900-01-01";
	private static final String DEFAULT_HORA = "00:00:00";

	private int usuario = DEFAULT_USUARIO;
	private String descricao = DEFAULT_DESCRICAO;
	private String data = DEFAULT_DATA;
	private String hora = DEFAULT_HORA;

	public LogModel(int usuario, String descricao, String data, String hora) {
		super();
		this.usuario = usuario;
		this.descricao = descricao;
		this.data = data;
		this.hora = hora;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}

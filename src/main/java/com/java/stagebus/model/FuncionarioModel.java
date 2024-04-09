package com.java.stagebus.model;

public class FuncionarioModel {
	
	private static final int DEFAULT_ID = 1;
	private static final String DEFAULT_NOME = "FUNCIONÁRIO";
	private static final String DEFAULT_APELIDO = "FUN";
	private static final String DEFAULT_TIPO = "MOTORISTA";
	private static final String DEFAULT_MATRICULA = "VAZIO";
	private static final int DEFAULT_ID_TIPO = 0;

	
	private int id = DEFAULT_ID;
	private String nome = DEFAULT_NOME;
	private String apelido = DEFAULT_APELIDO;
	private String tipo = DEFAULT_TIPO;
	private String matricula = DEFAULT_MATRICULA;
	private int id_tipo = DEFAULT_ID_TIPO;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdTipo() {
		return id_tipo;
	}
	public void setIdTipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
	
	

}

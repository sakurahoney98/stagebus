package com.java.stagebus.model;

public class CarroModel {

	
	private static final int DEFAULT_NUMERO = 0;
	private static final int DEFAULT_ID_TIPO = 1;
	private static final int DEFAULT_ID_GARAGEM = 1;
	private static final String DEFAULT_NOME = "NOME";
	private static final String DEFAULT_PLACA = "VAZIO";
	private static final String DEFAULT_TIPO = "VAZIO";
	private static final int DEFAULT_ID_STATUS = 1;
	private static final String DEFAULT_STATUS = "NOVO";
	private static final String DEFAULT_GARAGEM = "SEM GARAGEM";


	private int id_tipo = DEFAULT_ID_TIPO;
	private int id_garagem = DEFAULT_ID_GARAGEM;
	private int numero = DEFAULT_NUMERO;
	private String nome = DEFAULT_NOME;
	private String placa = DEFAULT_PLACA;
	private String tipo = DEFAULT_TIPO;
	private int id_status = DEFAULT_ID_STATUS;
	private String status = DEFAULT_STATUS;
	private String garagem = DEFAULT_GARAGEM;


	
	

	public int getIdTipo() {
		return id_tipo;
	}

	public void setIdTipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
	public int getIdGaragem() {
		return id_garagem;
	}

	public void setIdGaragem(int id_garagem) {
		this.id_garagem = id_garagem;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdStatus() {
		return id_status;
	}

	public void setIdStatus(int id_status) {
		this.id_status = id_status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGaragem() {
		return garagem;
	}

	public void setGaragem(String garagem) {
		this.garagem = garagem;
	}

	@Override
	public String toString() {
		return "CarroModel [id_tipo=" + id_tipo + ", id_garagem=" + id_garagem + ", " + numero + ", nome=" + nome
				+ ", placa=" + placa + ", tipo=" + tipo + ", id_status=" + id_status + ", status=" + status
				+ ", garagem=" + garagem + "]";
	}
	
	

}

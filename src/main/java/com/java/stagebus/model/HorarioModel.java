package com.java.stagebus.model;

public class HorarioModel {
	
	private static final int DEFAULT_ID = 1;
	private static final int DEFAULT_ID_DIA = 1;
	private static final String DEFAULT_DIA = "VAZIO";
	private static final int DEFAULT_ID_CARRO = 0;
	private static final String DEFAULT_CARRO = "VAZIO";
	private static final String DEFAULT_HORA = "00:00:00";
	private static final int DEFAULT_ID_LINHA = 0;
	private static final String DEFAULT_LINHA = "VAZIO";
	private static final String DEFAULT_NUM_LINHA = "VAZIO";
	private static final int DEFAULT_ID_MOTORISTA = 0;
	private static final String DEFAULT_MOTORISTA = "Sem informações";
	private static final int DEFAULT_ID_COBRADOR = 0;
	private static final String DEFAULT_COBRADOR = "Sem informações";
	private static final int DEFAULT_ID_GARAGEM = 0;
	private static final String DEFAULT_GARAGEM = "Sem informações";
	
	
	private int id = DEFAULT_ID;
	private int id_dia = DEFAULT_ID_DIA;
	private String dia = DEFAULT_DIA;
	private String hora = DEFAULT_HORA;
	private int id_linha = DEFAULT_ID_LINHA;
	private String linha = DEFAULT_LINHA;
	private String num_linha = DEFAULT_NUM_LINHA;
	private int id_carro = DEFAULT_ID_CARRO;
	private String carro = DEFAULT_CARRO;
	private int id_motorista = DEFAULT_ID_MOTORISTA;
	private String motorista = DEFAULT_MOTORISTA;
	private int id_cobrador = DEFAULT_ID_COBRADOR;
	private String cobrador = DEFAULT_COBRADOR;
	private int id_garagem = DEFAULT_ID_GARAGEM;
	private String garagem = DEFAULT_GARAGEM;
	
	
	public String getNum_linha() {
		return num_linha;
	}
	public void setNum_linha(String num_linha) {
		this.num_linha = num_linha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdDia() {
		return id_dia;
	}
	public void setIdDia(int id_dia) {
		this.id_dia = id_dia;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getIdLinha() {
		return id_linha;
	}
	public void setIdLinha(int id_linha) {
		this.id_linha = id_linha;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public int getIdCarro() {
		return id_carro;
	}
	public void setIdCarro(int id_carro) {
		this.id_carro = id_carro;
	}
	public String getCarro() {
		return carro;
	}
	public void setCarro(String carro) {
		this.carro = carro;
	}
	public int getIdMotorista() {
		return id_motorista;
	}
	public void setIdMotorista(int id_motorista) {
		this.id_motorista = id_motorista;
	}
	public String getMotorista() {
		return motorista;
	}
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	public int getIdCobrador() {
		return id_cobrador;
	}
	public void setIdCobrador(int id_cobrador) {
		this.id_cobrador = id_cobrador;
	}
	public String getCobrador() {
		return cobrador;
	}
	public void setCobrador(String cobrador) {
		this.cobrador = cobrador;
	}
	
	public int getIdGaragem() {
		return id_garagem;
	}
	public void setIdGaragem(int id_garagem) {
		this.id_garagem = id_garagem;
	}
	public String getGaragem() {
		return garagem;
	}
	public void setGaragem(String garagem) {
		this.garagem = garagem;
	}
	
	
	
	
	
	
	

}

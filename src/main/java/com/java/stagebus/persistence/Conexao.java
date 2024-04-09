package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;

	public Conexao(String company_link) {
		// Dados de conexão
		url = "jdbc:postgresql://localhost:5432/" + company_link;
		usuario = "postgres";
		senha = "postgres";

		// Tentando fazer conexão com o banco de dados
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			//System.out.println("Conexão estabelecida");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public Connection getConexao() {
		return conexao;
	}

	

}

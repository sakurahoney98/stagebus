package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.GaragemEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.GaragemModel;

public class GaragemPersistence {

	private static Connection conect;
	
	public GaragemPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Quantidade de objetos na tabela garagem
	public int garageAmount() {
		
		Statement st;
		ResultSet rs;
		try {
			st = conect.createStatement();

			String sql = "SELECT COUNT(*) FROM " + GaragemEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			return rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	// Lista de todos os objetos da tabela garagem
	public ResultSet listOfGarage() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + GaragemEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando um objeto usando o ID como referencia
	public ResultSet searchByID(int id) {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + GaragemEnum.TABELA.getNome() + " WHERE " + GaragemEnum.ID.getNome() + " = "
					+ id;

			rs = st.executeQuery(sql);

			rs.next();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Tipos:
	// 1 - Busca por nome
	// 2 - Buscar por id
	public ResultSet search(int type_search, String term) {
		
		Statement st;
		ResultSet rs = null;

		switch (type_search) {
		case 1:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + GaragemEnum.TABELA.getNome() + " WHERE " + GaragemEnum.NOME.getNome()
						+ " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 2:

			try {
				st = conect.createStatement();

				// Convertendo o ID do objeto para varchar para realizar a busca pelo termo
				// correpsondente
				String sql = "SELECT * FROM " + GaragemEnum.TABELA.getNome() + " WHERE CAST(" + GaragemEnum.ID.getNome()
						+ " AS VARCHAR) ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		default:
			break;

		}

		return rs;

	}

	// Inserindo objeto na tabela garagem
	public void insertGarage(GaragemModel garage) {
		

		Statement st;

		try {
			st = conect.createStatement();

			// Juntando os campos do objeto que devem ser preenchidos
			String campos = GaragemEnum.ID.getNome() + " , " + GaragemEnum.NOME.getNome() + " , "
					+ GaragemEnum.LARGURA.getNome() + " , " + GaragemEnum.COMPRIMENTO.getNome() + " , "
					+ GaragemEnum.ALTURA.getNome() + " , " + GaragemEnum.RESPONSAVEL.getNome() + " , "
					+ GaragemEnum.LOCAL.getNome() + " , " + GaragemEnum.MAXIMO.getNome();

			// Juntando os campos com os respectivos valores
			String sql = "INSERT INTO " + GaragemEnum.TABELA.getNome() + "(" + campos + ") " + "	VALUES ("
					+ garage.getId() + ", '" + garage.getNome() + "', " + garage.getLargura() + ", "
					+ garage.getComprimento() + ", " + garage.getAltura() + ", '" + garage.getResponsavel() + "', '"
					+ garage.getLocal() + "', " + garage.getMax() + ");";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Capturando o último id cadastrado
	public int generateID() {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT * FROM " + GaragemEnum.ULTIMO_REGISTRO.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			if (rs.getInt(1) > 0)
				value = rs.getInt(2);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

	// Deletando objeto da tabela garagem usando o ID do objeto como referencia
	public void delete(int id) {
		
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + GaragemEnum.TABELA.getNome() + " WHERE " + GaragemEnum.ID.getNome() + " = "
					+ id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// columnType = 1 significa que a coluna é do tipo inteiro
	// columnType = 2 significa que a coluna é do tipo String
	public void update(String columnUpdate, int id, String value, int columnType) {
		

		Statement st;

		// Se o valor da coluna for do tipo string, colocar o valor entre ''
		if (columnType == 2)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();

			String sql = " UPDATE " + GaragemEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value + " WHERE "
					+ GaragemEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Quantidade de objetos da tabela carro vinculados a um objeto da tabela
	// garagem
	public int amountBusOnGarage(int garage) {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT COUNT (" + CarroEnum.ID.getNome() + ") FROM " + CarroEnum.TABELA.getNome() + " WHERE "
					+ CarroEnum.GARAGEM.getNome() + " = " + garage;

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

}

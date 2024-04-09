package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.TipoCarroEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.TipoCarroModel;

public class TipoCarroPersistence {

	private static Connection conect = StagebusApplication.getConexao();
	
	public TipoCarroPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Quantidade de objetos na tabela tipo carro
	public int amountCarType() {

		Statement st;
		ResultSet rs;
		int value = 0;
		try {
			st = conect.createStatement();

			String sql = "SELECT COUNT(*) FROM " + TipoCarroEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

			return rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

	// Inserindo objeto na tabela tipo de carro
	public void insertCarType(TipoCarroModel type) {
		Statement st;
		try {
			// Referenciando os campos do objeto a serem preeenchidos
			String campos = TipoCarroEnum.ID.getNome() + " , " + TipoCarroEnum.NOME.getNome() + " , "
					+ TipoCarroEnum.LARGURA.getNome() + " , " + TipoCarroEnum.COMPRIMENTO.getNome() + " , "
					+ TipoCarroEnum.ALTURA.getNome() + " , " + TipoCarroEnum.PESO.getNome();
			st = conect.createStatement();

			// Informando os campos e seus respectivos valores
			String sql = "INSERT INTO public.tipo_carro(" + campos + ")	VALUES (" + type.getId() + ", '"
					+ type.getNome() + "', " + type.getLargura() + ", " + type.getComprimento() + ", "
					+ type.getAltura() + ", " + type.getPeso() + ")";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Capturando o ultimo ID cadastrado no banco de dados
	public int generateID() {
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT * FROM " + TipoCarroEnum.ULTIMO_REGISTRO.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			if (rs.getInt(1) > 0)
				value = rs.getInt(2);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;
	}

	// Deletando um objeto da tabela tipo carro usando o ID do objeto como
	// referencia
	public void delete(int id) {
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + TipoCarroEnum.TABELA.getNome() + " WHERE " + TipoCarroEnum.ID.getNome()
					+ " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Capturando os dados de um objeto da tabela tipo carro usando o ID do objeto
	// como referencia
	public ResultSet searchByID(int id) {
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + TipoCarroEnum.TABELA.getNome() + " WHERE " + TipoCarroEnum.ID.getNome()
					+ " = " + id;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Lista de todos os objetos da tabela tipo carro
	public ResultSet listOfCarType() {
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + TipoCarroEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

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

				String sql = "SELECT * FROM " + TipoCarroEnum.TABELA.getNome() + " WHERE "
						+ TipoCarroEnum.NOME.getNome() + " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 2:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + TipoCarroEnum.TABELA.getNome() + " WHERE CAST("
						+ TipoCarroEnum.ID.getNome() + " AS VARCHAR) ILIKE '%" + term + "%'";

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

	// columnType = 1 significa que a coluna é do tipo inteiro,
	// columnType = 2 significa que a coluna é do tipo String
	public void update(String columnUpdate, int id, String value, int columnType) {

		Statement st;

		// Verificando se o valor da coluna é do tipo String
		// Se for, colocando o valor entre ''
		if (columnType == 2)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();

			String sql = " UPDATE " + TipoCarroEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value
					+ " WHERE " + TipoCarroEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Quantidade de objetos da tabela carro vinculados a um objeto da tabela tipo
	// carro
	public int amountBusCarType(int id) {
		Statement st;
		ResultSet rs;
		int value = 0;
		try {
			st = conect.createStatement();

			String sql = "SELECT COUNT(" + CarroEnum.ID.getNome() + ") FROM " + CarroEnum.TABELA.getNome() + " WHERE "
					+ CarroEnum.TIPO.getNome() + " = " + id;

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

			return rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

}
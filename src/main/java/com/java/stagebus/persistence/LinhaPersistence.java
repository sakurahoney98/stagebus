package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.DiaEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.enums.LinhaEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.LinhaModel;

public class LinhaPersistence {

	private static Connection conect;
	
	public LinhaPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Lista de todos os objetos da tabela linha
	public ResultSet listOfLine() {

		Statement st;
		ResultSet rs = null;

		try {

			st = conect.createStatement();

			String sql = "SELECT * FROM " + LinhaEnum.VIEW_ALL_LINES.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Inserindo objeto na tabela linha
	public void insertLine(LinhaModel line) {

		Statement st;
		try {
			// Selecionando campos do objeto para serem preenchidos
			String campos = LinhaEnum.ID.getNome() + " , " + LinhaEnum.NUMERO.getNome() + " , "
					+ LinhaEnum.NOME.getNome() + " , " + LinhaEnum.IDA.getNome() + " , " + LinhaEnum.VOLTA.getNome();

			st = conect.createStatement();

			// Referenciando os campos e seus respectivos valores
			String sql = "INSERT INTO public.linha(" + campos + ") VALUES (" + line.getId() + ", '" + line.getLinha()
					+ "', '" + line.getNome() + "', '" + line.getIda() + "', '" + line.getVolta() + "');";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Deletando objeto da tabela linha usando o ID do objeto como referencia
	public void delete(int id) {
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + LinhaEnum.TABELA.getNome() + " WHERE " + LinhaEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Capturando objeto pelo ID
	public ResultSet searchByID(int id) {
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + LinhaEnum.VIEW_ALL_LINES.getNome() + " WHERE " + LinhaEnum.ID.getNome()
					+ " = " + id;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando o objeto pelo numero da linha
	public ResultSet searchByLineNumber(String line_number) {
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + LinhaEnum.VIEW_ALL_LINES.getNome() + " WHERE " + LinhaEnum.NUMERO.getNome()
					+ " = '" + line_number + "'";

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando o do último ID inserido na tabela linha
	public int generateID() {
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT * FROM " + LinhaEnum.ULTIMO_REGISTRO.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			if (rs.getInt(1) > 0)
				value = rs.getInt(2);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;
	}

	// Tipos:
	// 1 - Busca por nome da linha
	// 2 - Buscar por numero da linha
	public ResultSet search(int type_search, String term) {
		Statement st;
		ResultSet rs = null;

		switch (type_search) {
		case 1:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + LinhaEnum.VIEW_ALL_LINES.getNome() + " WHERE "
						+ LinhaEnum.NOME.getNome() + " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 2:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + LinhaEnum.VIEW_ALL_LINES.getNome() + " WHERE "
						+ LinhaEnum.NUMERO.getNome() + " ILIKE '%" + term + "%'";

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

	// Lista de objetos da tabela horario vinculados com um objeto da tabela linha
	public ResultSet scheduleOfLine(int id) {

		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Campos capturados: nome do dia e hora
			String sql = "SELECT " + DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome() + " , "
					+ HorarioEnum.HORA.getNome() + " FROM " + HorarioEnum.TABELA.getNome() + "	INNER JOIN "
					+ DiaEnum.TABELA.getNome() + " ON " + HorarioEnum.TABELA.getNome() + "." + HorarioEnum.DIA.getNome()
					+ " = " + DiaEnum.TABELA.getNome() + "." + DiaEnum.ID.getNome() + " WHEN  "
					+ HorarioEnum.LINHA.getNome() + " =  " + id + " ORDER BY " + HorarioEnum.DIA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// columnType = 1 significa que a coluna é do tipo inteiro
	// columnType = 2 significa que a coluna é do tipo String
	public void update(String columnUpdate, int id, String value, int columnType) {

		Statement st;

		if (value.equals("0"))
			value = null;
		// Verificando se o valor da coluna é inteiro
		// Caso seja, colocar o valor entre ''
		if (columnType == 2)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();

			String sql = " UPDATE " + LinhaEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value + " WHERE "
					+ LinhaEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Capturando objetos da tabela horario usando como parâmetro o objeto da tabela
	// carro e dia
	public ResultSet carByDay(int day, int id) {
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT " + HorarioEnum.CARRO.getNome() + " , " + HorarioEnum.HORA.getNome() + " FROM "
					+ HorarioEnum.TABELA.getNome() + " WHERE " + HorarioEnum.LINHA.getNome() + " = " + id + " AND "
					+ HorarioEnum.DIA.getNome() + " = " + day + " ORDER BY " + HorarioEnum.HORA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

}

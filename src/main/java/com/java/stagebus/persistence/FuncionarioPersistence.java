package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.FuncionarioEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.enums.LinhaEnum;
import com.java.stagebus.enums.TipoFuncionarioEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.FuncionarioModel;

public class FuncionarioPersistence {

	private static Connection conect;
	
	public FuncionarioPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// gerando ID para o objeto
	public int generateID() {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			// Capturando o último ID cadastrado
			String sql = " SELECT * FROM " + FuncionarioEnum.ULTIMO_REGISTRO.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			if (rs.getInt(1) > 0)
				value = rs.getInt(2);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;
	}

	// Deletando objeto usando o ID como referencia
	public void delete(int id) {
		
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + FuncionarioEnum.TABELA.getNome() + " WHERE " + FuncionarioEnum.ID.getNome()
					+ " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Pegando o objeto através do ID
	public ResultSet searchByID(int id) {
		
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + FuncionarioEnum.VIEW_ALL_EMPLOYEE.getNome() + "	WHERE "
					+ FuncionarioEnum.ID.getNome() + " = " + id;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Inseridno objeto
	public void insertEmployee(FuncionarioModel employee) {
		
		Statement st;

		// Juntando todos os campos do objeto a serem preeenchidos
		String campos = FuncionarioEnum.ID.getNome() + " , " + FuncionarioEnum.NOME.getNome() + " , "
				+ FuncionarioEnum.APELIDO.getNome() + " , " + FuncionarioEnum.TIPO.getNome() + " , "
				+ FuncionarioEnum.MATRICULA.getNome();

		try {
			st = conect.createStatement();

			// Informando os campos e os respectivos valores
			String sql = "INSERT INTO public.funcionario(" + campos + ") VALUES (" + employee.getId() + ", '"
					+ employee.getNome() + "', '" + employee.getApelido() + "', " + employee.getIdTipo() + ", '"
					+ employee.getMatricula() + "');";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Lista de todos objetos da tabela funcionario
	public ResultSet listOfEmployee() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + FuncionarioEnum.VIEW_ALL_EMPLOYEE.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Lista de todos os objetos da tabela tipo_funcionario
	public ResultSet listOfTypeEmployee() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT *	FROM " + TipoFuncionarioEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Capturando todos os objetos da tabela horario vinculados a um objeto da
	// tabela funcionario
	public ResultSet scheduleOfEmployee(int id) {
		

		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Campos capturados: id do dia, hora, numero da linha
			// Pesquisando se o motorista ou o cobrador vinculados ao horário possuem o ID
			// do funcionário
			String sql = "SELECT " + HorarioEnum.DIA.getNome() + ", " + HorarioEnum.HORA.getNome() + ", "
					+ LinhaEnum.TABELA.getNome() + "." + LinhaEnum.NOME.getNome() + " FROM "
					+ HorarioEnum.TABELA.getNome() + " INNER JOIN	" + LinhaEnum.TABELA.getNome() + " ON "
					+ HorarioEnum.TABELA.getNome() + "." + HorarioEnum.LINHA.getNome() + " = "
					+ LinhaEnum.TABELA.getNome() + "." + LinhaEnum.ID.getNome() + "	 WHERE "
					+ HorarioEnum.MOTORISTA.getNome() + " = " + id + " OR " + HorarioEnum.COBRADOR.getNome() + " = "
					+ id + " ORDER BY " + HorarioEnum.DIA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Tipos:
	// 1 - Busca por nome
	// 2 - Busca por apleido
	// 3 - Busca por matrícula
	// 4 - Busca pelo nome do tipo de funcionário
	public ResultSet search(int type, String term) {
		
		Statement st;
		ResultSet rs = null;

		switch (type) {
		case 1:
			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + FuncionarioEnum.VIEW_ALL_EMPLOYEE.getNome() + " WHERE "
						+ FuncionarioEnum.NOME.getNome() + " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 2:
			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + FuncionarioEnum.VIEW_ALL_EMPLOYEE.getNome() + " WHERE "
						+ FuncionarioEnum.APELIDO.getNome() + " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 3:
			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + FuncionarioEnum.VIEW_ALL_EMPLOYEE.getNome() + " WHERE "
						+ FuncionarioEnum.MATRICULA.getNome() + " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 4:
			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + FuncionarioEnum.VIEW_ALL_EMPLOYEE.getNome() + " WHERE "
						+ FuncionarioEnum.DESCRICAO_FUNCIONARIO.getNome() + " ILIKE '%" + term + "%'";

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

		if (columnType == 2)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();

			// Alterando o objeto com base no id
			// O metodo faz alteração na coluna informada pelo usuário e o valor informado
			// pelo usuário
			String sql = " UPDATE " + FuncionarioEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value
					+ " WHERE " + FuncionarioEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Quantidade de objetos da tabela horario vinculados a um objeto da tabela
	// funcionario
	public int bondEmployeeSchedule(int employee) {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT COUNT (" + HorarioEnum.ID.getNome() + ") FROM " + HorarioEnum.TABELA.getNome()
					+ " WHERE " + HorarioEnum.MOTORISTA.getNome() + " = " + employee + " OR "
					+ HorarioEnum.COBRADOR.getNome() + " = " + employee;

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

}

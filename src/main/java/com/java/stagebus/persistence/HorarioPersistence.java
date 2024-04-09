package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.DiaEnum;
import com.java.stagebus.enums.FuncionarioEnum;
import com.java.stagebus.enums.GaragemEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.enums.LinhaEnum;
import com.java.stagebus.enums.TipoFuncionarioEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.HorarioModel;

public class HorarioPersistence {
	private static Connection conect;
	
	public HorarioPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Inserindo objeto na tabela horario
	public void insertSchedule(HorarioModel schedule) {
		
		Statement st;

		// Verificando se o valor digitado como ID para o motorista e o cobrador são
		// iguais a 0
		// Sendo igual a 0 significa que não foi definido nenhum funcionário para a
		// função daquele horário

		String conductor = schedule.getIdCobrador() == 0 ? null : schedule.getIdCobrador() + "";
		String driver = schedule.getIdMotorista() == 0 ? null : schedule.getIdMotorista() + "";

		try {
			st = conect.createStatement();

			// Juntando todos os campos do objeto para serem preenchidos
			String campos = HorarioEnum.ID.getNome() + " , " + HorarioEnum.DIA.getNome() + " , "
					+ HorarioEnum.HORA.getNome() + " , " + HorarioEnum.LINHA.getNome() + " , "
					+ HorarioEnum.CARRO.getNome() + " , " + HorarioEnum.MOTORISTA.getNome() + " , "
					+ HorarioEnum.COBRADOR.getNome() + " , " + HorarioEnum.GARAGEM.getNome();

			// Referenciando os campos com os respectivos valores
			String sql = "INSERT INTO public.horario(" + campos + ") " + "	VALUES (" + schedule.getId() + ", "
					+ schedule.getIdDia() + ", '" + schedule.getHora() + "', " + schedule.getIdLinha() + ", "
					+ schedule.getIdCarro() + ", " + driver + ", " + conductor + ", (SELECT "
					+ CarroEnum.GARAGEM.getNome() + " FROM " + CarroEnum.TABELA.getNome() + " WHERE "
					+ CarroEnum.ID.getNome() + " = " + schedule.getIdCarro() + " ))";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Deletando objeto da tabela horario usando o ID do objeto com referencia
	public void delete(int id) {
		
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + HorarioEnum.TABELA.getNome() + " WHERE " + HorarioEnum.ID.getNome() + " = "
					+ id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// columnType = 1 significa que a coluna é do tipo inteiro e a chamada foi feita
	// da tela de edição
	// columnType = 2 significa que a coluna é do tipo String e a chamada foi feita
	// da tela de edição
	// columnType = 3 significa que a coluna é do tipo inteiro e a chamada foi feita
	// da tela de exlusão
	// columnType = 4 significa que a coluna é do tipo String e a chamada foi feita
	// da tela de exlusão
	public void update(String column, int id, String value, int columnType) {
		
		Statement st;

		// Verificando se o tipo de valor da coluna é uma string
		// Em caso positivo colocando o valor em ''
		if (columnType == 2 || columnType == 4)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();

			String sql;

			// Verificando quem fez a chamada do metodo
			if (columnType < 3)
				// A chamada da view de edição usando como referencia o ID do objeto
				sql = "UPDATE " + HorarioEnum.TABELA.getNome() + " SET " + column + " = " + value + " WHERE "
						+ HorarioEnum.ID.getNome() + " = " + id;
			else
				// A chamada das outras views usa a coluna que está sendo editada como
				// referencia para o objeto
				sql = "UPDATE " + HorarioEnum.TABELA.getNome() + " SET " + column + " = " + value + " WHERE " + column
						+ " = " + id;
			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Capturando o último ID cadastrado na tabela horario
	public int generateID() {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT * FROM " + HorarioEnum.ULTIMO_REGISTRO.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			if (rs.getInt(1) > 0)
				value = rs.getInt(2);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

	// Capturando todos os objetos da tabela dia
	public ResultSet listOfDay() {
		
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + DiaEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Verificando quantos objetos existem com a mesma linha, dia e hora
	public int checkConflictLineHour(int line, int day, String hour) {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = "SELECT COUNT(*) FROM " + HorarioEnum.TABELA.getNome() + " WHERE "
					+ HorarioEnum.LINHA.getNome() + " = " + line + " AND " + HorarioEnum.HORA.getNome() + " = '" + hour
					+ "'" + " AND " + HorarioEnum.DIA.getNome() + " = " + day;

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;
	}

	// Modificando o valor do item carro na tabela horario usando como referncia o
	// ID da linha
	// columnType = 1 significa que a coluna é do tipo inteiro,
	// columnType = 2 significa que a coluna é do tipo String
	public void updateCar(String line, String car) {
		

		Statement st;

		try {
			st = conect.createStatement();

			String sql = " UPDATE " + HorarioEnum.TABELA.getNome() + " SET " + HorarioEnum.CARRO.getNome() + " = " + car
					+ " WHERE " + HorarioEnum.LINHA.getNome() + " = " + line;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Selecionando todos os objetos da tabela horario que estão vinculados com um
	// objeto da tabela linha
	// Parâmetro também usado: dia
	// Ordenado de forma crescente pela hora
	public ResultSet scheduleLineByDay(int id, int day) {
		
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
					+ HorarioEnum.LINHA.getNome() + " = " + id + " AND " + HorarioEnum.DIA.getNome() + " = " + day
					+ " ORDER BY " + HorarioEnum.HORA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Selecionando todos os objetos da tabela horario que estão vinculados com um
	// objeto da tabela carro
	// Parâmetro também usado: dia
	// Ordenado de forma crescente pela hora
	public ResultSet scheduleCarByDay(int id, int day) {
		
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
					+ HorarioEnum.CARRO.getNome() + " = " + id + " AND " + HorarioEnum.DIA.getNome() + " = " + day
					+ " ORDER BY " + HorarioEnum.HORA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Lista de todos os objetos da tabela carro
	public ResultSet listOfCar() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Captura dos campos: ID do carro e nome do carro
			String sql = "SELECT " + CarroEnum.ID.getNome() + " ,  " + CarroEnum.NOME.getNome() + " FROM "
					+ CarroEnum.TABELA.getNome() + " ORDER BY " + CarroEnum.ID.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Lista de todos os objetos da tabela linha
	public ResultSet listOfLine() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Captura dos campos: ID da linha e nome da linha
			String sql = "SELECT " + LinhaEnum.ID.getNome() + " ,  " + LinhaEnum.NOME.getNome() + " , "
					+ LinhaEnum.NUMERO.getNome() + " FROM " + LinhaEnum.TABELA.getNome() + " ORDER BY "
					+ LinhaEnum.NUMERO.getNome();
			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Lista de todos os objetos da tabela funcionario
	public ResultSet listOfEmployee() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Captura dos campos: ID do funcionario e apelido do funcionario
			String sql = "SELECT " + FuncionarioEnum.ID.getNome() + " ,  " + FuncionarioEnum.APELIDO.getNome()
					+ " FROM " + FuncionarioEnum.TABELA.getNome() + " ORDER BY " + FuncionarioEnum.APELIDO.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Lista de todos os objetos da tabela funcionario onde o tipo do funcionario é
	// 1
	public ResultSet listOfDriver() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Captura de campos: ID do funcionario e apelido do funcionario
			String sql = "SELECT " + FuncionarioEnum.ID.getNome() + " ,  " + FuncionarioEnum.APELIDO.getNome()
					+ " FROM " + FuncionarioEnum.TABELA.getNome() + " WHERE " + FuncionarioEnum.TIPO.getNome() + " = "
					+ TipoFuncionarioEnum.MOTORISTA.getNome() + " ORDER BY " + FuncionarioEnum.APELIDO.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Lista de todos os objetos da tabela funcionario onde o tipo do funcionario é
	// 2
	public ResultSet listOfConductor() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Captura dos campos: ID funcionario e apelido funcionario
			String sql = "SELECT " + FuncionarioEnum.ID.getNome() + " ,  " + FuncionarioEnum.APELIDO.getNome()
					+ " FROM " + FuncionarioEnum.TABELA.getNome() + " WHERE " + FuncionarioEnum.TIPO.getNome() + " = "
					+ TipoFuncionarioEnum.COBRADOR.getNome() + " ORDER BY " + FuncionarioEnum.APELIDO.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Tipos:
	// 1 - Busca por dia
	// 2 - Buscar por carro
	// 3 - Buscar por linha
	// 4 - Buscar por funcionario
	// 5 - Buscar por garagem
	public ResultSet search(int type, int id) {
		
		Statement st;
		ResultSet rs = null;
		try {
			switch (type) {
			case 1: {

				st = conect.createStatement();

				String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.DIA.getNome() + " = " + id + " ORDER BY " + HorarioEnum.HORA.getNome();

				rs = st.executeQuery(sql);

				break;

			}

			case 2: {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.CARRO.getNome() + " = " + id + " ORDER BY " + HorarioEnum.DIA.getNome() + " , "
						+ HorarioEnum.HORA.getNome();

				rs = st.executeQuery(sql);

				break;
			}

			case 3: {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.LINHA.getNome() + " = " + id + " ORDER BY " + HorarioEnum.DIA.getNome() + " , "
						+ HorarioEnum.HORA.getNome();

				rs = st.executeQuery(sql);

				break;
			}

			case 4: {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.MOTORISTA.getNome() + " = " + id + " OR " + HorarioEnum.COBRADOR + " = " + id
						+ " ORDER BY " + HorarioEnum.DIA.getNome() + " , " + HorarioEnum.HORA.getNome();

				rs = st.executeQuery(sql);

				break;
			}

			case 5: {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.GARAGEM.getNome() + " = " + id + " ORDER BY " + HorarioEnum.DIA.getNome() + " , "
						+ HorarioEnum.HORA.getNome();

				rs = st.executeQuery(sql);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}
		} catch (Exception e) {

		}

		return rs;
	}

	// Lista de todos os objetos da tabela garagem
	public ResultSet listOfGarage() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Captura dos campos: ID da garagem e nome da garagem
			String sql = "SELECT " + GaragemEnum.ID.getNome() + " ,  " + GaragemEnum.NOME.getNome() + " FROM "
					+ GaragemEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Deletando objeto da tabela horario usando como referencia o ID da coluna
	public void deleteByIdObject(String column, int id) {
		

		Statement st;

		try {
			st = conect.createStatement();

			String sql = " DELETE FROM " + HorarioEnum.TABELA.getNome() + " WHERE " + column + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Quantidade de objetos de uma tabela que tem vinculo com algum objeto da
	// tabela horario
	public int bondObjectSchedule(String object, int objectID) {
		
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT COUNT (" + HorarioEnum.ID.getNome() + ") FROM " + HorarioEnum.TABELA.getNome()
					+ " WHERE " + object + " = " + objectID;

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

}

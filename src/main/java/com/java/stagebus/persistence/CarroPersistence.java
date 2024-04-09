package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.DiaEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.enums.StatusEnum;
import com.java.stagebus.enums.TipoCarroEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.CarroModel;

public class CarroPersistence {

	private static Connection conect;
	
	public CarroPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Lista de todos os objetos da tabela carro
	public ResultSet listOfCar() {
		
		Statement st;
		ResultSet rs = null;

		try {

			st = conect.createStatement();

			// Seleciando a view para capturar todos os dados do carro
			// Utilizada a view porque existe inner join para capturar o nome das chaves
			// estrangeiras
			String sql = "SELECT * FROM " + CarroEnum.VIEW_ALL_CARS.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Inserindo objeto no banco de dados
	public void insertCar(CarroModel carro) {
		

		Statement st;

		// Usando uma string para armazenar os campos que serão inseridos
		String campos = CarroEnum.ID.getNome() + " , " + CarroEnum.NOME.getNome() + " , " + CarroEnum.PLACA.getNome()
				+ " , " + CarroEnum.TIPO.getNome() + " , " + CarroEnum.STATUS.getNome() + " , "
				+ CarroEnum.GARAGEM.getNome();
		try {
			st = conect.createStatement();

			// Criando string com nome dos campos e valores correspondentes
			String sql = "INSERT INTO " + CarroEnum.TABELA.getNome() + "(\r\n" + campos + ")\r\n" + "	VALUES ("
					+ carro.getNumero() + " , ' " + carro.getNome() + "', '" + carro.getPlaca() + "', "
					+ carro.getIdTipo() + ", " + carro.getIdStatus() + ", " + carro.getIdGaragem() + ");";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Checando quantos objetos existem no banco com o mesmo ID
	public int checkingExistingCar(int id) {
		

		Statement st;
		ResultSet rs;
		int value = 0;

		try {

			st = conect.createStatement();

			String sql = "SELECT COUNT(" + CarroEnum.ID.getNome() + ") from " + CarroEnum.TABELA.getNome() + " WHERE "
					+ CarroEnum.ID.getNome() + " = " + id;

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;
	}

	// Deletando objeto do banco usando o ID do objeto como referencia
	public void delete(int id) {
		
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + CarroEnum.TABELA.getNome() + " WHERE " + CarroEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Pesquisando um objeto no banco usando o ID do objeto como referencia
	public ResultSet searchByID(int id) {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + CarroEnum.VIEW_ALL_CARS.getNome() + " WHERE " + CarroEnum.ID.getNome()
					+ " = " + id;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando todos os objetos da tabela status
	public ResultSet listOfStatus() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + StatusEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando todos os objetos da tabela tipo_carro
	public ResultSet listOfType() {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Campos capturados: id tipo de carro e nome do tipo de carro
			String sql = "SELECT " + TipoCarroEnum.ID.getNome() + ", " + TipoCarroEnum.NOME.getNome() + " from public."
					+ TipoCarroEnum.TABELA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando todos os objetos da tabela horario que tem vinculo com um objeto
	// da tabela carro
	public ResultSet scheduleOfCar(int id) {
		

		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			// Campos capturados: nome do dia e hora
			String sql = "SELECT " + DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome() + ", "
					+ HorarioEnum.HORA.getNome() + "\r\n" + "	FROM " + HorarioEnum.TABELA.getNome() + "\r\n"
					+ "	INNER JOIN\r\n" + "	" + DiaEnum.TABELA.getNome() + " ON " + HorarioEnum.TABELA.getNome() + "."
					+ HorarioEnum.DIA.getNome() + " = " + DiaEnum.TABELA.getNome() + "." + DiaEnum.ID.getNome()
					+ " WHEN  " + CarroEnum.TABELA.getNome() + " =  " + id + " ORDER BY " + HorarioEnum.DIA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Tipos:
	// 1 - Buscar por nome
	// 2 - Buscar por numero
	// 3 - Buscar por placa

	public ResultSet search(int type_search, String term) {
		
		Statement st;
		ResultSet rs = null;

		switch (type_search) {
		case 1:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + CarroEnum.VIEW_ALL_CARS.getNome() + " WHERE " + CarroEnum.NOME.getNome()
						+ " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 2:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + CarroEnum.VIEW_ALL_CARS.getNome() + " WHERE CAST("
						+ CarroEnum.ID.getNome() + " AS VARCHAR) ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 3:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + CarroEnum.VIEW_ALL_CARS.getNome() + " WHERE "
						+ CarroEnum.PLACA.getNome() + " ILIKE '%" + term + "%'";

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

	// columnType = 1 significa que a coluna é do tipo inteiro e a chamada foi feita
	// da tela de edição
	// columnType = 2 significa que a coluna é do tipo String e a chamada foi feita
	// da tela de edição
	// columnType = 3 significa que a coluna é do tipo inteiro e a chamada foi feita
	// da tela de exlusão
	// columnType = 4 significa que a coluna é do tipo String e a chamada foi feita
	// da tela de exlusão
	public void update(String columnUpdate, int id, String value, int columnType) {
		
		Statement st;

		// Formatando o valor que for do tipo String colocando ' '
		if (columnType == 2 || columnType == 4)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();
			String sql;

			// Chamadas vinda da tela de edição utilizam como base o ID pra modificar o
			// objeto
			if (columnType < 3)

				sql = " UPDATE " + CarroEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value + " WHERE "
						+ CarroEnum.ID.getNome() + " = " + id;

			// Chamadas vindas de outras telas usam como base a própria coluna que está
			// sendo modificação para identificar o objeto
			else
				sql = " UPDATE " + CarroEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value + " WHERE "
						+ columnUpdate + " = " + id;
			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Modificar o id/número do carro
	public void updateCarNumber(int id, int newID) {
		

		Statement st;

		try {
			st = conect.createStatement();

			String sql = " UPDATE " + HorarioEnum.TABELA.getNome() + " SET " + HorarioEnum.CARRO.getNome() + " = "
					+ newID + " WHERE " + HorarioEnum.CARRO.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Capturando objetos da tabela horário que estão relacionados a um objeto da
	// tabela carro
	// Usando como parametro o ID do objeto e o dia
	// Retornado apenas a linha
	public ResultSet lineByDay(int day, int id) {
		
		Statement st;
		ResultSet rs = null;
		try {
			st = conect.createStatement();

			String sql = "SELECT *  FROM " + CarroEnum.VIEW_LINHAS_DO_CARRO.getNome() + " WHERE "
					+ HorarioEnum.CARRO.getNome() + " = " + id + " AND " + HorarioEnum.DIA.getNome() + " = " + day
					+ " ORDER BY " + HorarioEnum.HORA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

}

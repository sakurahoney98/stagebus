package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.DiaEnum;
import com.java.stagebus.enums.FuncionarioEnum;
import com.java.stagebus.enums.GaragemEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.enums.LinhaEnum;
import com.java.stagebus.enums.RelatorioEnum;
import com.java.stagebus.enums.StatusEnum;
import com.java.stagebus.enums.TipoCarroEnum;
import com.java.stagebus.enums.TipoFuncionarioEnum;
import com.java.stagebus.enums.UsuarioEnum;
import com.java.stagebus.main.StagebusApplication;

public class RelatorioPersistence {

	private static Connection conect;
	
	public RelatorioPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Lista de todos os objetos da tabela horário vinculados com um objeto da
	// tabela funcionario
	public ResultSet employeeSchedule(int employee) {
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + FuncionarioEnum.HORARIO_FUNCIONARIO.getNome() + " WHERE "
					+ HorarioEnum.COBRADOR.getNome() + " = " + employee + " OR " + HorarioEnum.MOTORISTA.getNome()
					+ " = " + employee + " ORDER BY " + HorarioEnum.DIA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Capturando dados da tabela carro
	// 1 - Filtro de status
	// 2 - Filtro de garagem
	// 3 - Filtro de tipo de carro
	// 0 - Sem filtro
	public ResultSet getCarTable(List<String> columns, int param, int id_param) {
		Statement st;
		ResultSet rs = null;

		try {

			// Criação de váriaveis para o caso de ser necessário usar join ou where
			String inner = "";
			String where = "";
			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			// Verificando se será necessário usar join com a tabela tipo carro para
			// capturar o nome do objeto
			if (columns.contains(TipoCarroEnum.TABELA.getNome() + "." + TipoCarroEnum.NOME.getNome()))
				inner += "\n JOIN " + TipoCarroEnum.TABELA.getNome() + " ON " + TipoCarroEnum.TABELA.getNome() + "."
						+ TipoCarroEnum.ID.getNome() + " = " + CarroEnum.TABELA.getNome() + "."
						+ CarroEnum.TIPO.getNome();

			// Verificando se é necessário fazer join com a tabela status para capturar o
			// nome do objeto
			if (columns.contains(StatusEnum.TABELA.getNome() + "." + StatusEnum.DESCRICAO.getNome()))
				inner += "\n JOIN " + StatusEnum.TABELA.getNome() + " ON " + StatusEnum.TABELA.getNome() + "."
						+ StatusEnum.ID.getNome() + " = " + CarroEnum.TABELA.getNome() + "."
						+ CarroEnum.STATUS.getNome();

			// Verificando se é necessário fazer join com a tabela garagem para capturar o
			// nome do objeto
			if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome()))
				inner += "\n JOIN " + GaragemEnum.TABELA.getNome() + " ON " + GaragemEnum.TABELA.getNome() + "."
						+ GaragemEnum.ID.getNome() + " = " + CarroEnum.TABELA.getNome() + "."
						+ CarroEnum.GARAGEM.getNome();

			// Verificando se existe filtro de status
			if (param == 1)
				where = "\n WHERE " + CarroEnum.STATUS.getNome() + " = " + id_param;

			// Verificando se existe filtro de garagem
			if (param == 2)
				where = "\n WHERE " + CarroEnum.GARAGEM.getNome() + " = " + id_param;

			// Verificando se existe filtro de tipo de carro
			if (param == 3)
				where = "\n WHERE " + CarroEnum.TIPO.getNome() + " = " + id_param;

			// Unindo campos selecionados com join, where e ordenando pelo numero do carro
			sql += "\n FROM " + CarroEnum.TABELA.getNome() + inner + where + "\n ORDER BY " + CarroEnum.ID.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando dados da tabela funcionario
	// 1 - Filtro de tipo de funcionário
	// 0 - Sem filtro
	public ResultSet getEmployeeTable(List<String> columns, int param, int id_param) {
		Statement st;
		ResultSet rs = null;

		try {
			// Criação de váriaveis para o caso de ser necessário usar join ou where
			String inner = "";
			String where = "";

			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			// Verificando se é necessário fazer join com a tabela tipo funcionario para
			// capturar o nome do objeto
			if (columns.contains(TipoFuncionarioEnum.TABELA.getNome() + "." + TipoFuncionarioEnum.DESCRICAO.getNome()))
				inner += "\n JOIN " + TipoFuncionarioEnum.TABELA.getNome() + " ON "
						+ TipoFuncionarioEnum.TABELA.getNome() + "." + TipoFuncionarioEnum.ID.getNome() + " = "
						+ FuncionarioEnum.TABELA.getNome() + "." + FuncionarioEnum.TIPO.getNome();

			if (param == 1)
				where = "\n WHERE " + FuncionarioEnum.TIPO.getNome() + " = " + id_param;

			sql += "\n FROM " + FuncionarioEnum.TABELA.getNome() + inner + where + " ORDER BY "
					+ FuncionarioEnum.NOME.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando dados da tabela garagem
	public ResultSet getGarageTable(List<String> columns) {
		Statement st;
		ResultSet rs = null;

		try {
			// Criação de váriaveis para o caso de ser necessário usar join ou group by
			String left = "";
			String group_by = "";

			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			// Verificando se é necessário fazer left join com a tabela carro para saber a
			// quantidade de ônibus na garagem
			if (columns.contains("COUNT (" + CarroEnum.TABELA.getNome() + "." + CarroEnum.GARAGEM.getNome() + ")")) {
				left += "\n LEFT JOIN " + CarroEnum.TABELA.getNome() + " ON " + CarroEnum.TABELA.getNome() + "."
						+ CarroEnum.GARAGEM.getNome() + " = " + GaragemEnum.TABELA.getNome() + "."
						+ GaragemEnum.ID.getNome();

				// Preenchendo o group by com as colunas da tabela garagem
				group_by = "\n GROUP BY ";
				for (int i = 0; i < (columns.size() - 1); i++) {
					// Verificando se o objeto é o anti penúltimo da lista
					if ((i + 2) != columns.size())
						// Se não for inserir vírgula
						group_by += GaragemEnum.TABELA.getNome() + "." + columns.get(i) + ", ";
					else
						// Se for não colocar vírgula
						group_by += GaragemEnum.TABELA.getNome() + "." + columns.get(i);
				}

			}

			// Unindo as colunas selecionadas, left join e group by com ordenação pelo nome
			// da garagem
			sql += "\n FROM " + GaragemEnum.TABELA.getNome() + left + group_by + " ORDER BY "
					+ GaragemEnum.NOME.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando dados da tabela horario
	// 1 - Filtro por dia
	// 2 - Filtro por garagem
	// 3 - Filtro por carro
	// 4 - Filtro por linha
	// 5 - Filtro por funcionario
	// 0 - Sem filtro
	public ResultSet getScheduleTable(List<String> columns, int param, int id_param) {
		Statement st;
		ResultSet rs = null;

		try {
			// Criação de váriaveis para o caso de ser necessário usar join ou where
			String inner = "";
			String where = "";

			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			// Verificando se é necessário fazer join com a tabela dia para capturar o nome
			// do objeto
			if (columns.contains(DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome()))
				inner += "\n JOIN " + DiaEnum.TABELA.getNome() + " ON " + DiaEnum.TABELA.getNome() + "."
						+ DiaEnum.ID.getNome() + " = " + HorarioEnum.TABELA.getNome() + "." + HorarioEnum.DIA.getNome();

			// Verificando se é necessário fazer join com a tabela linha para capturar o
			// numero do objeto
			if (columns.contains("num." + LinhaEnum.NUMERO.getNome()))
				inner += "\n JOIN " + LinhaEnum.TABELA.getNome() + " num ON num." + LinhaEnum.ID.getNome() + " = "
						+ HorarioEnum.TABELA.getNome() + "." + HorarioEnum.LINHA.getNome();

			// Verificando se é necessário fazer join com a tabela linha para capturar o
			// nome do objeto
			if (columns.contains("nome." + LinhaEnum.NOME.getNome()))
				inner += "\n JOIN " + LinhaEnum.TABELA.getNome() + " nome ON nome." + LinhaEnum.ID.getNome() + " = "
						+ HorarioEnum.TABELA.getNome() + "." + HorarioEnum.LINHA.getNome();

			// Verificando se é necessário fazer join com a tabela funcionario para capturar
			// o apelido do objeto motorista
			if (columns.contains("mot." + FuncionarioEnum.APELIDO.getNome() + " as nome_motorista"))
				inner += "\n LEFT JOIN " + FuncionarioEnum.TABELA.getNome() + " mot ON mot."
						+ FuncionarioEnum.ID.getNome() + " = " + HorarioEnum.TABELA.getNome() + "."
						+ HorarioEnum.MOTORISTA.getNome();

			// Verificando se é necessário fazer join com a tabela funcionario para capturar
			// o apelido do objeto cobrador
			if (columns.contains("cob." + FuncionarioEnum.APELIDO.getNome() + " as nome_cobrador"))
				inner += "\n LEFT JOIN " + FuncionarioEnum.TABELA.getNome() + " cob ON cob."
						+ FuncionarioEnum.ID.getNome() + " = " + HorarioEnum.TABELA.getNome() + "."
						+ HorarioEnum.COBRADOR.getNome();

			// Verificando se é necessário fazer join com a tabela garagem para capturar o
			// nome do objeto
			if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome()))
				inner += "\n JOIN " + GaragemEnum.TABELA.getNome() + " ON " + GaragemEnum.TABELA.getNome() + "."
						+ GaragemEnum.ID.getNome() + " = " + HorarioEnum.TABELA.getNome() + "."
						+ HorarioEnum.GARAGEM.getNome();

			// Verificando se existe filtro de dia
			if (param == 1)
				where = "\n WHERE " + HorarioEnum.DIA.getNome() + " = " + id_param;

			// Verificando se existe filtro de garagem
			else if (param == 2)
				where = "\n WHERE " + HorarioEnum.GARAGEM.getNome() + " = " + id_param;

			// Verificando se existe filtro de carro
			else if (param == 3)
				where = "\n WHERE " + HorarioEnum.CARRO.getNome() + " = " + id_param;

			// Verificando se existe filtro de linha
			else if (param == 4)
				where = "\n WHERE " + HorarioEnum.LINHA.getNome() + " = " + id_param;

			// Verificando se existe filtro de funcionario
			else if (param == 5)
				where = "\n WHERE " + HorarioEnum.MOTORISTA.getNome() + " = " + id_param + "\n OR "
						+ HorarioEnum.COBRADOR.getNome() + " = " + id_param;

			sql += "\n FROM " + HorarioEnum.TABELA.getNome() + inner + where + " ORDER BY " + HorarioEnum.DIA.getNome()
					+ ", " + HorarioEnum.HORA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando dados da tabela linha
	public ResultSet getLineTable(List<String> columns) {
		Statement st;
		ResultSet rs = null;

		try {

			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			sql += "\n FROM " + LinhaEnum.TABELA.getNome() + " ORDER BY " + LinhaEnum.NUMERO.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando dados da tabela usuario
	public ResultSet getUserTable(List<String> columns) {
		Statement st;
		ResultSet rs = null;

		try {

			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			sql += "\n FROM " + UsuarioEnum.TABELA.getNome() + " ORDER BY " + UsuarioEnum.NOME.getNome() + ", "
					+ UsuarioEnum.SOBRENOME.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Capturando dados da tabela tipo carro
	public ResultSet getCarTypeTable(List<String> columns) {
		Statement st;
		ResultSet rs = null;

		try {

			st = conect.createStatement();

			String sql = "SELECT ";

			// Referenciando os campos que devem ser selecionados
			for (int i = 0; i < columns.size(); i++) {
				// Verificando se é a penultima coluna da lista
				// Caso não seja colocar a virgula no final
				if ((i + 1) != columns.size())
					sql += columns.get(i) + ", ";
				else
					// Caso seja não colocar vírgula
					sql += columns.get(i);
			}

			sql += "\n FROM " + TipoCarroEnum.TABELA.getNome() + " ORDER BY " + TipoCarroEnum.NOME.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// 1 - Para capturar dados usando como referencia o ID do carro
	// 2 - Para capturar dados usando como referencia o ID da linha
	public ResultSet reportOfCarsLines(int id, int type) {
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql;

			if (type == 1)
				sql = "SELECT * " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.CARRO.getNome() + " = " + id + " ORDER BY " + HorarioEnum.DIA.getNome();

			else

				sql = "SELECT * " + HorarioEnum.RELATORIO_CARRROS_LINHAS.getNome() + " WHERE "
						+ HorarioEnum.LINHA.getNome() + " = " + id + " ORDER BY " + HorarioEnum.DIA.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Capturando dados de uma garagem usando o ID da garage como referencia
	public ResultSet getDataGarage(int id) {
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			// Campos capturados: largura e comprimento
			String sql = "SELECT " + GaragemEnum.LARGURA.getNome() + ", " + GaragemEnum.COMPRIMENTO.getNome() + "\r\n"
					+ "FROM public." + GaragemEnum.TABELA.getNome() + "\r\n" + "WHERE " + GaragemEnum.ID.getNome()
					+ " = " + id;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Parametro igual a 1 = organizar por horario de saída
	// Parametro igual a 2 = organizar pelo numero do carro
	// Parametro igual a 3 = organizar pelo número da linha

	public ResultSet getBusListOfGarage(int id, int param, int dia) {
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + RelatorioEnum.VIEW_ONIBUS_DIA.getNome() + " WHERE "
					+ HorarioEnum.GARAGEM.getNome() + " = " + id + " AND dia = " + dia + " AND "
					+ CarroEnum.STATUS.getNome() + " = 2\r\n" + "					ORDER BY ";

			if (param == 1)
				sql += HorarioEnum.HORA.getNome();
			else if (param == 2)
				sql += HorarioEnum.CARRO.getNome();
			else if (param == 3)
				sql += LinhaEnum.NUMERO.getNome();

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

}

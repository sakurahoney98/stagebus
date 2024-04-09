package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.java.stagebus.enums.UsuarioEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.UsuarioModel;

public class UsuarioPersistence {
	private static Connection conect;
	
	public UsuarioPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Verificando existencia de um nome de login cadastrado na tabela usuario
	public boolean checkLoginExisting(String user_name) {

		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = "SELECT COUNT(*) FROM " + UsuarioEnum.TABELA.getNome() + " WHERE "
					+ UsuarioEnum.LOGIN.getNome() + " = '" + user_name + "'";

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (value > 0)
			return true;
		else
			return false;

	}

	// Verificando se o objeto está com status ativo usando como referencia o login
	public boolean checkActiveUser(String user_name) {

		Statement st;
		ResultSet rs;
		boolean value = false;

		try {
			st = conect.createStatement();

			String sql = "SELECT " + UsuarioEnum.STATUS.getNome() + " FROM " + UsuarioEnum.TABELA.getNome() + " WHERE "
					+ UsuarioEnum.LOGIN.getNome() + " = '" + user_name + "'";

			rs = st.executeQuery(sql);

			rs.next();

			value = rs.getBoolean(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

	// Inseridno objeto na tabela usuario
	public void insertUser(UsuarioModel user, List<String> permissions) {
		Statement st;

		try {
			st = conect.createStatement();

			// Referenciando os campos do objeto a serem preenchidos
			String campos = UsuarioEnum.ID.getNome() + " , " + UsuarioEnum.LOGIN.getNome() + " , "
					+ UsuarioEnum.SENHA.getNome() + " , " + UsuarioEnum.NOME.getNome() + " , "
					+ UsuarioEnum.SOBRENOME.getNome() + " , " + UsuarioEnum.CADASTRAR_USUARIO.getNome() + " , "
					+ UsuarioEnum.CADASTRAR_CARRO.getNome() + " , " + UsuarioEnum.CADASTRAR_GARAGEM.getNome() + " , "
					+ UsuarioEnum.CADASTRAR_LINHA.getNome() + " , " + UsuarioEnum.CADASTRAR_TIPO_CARRO.getNome() + " , "
					+ UsuarioEnum.CADASTRAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EDITAR_USUARIO.getNome() + " , "
					+ UsuarioEnum.EDITAR_CARRO.getNome() + " , " + UsuarioEnum.EDITAR_GARAGEM.getNome() + " , "
					+ UsuarioEnum.EDITAR_LINHA.getNome() + " , " + UsuarioEnum.EDITAR_TIPO_CARRO.getNome() + " , "
					+ UsuarioEnum.EDITAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EMITIR_RELATORIO.getNome() + " , "
					+ UsuarioEnum.CADASTRAR_EDITAR_HORARIO.getNome() + " , "
					+ UsuarioEnum.DAR_PERMISSAO_USUARIO.getNome() + " , " + UsuarioEnum.EXCLUIR_USUARIO.getNome()
					+ " , " + UsuarioEnum.ATIVAR_DESATIVAR_USUARIO.getNome() + " , " + UsuarioEnum.STATUS.getNome();

			// Informando os campos e seus respectivos valores
			String sql = "INSERT INTO " + UsuarioEnum.TABELA.getNome() + "(" + campos + ") VALUES (" + user.getId()
					+ ", '" + user.getLogin() + "', '" + user.getSenha() + "', '" + user.getNome() + "', '"
					+ user.getSobrenome() + "', " + user.isCad_user() + ", " + user.isCad_car() + ", "
					+ user.isCad_gar() + ", " + user.isCad_lin() + ", " + user.isCad_tip_car() + ", " + user.isCad_fun()
					+ " , " + user.isEd_user() + ", " + user.isEd_car() + ", " + user.isEd_car() + ", "
					+ user.isEd_lin() + ", " + user.isEd_tip_car() + " , " + user.isEd_fun() + ", " + user.isEm_rel()
					+ ", " + user.isCad_ed_hor() + ", " + user.isPerm_user() + ", " + user.isExc_user() + ", "
					+ user.isAt_des_user() + " , " + user.isStatus() + ");";

			st.executeUpdate(sql);

			// Atribuindo permissoes ao usuario
			assignPermissions(user.getId(), permissions);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Capturando o ultimo ID cadastrado na tabela usuario
	public int generateID() {
		Statement st;
		ResultSet rs;
		int value = 0;

		try {
			st = conect.createStatement();

			String sql = " SELECT * FROM " + UsuarioEnum.ULTIMO_REGISTRO.getNome();

			rs = st.executeQuery(sql);

			rs.next();

			if (rs.getInt(1) > 0)
				value = rs.getInt(2);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return value;

	}

	// Capturando dados da tabela usuario usando o ID como referencia
	public ResultSet searchByID(int id) {

		Statement st;
		ResultSet rs = null;

		// Referenciando os campos a serem selecionados
		String campos = UsuarioEnum.ID.getNome() + " , " + UsuarioEnum.LOGIN.getNome() + " , "
				+ UsuarioEnum.SENHA.getNome() + " , " + UsuarioEnum.NOME.getNome() + " , "
				+ UsuarioEnum.SOBRENOME.getNome() + " , " + UsuarioEnum.CADASTRAR_USUARIO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_CARRO.getNome() + " , " + UsuarioEnum.CADASTRAR_GARAGEM.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_LINHA.getNome() + " , " + UsuarioEnum.CADASTRAR_TIPO_CARRO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EDITAR_USUARIO.getNome() + " , "
				+ UsuarioEnum.EDITAR_CARRO.getNome() + " , " + UsuarioEnum.EDITAR_GARAGEM.getNome() + " , "
				+ UsuarioEnum.EDITAR_LINHA.getNome() + " , " + UsuarioEnum.EDITAR_TIPO_CARRO.getNome() + " , "
				+ UsuarioEnum.EDITAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EMITIR_RELATORIO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_EDITAR_HORARIO.getNome() + " , " + UsuarioEnum.DAR_PERMISSAO_USUARIO.getNome()
				+ " , " + UsuarioEnum.EXCLUIR_USUARIO.getNome() + " , " + UsuarioEnum.ATIVAR_DESATIVAR_USUARIO.getNome()
				+ " , " + UsuarioEnum.STATUS.getNome();
		try {
			st = conect.createStatement();

			String sql = "SELECT " + campos + " FROM " + UsuarioEnum.TABELA.getNome() + " WHERE "
					+ UsuarioEnum.ID.getNome() + " = " + id;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Capturando os dados da tabela usuario usando o login como referencia
	public ResultSet searchByUserName(String userName) {

		Statement st;
		ResultSet rs = null;

		// Refernciando os campos a serem selecionados
		String campos = UsuarioEnum.ID.getNome() + " , " + UsuarioEnum.LOGIN.getNome() + " , "
				+ UsuarioEnum.SENHA.getNome() + " , " + UsuarioEnum.NOME.getNome() + " , "
				+ UsuarioEnum.SOBRENOME.getNome() + " , " + UsuarioEnum.CADASTRAR_USUARIO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_CARRO.getNome() + " , " + UsuarioEnum.CADASTRAR_GARAGEM.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_LINHA.getNome() + " , " + UsuarioEnum.CADASTRAR_TIPO_CARRO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EDITAR_USUARIO.getNome() + " , "
				+ UsuarioEnum.EDITAR_CARRO.getNome() + " , " + UsuarioEnum.EDITAR_GARAGEM.getNome() + " , "
				+ UsuarioEnum.EDITAR_LINHA.getNome() + " , " + UsuarioEnum.EDITAR_TIPO_CARRO.getNome() + " , "
				+ UsuarioEnum.EDITAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EMITIR_RELATORIO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_EDITAR_HORARIO.getNome() + " , " + UsuarioEnum.DAR_PERMISSAO_USUARIO.getNome()
				+ " , " + UsuarioEnum.EXCLUIR_USUARIO.getNome() + " , " + UsuarioEnum.ATIVAR_DESATIVAR_USUARIO.getNome()
				+ " , " + UsuarioEnum.STATUS.getNome();
		try {
			st = conect.createStatement();

			String sql = "SELECT " + campos + " FROM " + UsuarioEnum.TABELA.getNome() + " WHERE "
					+ UsuarioEnum.LOGIN.getNome() + " = '" + userName + "'";

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Lista de tdos os objetos da tabela usuario
	public ResultSet listOfUsers() {
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			String sql = "SELECT * FROM " + UsuarioEnum.TABELA.getNome() + " WHERE " + UsuarioEnum.ID.getNome() + " != 1 " ;

			rs = st.executeQuery(sql);

			rs.next();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	// Deletando objeto da tabela usuario usando o ID como referencia
	public void delete(int id) {
		Statement st;

		try {
			st = conect.createStatement();

			String sql = "DELETE FROM " + UsuarioEnum.TABELA.getNome() + " WHERE " + UsuarioEnum.ID.getNome() + " = "
					+ id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Tipos:
	// 1 - Busca por nome
	// 2 - Buscar por sobrenome
	// 3 - Busca por login
	public ResultSet search(int type_search, String term) {
		Statement st;
		ResultSet rs = null;

		switch (type_search) {
		case 1:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + UsuarioEnum.TABELA.getNome() + " WHERE " + UsuarioEnum.NOME.getNome()
						+ " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 2:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + UsuarioEnum.TABELA.getNome() + " WHERE "
						+ UsuarioEnum.SOBRENOME.getNome() + " ILIKE '%" + term + "%'";

				rs = st.executeQuery(sql);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;

		case 3:

			try {
				st = conect.createStatement();

				String sql = "SELECT * FROM " + UsuarioEnum.TABELA.getNome() + " WHERE " + UsuarioEnum.LOGIN.getNome()
						+ " ILIKE '%" + term + "%'";

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

	// columnType = 1 significa que a coluna é do tipo inteir
	// columnType = 2 significa que a coluna é do tipo String
	public void update(String columnUpdate, int id, String value, int columnType) {

		Statement st;

		if (columnType == 2)
			value = "'" + value + "'";

		try {
			st = conect.createStatement();

			String sql = " UPDATE " + UsuarioEnum.TABELA.getNome() + " SET " + columnUpdate + " = " + value + " WHERE "
					+ UsuarioEnum.ID.getNome() + " = " + id;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Atualizando a lista de permissoes do usuario
	public void updatePermissions(int id, List<String> permissions) {

		// Referenciando todas as permissões que um usuario pode ter
		String allPermissions[] = { UsuarioEnum.CADASTRAR_USUARIO.getNome(), UsuarioEnum.CADASTRAR_CARRO.getNome(),
				UsuarioEnum.CADASTRAR_GARAGEM.getNome(), UsuarioEnum.CADASTRAR_LINHA.getNome(),
				UsuarioEnum.CADASTRAR_TIPO_CARRO.getNome(), UsuarioEnum.CADASTRAR_FUNCIONARIO.getNome(),
				UsuarioEnum.EDITAR_USUARIO.getNome(), UsuarioEnum.EDITAR_CARRO.getNome(),
				UsuarioEnum.EDITAR_GARAGEM.getNome(), UsuarioEnum.EDITAR_LINHA.getNome(),
				UsuarioEnum.EDITAR_TIPO_CARRO.getNome(), UsuarioEnum.EDITAR_FUNCIONARIO.getNome(),
				UsuarioEnum.EMITIR_RELATORIO.getNome(), UsuarioEnum.CADASTRAR_EDITAR_HORARIO.getNome(),
				UsuarioEnum.DAR_PERMISSAO_USUARIO.getNome(), UsuarioEnum.EXCLUIR_USUARIO.getNome(),
				UsuarioEnum.ATIVAR_DESATIVAR_USUARIO.getNome(), UsuarioEnum.STATUS.getNome() };
		Statement st;

		try {
			st = conect.createStatement();

			// Atribuindo falso para todas as permissões
			for (int i = 0; i < allPermissions.length; i++) {

				String sql = "UPDATE " + UsuarioEnum.TABELA.getNome() + " SET " + allPermissions[i] + " = false "
						+ " WHERE " + UsuarioEnum.ID.getNome() + " = " + id + ";";

				st.executeUpdate(sql);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Adicionando permissões
		assignPermissions(id, permissions);

	}

	// Atribuição de permissões a um usuario
	private void assignPermissions(int id, List<String> permissions) {
		Statement st;

		try {
			st = conect.createStatement();

			// Atribuindo true para uma lista de permissoes passada como parametro
			for (String s : permissions) {
				String sql = "UPDATE " + UsuarioEnum.TABELA.getNome() + " SET " + s + " = true" + " WHERE "
						+ UsuarioEnum.ID.getNome() + " = " + id + ";";

				st.executeUpdate(sql);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

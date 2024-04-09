package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.LogEnum;
import com.java.stagebus.enums.UsuarioEnum;
import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.LogModel;

public class LogPersistence {
	private static Connection conect;
	
	public LogPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Inserindo log no banco de dados
	public void insertLog(LogModel log) {
		Statement st;

		try {

			st = conect.createStatement();

			// Dados inseridos: ID do usuário, descrição da atividade, data da ação, hora da
			// ação
			String sql = "INSERT INTO public." + LogEnum.TABELA.getNome() + "( " + LogEnum.USUARIO.getNome() + " , "
					+ LogEnum.DESCRICAO.getNome() + ", " + LogEnum.DATA.getNome() + ", " + LogEnum.HORA.getNome()
					+ " )\r\n" + "	VALUES (" + log.getUsuario() + ", '" + log.getDescricao() + "', '" + log.getData()
					+ "', '" + log.getHora() + "');";

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Capturando as atividades de um usuário utilizando como referencia o ID do
	// usuário
	public ResultSet getActionsUser(int user) {
		Statement st;
		ResultSet rs = null;

		try {
			st = conect.createStatement();

			// Canpos capturados: id do usuário da ação, descrição da atividade, hora da
			// ação, data da ação e nome do usuário da ação
			String sql = "SELECT " + LogEnum.USUARIO.getNome() + ", " + LogEnum.DESCRICAO.getNome() + ", "
					+ LogEnum.HORA.getNome() + ", " + LogEnum.DATA.getNome() + ", " + UsuarioEnum.TABELA.getNome() + "."
					+ UsuarioEnum.LOGIN.getNome() + " FROM " + LogEnum.TABELA.getNome() + " JOIN "
					+ UsuarioEnum.TABELA.getNome() + " ON " + LogEnum.USUARIO.getNome() + " = "
					+ UsuarioEnum.ID.getNome() + " WHERE " + LogEnum.USUARIO.getNome() + " = " + user;

			rs = st.executeQuery(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;

	}

	// Deletando objeto da tabela usuario
	public void delete(int user) {
		Statement st;

		try {

			st = conect.createStatement();

			String sql = "DELETE FROM " + LogEnum.TABELA.getNome() + " WHERE " + LogEnum.USUARIO.getNome() + " = "
					+ user;

			st.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

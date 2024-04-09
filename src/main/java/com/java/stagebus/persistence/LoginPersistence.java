package com.java.stagebus.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.stagebus.enums.UsuarioEnum;
import com.java.stagebus.main.StagebusApplication;

public class LoginPersistence {

	private static Connection conect;
	
	public LoginPersistence() {
		conect = StagebusApplication.getConexao();
	}

	// Capturando a senha do usuário usando como referncia o login
	public String getPassword(String user) {

		Statement st;
		ResultSet rs;
		String hashedPassword = "";

		try {
			st = conect.createStatement();

			String sql = "SELECT " + UsuarioEnum.SENHA.getNome() + " FROM public." + UsuarioEnum.TABELA.getNome()
					+ " WHERE " + UsuarioEnum.LOGIN.getNome() + " = '" + user + "'";

			rs = st.executeQuery(sql);

			rs.next();

			// Descriptografando a senha
			hashedPassword = rs.getString(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return hashedPassword;

	}

	// Capturando o ID do usuário usando como referencia o login
	public int getIDUser(String user) {

		Statement st;
		ResultSet rs;
		int id = 0;

		try {
			st = conect.createStatement();

			String sql = "SELECT " + UsuarioEnum.ID.getNome() + " FROM public." + UsuarioEnum.TABELA.getNome()
					+ " WHERE " + UsuarioEnum.LOGIN.getNome() + " = '" + user + "'";

			rs = st.executeQuery(sql);

			rs.next();

			id = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;

	}
}

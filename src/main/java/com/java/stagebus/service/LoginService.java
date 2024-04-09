package com.java.stagebus.service;

import org.mindrot.jbcrypt.BCrypt;

import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.dao.LoginDAO;
import com.java.stagebus.persistence.LoginPersistence;
import com.java.stagebus.persistence.UsuarioPersistence;

public class LoginService implements LoginDAO {

	private UsuarioPersistence userPersistence = new UsuarioPersistence();
	private LoginPersistence loginPersistence = new LoginPersistence();
	private LogDAO logDAO = new LogService();
	private String message = "";

	@Override
	public boolean checkLogin(String plainPassword, String user) {
		if (userPersistence.checkLoginExisting(user)) {

			if (userPersistence.checkActiveUser(user)) {

				if (verifyPassword(plainPassword, loginPersistence.getPassword(user))) {

					logDAO.insertLog(loginPersistence.getIDUser(user), "fez login no sistema.");

					return true;
				}
			}
		}

		return false;

	}

	public String getMessage() {

		return message;
	}

	private static boolean verifyPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}

}

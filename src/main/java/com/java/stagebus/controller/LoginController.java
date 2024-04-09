package com.java.stagebus.controller;

import com.java.stagebus.dao.LoginDAO;
import com.java.stagebus.service.LoginService;

public class LoginController {

	private LoginDAO loginDAO = new LoginService();

	// Verificando o login de um usuário
	public boolean checkLogin(String plainPassword, String user) {

		return loginDAO.checkLogin(plainPassword, user);

	}

}

package com.java.stagebus.controller;

import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.service.LogService;

public class LogController {

	private LogDAO logDAO = new LogService();

	// Deletando usuário da tabela de log
	public void delete(int user) {
		logDAO.delete(user);
	}

}

package com.java.stagebus.controller;

import java.util.List;
import java.util.Map;

import com.java.stagebus.dao.UsuarioDAO;
import com.java.stagebus.model.UsuarioModel;
import com.java.stagebus.service.UsuarioService;

public class UsuarioController {

	private UsuarioDAO userDAO = new UsuarioService();

	// Gerando ID de novo objeto
	public int generateID() {

		return userDAO.generateID();

	}

	// Capturando objeto pelo ID
	public UsuarioModel searchByID(int id) {

		return userDAO.searchByID(id);

	}

	// Capturando objeto pelo login
	public UsuarioModel searchByUserName(String userName) {

		return userDAO.searchByUserName(userName);

	}

	// Lista de usuários
	public Map<Integer, UsuarioModel> listOfUsers() {

		return userDAO.listOfUser();

	}

	// Inserindo objeto no banco de dados
	public boolean insertUser(int userID, int id, String login, String password, String conf_password, String name,
			String last_name, List<String> permissions) {

		return userDAO.insertUser(userID, id, login, password, conf_password, name, last_name, permissions);
	}

	// Pesquisando objeto no banco de dados através do termo digitado
	public Map<Integer, UsuarioModel> search(String term) {

		return userDAO.search(term);
	}

	// Atualização de objeto através da view de edição
	public boolean update(int user, UsuarioModel oldObject, String login, String password, String conf_password,
			String name, String last_name, List<String> permission) {

		return userDAO.update(user, oldObject, login, password, conf_password, name, last_name, permission);
	}

	// Deletando objeto
	public void delete(int user, int id) {

		userDAO.delete(user, id);
	}

	// Lista de usuários para table da view
	public Object[][] generateUserList(Map<Integer, UsuarioModel> list) {

		return userDAO.generateUserList(list);
	}

	// Capturando mensagem de erro
	public String getMessage() {

		return userDAO.getMessage();
	}
}

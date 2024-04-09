package com.java.stagebus.dao;

import java.util.List;
import java.util.Map;

import com.java.stagebus.model.UsuarioModel;

public interface UsuarioDAO {

	boolean insertUser(int userID, int id, String login, String password, String conf_password, String name, String last_name,
			List<String> permissions);

	UsuarioModel searchByID(int id);
	
	UsuarioModel searchByUserName(String userName);

	int generateID();

	Map<Integer, UsuarioModel> listOfUser();

	void delete(int user, int id);

	public Map<Integer, UsuarioModel> search(String term);

	boolean update(int user, UsuarioModel oldObject, String login, String password, String conf_password, String name,
			String last_name, List<String> permissions);
	
	Object[][] generateUserList(Map<Integer, UsuarioModel> list);
	
	String getMessage();

}

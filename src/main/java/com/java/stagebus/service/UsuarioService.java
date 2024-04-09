package com.java.stagebus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;

import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.dao.UsuarioDAO;
import com.java.stagebus.enums.UsuarioEnum;
import com.java.stagebus.model.UsuarioModel;
import com.java.stagebus.persistence.UsuarioPersistence;

public class UsuarioService implements UsuarioDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private String message = DEFAULT_MENSAGEM;
	private UsuarioPersistence userPersistence = new UsuarioPersistence();
	private LogDAO logDAO = new LogService();

	@Override
	public boolean insertUser(int userID, int id, String login, String password, String conf_password, String name,
			String last_name, List<String> permissions) {
		if (validation(login, password, conf_password, name, last_name, 1)) {
			UsuarioModel user = new UsuarioModel();
			user.setNome(name);
			user.setLogin(login);
			user.setSenha(hashPassword(password));
			user.setSobrenome(last_name);
			user.setId(id);

			userPersistence.insertUser(user, permissions);

			logDAO.insertLog(userID,
					"inseriu usuário (" + user.getId() + ") " + user.getLogin() + " no banco de dados.");

			return true;
		} else

			return false;

	}

	public boolean insertUserRandom(int id, String login, String password, String conf_password, String name,
			String last_name, List<String> permissions) {
		if (validation(login, password, conf_password, name, last_name, 1)) {
			UsuarioModel user = new UsuarioModel();
			user.setNome(name);
			user.setLogin(login);
			user.setSenha(hashPassword(password));
			user.setSobrenome(last_name);
			user.setId(id);

			userPersistence.insertUser(user, permissions);

			return true;
		} else

			return false;

	}

	public int generateID() {

		return userPersistence.generateID() + 1;
	}

	public UsuarioModel searchByID(int id) {

		UsuarioModel user = new UsuarioModel();

		ResultSet rs = userPersistence.searchByID(id);

		try {
			if (rs.next()) {
				user = mountObject(rs);
			} else
				user = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;

	}

	public UsuarioModel searchByUserName(String userName) {

		UsuarioModel user = new UsuarioModel();

		ResultSet rs = userPersistence.searchByUserName(userName);

		try {
			if (rs.next()) {
				user = mountObject(rs);
			} else
				user = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;

	}

	@Override
	public Map<Integer, UsuarioModel> listOfUser() {
		ResultSet rs = userPersistence.listOfUsers();
		Map<Integer, UsuarioModel> list = new HashMap<Integer, UsuarioModel>();

		try {
			while (rs.next()) {
				UsuarioModel user = mountObject(rs);

				list.put(user.getId(), user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void delete(int user, int id) {
		logDAO.delete(id);
		userPersistence.delete(id);
		logDAO.insertLog(user, "deletou usuário " + id + " no banco de dados.");

	}

	private UsuarioModel mountObject(ResultSet rs) {

		UsuarioModel user = new UsuarioModel();
		try {
			user.setId(rs.getInt(1));
			user.setLogin(rs.getString(2));
			user.setSenha(rs.getString(3));
			user.setNome(rs.getString(4));
			user.setSobrenome(rs.getString(5));
			user.setCad_user(rs.getBoolean(6));
			user.setCad_car(rs.getBoolean(7));
			user.setCad_gar(rs.getBoolean(8));
			user.setCad_lin(rs.getBoolean(9));
			user.setCad_tip_car(rs.getBoolean(10));
			user.setCad_fun(rs.getBoolean(11));
			user.setEd_user(rs.getBoolean(12));
			user.setEd_car(rs.getBoolean(13));
			user.setEd_gar(rs.getBoolean(14));
			user.setEd_lin(rs.getBoolean(15));
			user.setEd_tip_car(rs.getBoolean(16));
			user.setEd_fun(rs.getBoolean(17));
			user.setEm_rel(rs.getBoolean(18));
			user.setCad_ed_hor(rs.getBoolean(19));
			user.setPerm_user(rs.getBoolean(20));
			user.setExc_user(rs.getBoolean(21));
			user.setAt_des_user(rs.getBoolean(22));
			user.setStatus(rs.getBoolean(23));
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;

	}

	@Override
	public Map<Integer, UsuarioModel> search(String term) {
		Map<Integer, UsuarioModel> list = new HashMap<Integer, UsuarioModel>();

		ResultSet searchName = userPersistence.search(1, term);

		try {
			while (searchName.next()) {
				UsuarioModel user = mountObject(searchName);

				list.put(user.getId(), user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet searchLastname = userPersistence.search(2, term);

		try {
			while (searchLastname.next()) {
				UsuarioModel user = mountObject(searchLastname);

				if (!list.containsKey(user.getId()))
					list.put(user.getId(), user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet searchLogin = userPersistence.search(3, term);

		try {
			while (searchLogin.next()) {
				UsuarioModel user = mountObject(searchLogin);

				if (!list.containsKey(user.getId()))
					list.put(user.getId(), user);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	@Override
	public boolean update(int user, UsuarioModel oldObject, String login, String password, String conf_password,
			String name, String last_name, List<String> permissions) {
		if (validation(login, password, conf_password, name, last_name, 2)) {

			if (!login.equals(oldObject.getLogin())) {
				userPersistence.update(UsuarioEnum.LOGIN.getNome(), oldObject.getId(), login, 2);
				logDAO.insertLog(user, "alterou o login do usuário " + oldObject.getId() + " de " + oldObject.getLogin()
						+ " para " + login + ".");
			}
			if (!password.replaceAll(" ", "").equals("")) {
				password = hashPassword(password);
				if (!password.equals(oldObject.getSenha())) {
					userPersistence.update(UsuarioEnum.SENHA.getNome(), oldObject.getId(), password, 2);
					logDAO.insertLog(user, "alterou a senha do usuário " + oldObject.getId() + ".");
				}
			}
			if (!name.equals(oldObject.getNome())) {
				userPersistence.update(UsuarioEnum.NOME.getNome(), oldObject.getId(), name, 2);
				logDAO.insertLog(user, "alterou o nome do usuário " + oldObject.getId() + " de " + oldObject.getNome()
						+ " para " + name + ".");
			}
			if (!last_name.equals(oldObject.getSobrenome())) {
				userPersistence.update(UsuarioEnum.SOBRENOME.getNome(), oldObject.getId(), last_name, 2);
				logDAO.insertLog(user, "alterou o sobrenome do usuário " + oldObject.getId() + " de "
						+ oldObject.getSobrenome() + " para " + last_name + ".");
			}
			userPersistence.updatePermissions(oldObject.getId(), permissions);
			
			return true;

		}

		return false;
	}

	private boolean validation(String login, String password, String conf_password, String name, String last_name,
			int value) {

		this.message = "";

		if (value == 1) {
			if (name.replace(" ", "").equals("") || login.replace(" ", "").equals("")
					|| password.replace(" ", "").equals("") || last_name.replace(" ", "").equals(""))
				this.message += "Todos os campos obrigatórios devem ser preenchidos. ";
			if (userPersistence.checkLoginExisting(login))
				this.message += "Nome de usuário já cadastrado no sistema.";
		} else if (name.replace(" ", "").equals("") || login.replace(" ", "").equals("")
				|| last_name.replace(" ", "").equals(""))
			this.message += "Todos os campos obrigatórios devem ser preenchidos. ";
		if (!(password.equals(conf_password)))
			this.message += "As senhas digitadas não conferem. ";

		if (message.equals(""))
			return true;
		return false;
	}

	@Override
	public Object[][] generateUserList(Map<Integer, UsuarioModel> list) {

		Object[][] ob = new Object[list.size()][3];

		List<Map.Entry<Integer, UsuarioModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = entryList.get(i).getValue().getId();
			ob[i][1] = entryList.get(i).getValue().getNome() + " " + entryList.get(i).getValue().getSobrenome();
			ob[i][2] = entryList.get(i).getValue().getLogin();

		}

		return ob;

	}

	private static String hashPassword(String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
	}

	public String getMessage() {
		return this.message;
	}

}

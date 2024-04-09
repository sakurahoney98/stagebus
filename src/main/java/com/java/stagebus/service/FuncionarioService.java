package com.java.stagebus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.stagebus.dao.FuncionarioDAO;
import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.enums.FuncionarioEnum;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.persistence.FuncionarioPersistence;

public class FuncionarioService implements FuncionarioDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private String message = DEFAULT_MENSAGEM;
	private FuncionarioPersistence employeePersistence = new FuncionarioPersistence();
	private LogDAO logDAO = new LogService();

	// Inserindo funcionario no banco de dados
	@Override
	public boolean insertEmployee(int user, String id, String name, String nickname, String registration, String type) {

		// Validando informações recebidas
		if (validation(name, nickname)) {
			FuncionarioModel employee = new FuncionarioModel();

			// As informações de ID do item Tipo vem em forma de String com o ID + nome do
			// item
			// Nesse caso é preciso capturar da string somente o valor do ID do objeto e
			// converter para inteiro
			type = type.substring(0, (type.indexOf("-") - 1));

			employee.setApelido(nickname);
			employee.setId(Integer.parseInt(id));
			employee.setIdTipo(Integer.parseInt(type));
			employee.setMatricula(registration);
			employee.setNome(name);

			employeePersistence.insertEmployee(employee);

			logDAO.insertLog(user,
					"inseriu funcionário (" + employee.getId() + ") " + employee.getNome() + " no banco de dados.");

			return true;
		}

		return false;
	}

	public boolean insertEmployeeRandom(int id, String name, String nickname, String registration, int type) {

		if (validation(name, nickname)) {
			FuncionarioModel employee = new FuncionarioModel();

			employee.setApelido(nickname);
			employee.setId(id);
			employee.setIdTipo(type);
			employee.setMatricula(registration);
			employee.setNome(name);

			employeePersistence.insertEmployee(employee);

			return true;
		}

		return false;
	}

	// Lista de todos funcionarios
	@Override
	public Map<Integer, FuncionarioModel> listOfEmployee() {
		Map<Integer, FuncionarioModel> list = new HashMap<Integer, FuncionarioModel>();
		ResultSet rs = employeePersistence.listOfEmployee();

		try {
			while (rs.next()) {
				FuncionarioModel employee = mountObject(rs);

				list.put(employee.getId(), employee);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Pegando um funcionario pelo ID
	@Override
	public FuncionarioModel searchByID(int id) {
		FuncionarioModel employee = new FuncionarioModel();
		ResultSet rs = employeePersistence.searchByID(id);

		try {
			if (rs.next()) {
				employee = mountObject(rs);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return employee;
	}

	// Deletando funcionario do sistema pelo ID
	@Override
	public void delete(int user, int id) {

		employeePersistence.delete(id);
		logDAO.insertLog(user, "deletou funcionário " + id + " do banco de dados.");

	}

	// Lista de todos os tipos de funcionário
	// Informações ID do tipo e nome do tipo
	@Override
	public List<String> listOfTypeEmployee() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = employeePersistence.listOfTypeEmployee();

		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);
				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Gerando um ID para o novo funcionário
	@Override
	public int generateID() {

		return employeePersistence.generateID() + 1;
	}

	// Horarios do funcionário
	// Com informaçãoes de Dia, Hora e Linha
	@Override
	public List<HorarioModel> scheduleOfEmployee(int id) {

		List<HorarioModel> list = new ArrayList<HorarioModel>();
		ResultSet rs = employeePersistence.scheduleOfEmployee(id);

		try {
			while (rs.next()) {
				HorarioModel schedule = new HorarioModel();
				schedule.setDia(rs.getString(1));
				schedule.setHora(rs.getString(2));
				schedule.setLinha(rs.getString(3));

				list.add(schedule);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Montando um objeto do tipo fucnionario com base nas informações do retorno do
	// ResultSet
	private FuncionarioModel mountObject(ResultSet rs) {
		FuncionarioModel employee = new FuncionarioModel();

		try {
			employee.setId(rs.getInt(1));
			employee.setNome(rs.getString(2));
			employee.setApelido(rs.getString(3));
			employee.setIdTipo(rs.getInt(4));
			employee.setMatricula(rs.getString(5));
			employee.setTipo(rs.getString(6));
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return employee;
	}

	// Pesquisando um funcionário no banco de dados
	@Override
	public Map<Integer, FuncionarioModel> search(String term) {
		Map<Integer, FuncionarioModel> list = new HashMap<Integer, FuncionarioModel>();

		// Pesquisando pelo nome
		ResultSet searchName = employeePersistence.search(1, term);

		try {
			while (searchName.next()) {
				FuncionarioModel employee = mountObject(searchName);

				list.put(employee.getId(), employee);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Pesquisando pelo apelido
		ResultSet searchNickname = employeePersistence.search(2, term);

		try {
			while (searchNickname.next()) {
				FuncionarioModel employee = mountObject(searchNickname);

				list.put(employee.getId(), employee);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Pesquisando pela matricula
		ResultSet searchregistration = employeePersistence.search(3, term);

		try {
			while (searchregistration.next()) {
				FuncionarioModel employee = mountObject(searchregistration);

				list.put(employee.getId(), employee);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Pesquisando pelo nome do tipo
		ResultSet searchType = employeePersistence.search(4, term);

		try {
			while (searchType.next()) {
				FuncionarioModel employee = mountObject(searchType);

				list.put(employee.getId(), employee);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Atualizando informações do funcionário
	@Override
	public boolean update(int user, FuncionarioModel oldObject, String name, String nickname, String registration,
			String type) {

		// Validando informações recebidas
		if (validation(name, nickname)) {
			// As informações de ID do item Tipo vem em forma de String com o ID + nome do
			// item
			// Nesse caso é preciso capturar da string somente o valor do ID do objeto
			type = type.substring(0, (type.indexOf("-") - 1));

			// Verificando se houve alteração no nome do funcionário
			if (!name.equals(oldObject.getNome())) {
				employeePersistence.update(FuncionarioEnum.NOME.getNome(), oldObject.getId(), name, 2);
				logDAO.insertLog(user, "alterou o nome do funcionario " + oldObject.getId() + " de "
						+ oldObject.getNome() + " para " + name + ".");
			}

			// Verificando se houve alteração no apelido do funcionário
			if (!nickname.equals(oldObject.getApelido())) {
				employeePersistence.update(FuncionarioEnum.APELIDO.getNome(), oldObject.getId(), nickname, 2);
				logDAO.insertLog(user, "alterou o apelido do funcionário " + oldObject.getId() + " de "
						+ oldObject.getApelido() + " para " + nickname + ".");
			}

			// Verificando se houve alteração na matricula do funcionário
			if (!registration.equals(oldObject.getMatricula())) {
				employeePersistence.update(FuncionarioEnum.MATRICULA.getNome(), oldObject.getId(), registration, 2);
				logDAO.insertLog(user, "alterou a matrícula do funcionario " + oldObject.getId() + " de "
						+ oldObject.getMatricula() + " para " + registration + ".");
			}

			// Verificando se houve alteração no tipo do funcionário
			if (Integer.parseInt(type) != oldObject.getIdTipo()) {
				employeePersistence.update(FuncionarioEnum.TIPO.getNome(), oldObject.getId(), String.valueOf(type), 1);
				logDAO.insertLog(user, "alterou o tipo do funcionario " + oldObject.getId() + " de "
						+ oldObject.getIdTipo() + " para " + type + ".");
			}
			return true;
		}

		return false;
	}

	// Validações das informações recebidas
	private boolean validation(String name, String nickname) {
		this.message = "";

		// Verifica se os campos obrigatórios estão em branco
		if (name.replace(" ", "").equals("") || nickname.replace(" ", "").equals("")) {
			this.message += "Campos obrigatórios não podem ficar em branco. ";
			return false;
		}
		return true;
	}

	// Lista de funcionarios para a tabela da view
	@Override
	public Object[][] generateEmployeeList(Map<Integer, FuncionarioModel> list) {

		Object[][] ob = new Object[list.size()][4];

		List<Map.Entry<Integer, FuncionarioModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		// Informações que serão exibidas: ID, Nome, Tipo de funcionário, Matricula
		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = entryList.get(i).getValue().getId();
			ob[i][1] = entryList.get(i).getValue().getNome();
			ob[i][2] = entryList.get(i).getValue().getTipo();
			ob[i][3] = entryList.get(i).getValue().getMatricula();

		}

		return ob;

	}

	// Mensagem de erro
	@Override
	public String getMessage() {

		return this.message;
	}

	// Lista de tipo de funcionário para ComboBox
	@Override
	public String[] generateListOfTypeEmployee(List<String> listOfTypeEmployee) {

		String[] list = new String[listOfTypeEmployee.size()];

		for (int i = 0; i < listOfTypeEmployee.size(); i++)
			list[i] = listOfTypeEmployee.get(i);

		return list;
	}

	// Quantidade de horarios que estão vinculados ao funcionário
	@Override
	public int bondEmployeeSchedule(int employee) {

		return employeePersistence.bondEmployeeSchedule(employee);
	}

}

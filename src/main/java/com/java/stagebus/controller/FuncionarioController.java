package com.java.stagebus.controller;

import java.util.List;
import java.util.Map;

import com.java.stagebus.dao.FuncionarioDAO;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.service.FuncionarioService;

public class FuncionarioController {

	private FuncionarioDAO employeeDAO = new FuncionarioService();

	// Inserindo funcionário no banco de dados
	public boolean insertEmployee(int user, String id, String name, String nickname, String registration, String type) {

		return employeeDAO.insertEmployee(user, id, name, nickname, registration, type);
	}

	// Capturando lista de funcionário
	public Map<Integer, FuncionarioModel> listOfEmployee() {

		return employeeDAO.listOfEmployee();
	}

	// Capturando um funcionario pelo ID
	public FuncionarioModel searchByID(int id) {

		return employeeDAO.searchByID(id);
	}

	// Deletando funcionário
	public void delete(int user, int id) {

		employeeDAO.delete(user, id);
	}

	// Lista de tipos de funcionário
	public List<String> listOfTypeEmployee() {

		return employeeDAO.listOfTypeEmployee();
	}

	// Gerando ID para novo fucnionário
	public int generateID() {

		return employeeDAO.generateID();
	}

	// Capturando horarios vinculados ao funcionário
	public List<HorarioModel> scheduleOfEmployee(int id) {

		return employeeDAO.scheduleOfEmployee(id);
	}

	// Pesquisando um funcionário no banco de dados atráves do termo digitado
	public Map<Integer, FuncionarioModel> search(String term) {

		return employeeDAO.search(term);
	}

	// Gerando lista de funcionário para tabel da view
	public Object[][] generateEmployeeList(Map<Integer, FuncionarioModel> list) {

		return employeeDAO.generateEmployeeList(list);
	}

	// Gerando lista de tipo de fucionário para ComboBox da view
	public String[] generateListOfTypeEmployee(List<String> listOfTypeEmployee) {

		return employeeDAO.generateListOfTypeEmployee(listOfTypeEmployee);
	}

	// Capturando mensagem de erro
	public String getMessage() {

		return employeeDAO.getMessage();
	}

	// Atualizando dados da view de edição
	public boolean update(int user, FuncionarioModel oldObject, String name, String nickname, String registration,
			String type) {

		return employeeDAO.update(user, oldObject, name, nickname, registration, type);
	}

	// Quantidade de vinculos do funcionário com horários
	public int bondEmployeeSchedule(int employee) {

		return employeeDAO.bondEmployeeSchedule(employee);
	}

}

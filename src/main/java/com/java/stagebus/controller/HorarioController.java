package com.java.stagebus.controller;

import java.util.List;

import com.java.stagebus.dao.CarroDAO;
import com.java.stagebus.dao.HorarioDAO;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.service.CarroService;
import com.java.stagebus.service.HorarioService;

public class HorarioController {

	private HorarioDAO scheduleDAO = new HorarioService();
	private CarroDAO carDAO = new CarroService();

	// Adiconando objeto no banco
	public boolean insertSchedule(int user, String day, String hour, String line, String car, String driver,
			String ticket_reviser) {

		return scheduleDAO.insertSchedule(user, day, hour, line, car, driver, ticket_reviser);
	}

	// Deletando objeto
	public void delete(int user, int id) {

		scheduleDAO.delete(user, id);

	}

	// Capturando lista de dia
	public List<String> listOfDay() {

		return scheduleDAO.listOfDay();
	}

	// Capturando lista de carro
	public List<String> listOfCar() {

		return scheduleDAO.listOfCar();
	}

	// Capturando lista de linha
	public List<String> listOfLine() {

		return scheduleDAO.listOfLine();
	}

	// Capturando lista de motorista
	public List<String> listOfDriver() {

		return scheduleDAO.listOfDriver();
	}

//Capturando lista de funcionário
	public List<String> listOfEmployee() {

		return scheduleDAO.listOfEmployee();
	}

	// Capturando lista de cobrador
	public List<String> listOfConductor() {

		return scheduleDAO.listOfConductor();
	}

	// Capturando lista de garagem
	public List<String> listOfGarage() {

		return scheduleDAO.listOfGarage();
	}

	// Capturando lista de horários vinculados a uma linha pelo id da linha
	public List<HorarioModel> scheduleLineByDay(int id) {

		return scheduleDAO.scheduleLineByDay(id);
	}

	// Gerando lista de horarios de uma linha para table da view
	public Object[][] generateScheduleLineList(List<HorarioModel> list) {

		return scheduleDAO.generateScheduleLineList(list);
	}

	// Capturando a lista de horários vinculados a um carro pelo id do carro
	public List<HorarioModel> scheduleCarByDay(int id) {

		return scheduleDAO.scheduleCarByDay(id);
	}

	// Gerando lista de horarios do carro pasra table da view
	public Object[][] generateScheduleCarList(List<HorarioModel> list) {

		return scheduleDAO.generateScheduleCarList(list);

	}

	// Pesquisando no banco de dados
	public List<HorarioModel> search(int type, String id) {

		return scheduleDAO.search(type, id);
	}

	public Object[][] generateFilterScheduleList(List<HorarioModel> list) {

		return scheduleDAO.generateFilterScheduleList(list);

	}

	public String[] getFilterList(int filter) {

		return scheduleDAO.getFilterList(filter);
	}

	// Capturando mensagem de erro
	public String getMessage() {

		return scheduleDAO.getMessage();
	}

	// Gerando lista para ComboBox da view
	public String[] generateObjectList(List<String> list) {

		return carDAO.generateObjectList(list);
	}

	// Atualização de dados para outras views
	public void update(String column, int id, String value, int columnType) {

		scheduleDAO.update(column, id, value, columnType);
	}

	// Deletando objeto pelo id do carro ou linha
	public void deleteByIdObject(String column, int id) {

		scheduleDAO.deleteByIdObject(column, id);
	}

	// Atualização de objeto pela view de edição
	public boolean update(int user, HorarioModel oldObject, String day, String hour, String line, String car,
			String driver, String ticket_reviser) {

		return scheduleDAO.update(user, oldObject, day, hour, line, car, driver, ticket_reviser);
	}

	// Vinculos de algum objeto com horário
	public int bondObjectSchedule(String object, int objectID) {

		return scheduleDAO.bondObjectSchedule(object, objectID);
	}

}

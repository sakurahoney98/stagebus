package com.java.stagebus.controller;

import java.util.List;
import java.util.Map;

import com.java.stagebus.dao.CarroDAO;
import com.java.stagebus.dao.HorarioDAO;
import com.java.stagebus.model.CarroModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.service.CarroService;
import com.java.stagebus.service.HorarioService;

public class CarroController {

	private CarroDAO carDAO = new CarroService();
	private HorarioDAO scheduleDAO = new HorarioService();

	// Fazendo solicitação de inclusão de carro
	public boolean insertCar(int user, String num, String name, String license_plate, String type, String status,
			String garage) {

		return carDAO.insertCar(user, num, name, license_plate, type, status, garage);
	}

	// Pegando objeto pelo ID
	public CarroModel searchByID(int id) {

		return carDAO.searchByID(id);
	}

	// Capturando lista de carro
	public Map<Integer, CarroModel> listOfCar() {

		return carDAO.listOfCar();
	}

	// Apagando carro
	public void delete(int user, int id) {

		carDAO.delete(user, id);
	}

	// Capturando lista de status
	public List<String> listOfStatus() {

		return carDAO.listOfStatus();
	}

	// Capturando lista de garagem
	public List<String> listOfGarage() {

		return scheduleDAO.listOfGarage();
	}

	// Capturando lista de tipo
	public List<String> listOfType() {

		return carDAO.listOfType();
	}

	// Capturando lista de horários do carro
	public List<HorarioModel> scheduleOfCar(int id) {

		return carDAO.scheduleOfCar(id);
	}

	// Pesquisando objetos no banco de dados de acordo com o termo digitado
	public Map<Integer, CarroModel> search(String term) {

		return carDAO.search(term);
	}

	// Atualizando dados do carro atráves da view de edição
	public boolean update(int user, CarroModel oldObject, String num, String name, String license_plate, String type,
			String status, String garage) {

		return carDAO.update(user, oldObject, num, name, license_plate, type, status, garage);
	}

	// Gerando uma lista para a tabel do view
	public Object[][] generateCarList(Map<Integer, CarroModel> list) {

		return carDAO.generateCarList(list);
	}

	// Capturando as linhas de ônibus vinculadas ao carro
	public List<String> lineByDay(int id) {

		return carDAO.lineByDay(id);
	}

	// Gerando lista para o ComboBox
	public String[] generateObjectList(List<String> list) {

		return carDAO.generateObjectList(list);
	}

	// Atualização de dados para outras views
	public void update(String column, int id, String value, int columnType) {

		carDAO.update(column, id, value, columnType);
	}

	// Gerando lista de carro para ComboBox
	public String[] generateObjectList(Map<Integer, CarroModel> list) {

		return carDAO.generateObjectList(list);
	}

	// Capturando mensagem de erro
	public String getMessage() {

		return carDAO.getMessage();
	}

}

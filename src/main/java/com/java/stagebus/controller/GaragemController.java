package com.java.stagebus.controller;

import java.util.Map;

import com.java.stagebus.dao.GaragemDAO;
import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.service.GaragemService;

public class GaragemController {

	private GaragemDAO garageDAO = new GaragemService();

	// Inserindo garagem
	public boolean insertGarage(int user, int id, String name, String length, String width, String heigth,
			String sponsor, String location, String max) {

		return garageDAO.insertGarage(user, id, name, length, width, heigth, sponsor, location, max);
	}

	// Lista de garagem
	public Map<Integer, GaragemModel> listOfGarage() {

		return garageDAO.listOfGarage();
	}

	// Deletando garagem
	public void delete(int userID, int id) {

		garageDAO.delete(userID, id);
	}

	// Capturando garagem pelo id
	public GaragemModel searchByID(int id) {

		return garageDAO.searchByID(id);
	}

	// Pesquisando uma garagem no banco de dados através do termo digitado
	public Map<Integer, GaragemModel> search(String term) {

		return garageDAO.search(term);
	}

	// Atualização dos dados da garagem através da view de edição
	public boolean update(int user, GaragemModel oldObject, String name, String length, String width, String heigth,
			String sponsor, String location, String max) {

		return garageDAO.update(user, oldObject, name, length, width, heigth, sponsor, location, max);
	}

	// Lista de garagem para tabel da view
	public Object[][] generateGarageList(Map<Integer, GaragemModel> list) {

		return garageDAO.generategGarageList(list);
	}

	// Quantidade de ônibius na garagem
	public int amountBusOnGarage(int garage) {

		return garageDAO.amountBusOnGarage(garage);

	}

	// Gerando id para nova garagem
	public int generateID() {

		return garageDAO.generateID();
	}


	// Atualzação de dados através de outras views
	public void update(String column, int id, String value, int columnType) {

		garageDAO.update(column, id, value, columnType);
	}

	// capturando mensagem de erro
	public String getMessage() {

		return garageDAO.getMessage();
	}

}

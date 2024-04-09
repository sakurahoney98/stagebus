package com.java.stagebus.controller;

import java.util.List;
import java.util.Map;

import com.java.stagebus.dao.LinhaDAO;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.model.LinhaModel;
import com.java.stagebus.service.LinhaService;

public class LinhaController {

	private LinhaDAO lineDAO = new LinhaService();

	// Inserindo objeto no banco de dados
	public boolean insertLine(int user, String id, String number_line, String name, String departure_itinerary,
			String return_itinerary) {

		return lineDAO.insertLine(user, id, number_line, name, departure_itinerary, return_itinerary);
	}

	// Gerando ID para novo objeto
	public int generateID() {

		return lineDAO.generateID();
	}

	// Lista de linhas
	public Map<Integer, LinhaModel> listOfLine() {

		return lineDAO.listOfLine();

	}

	// Capturando objeto pelo ID
	public LinhaModel searchById(int id) {

		return lineDAO.searchById(id);

	}

	// Capturando objeto pelo número da linha
	public LinhaModel searchByLineNumber(String line_number) {

		return lineDAO.searchByLineNumber(line_number);
	}

	// Deletando objeto
	public void delete(int user, int id) {

		lineDAO.delete(user, id);

	}

	// Pesquisabndo objetos no banco de dados
	public Map<Integer, LinhaModel> search(String term) {

		return lineDAO.search(term);
	}

	// Horários da linha
	public List<HorarioModel> scheduleOfLine(int id) {

		return lineDAO.scheduleOfLine(id);
	}

	// Atualização de dados do objeto pela view de edição
	public boolean update(int user, LinhaModel oldObject, String number_line, String name, String departure_itinerary,
			String return_itinerary) {

		return lineDAO.update(user, oldObject, number_line, name, departure_itinerary, return_itinerary);
	}

	// Gerando lista de linha para a table da view
	public Object[][] generateLineList(Map<Integer, LinhaModel> list) {

		return lineDAO.generateLineList(list);
	}

	// Capturando carros vinculados a linha por dia
	public List<String> carByDay(int id) {

		return lineDAO.carByDay(id);
	}

	// capturando mensagem de erro
	public String getMessage() {

		return lineDAO.getMessage();
	}

}

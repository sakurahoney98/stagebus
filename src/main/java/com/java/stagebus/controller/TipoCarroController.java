package com.java.stagebus.controller;

import java.util.Map;

import com.java.stagebus.dao.TipoCarroDAO;
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.service.TipoCarroService;

public class TipoCarroController {

	private TipoCarroDAO car_typeDAO = new TipoCarroService();

	// Gerando ID do novo objeto
	public int genarateID() {

		return car_typeDAO.genarateID();
	}

	// Inserindo objeto no banco
	public boolean insertCarType(int user, String id, String nome, String length, String width, String heigth,
			String weigth) {

		return car_typeDAO.insertCarType(user, id, nome, length, width, heigth, weigth);
	}

	// Capturando lista de tipo de carro
	public Map<Integer, TipoCarroModel> listOfCarType() {

		return car_typeDAO.listOfCarType();
	}

	// Capturando objeto pelo ID
	public TipoCarroModel searchByID(int id) {

		return car_typeDAO.searchByID(id);
	}

	// Deletando objeto
	public void delete(int user, int id) {

		car_typeDAO.delete(user, id);
	}

	// Pesquisando objeto pelo termo digitado
	public Map<Integer, TipoCarroModel> search(String term) {

		return car_typeDAO.search(term);
	}

	// Atualização de objeto pela view de edição
	public boolean update(int user, TipoCarroModel oldObject, String name, String length, String width, String heigth,
			String weigth) {

		return car_typeDAO.update(user, oldObject, name, length, width, heigth, weigth);
	}

	// Lista de tipo de carro para table da view
	public Object[][] generateCarTypeList(Map<Integer, TipoCarroModel> list) {

		return car_typeDAO.generateCarTypeList(list);
	}

	// Quantidade de ônibus com o tipo de carro especificado pelo ID
	public int amountBusCarType(int id) {

		return car_typeDAO.amountBusCarType(id);

	}



	// Atualização de objeto por outras views
	public void update(String column, int id, String value, int columnType) {

		car_typeDAO.update(column, id, value, columnType);
	}

	// Capturando mensagem de erro
	public String getMessage() {

		return car_typeDAO.getMessage();
	}

}

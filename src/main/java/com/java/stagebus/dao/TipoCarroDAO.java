package com.java.stagebus.dao;

import java.util.Map;

import com.java.stagebus.model.TipoCarroModel;

public interface TipoCarroDAO {

	int amountCarType();

	boolean insertCarType(int user, String id, String name, String length, String width, String heigth, String weigth);

	int genarateID();

	void delete(int user, int id);

	TipoCarroModel searchByID(int id);

	Map<Integer, TipoCarroModel> listOfCarType();

	Map<Integer, TipoCarroModel> search(String term);

	boolean update(int user, TipoCarroModel oldObject, String name, String length, String width, String heigth, String weigth);

	Object[][] generateCarTypeList(Map<Integer, TipoCarroModel> list);

	int amountBusCarType(int id);
	
	
	void update (String column, int id,String value, int columnType);

	String getMessage();
	

}

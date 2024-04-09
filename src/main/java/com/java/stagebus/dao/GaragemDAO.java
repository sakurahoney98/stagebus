package com.java.stagebus.dao;

import java.util.Map;

import com.java.stagebus.model.GaragemModel;

public interface GaragemDAO {

	int garageAmount();
	
	boolean insertGarage(int user, int id, String name, String lenght, String width, String height, String sponsor,
			String location, String max);

	Map<Integer, GaragemModel> listOfGarage();
	
	int generateID();

	GaragemModel searchByID(int id);

	void delete(int userID, int id);

	
	Map<Integer, GaragemModel> search(String term);


	boolean update(int user, GaragemModel oldObject, String name, String length, String width, String heigth, String sponsor,
			String location, String max);
	
	Object[][] generategGarageList(Map<Integer, GaragemModel> list);
	
	int amountBusOnGarage(int garage);
	
	void update(String column, int id, String value, int columnType);
	
	String getMessage();
	
	
}

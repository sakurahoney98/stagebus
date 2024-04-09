package com.java.stagebus.dao;

import java.util.List;
import java.util.Map;

import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.model.LinhaModel;

public interface LinhaDAO {

	boolean insertLine(int user, String id, String number_line, String name, String departure_itinerary,
			String return_itinerary);

	Map<Integer, LinhaModel> listOfLine();

	LinhaModel searchById(int id);
	
	LinhaModel searchByLineNumber(String line_number);

	void delete(int user, int id);

	int generateID();


	Map<Integer, LinhaModel> search(String term);

	List<HorarioModel> scheduleOfLine(int id);
	
	boolean update(int user, LinhaModel oldObject, String number_line, String name, String departure_itinerary,
			String return_itinerary);
	
	Object[][] generateLineList(Map<Integer, LinhaModel> list);

	List<String> carByDay(int id);
	
	String getMessage();

}

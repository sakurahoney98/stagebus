package com.java.stagebus.dao;

import java.util.List;
import java.util.Map;

import com.java.stagebus.model.CarroModel;
import com.java.stagebus.model.HorarioModel;

public interface CarroDAO {

	boolean insertCar(int user, String num, String name, String license_plate, String type, String status,
			String garage);

	CarroModel searchByID(int id);

	Map<Integer, CarroModel> listOfCar();

	void delete(int user, int id);

	List<String> listOfStatus();

	List<String> listOfType();

	String[] generateObjectList(List<String> list);

	List<HorarioModel> scheduleOfCar(int id);

	Map<Integer, CarroModel> search(String term);

	boolean update(int user, CarroModel oldObject, String num, String name, String license_plate, String type,
			String status, String garage);

	Object[][] generateCarList(Map<Integer, CarroModel> list);

	List<String> lineByDay(int id);

	void update(String column, int id, String value, int columnType);

	String[] generateObjectList(Map<Integer, CarroModel> list);

	String getMessage();

}

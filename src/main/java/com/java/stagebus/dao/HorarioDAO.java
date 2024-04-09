package com.java.stagebus.dao;

import java.util.List;

import com.java.stagebus.model.HorarioModel;

public interface HorarioDAO {

	boolean insertSchedule(int user, String day, String hour, String line, String car, String driver,
			String ticket_reviser);

	void delete(int user, int id);

	int generateID();

	List<String> listOfDay();

	List<String> listOfCar();

	List<String> listOfLine();

	List<String> listOfEmployee();

	List<String> listOfDriver();

	List<String> listOfConductor();

	List<String> listOfGarage();

	List<HorarioModel> scheduleLineByDay(int id);

	Object[][] generateScheduleLineList(List<HorarioModel> list);

	List<HorarioModel> scheduleCarByDay(int id);

	Object[][] generateScheduleCarList(List<HorarioModel> list);

	String[] getFilterList(int filter);

	List<HorarioModel> search(int type, String id);

	Object[][] generateFilterScheduleList(List<HorarioModel> list);

	String getMessage();

	void update(String column, int id, String value, int columnType);

	void deleteByIdObject(String column, int id);

	List<HorarioModel> search(int type, int id);

	public int bondObjectSchedule(String object, int objectID);

	boolean update(int user, HorarioModel oldObject, String day, String hour, String line, String car, String driver,
			String ticket_reviser);

}

package com.java.stagebus.dao;

import java.util.List;
import java.util.Map;

import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.HorarioModel;

public interface FuncionarioDAO {

	boolean insertEmployee(int user, String id, String name, String nickname, String registration, String type);

	Map<Integer, FuncionarioModel> listOfEmployee();

	FuncionarioModel searchByID(int id);

	void delete(int user, int id);

	List<String> listOfTypeEmployee();

	int generateID();

	List<HorarioModel> scheduleOfEmployee(int id);

	Map<Integer, FuncionarioModel> search(String term);

	boolean update(int user, FuncionarioModel oldObject, String name, String nickname, String registration,
			String type);

	Object[][] generateEmployeeList(Map<Integer, FuncionarioModel> list);

	String[] generateListOfTypeEmployee(List<String> listOfTypeEmployee);

	int bondEmployeeSchedule(int employee);

	String getMessage();

}

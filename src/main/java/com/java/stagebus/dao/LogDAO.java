package com.java.stagebus.dao;

public interface LogDAO {

	void insertLog(int user, String description);
	
	void delete (int user);
	
}

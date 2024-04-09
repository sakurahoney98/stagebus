package com.java.stagebus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.model.LogModel;
import com.java.stagebus.persistence.LogPersistence;

public class LogService implements LogDAO {

	private LogPersistence logPersistence = new LogPersistence();

	@Override
	public void insertLog(int user, String description) {
		LogModel log = new LogModel(user, description, getDateNow(), getHourNow());

		logPersistence.insertLog(log);

	}
	
	@Override
	public void delete(int user) {
		List<LogModel> actions = actionsList(logPersistence.getActionsUser(user));
		
		logPersistence.delete(user);
		
		for(LogModel log : actions) {
			logPersistence.insertLog(log);
		}
		
		
		
	}
	
	private List<LogModel> actionsList(ResultSet rs){
		
		List<LogModel> list = new ArrayList<LogModel>();
		
		try {
			while(rs.next()) {
				LogModel log = new LogModel(1, "usuário excluído: (" + rs.getInt(1) + ") " + rs.getString(5) + " " + rs.getString(2), rs.getString(4), rs.getString(3));
				list.add(log);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

	// Capturando a data do log
	private String getDateNow() {

		DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return LocalDateTime.now().format(data);
	}

	// Capturando a hora do log
	private String getHourNow() {
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");

		return LocalDateTime.now().format(hora);
	}



	

}

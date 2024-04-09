package com.java.stagebus.dao;

public interface LoginDAO {

	boolean checkLogin(String plainPassword, String user);
}

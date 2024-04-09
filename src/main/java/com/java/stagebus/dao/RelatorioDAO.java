package com.java.stagebus.dao;

import java.util.List;

import com.java.stagebus.model.CarroModel;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.model.LinhaModel;
import com.java.stagebus.model.RelatorioModel;
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.model.UsuarioModel;

public interface RelatorioDAO {

	List<CarroModel> getCarTable(List<String> columns, int param, int id_param);

	List<FuncionarioModel> getEmployeeTable(List<String> columns, int param, int id_param);

	List<GaragemModel> getGarageTable(List<String> columns);

	List<HorarioModel> getScheduleTable(List<String> columns, int param, int id_param);

	List<LinhaModel> getLineTable(List<String> columns);

	List<UsuarioModel> getUserTable(List<String> columns);
	
	List<TipoCarroModel> getCarTypeTable(List<String> columns);

	List<HorarioModel> employeeSchedule(int employee);

	GaragemModel getDataGarage(int id);

	List<RelatorioModel> getBusListOfGarage(int id, int param, int dia);

	List<String> listOfGarage();

	Object[][] generateEmployeeScheduleList(List<HorarioModel> list);

	Object[][] generateScheduleList(List<RelatorioModel> list);
}

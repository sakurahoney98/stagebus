package com.java.stagebus.controller;

import java.util.List;

import com.java.stagebus.dao.RelatorioDAO;
import com.java.stagebus.model.CarroModel;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.model.LinhaModel;
import com.java.stagebus.model.RelatorioModel;
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.model.UsuarioModel;
import com.java.stagebus.service.RelatorioService;

public class RelatorioController {

	RelatorioDAO reportDAO = new RelatorioService();

	// Lista de horarios de um funcionário
	public List<HorarioModel> employeeSchedule(int employee) {

		return reportDAO.employeeSchedule(employee);
	}

	// Capturando dados na tabela carro
	public List<CarroModel> getCarTable(List<String> columns, int param, int id_param) {

		return reportDAO.getCarTable(columns, param, id_param);

	}

	// Capturando dados essenciais de uma garagem
	public GaragemModel getDataGarage(int id) {

		return reportDAO.getDataGarage(id);
	}

	// Capturando a lista de ônibus de uma garagem
	public List<RelatorioModel> getBusListOfGarage(int id, int param, int dia) {

		return reportDAO.getBusListOfGarage(id, param, dia);
	}

	// Lista de garagem
	public List<String> listOfGarage() {

		return reportDAO.listOfGarage();
	}

	// Lista de horarios do funcionário para table da view
	public Object[][] generateEmployeeScheduleList(List<HorarioModel> list) {

		return reportDAO.generateEmployeeScheduleList(list);
	}

	// Gerando lista de horário para table da view
	public Object[][] generateScheduleList(List<RelatorioModel> list) {

		return reportDAO.generateScheduleList(list);
	}

	// Capturando dados da tabela de Funcionário
	public List<FuncionarioModel> getEmployeeTable(List<String> columns, int param, int id_param) {

		return reportDAO.getEmployeeTable(columns, param, id_param);
	}

	// Capturando dados da tabela de garagem
	public List<GaragemModel> getGarageTable(List<String> columns) {

		return reportDAO.getGarageTable(columns);
	}

	// Capturando dados da tabela de horario
	public List<HorarioModel> getScheduleTable(List<String> columns, int param, int id_param) {

		return reportDAO.getScheduleTable(columns, param, id_param);
	}

	// Capturando dados da tabela de linha
	public List<LinhaModel> getLineTable(List<String> columns) {

		return reportDAO.getLineTable(columns);

	}

	// Capturando dados da tabela de usuário
	public List<UsuarioModel> getUserTable(List<String> columns) {

		return reportDAO.getUserTable(columns);
	}

	// Capturando dados da tabela de tipo carro
	public List<TipoCarroModel> getCarTypeTable(List<String> columns) {

		return reportDAO.getCarTypeTable(columns);
	}

}

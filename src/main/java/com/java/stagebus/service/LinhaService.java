package com.java.stagebus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.stagebus.dao.LinhaDAO;
import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.enums.LinhaEnum;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.model.LinhaModel;
import com.java.stagebus.persistence.LinhaPersistence;

public class LinhaService implements LinhaDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private String message = DEFAULT_MENSAGEM;
	private LinhaPersistence linePersistence = new LinhaPersistence();
	private LogDAO logDAO = new LogService();

	//Inserindo linha no banco de dados
	@Override
	public boolean insertLine(int user, String id, String number_line, String name, String departure_itinerary,
			String return_itinerary) {

		//validando informações recebidas
		if (validation(number_line, name)) {
			
			LinhaModel line = new LinhaModel();
			line.setId(Integer.parseInt(id));
			line.setIda(departure_itinerary);
			line.setLinha(number_line);
			line.setNome(name);
			line.setVolta(return_itinerary);

			linePersistence.insertLine(line);

			logDAO.insertLog(user, "inseriu linha (" + line.getId() + ") " + line.getNome() + " no banco de dados.");

			return true;

		}

		return false;
	}

	public boolean insertLineRandom(int id, String number_line, String name, String departure_itinerary,
			String return_itinerary) {

		if (validation(number_line, name)) {
			LinhaModel line = new LinhaModel();
			line.setId(id);
			line.setIda(departure_itinerary);
			line.setLinha(number_line);
			line.setNome(name);
			line.setVolta(return_itinerary);

			linePersistence.insertLine(line);

			return true;

		}

		return false;
	}

	//Lista de linhas
	@Override
	public Map<Integer, LinhaModel> listOfLine() {

		Map<Integer, LinhaModel> list = new HashMap<Integer, LinhaModel>();
		ResultSet rs = linePersistence.listOfLine();

		try {
			while (rs.next()) {
				LinhaModel line = mountObject(rs);

				list.put(line.getId(), line);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	//Capturando linha através do ID
	@Override
	public LinhaModel searchById(int id) {

		LinhaModel line = new LinhaModel();
		ResultSet rs = linePersistence.searchByID(id);

		try {
			if (rs.next()) {
				line = mountObject(rs);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return line;
	}

	//Capturando linha pelo número da linha
	@Override
	public LinhaModel searchByLineNumber(String line_number) {

		LinhaModel line = new LinhaModel();
		ResultSet rs = linePersistence.searchByLineNumber(line_number);

		try {
			if (rs.next()) {
				line = mountObject(rs);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return line;
	}

	//Deletando linha do banco de dados com ID
	@Override
	public void delete(int user, int id) {

		linePersistence.delete(id);
		logDAO.insertLog(user, "deletou linha " + id + " do banco de dados.");

	}

	//Gerando ID para nova linha
	@Override
	public int generateID() {

		return linePersistence.generateID() + 1;
	}

	//Procurando linha de acordo com o termo digitado
	@Override
	public Map<Integer, LinhaModel> search(String term) {
		Map<Integer, LinhaModel> list = new HashMap<Integer, LinhaModel>();
		
		//Busca por nome
		ResultSet searchName = linePersistence.search(1, term);

		try {
			while (searchName.next()) {
				LinhaModel line = mountObject(searchName);

				list.put(line.getId(), line);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		//Busca por númeor da linha
		ResultSet searchNumber = linePersistence.search(2, term);

		try {
			while (searchNumber.next()) {
				LinhaModel line = mountObject(searchNumber);

				if (!list.containsKey(line.getId()))
					list.put(line.getId(), line);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	//Montando objeto linha de acordo com informações do ResultSet
	private LinhaModel mountObject(ResultSet rs) {

		LinhaModel line = new LinhaModel();
		try {
			line.setId(rs.getInt(1));
			line.setLinha(rs.getString(2));
			line.setNome(rs.getString(3));
			line.setIda(rs.getString(4));
			line.setVolta(rs.getString(5));
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return line;

	}

	//mensagem de erro
	public String getMessage() {

		return this.message;
	}

	//Horários da linha
	@Override
	public List<HorarioModel> scheduleOfLine(int id) {
		List<HorarioModel> list = new ArrayList<HorarioModel>();
		ResultSet rs = linePersistence.scheduleOfLine(id);

		try {
			while (rs.next()) {
				HorarioModel schedule = new HorarioModel();
				schedule.setDia(rs.getString(1));
				schedule.setHora(rs.getString(2));

				list.add(schedule);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	//Atualizando informações da linha
	@Override
	public boolean update(int user, LinhaModel oldObject, String number_line, String name, String departure_itinerary,
			String return_itinerary) {
		//Validando informações recebidas
		if (validation(number_line, name)) {

			if (!number_line.equals(oldObject.getLinha())) {
				linePersistence.update(LinhaEnum.NUMERO.getNome(), oldObject.getId(), number_line, 2);
				logDAO.insertLog(user, "alterou o número da linha " + oldObject.getId() + " de " + oldObject.getLinha()
						+ " para " + number_line + ".");
			}
			if (!name.equals(oldObject.getNome())) {
				linePersistence.update(LinhaEnum.NOME.getNome(), oldObject.getId(), name, 2);
				logDAO.insertLog(user, "alterou o nome da linha " + oldObject.getId() + " de " + oldObject.getNome()
						+ " para " + name + ".");
			}

			if (!departure_itinerary.equals(oldObject.getIda())) {
				linePersistence.update(LinhaEnum.IDA.getNome(), oldObject.getId(), departure_itinerary, 2);
				logDAO.insertLog(user, "alterou o roteiro de ida da linha " + oldObject.getId() + " de "
						+ oldObject.getIda() + " para " + departure_itinerary + ".");
			}
			if (!return_itinerary.equals(oldObject.getVolta())) {
				linePersistence.update(LinhaEnum.VOLTA.getNome(), oldObject.getId(), return_itinerary, 2);
				logDAO.insertLog(user, "alterou o roteiro de volta da linha " + oldObject.getId() + " de "
						+ oldObject.getVolta() + " para " + return_itinerary + ".");
			}
			return true;
		}

		return false;
	}

	@Override
	public Object[][] generateLineList(Map<Integer, LinhaModel> list) {

		Object[][] ob = new Object[list.size()][2];

		List<Map.Entry<Integer, LinhaModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = entryList.get(i).getValue().getLinha();
			ob[i][1] = entryList.get(i).getValue().getNome();

		}

		return ob;

	}

	@Override
	public List<String> carByDay(int id) {

		Calendar calendar = Calendar.getInstance();

		int today = calendar.get(Calendar.DAY_OF_WEEK);

		List<String> carList = new ArrayList<String>();

		for (int i = 1; i <= 7; i++) {
			ResultSet rs = linePersistence.carByDay(i, id);

			if (i > today) {
				try {
					if (rs.next())
						carList.add(rs.getInt(1) + "");
					else
						carList.add("Sem informações");
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

			else if (i < today) {
				try {
					if (rs.next()) {
						carList.add(rs.getInt(1) + "");

						while (rs.next())
							carList.add(rs.getInt(1) + "");
					} else
						carList.add("Sem informações");
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

			else {
				try {
					if (rs.next()) {
						List<HorarioModel> allCars = new ArrayList<HorarioModel>();

						HorarioModel h = new HorarioModel();
						h.setIdCarro(rs.getInt(1));
						h.setHora(rs.getString(2));

						allCars.add(h);

						while (rs.next()) {
							h = new HorarioModel();
							h.setIdCarro(rs.getInt(1));
							h.setHora(rs.getString(2));

							allCars.add(h);
						}

						for (int j = 0; j < allCars.size(); j++) {
							if (j + 1 == allCars.size()) {
								carList.add(allCars.get(j).getIdCarro() + "");

							} else {

								// Formato da string
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

								// Convertendo a string para LocalTime
								LocalTime hour = LocalTime.parse(allCars.get(j).getHora(), formatter);

								if (hour.isBefore(LocalTime.now())) {
									carList.add(allCars.get(j).getIdCarro() + "");
									break;

								}
							}

						}
					} else
						carList.add("Sem informações");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

		return carList;
	}

	private boolean validation(String number_line, String name) {

		this.message = "";

		if (number_line.replace(" ", "").equals("") || name.replace(" ", "").equals("")) {
			this.message += "Campos obrigatórios não podem ficar em branco. ";

		}

		try {
			if (linePersistence.searchByLineNumber(number_line).next())
				this.message += "Número da linha já existe.";
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (message.equals(""))
			return true;
		else

			return false;

	}

}

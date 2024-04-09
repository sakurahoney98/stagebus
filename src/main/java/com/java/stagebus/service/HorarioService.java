package com.java.stagebus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.java.stagebus.dao.HorarioDAO;
import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.persistence.HorarioPersistence;

public class HorarioService implements HorarioDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private String message = DEFAULT_MENSAGEM;
	private HorarioPersistence schedulePersistence = new HorarioPersistence();
	private LogDAO logDAO = new LogService();

	// Inserindo horario no banco
	@Override
	public boolean insertSchedule(int user, String day, String hour, String line, String car, String driver,
			String ticket_reviser) {

		// Verificando
		if (schedulePersistence.checkConflictLineHour(Integer.parseInt(line.substring(0, line.indexOf("-") - 1)),
				Integer.parseInt(day.substring(0, day.indexOf("-") - 1)), hour) > 0)
			this.message += "Já foi cadastrado um horário com os mesmos parametros para a linha informada.";
		if (validateHour(hour)) {
			if (message.equals("")) {
				HorarioModel schedule = new HorarioModel();
				schedule.setHora(hour + ":00");
				schedule.setId(generateID());
				schedule.setIdCarro(Integer.parseInt(car.substring(0, car.indexOf("-") - 1)));
				schedule.setIdCobrador(Integer.parseInt(ticket_reviser.substring(0, ticket_reviser.indexOf("-") - 1)));
				schedule.setIdDia(Integer.parseInt(day.substring(0, day.indexOf("-") - 1)));
				schedule.setIdLinha(Integer.parseInt(line.substring(0, line.indexOf("-") - 1)));
				schedule.setIdMotorista(Integer.parseInt(driver.substring(0, driver.indexOf("-") - 1)));

				schedulePersistence.insertSchedule(schedule);

				logDAO.insertLog(user, "inseriu horario para o carro " + schedule.getIdCarro() + " e linha "
						+ schedule.getIdLinha() + " no banco de dados.");

				return true;
			}
		}
		return false;
	}

	public boolean insertScheduleRandom(int day, String hour, int line, int car, int driver, int ticket_reviser) {

		if (schedulePersistence.checkConflictLineHour(line, day, hour) > 0)
			this.message += "Já foi cadastrado um horário com os mesmos parametros para a linha informada.";
		if (message.equals("")) {
			HorarioModel schedule = new HorarioModel();
			schedule.setHora(hour);
			schedule.setId(generateID());
			schedule.setIdCarro(car);
			schedule.setIdCobrador(ticket_reviser);
			schedule.setIdDia(day);
			schedule.setIdLinha(line);
			schedule.setIdMotorista(driver);

			schedulePersistence.insertSchedule(schedule);

			return true;
		}

		return false;
	}

	// Deletando horario do banco de dados usando o ID
	@Override
	public void delete(int user, int id) {

		schedulePersistence.delete(id);
		logDAO.insertLog(user, "deletou horário do banco de dados.");
	}

	// Gerando ID para novo horário
	@Override
	public int generateID() {

		return schedulePersistence.generateID() + 1;
	}

	// Horarios vinculados a uma linha
	@Override
	public List<HorarioModel> scheduleLineByDay(int id) {
		List<HorarioModel> scheduleList = new ArrayList<HorarioModel>();

		// Percorrendo todos os dias da semana
		for (int i = 1; i <= 7; i++) {
			ResultSet rs = schedulePersistence.scheduleLineByDay(id, i);

			try {
				while (rs.next())
					scheduleList.add(mountObject(rs));
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return scheduleList;
	}

	// Atualizando informações de um horário
	@Override
	public boolean update(int user, HorarioModel oldObject, String day, String hour, String line, String car,
			String driver, String ticket_reviser) {

		// Verificando se as informações recebidas podem gerar conflito
		if (schedulePersistence.checkConflictLineHour(Integer.parseInt(line.substring(0, line.indexOf("-") - 1)),
				Integer.parseInt(day.substring(0, day.indexOf("-") - 1)), hour) > 1) {
			this.message += "Já foi cadastrado um horário com os mesmos parametros para a linha informada.";
			return false;
		} else {
			// As informações de ID dos itens Dia, Linha, Carro, Motorista e Cobrador vem em
			// forma de String com o ID + nome do item
			// Nesse caso é preciso capturar da string somente o valor do ID do objeto

			day = day.substring(0, (day.indexOf("-") - 1));
			line = line.substring(0, (line.indexOf("-") - 1));
			car = car.substring(0, (car.indexOf("-") - 1));
			driver = driver.substring(0, (driver.indexOf("-") - 1));
			ticket_reviser = ticket_reviser.substring(0, (ticket_reviser.indexOf("-") - 1));

			// Acrescentando campo de segundos na String de hora
			hour += ":00";

			// Verificando se houve alteração no campo de dia do horário
			if (oldObject.getIdDia() != Integer.parseInt(day)) {
				schedulePersistence.update(HorarioEnum.DIA.getNome(), oldObject.getId(), day, 1);
				logDAO.insertLog(user, "alterou o dia do horario " + oldObject.getId() + " de " + oldObject.getIdDia()
						+ " para " + day);
			}

			// Verificando se houve alteração no campo de hora do horário
			if (!oldObject.getHora().equals(hour)) {
				schedulePersistence.update(HorarioEnum.HORA.getNome(), oldObject.getId(), hour, 2);
				logDAO.insertLog(user, "alterou a hora do horario " + oldObject.getId() + " de " + oldObject.getHora()
						+ " para " + hour);
			}

			// Verificando se houve alteração no campo de linha do horário
			if (oldObject.getIdLinha() != Integer.parseInt(line)) {
				schedulePersistence.update(HorarioEnum.LINHA.getNome(), oldObject.getId(), line, 1);
				logDAO.insertLog(user, "alterou a linha do horario " + oldObject.getId() + " de "
						+ oldObject.getIdLinha() + " para " + line);
			}

			// Verificando se houve alteração no campo de carro do horário
			if (oldObject.getIdCarro() != Integer.parseInt(car)) {
				schedulePersistence.update(HorarioEnum.CARRO.getNome(), oldObject.getId(), car, 1);
				logDAO.insertLog(user, "alterou o carro do horario " + oldObject.getId() + " de "
						+ oldObject.getIdCarro() + " para " + car);
			}

			// Verificando se houve alteração no campo de motorista do horário
			if (oldObject.getIdMotorista() != Integer.parseInt(driver)) {
				schedulePersistence.update(HorarioEnum.MOTORISTA.getNome(), oldObject.getId(), driver, 1);
				logDAO.insertLog(user, "alterou o motorista do horario " + oldObject.getId() + " de "
						+ oldObject.getIdMotorista() + " para " + driver);
			}

			// Verificando se houve alteração no campo de cobrador do horário
			if (oldObject.getIdCobrador() != Integer.parseInt(ticket_reviser)) {
				schedulePersistence.update(HorarioEnum.COBRADOR.getNome(), oldObject.getId(), ticket_reviser, 1);
				logDAO.insertLog(user, "alterou o cobrador do horario " + oldObject.getId() + " de "
						+ oldObject.getIdCobrador() + " para " + ticket_reviser);
			}

			return true;

		}

	}

	// Alteração nas informções do horário
	@Override
	public void update(String column, int id, String value, int columnType) {

		schedulePersistence.update(column, id, value, columnType);
	}

	// Horários do carro
	@Override
	public List<HorarioModel> scheduleCarByDay(int id) {

		List<HorarioModel> scheduleList = new ArrayList<HorarioModel>();

		// Percorrendo todos os dias da semana
		for (int i = 1; i <= 7; i++) {
			ResultSet rs = schedulePersistence.scheduleCarByDay(id, i);
			try {
				while (rs.next())
					scheduleList.add(mountObject(rs));
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return scheduleList;
	}

	// Gerando lista de horários da linha para tabela da view
	@Override
	public Object[][] generateScheduleLineList(List<HorarioModel> list) {

		Object[][] ob = new Object[list.size()][6];

		// Informações: Dia, Hora, Garagem, Carro, Motorista e Cobrador
		for (int i = 0; i < list.size(); i++) {

			ob[i][0] = list.get(i).getDia();
			ob[i][1] = list.get(i).getHora();
			ob[i][2] = list.get(i).getGaragem();
			ob[i][3] = list.get(i).getIdCarro();
			ob[i][4] = list.get(i).getMotorista();
			ob[i][5] = list.get(i).getCobrador();
		}

		return ob;

	}

	// Gerando lista de horário do carro para tabela da view
	@Override
	public Object[][] generateScheduleCarList(List<HorarioModel> list) {

		Object[][] ob = new Object[list.size()][6];

		// Informações: Dia, Hora, Garagem, Linha, Motorista e Cobrador
		for (int i = 0; i < list.size(); i++) {

			ob[i][0] = list.get(i).getDia();
			ob[i][1] = list.get(i).getHora();
			ob[i][2] = list.get(i).getGaragem();
			ob[i][3] = list.get(i).getLinha();
			ob[i][4] = list.get(i).getMotorista();
			ob[i][5] = list.get(i).getCobrador();
		}

		return ob;

	}

	// Lista de garagens
	@Override
	public List<String> listOfGarage() {
		ResultSet rs = schedulePersistence.listOfGarage();
		List<String> list = new ArrayList<String>();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Lista de dias
	@Override
	public List<String> listOfDay() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = schedulePersistence.listOfDay();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Lista de carros
	@Override
	public List<String> listOfCar() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = schedulePersistence.listOfCar();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Lista de linhas
	@Override
	public List<String> listOfLine() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = schedulePersistence.listOfLine();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - (" + rs.getString(3) + ") " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Lista de funcionários
	@Override
	public List<String> listOfEmployee() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = schedulePersistence.listOfEmployee();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Lista de motoristas
	@Override
	public List<String> listOfDriver() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = schedulePersistence.listOfDriver();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Listade cobrador
	@Override
	public List<String> listOfConductor() {
		List<String> list = new ArrayList<String>();
		ResultSet rs = schedulePersistence.listOfConductor();

		// Informações: ID - Nome
		try {
			while (rs.next()) {
				String s = rs.getInt(1) + " - " + rs.getString(2);

				list.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	// Filtrando lista de horários de acordo com o parametro selecionado
	@Override
	public List<HorarioModel> search(int type, String id) {
		// O parametro do filtro vem com o número da opção + nome da opção
		// Nesse caso é preciso extrair o número da informação recebida para usar como
		// parametro
		int id_format = Integer.parseInt(id.substring(0, (id.indexOf("-") - 1)));

		ResultSet rs = schedulePersistence.search(type, id_format);

		List<HorarioModel> list = new ArrayList<HorarioModel>();

		try {
			while (rs.next()) {

				HorarioModel schedule = mountObject(rs);

				list.add(schedule);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Filtrando lista de horários de acordo com o parametro selecionado
	@Override
	public List<HorarioModel> search(int type, int id) {

		ResultSet rs = schedulePersistence.search(type, id);

		List<HorarioModel> list = new ArrayList<HorarioModel>();

		try {
			while (rs.next()) {

				HorarioModel schedule = mountObject(rs);

				list.add(schedule);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Lista de horário para tabela da view
	@Override
	public Object[][] generateFilterScheduleList(List<HorarioModel> list) {

		Object[][] ob = new Object[list.size()][7];

		for (int i = 0; i < list.size(); i++) {

			ob[i][0] = list.get(i).getDia();
			ob[i][1] = list.get(i).getHora().substring(0, list.get(i).getHora().lastIndexOf(":"));
			ob[i][2] = list.get(i).getIdCarro();
			ob[i][3] = list.get(i).getLinha();
			ob[i][4] = list.get(i).getGaragem();
			ob[i][5] = list.get(i).getMotorista();
			ob[i][6] = list.get(i).getCobrador();
		}

		return ob;

	}

	// Montando objeto horário de acordo com as informações recebidas pelo ResutSet
	private HorarioModel mountObject(ResultSet rs) {

		HorarioModel schedule = new HorarioModel();

		try {
			schedule.setDia(rs.getString(1));
			schedule.setHora(rs.getString(2));
			schedule.setMotorista(rs.getString(3) == null ? "Sem informação" : rs.getString(3));
			schedule.setCobrador(rs.getString(4) == null ? "Sem informação" : rs.getString(4));
			schedule.setGaragem(rs.getString(5));
			schedule.setIdCarro(rs.getInt(6));
			schedule.setLinha(rs.getString(7));
			schedule.setId(rs.getInt(8));
			schedule.setIdLinha(rs.getInt(9));
			schedule.setIdDia(rs.getInt(10));
			schedule.setIdGaragem(rs.getInt(12));
			schedule.setIdMotorista(rs.getInt(13));
			schedule.setIdCobrador(rs.getInt(14));

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return schedule;

	}

	// Validaçao da hora infomrada

	private boolean validateHour(String hour) {
		// Verificando se a hora está vazia
		if (hour.replaceAll(" ", "").equals(""))
			this.message = "A hora não pode ficar vazia.";

		// verificando se os dados informados são um horário válido
		try {
			LocalTime.parse(hour);
		} catch (Exception e) {
			this.message = "A hora não é valida.";
		}

		if (message.equals(""))
			return true;
		else
			return false;
	}

	// Deletando horário do banco de dados
	@Override
	public void deleteByIdObject(String column, int id) {

		schedulePersistence.deleteByIdObject(column, id);
	}

	// Mensagem de erro
	@Override
	public String getMessage() {
		return this.message;
	}

//Quantitdade de horários vinculados a um carro ou linha
	@Override
	public int bondObjectSchedule(String object, int objectID) {

		return schedulePersistence.bondObjectSchedule(object, objectID);
	}

//Gerando lista de filtro com ComboBox
	@Override
	public String[] getFilterList(int filter) {

		// Verificando e montando a lista secundária para a ComboBox
		// 1 - Gerando opções de dia
		// 2 - Gerando opções de carro
		// 3 - gerando opções de linha
		// 4 - Gerando opções de funcionário
		// 5 - gerando opções de garagem
		switch (filter) {
		case 1: {
			List<String> day = listOfDay();

			String[] list = new String[day.size()];

			for (int i = 0; i < day.size(); i++) {
				list[i] = day.get(i);
			}

			return list;
		}

		case 2: {
			List<String> car = listOfCar();

			String[] list = new String[car.size()];

			for (int i = 0; i < car.size(); i++) {
				list[i] = car.get(i);
			}

			return list;
		}

		case 3: {
			List<String> line = listOfLine();

			String[] list = new String[line.size()];

			for (int i = 0; i < line.size(); i++) {
				list[i] = line.get(i);
			}

			return list;
		}

		case 4: {
			List<String> employee = listOfEmployee();

			String[] list = new String[employee.size()];

			for (int i = 0; i < employee.size(); i++) {
				list[i] = employee.get(i);
			}

			return list;
		}

		case 5: {
			List<String> garage = listOfGarage();

			String[] list = new String[garage.size()];

			for (int i = 0; i < garage.size(); i++) {
				list[i] = garage.get(i);
			}

			return list;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + filter);
		}

	}

}

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

import com.java.stagebus.dao.CarroDAO;
import com.java.stagebus.dao.GaragemDAO;
import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.dao.TipoCarroDAO;
import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.model.CarroModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.persistence.CarroPersistence;

public class CarroService implements CarroDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private String message = DEFAULT_MENSAGEM;
	private TipoCarroDAO typeOfCarDAO = new TipoCarroService();
	private GaragemDAO garageDAO = new GaragemService();
	private CarroPersistence carPersistence = new CarroPersistence();
	private LogDAO logDAO = new LogService();
	private HorarioService scheduleService = new HorarioService();

	// Recebendo dados para fazer inserção do carro na base de dados
	@Override
	public boolean insertCar(int user, String num, String name, String license_plate, String type, String status,
			String garage) {

		// Fazendo a validação das informações recebidas
		if (validation(num, name, license_plate)) {
			// Criando um objeto carro e setando o objeto com as informações recebidas
			CarroModel car = new CarroModel();

			// As informações de ID dos itens Garagem, Satus e Tipo vem em forma de String
			// com o ID + nome do item
			// Nesse caso é preciso capturar da string somente o valor do ID do objeto e
			// converter para inteiro
			car.setIdGaragem(Integer.parseInt(garage.substring(0, garage.indexOf("-") - 1)));
			car.setIdStatus(Integer.parseInt(status.substring(0, status.indexOf("-") - 1)));
			car.setIdTipo(Integer.parseInt(type.substring(0, type.indexOf("-") - 1)));
			car.setNome(name);
			car.setNumero(Integer.parseInt(num));
			car.setPlaca(license_plate);

			// Inserindo carro
			carPersistence.insertCar(car);

			// Inserindo no log a atividade do usuario
			logDAO.insertLog(user, "inseriu carro (" + car.getNumero() + ") " + car.getNome() + " no banco de dados.");

			return true;

		} else
			return false;

	}

	public boolean insertCarRandom(int num, String name, String license_plate, int type, int status, int garage) {

		if (validation(String.valueOf(num), name, license_plate)) {
			CarroModel car = new CarroModel();
			car.setIdGaragem(garage);
			car.setIdStatus(status);
			car.setIdTipo(type);
			car.setNome(name);
			car.setNumero(num);
			car.setPlaca(license_plate);

			carPersistence.insertCar(car);

			return true;

		} else
			return false;

	}

	// Mensagem de erro
	@Override
	public String getMessage() {
		return this.message;
	}

	// Capturando carro pelo ID
	@Override
	public CarroModel searchByID(int id) {
		// Fazendo chamada para o banco de dados
		ResultSet rs = carPersistence.searchByID(id);

		CarroModel car = new CarroModel();
		try {
			// verificando se a chamada retornou resultados
			if (rs.next()) {
				// Montando o carro com o resultado retornado
				car = mountOBject(rs);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return car;
	}

	// Lista de todos os carros do sistema
	@Override
	public Map<Integer, CarroModel> listOfCar() {
		Map<Integer, CarroModel> list = new HashMap<Integer, CarroModel>();

		// Fazendo chamada para banco de dados
		ResultSet rs = carPersistence.listOfCar();

		try {
			// Verificando se a chamada retornou resultados
			while (rs.next()) {
				// Montando carro com o resultado retornado
				CarroModel car = mountOBject(rs);

				// Inserindo carro na lista
				list.put(car.getNumero(), car);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	// Deletando carro do sistema
	@Override
	public void delete(int user, int id) {

		carPersistence.delete(id);

		// Inseridno ação no log
		logDAO.insertLog(user, "deletou o carro " + id + " do banco de dados.");

	}

	// Lista de status
	@Override
	public List<String> listOfStatus() {
		ResultSet rs = carPersistence.listOfStatus();
		List<String> list = new ArrayList<String>();

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

	// Lista de tipos de carro
	@Override
	public List<String> listOfType() {
		ResultSet rs = carPersistence.listOfType();
		List<String> list = new ArrayList<String>();

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

	// Lista de horarios do carro
	@Override
	public List<HorarioModel> scheduleOfCar(int id) {
		List<HorarioModel> list = new ArrayList<HorarioModel>();
		ResultSet rs = carPersistence.scheduleOfCar(id);

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

	// Pesquisando carro no banco de dados
	@Override
	public Map<Integer, CarroModel> search(String term) {
		Map<Integer, CarroModel> list = new HashMap<Integer, CarroModel>();

		// Buscando o termo digitado pelo nome
		ResultSet searchName = carPersistence.search(1, term);

		try {
			while (searchName.next()) {
				CarroModel car = mountOBject(searchName);

				list.put(car.getNumero(), car);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Fazendo a busca do termo digitado pelo numero
		ResultSet searchNumber = carPersistence.search(2, term);

		try {
			while (searchNumber.next()) {
				CarroModel car = mountOBject(searchNumber);

				if (!list.containsKey(car.getNumero()))
					list.put(car.getNumero(), car);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Fazendo a busca do termo digitado pela placa
		ResultSet searchLicensePlate = carPersistence.search(3, term);

		try {
			while (searchLicensePlate.next()) {
				CarroModel car = mountOBject(searchLicensePlate);

				if (!list.containsKey(car.getNumero()))
					list.put(car.getNumero(), car);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Atualizando dados do carro
	@Override
	public boolean update(int user, CarroModel oldObject, String num, String name, String license_plate, String type,
			String status, String garage) {

		// Fazendo a validação dos dados recebidos
		if (validation(num, name, license_plate)) {
			// As informações de ID dos itens Garagem, Satus e Tipo vem em forma de String
			// com o ID + nome do item
			// Nesse caso é preciso capturar da string somente o valor do ID do objeto e
			// converter para inteiro
			type = type.substring(0, (type.indexOf("-") - 1));
			status = status.substring(0, (status.indexOf("-") - 1));
			garage = garage.substring(0, (garage.indexOf("-") - 1));

			// Verificando se houve alteração no numero do carro
			if (Integer.parseInt(num) != oldObject.getNumero()) {

				// Capturando todos os horarios que estavam vinculados ao antigo numero do carro
				List<HorarioModel> list = scheduleService.search(2, oldObject.getNumero());

				// Deletando o carro dos horarios que ele havia sido cadastrado
				scheduleService.deleteByIdObject(HorarioEnum.CARRO.getNome(), oldObject.getNumero());

				// Alterando o numero do carro
				carPersistence.update(CarroEnum.ID.getNome(), oldObject.getNumero(), String.valueOf(num), 1);

				// Atribuindo ao novo numero do carro os horarios cadastrados
				for (HorarioModel h : list) {
					scheduleService.insertScheduleRandom(h.getIdDia(), h.getHora(), h.getIdLinha(),
							Integer.parseInt(num), h.getIdMotorista(), h.getIdCobrador());
				}
				logDAO.insertLog(user, "alterou o número do carro " + oldObject.getNumero() + " de "
						+ oldObject.getNumero() + " para " + num + ".");
			}

			// Verificando se houve alteração no nome do carro
			if (!name.equals(oldObject.getNome())) {
				carPersistence.update(CarroEnum.NOME.getNome(), oldObject.getNumero(), name, 2);
				logDAO.insertLog(user, "alterou o nome do carro " + oldObject.getNumero() + " de " + oldObject.getNome()
						+ " para " + name + ".");
			}

			// Verificando se houve alteração na placa do carro
			if (!license_plate.equals(oldObject.getPlaca())) {
				carPersistence.update(CarroEnum.PLACA.getNome(), oldObject.getNumero(), license_plate, 2);
				logDAO.insertLog(user, "alterou a placa do carro " + oldObject.getNumero() + " de "
						+ oldObject.getPlaca() + " para " + license_plate + ".");
			}

			// Verificando se houve alteração no tipo do carro
			if (Integer.parseInt(type) != oldObject.getIdTipo()) {
				carPersistence.update(CarroEnum.TIPO.getNome(), oldObject.getNumero(), String.valueOf(type), 1);
				logDAO.insertLog(user, "alterou o tipo do carro " + oldObject.getNumero() + " de "
						+ oldObject.getIdTipo() + " para " + type + ".");
			}

			// Verificando se houve alteração no status do carro
			if (Integer.parseInt(status) != oldObject.getIdStatus()) {
				carPersistence.update(CarroEnum.STATUS.getNome(), oldObject.getNumero(), String.valueOf(status), 1);
				logDAO.insertLog(user, "alterou o status do carro " + oldObject.getNumero() + " de "
						+ oldObject.getIdStatus() + " para " + status + ".");
			}

			// Verificando se houve alteração na garagem do carro
			if (Integer.parseInt(garage) != oldObject.getIdGaragem()) {
				carPersistence.update(CarroEnum.GARAGEM.getNome(), oldObject.getNumero(), String.valueOf(garage), 1);
				logDAO.insertLog(user, "alterou a garagem do carro " + oldObject.getNumero() + " de "
						+ oldObject.getIdGaragem() + " para " + garage + ".");
			}
			return true;

		}

		return false;
	}

	// Gerando lista de carro para a tabela da view
	@Override
	public Object[][] generateCarList(Map<Integer, CarroModel> list) {

		Object[][] ob = new Object[list.size()][3];

		List<Map.Entry<Integer, CarroModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		// Transformando a lista para ser compatível com a tabel da view
		// Itens: numero do carro, nome do carro e garagem do carro
		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = entryList.get(i).getValue().getNumero();
			ob[i][1] = entryList.get(i).getValue().getNome();
			ob[i][2] = entryList.get(i).getValue().getGaragem();

		}

		return ob;

	}

	// Lista de linhas vinculadas ao carro
	@Override
	public List<String> lineByDay(int id) {

		// Capturando o dia atual
		Calendar calendar = Calendar.getInstance();

		int today = calendar.get(Calendar.DAY_OF_WEEK);

		// Instanciando lista de linhas da semana
		List<String> lineList = new ArrayList<String>();

		// Percorrendo os dias da semana
		for (int i = 1; i <= 7; i++) {

			// Pesquisando por horarios relacionados ao carro no dia correspondente
			ResultSet rs = carPersistence.lineByDay(i, id);

			// Verificando se a pesquisa foi feita em um dia posterior ao atual
			if (i > today) {
				// Em caso positivo será adicionada a lista somente o primeiro resultado
				// retornado
				try {

					if (rs.next())
						lineList.add(rs.getString(1));
					else
						// Se não houver horarios cadastrados
						lineList.add("Sem informações");
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
			// Verificando se a pesquisa foi feita em um dia anterior ao atual
			else if (i < today) {
				// Em caso positivo deve ser adicionado o ultimo resultado retornado
				try {

					// Verificando se há pelo menos um resultado
					if (rs.next()) {
						// Caso haja adicionar na lista
						lineList.add(rs.getString(1) + "");
						// Após isso verificar se há outros resultados
						while (rs.next())
							// A medida que houver ir substituido o anterior pelo novo
							lineList.add(rs.getString(1));
					} else
						// Se não houver horarios cadastrados
						lineList.add("Sem informações");
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
			// Do contrario, o dia pesquisado é o atual
			else {
				try {
					if (rs.next()) {
						// Intanciando uma lista para armazenar todos os horarios retornados
						List<HorarioModel> allLines = new ArrayList<HorarioModel>();

						// Montando um objeto e usando a hora dessa vez
						HorarioModel h = new HorarioModel();
						h.setLinha(rs.getString(1));
						h.setHora(rs.getString(2));

						// Adicionando o prieiro resultado
						allLines.add(h);

						// Adicionando os demais resultados a lista
						while (rs.next()) {
							h = new HorarioModel();
							h.setLinha(rs.getString(1));
							h.setHora(rs.getString(2));

							allLines.add(h);
						}

						// Percorrendo a lista de horarios retornados
						for (int j = 0; i < allLines.size(); j++) {
							// Verificando se esse é último horario da lista
							if (j + 1 == allLines.size()) {
								// Caso seja ele é adicionado a lista principal
								lineList.add(allLines.get(j).getLinha() + "");

							} else {

								// Formato da string
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

								// Convertendo a string para LocalTime
								LocalTime hour = LocalTime.parse(h.getHora(), formatter);

								// Se a hora do horario for anterior a hora atual, caso seja o horario é
								// adicionado a lista principal
								if (hour.isBefore(LocalTime.now())) {
									lineList.add(allLines.get(j).getLinha() + "");
									break;

								}
							}

						}

						lineList.add(h.getLinha());
					} else
						lineList.add("Sem informações");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

		return lineList;
	}

	// Montando objeto carro com informações da consulta do resultset
	public CarroModel mountOBject(ResultSet rs) {

		CarroModel car = new CarroModel();
		try {
			car.setNumero(rs.getInt(1));
			car.setNome(rs.getString(2));
			car.setPlaca(rs.getString(3));
			car.setIdTipo(rs.getInt(4));
			car.setIdStatus(rs.getInt(5));
			car.setIdGaragem(rs.getInt(6));
			car.setGaragem(rs.getString(7));
			car.setStatus(rs.getString(8));
			car.setTipo(rs.getString(9));

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return car;

	}

	// Validações
	private boolean validation(String num, String name, String license_plate) {
		this.message = "";

		// Verifica se há tipos de carro cadastrados
		if (!(typeOfCarDAO.amountCarType() > 0))

			this.message += "É necessário cadastrar um tipo de carro antes de cadastrar um carro. ";

		// Verifica se há garagens cadastradas
		if (!(garageDAO.garageAmount() > 0))

			this.message += "É necessário cadastrar um tipo de carro antes de cadastrar um carro. ";

		// Verificando se o número de carro informado já foi cadastrado
		if (carPersistence.checkingExistingCar(Integer.parseInt(num)) > 0)
			this.message += "Já existe um carro com o número informado. ";

		if (name.replace(" ", "").equals("") || license_plate.replace(" ", "").equals(""))
			this.message += "Campos obrigatótrios naão podem ficar vazios";

		// Caso não haja nenhuma mensagem de erro significa que o objeto está ok para
		// ser inserido no banco de dados
		if (message.equals(""))
			return true;
		return false;
	}

	// Gerando uma lista para a combobox
	@Override
	public String[] generateObjectList(List<String> list) {

		String[] listObject = new String[list.size()];

		for (int i = 0; i < list.size(); i++)
			listObject[i] = list.get(i);

		return listObject;
	}

	// Gerando uma lista para a combobox
	@Override
	public String[] generateObjectList(Map<Integer, CarroModel> list) {

		String[] listObject = new String[list.size()];

		List<Map.Entry<Integer, CarroModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++)
			listObject[i] = entryList.get(i).getValue().getNumero() + " - " + entryList.get(i).getValue().getNome();

		return listObject;
	}

	// Atualizando informações do carro
	@Override
	public void update(String column, int id, String value, int columnType) {

		carPersistence.update(column, id, value, columnType);
	}

}

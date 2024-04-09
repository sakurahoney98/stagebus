package com.java.stagebus.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.stagebus.dao.GaragemDAO;
import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.enums.GaragemEnum;
import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.persistence.GaragemPersistence;

public class GaragemService implements GaragemDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private GaragemPersistence garagePersistence = new GaragemPersistence();
	private LogDAO logDAO = new LogService();
	private String message = DEFAULT_MENSAGEM;

	// Quantidade de garagens
	@Override
	public int garageAmount() {

		return garagePersistence.garageAmount();
	}

	// Inserindo garagem no banco
	@Override
	public boolean insertGarage(int user, int id, String name, String length, String width, String heigth,
			String sponsor, String location, String max) {
		GaragemModel garage = new GaragemModel();

		// validando informações recebidas
		if (validation(name, length, width, heigth, max)) {

			garage.setId(id);
			garage.setNome(name);
			garage.setLocal(location);
			garage.setResponsavel(sponsor);

			// Formatando os valores das medidas da garagem
			List<Double> list = formattingValues(length, width, heigth);

			garage.setComprimento(list.get(0));
			garage.setLargura(list.get(1));
			garage.setAltura(list.get(2));
			garage.setMax(Integer.valueOf(max));

			garagePersistence.insertGarage(garage);

			logDAO.insertLog(user,
					"inseriu garagem (" + garage.getId() + ") " + garage.getNome() + " no banco de dados.");

			return true;

		}

		return false;
	}

	public boolean insertGarageRandom(int id, String name, String length, String width, String heigth, String sponsor,
			String location, String max) {
		GaragemModel garage = new GaragemModel();

		if (validation(name, length, width, heigth, max)) {

			garage.setId(id);
			garage.setNome(name);
			garage.setLocal(location);
			garage.setResponsavel(sponsor);

			List<Double> list = formattingValues(length, width, heigth);

			garage.setComprimento(list.get(0));
			garage.setLargura(list.get(1));
			garage.setAltura(list.get(2));
			garage.setMax(Integer.valueOf(max));

			garagePersistence.insertGarage(garage);

			return true;

		}

		return false;
	}

	// Lista de todas as garagens
	@Override
	public Map<Integer, GaragemModel> listOfGarage() {
		ResultSet rs = garagePersistence.listOfGarage();
		Map<Integer, GaragemModel> list = new HashMap<>();

		try {
			while (rs.next()) {

				GaragemModel garage = mountObject(rs);
				list.put(garage.getId(), garage);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Gerando ID para nova garagem
	@Override
	public int generateID() {

		return garagePersistence.generateID() + 1;
	}

	// Pegando uma garagem pelo ID
	@Override
	public GaragemModel searchByID(int id) {

		ResultSet rs = garagePersistence.searchByID(id);
		GaragemModel garage = mountObject(rs);

		return garage;
	}

	// Deletando uma garagem pelo ID
	@Override
	public void delete(int userID, int id) {

		garagePersistence.delete(id);
		logDAO.insertLog(userID, "deletou a garagem " + id);

	}

	// Procurando uma garagem por um termo digitado
	@Override
	public Map<Integer, GaragemModel> search(String term) {
		Map<Integer, GaragemModel> list = new HashMap<Integer, GaragemModel>();

		// Pesquisando pelo nome
		ResultSet searchName = garagePersistence.search(1, term);

		try {
			while (searchName.next()) {
				GaragemModel garage = mountObject(searchName);
				list.put(garage.getId(), garage);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Pesquisando pelo ID
		ResultSet searchID = garagePersistence.search(2, term);

		try {
			while (searchID.next()) {
				GaragemModel garage = mountObject(searchID);

				if (!list.containsKey(garage.getId()))

					list.put(garage.getId(), garage);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	// Monando objeto garagem de acordo com as informações recebidas pelo ResultSet
	private GaragemModel mountObject(ResultSet rs) {

		GaragemModel garage = new GaragemModel();
		try {
			garage.setId(rs.getInt(1));
			garage.setNome(rs.getString(2));
			garage.setComprimento(rs.getDouble(3));
			garage.setLargura(rs.getDouble(4));
			garage.setAltura(rs.getDouble(5));
			garage.setResponsavel(rs.getString(6));
			garage.setLocal(rs.getString(7));
			garage.setMax(rs.getInt(8));
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return garage;

	}

	// Atualizando informações da garagem
	@Override
	public boolean update(int user, GaragemModel oldObject, String name, String length, String width, String heigth,
			String sponsor, String location, String max) {

		// Validando as informações recebidas
		if (validation(name, length, width, heigth, max)) {

			// Formatando os valores das medidas da garagem
			List<Double> list = formattingValues(length, width, heigth);

			length = list.get(0) + "";
			width = list.get(1) + "";
			heigth = list.get(2) + "";

			// Verificando se houve alteração no nome da garagem
			if (!name.equals(oldObject.getNome())) {
				garagePersistence.update(GaragemEnum.NOME.getNome(), oldObject.getId(), name, 2);
				logDAO.insertLog(user, "alterou o nome da garagem " + oldObject.getId() + " de " + oldObject.getNome()
						+ " para " + name + ".");
			}

			// Verificando se houve alteração no comprimento da garagem
			if (list.get(0) != oldObject.getComprimento()) {
				garagePersistence.update(GaragemEnum.COMPRIMENTO.getNome(), oldObject.getId(), length, 1);
				logDAO.insertLog(user, "alterou o comprimento da garagem " + oldObject.getId() + " de "
						+ oldObject.getComprimento() + " para " + length + ".");
			}

			// Verificando se houve alteração na largura da garagem
			if (list.get(1) != oldObject.getLargura()) {
				garagePersistence.update(GaragemEnum.LARGURA.getNome(), oldObject.getId(), width, 1);
				logDAO.insertLog(user, "alterou a largura da garagem " + oldObject.getId() + " de "
						+ oldObject.getLargura() + " para " + width + ".");
			}

			// Verificando se houve alteração na altura da garagem
			if (list.get(2) != oldObject.getAltura()) {
				garagePersistence.update(GaragemEnum.ALTURA.getNome(), oldObject.getId(), heigth, 1);
				logDAO.insertLog(user, "alterou a altura da garagem " + oldObject.getId() + " de "
						+ oldObject.getAltura() + " para " + heigth + ".");
			}

			// Verificando se houve alteração no nome do responsável da garagem
			if (!sponsor.equals(oldObject.getResponsavel())) {
				garagePersistence.update(GaragemEnum.RESPONSAVEL.getNome(), oldObject.getId(), sponsor, 2);
				logDAO.insertLog(user, "alterou o nome do responsável da garagem " + oldObject.getId() + " de "
						+ oldObject.getResponsavel() + " para " + sponsor + ".");
			}

			// Verificando se houve alteração na localização da garagem
			if (!location.equals(oldObject.getLocal())) {
				garagePersistence.update(GaragemEnum.LOCAL.getNome(), oldObject.getId(), location, 2);
				logDAO.insertLog(user, "alterou a localização da garagem " + oldObject.getId() + " de "
						+ oldObject.getLocal() + " para " + location + ".");
			}

			// Verificando se houve alteração na quantidade máxima da garagem
			if (Integer.parseInt(max) != oldObject.getMax()) {
				garagePersistence.update(GaragemEnum.MAXIMO.getNome(), oldObject.getId(), max, 1);
				logDAO.insertLog(user, "alterou quantidade máxima da garagem " + oldObject.getId() + " de "
						+ oldObject.getMax() + " para " + max + ".");
			}
			return true;

		}
		return false;

	}

	// Validando informações recebidas
	private boolean validation(String name, String length, String width, String heigth, String max) {
		this.message = "";

		// Verifica se os campos obrigatórios foram preenchidos
		if (name.replace(" ", "").equals("") || length.replace(" ", "").equals("") || width.replace(" ", "").equals("")
				|| max.replace(" ", "").equals(""))
			this.message += "Campos obrigatórios precisam ser preenchidos. ";

		// Verifica se o usuário não digitou medidas menores que 0
		if ((length.substring(0, 1).equals(".") || length.substring(0, 1).equals("0"))
				|| (width.substring(0, 1).equals(".") || width.substring(0, 1).equals("0"))
				|| (heigth.substring(0, 1).equals(".") || heigth.substring(0, 1).equals("0")))
			this.message += "As medidas da garagem não podem ser menor que zero. ";

		// Verifica se o valor maximo é maior que 0
		if (!(Integer.valueOf(max) > 0))
			this.message += "A quantidade máxima de veículos não pode ser igual ou menor que zero.";

		if (this.message.equals(""))
			return true;
		return false;
	}

	// Formatando valores das medidas da gragem
	private List<Double> formattingValues(String length, String width, String heigth) {

		List<Double> list = new ArrayList<Double>();

		// Substituindo as vírgulas por ponto para poder posteriormente converter em
		// double
		length = length.replace(",", ".");
		heigth = heigth.replace(",", ".");
		width = width.replace(",", ".");

		// Convertendo as medidas para serem armazenadas com duas casas decimais
		BigDecimal aux = new BigDecimal(Double.parseDouble(length)).setScale(2, RoundingMode.HALF_UP);
		list.add(aux.doubleValue());

		aux = new BigDecimal(Double.parseDouble(width)).setScale(2, RoundingMode.HALF_UP);
		list.add(aux.doubleValue());

		// Verificando se a altura foi digitada antes de fazer a conversão
		if (!heigth.equals("")) {
			aux = new BigDecimal(Double.parseDouble(heigth)).setScale(2, RoundingMode.HALF_UP);
			list.add(aux.doubleValue());
		} else
			list.add(0.00);

		return list;
	}

	// Gerando lista para tabela da view
	@Override
	public Object[][] generategGarageList(Map<Integer, GaragemModel> list) {

		Object[][] ob = new Object[list.size()][2];

		List<Map.Entry<Integer, GaragemModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		// Informações a serem exibidas: ID, Nome
		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = entryList.get(i).getValue().getId();
			ob[i][1] = entryList.get(i).getValue().getNome();

		}

		return ob;

	}

	// Quantidade de ônibus na garagem
	@Override
	public int amountBusOnGarage(int garage) {

		return garagePersistence.amountBusOnGarage(garage);

	}

	// Atualização de informações na garagem
	@Override
	public void update(String column, int id, String value, int columnType) {
		garagePersistence.update(column, id, value, columnType);
	}

	// Mensagem de erro
	@Override
	public String getMessage() {

		return this.message;
	}

}

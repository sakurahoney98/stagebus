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

import com.java.stagebus.dao.LogDAO;
import com.java.stagebus.dao.TipoCarroDAO;
import com.java.stagebus.enums.TipoCarroEnum;
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.persistence.TipoCarroPersistence;

public class TipoCarroService implements TipoCarroDAO {

	private static final String DEFAULT_MENSAGEM = "";

	private String message = DEFAULT_MENSAGEM;
	private TipoCarroPersistence car_typePersistence = new TipoCarroPersistence();
	private LogDAO logDAO = new LogService();

	@Override
	public int amountCarType() {

		return car_typePersistence.amountCarType();
	}

	@Override
	public boolean insertCarType(int user, String id, String name, String length, String width, String heigth,
			String weigth) {
		TipoCarroModel type = new TipoCarroModel();

		if (validation(name, length, width, heigth, weigth)) {
			type.setId(Integer.parseInt(id));
			type.setNome(name);

			List<Double> list = formattingValues(length, width, heigth, weigth);

			type.setComprimento(list.get(0));

			type.setLargura(list.get(1));

			type.setAltura(list.get(2));

			type.setPeso(list.get(3));

			car_typePersistence.insertCarType(type);

			logDAO.insertLog(user,
					"inseriu tipo de carro (" + type.getId() + ") " + type.getNome() + " no banco de dados.");

			return true;
		}

		return false;
	}
	
	public boolean insertCarTypeRandom(int id, String name, String length, String width, String heigth,
			String weigth) {
		TipoCarroModel type = new TipoCarroModel();

		if (validation(name, length, width, heigth, weigth)) {
			type.setId(id);
			type.setNome(name);

			List<Double> list = formattingValues(length, width, heigth, weigth);

			type.setComprimento(list.get(0));

			type.setLargura(list.get(1));

			type.setAltura(list.get(2));

			type.setPeso(list.get(3));

			car_typePersistence.insertCarType(type);

			

			return true;
		}

		return false;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public int genarateID() {

		return car_typePersistence.generateID() + 1;
	}

	@Override
	public void delete(int user, int id) {

		car_typePersistence.delete(id);
		logDAO.insertLog(user, "deletou tipo de carro " + id + " no banco de dados.");
	}

	@Override
	public TipoCarroModel searchByID(int id) {
		TipoCarroModel type = new TipoCarroModel();
		ResultSet rs = car_typePersistence.searchByID(id);

		try {
			if (rs.next()) {

				type = mountObject(rs);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return type;
	}

	@Override
	public Map<Integer, TipoCarroModel> listOfCarType() {
		ResultSet rs = car_typePersistence.listOfCarType();
		Map<Integer, TipoCarroModel> list = new HashMap<>();

		try {
			while (rs.next()) {
				TipoCarroModel type = mountObject(rs);

				list.put(type.getId(), type);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Map<Integer, TipoCarroModel> search(String term) {

		Map<Integer, TipoCarroModel> list = new HashMap<Integer, TipoCarroModel>();
		ResultSet searchName = car_typePersistence.search(1, term);

		try {
			while (searchName.next()) {
				TipoCarroModel type = mountObject(searchName);
				list.put(type.getId(), type);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet searchID = car_typePersistence.search(2, term);

		try {
			while (searchName.next()) {
				TipoCarroModel type = mountObject(searchID);

				if (!list.containsKey(type.getId()))
					list.put(type.getId(), type);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean update(int user, TipoCarroModel oldObject, String name, String length, String width, String heigth,
			String weigth) {

		if (validation(name, length, width, heigth, weigth)) {
			List<Double> list = formattingValues(length, width, heigth, weigth);

			if (!name.equals(oldObject.getNome())) {
				car_typePersistence.update(TipoCarroEnum.NOME.getNome(), oldObject.getId(), name, 2);
				logDAO.insertLog(user, "alterou o nome do carro " + oldObject.getId() + " de " + oldObject.getNome()
						+ " para " + name + ".");
			}
			if (list.get(0) != oldObject.getComprimento()) {
				car_typePersistence.update(TipoCarroEnum.COMPRIMENTO.getNome(), oldObject.getId(),
						list.get(0).toString(), 1);
				logDAO.insertLog(user, "alterou o comprimento do carro " + oldObject.getId() + " de "
						+ oldObject.getComprimento() + " para " + list.get(0) + ".");
			}
			if (list.get(1) != oldObject.getLargura()) {
				car_typePersistence.update(TipoCarroEnum.LARGURA.getNome(), oldObject.getId(), list.get(1).toString(),
						1);
				logDAO.insertLog(user, "alterou a largura do carro " + oldObject.getId() + " de "
						+ oldObject.getLargura() + " para " + list.get(1) + ".");
			}
			if (list.get(2) != oldObject.getAltura()) {
				car_typePersistence.update(TipoCarroEnum.ALTURA.getNome(), oldObject.getId(), list.get(2).toString(),
						1);
				logDAO.insertLog(user, "alterou a altura do carro " + oldObject.getId() + " de " + oldObject.getAltura()
						+ " para " + list.get(2) + ".");
			}
			if (list.get(3) != oldObject.getPeso()) {
				car_typePersistence.update(TipoCarroEnum.PESO.getNome(), oldObject.getId(), list.get(3).toString(), 1);
				logDAO.insertLog(user, "alterou o peso do carro " + oldObject.getId() + " de " + oldObject.getPeso()
						+ " para " + list.get(3) + ".");
			}
			return true;

		}
		return false;

	}
	
	@Override
	public Object[][] generateCarTypeList(Map<Integer, TipoCarroModel> list) {

		

		Object[][] ob = new Object[list.size()][2];

		List<Map.Entry<Integer, TipoCarroModel>> entryList = list.entrySet().stream().collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = entryList.get(i).getValue().getId();
			ob[i][1] = entryList.get(i).getValue().getNome();
			

		}

		return ob;

	}
	
	@Override
	public int amountBusCarType(int id) {
		
		return car_typePersistence.amountBusCarType(id);
		
	}
	
	
	
	
	@Override
	public void update (String column, int id,String value, int columnType) {
		
		car_typePersistence.update(column, id, value, columnType);
		
	}
	

	private TipoCarroModel mountObject(ResultSet rs) {

		TipoCarroModel type = new TipoCarroModel();
		try {
			type.setId(rs.getInt(1));
			type.setNome(rs.getString(2));
			type.setLargura(rs.getDouble(3));
			type.setComprimento(rs.getDouble(4));
			type.setAltura(rs.getDouble(5));
			type.setPeso(rs.getDouble(6));
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return type;
	}

	private boolean validation(String name, String length, String width, String heigth, String weigth) {

		this.message = "";

		// Verifica se campos obrigatórios estão preenchidos
		if (name.replace(" ", "").equals("") || length.equals("") || width.equals(""))
			this.message += "Campos obrigatórios não podem ficar vazios. ";

		// Verifica se o usuário não digitou medidas menores que 0
		if ((length.substring(0, 1).equals(".") || length.substring(0, 1).equals("0"))
				|| (width.substring(0, 1).equals(".") || width.substring(0, 1).equals("0"))
				|| (heigth.substring(0, 1).equals(".") || heigth.substring(0, 1).equals("0"))
				|| (weigth.substring(0, 1).equals(".") || weigth.substring(0, 1).equals("0")))
			this.message += "As medidas do carro não podem ser menor que zero. ";

		if (this.message.equals(""))
			return true;

		return false;
	}

	private List<Double> formattingValues(String length, String width, String heigth, String weigth) {

		List<Double> list = new ArrayList<Double>();

		// Substituindo as vírgulas por ponto para poder posteriormente converter em
		// double
		length = length.replace(",", ".");
		heigth = heigth.replace(",", ".");
		width = width.replace(",", ".");
		weigth = weigth.replace(",", ".");

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

		// Verificando se o peso foi digitado antes de fazer a conversão
		if (!weigth.equals("")) {
			aux = new BigDecimal(Double.parseDouble(weigth)).setScale(2, RoundingMode.HALF_UP);
			list.add(aux.doubleValue());
		} else
			list.add(0.00);

		return list;

	}

}

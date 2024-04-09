package com.java.stagebus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.stagebus.dao.RelatorioDAO;
import com.java.stagebus.enums.CarroEnum;
import com.java.stagebus.enums.DiaEnum;
import com.java.stagebus.enums.FuncionarioEnum;
import com.java.stagebus.enums.GaragemEnum;
import com.java.stagebus.enums.HorarioEnum;
import com.java.stagebus.enums.LinhaEnum;
import com.java.stagebus.enums.StatusEnum;
import com.java.stagebus.enums.TipoCarroEnum;
import com.java.stagebus.enums.TipoFuncionarioEnum;
import com.java.stagebus.enums.UsuarioEnum;
import com.java.stagebus.model.CarroModel;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.model.LinhaModel;
import com.java.stagebus.model.RelatorioModel;
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.model.UsuarioModel;
import com.java.stagebus.persistence.RelatorioPersistence;

public class RelatorioService implements RelatorioDAO {

	private RelatorioPersistence reportPersistence = new RelatorioPersistence();
	private HorarioService scheduleService = new HorarioService();
	private CarroService carService = new CarroService();

	@Override
	public List<CarroModel> getCarTable(List<String> columns, int param, int id_param) {

		List<CarroModel> list = new ArrayList<CarroModel>();
		ResultSet rs = reportPersistence.getCarTable(columns, param, id_param);

		try {
			while (rs.next()) {
				int position = 0;
				CarroModel car = new CarroModel();

				if (columns.contains(CarroEnum.ID.getNome())) {
					position++;
					car.setNumero(rs.getInt(position));
				}

				if (columns.contains(CarroEnum.NOME.getNome())) {
					position++;
					car.setNome(rs.getString(position));
				}

				if (columns.contains(CarroEnum.PLACA.getNome())) {
					position++;
					car.setPlaca(rs.getString(position));
				}

				if (columns.contains(TipoCarroEnum.TABELA.getNome() + "." + TipoCarroEnum.NOME.getNome())) {
					position++;
					car.setTipo(rs.getString(position));
				}

				if (columns.contains(StatusEnum.TABELA.getNome() + "." + StatusEnum.DESCRICAO.getNome())) {
					position++;
					car.setStatus(rs.getString(position));
				}

				if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {
					position++;
					car.setGaragem(rs.getString(position));
				}

				list.add(car);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<FuncionarioModel> getEmployeeTable(List<String> columns, int param, int id_param) {

		List<FuncionarioModel> list = new ArrayList<FuncionarioModel>();
		ResultSet rs = reportPersistence.getEmployeeTable(columns, param, id_param);

		try {
			while (rs.next()) {
				int position = 0;
				FuncionarioModel employee = new FuncionarioModel();

				if (columns.contains(FuncionarioEnum.ID.getNome())) {
					position++;
					employee.setId(rs.getInt(position));
				}

				if (columns.contains(FuncionarioEnum.NOME.getNome())) {
					position++;
					employee.setNome(rs.getString(position));
				}

				if (columns.contains(FuncionarioEnum.APELIDO.getNome())) {
					position++;
					employee.setApelido(rs.getString(position));
				}

				if (columns.contains(
						TipoFuncionarioEnum.TABELA.getNome() + "." + TipoFuncionarioEnum.DESCRICAO.getNome())) {
					position++;
					employee.setTipo(rs.getString(position));
				}

				if (columns.contains(FuncionarioEnum.MATRICULA.getNome())) {
					position++;
					employee.setMatricula(rs.getString(position));
				}

				list.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<GaragemModel> getGarageTable(List<String> columns) {

		List<GaragemModel> list = new ArrayList<GaragemModel>();
		ResultSet rs = reportPersistence.getGarageTable(columns);

		try {
			while (rs.next()) {
				int position = 0;
				GaragemModel garage = new GaragemModel();

				if (columns.contains(GaragemEnum.ID.getNome())) {
					position++;
					garage.setId(rs.getInt(position));
				}

				if (columns.contains(GaragemEnum.NOME.getNome())) {
					position++;
					garage.setNome(rs.getString(position));
				}

				if (columns.contains(GaragemEnum.LARGURA.getNome())) {
					position++;
					garage.setLargura(rs.getDouble(position));
				}

				if (columns.contains(GaragemEnum.COMPRIMENTO.getNome())) {
					position++;
					garage.setComprimento(rs.getDouble(position));
				}

				if (columns.contains(GaragemEnum.ALTURA.getNome())) {
					position++;
					garage.setAltura(rs.getDouble(position));
				}

				if (columns.contains(GaragemEnum.RESPONSAVEL.getNome())) {
					position++;
					garage.setResponsavel(rs.getString(position));
				}

				if (columns.contains(GaragemEnum.LOCAL.getNome())) {
					position++;
					garage.setLocal(rs.getString(position));
				}

				if (columns.contains(GaragemEnum.MAXIMO.getNome())) {
					position++;
					garage.setMax(rs.getInt(position));
				}

				if (columns
						.contains("COUNT (" + CarroEnum.TABELA.getNome() + "." + CarroEnum.GARAGEM.getNome() + ")")) {
					position++;
					garage.setOnibus(rs.getInt(position));
				}

				list.add(garage);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<HorarioModel> getScheduleTable(List<String> columns, int param, int id_param) {

		List<HorarioModel> list = new ArrayList<HorarioModel>();
		ResultSet rs = reportPersistence.getScheduleTable(columns, param, id_param);

		try {
			while (rs.next()) {
				int position = 0;
				HorarioModel schedule = new HorarioModel();

				if (columns.contains(DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome())) {
					position++;
					schedule.setDia(rs.getString(position));
				}

				if (columns.contains(HorarioEnum.HORA.getNome())) {
					position++;
					schedule.setHora(rs.getString(position));
				}

				if (columns.contains("num." + LinhaEnum.NUMERO.getNome())) {
					position++;
					schedule.setNum_linha(rs.getString(position));
				}

				if (columns.contains("nome." + LinhaEnum.NOME.getNome())) {
					position++;
					schedule.setLinha(rs.getString(position));
				}

				if (columns.contains(HorarioEnum.CARRO.getNome())) {
					position++;
					schedule.setIdCarro(rs.getInt(position));
				}

				if (columns.contains("mot." + FuncionarioEnum.APELIDO.getNome() + " as nome_motorista")) {
					position++;
					schedule.setMotorista(rs.getString(position));
				}

				if (columns.contains("cob." + FuncionarioEnum.APELIDO.getNome() + " as nome_cobrador")) {
					position++;
					schedule.setCobrador(rs.getString(position));
				}

				if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {
					position++;
					schedule.setGaragem(rs.getString(position));
				}

				list.add(schedule);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<LinhaModel> getLineTable(List<String> columns) {

		List<LinhaModel> list = new ArrayList<LinhaModel>();
		ResultSet rs = reportPersistence.getLineTable(columns);

		try {
			while (rs.next()) {
				int position = 0;
				LinhaModel line = new LinhaModel();

				if (columns.contains(LinhaEnum.ID.getNome())) {
					position++;
					line.setId(rs.getInt(position));
				}

				if (columns.contains(LinhaEnum.NUMERO.getNome())) {
					position++;
					line.setLinha(rs.getString(position));
				}

				if (columns.contains(LinhaEnum.NOME.getNome())) {
					position++;
					line.setNome(rs.getString(position));
				}

				if (columns.contains(LinhaEnum.IDA.getNome())) {
					position++;
					line.setIda(rs.getString(position));
				}

				if (columns.contains(LinhaEnum.VOLTA.getNome())) {
					position++;
					line.setVolta(rs.getString(position));
				}

				list.add(line);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<UsuarioModel> getUserTable(List<String> columns) {

		List<UsuarioModel> list = new ArrayList<UsuarioModel>();
		ResultSet rs = reportPersistence.getUserTable(columns);
		String permissions = UsuarioEnum.CADASTRAR_USUARIO.getNome() + " , " + UsuarioEnum.CADASTRAR_CARRO.getNome()
				+ " , " + UsuarioEnum.CADASTRAR_GARAGEM.getNome() + " , " + UsuarioEnum.CADASTRAR_LINHA.getNome()
				+ " , " + UsuarioEnum.CADASTRAR_TIPO_CARRO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EDITAR_USUARIO.getNome() + " , "
				+ UsuarioEnum.EDITAR_CARRO.getNome() + " , " + UsuarioEnum.EDITAR_GARAGEM.getNome() + " , "
				+ UsuarioEnum.EDITAR_LINHA.getNome() + " , " + UsuarioEnum.EDITAR_TIPO_CARRO.getNome() + " , "
				+ UsuarioEnum.EDITAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EMITIR_RELATORIO.getNome() + " , "
				+ UsuarioEnum.CADASTRAR_EDITAR_HORARIO.getNome() + " , " + UsuarioEnum.DAR_PERMISSAO_USUARIO.getNome()
				+ " , " + UsuarioEnum.EXCLUIR_USUARIO.getNome() + " , "
				+ UsuarioEnum.ATIVAR_DESATIVAR_USUARIO.getNome();

		try {
			while (rs.next()) {
				int position = 0;
				UsuarioModel user = new UsuarioModel();

				if (columns.contains(UsuarioEnum.ID.getNome())) {
					position++;
					user.setId(rs.getInt(position));
				}

				if (columns.contains(UsuarioEnum.LOGIN.getNome())) {
					position++;
					user.setLogin(rs.getString(position));
				}

				if (columns.contains(UsuarioEnum.NOME.getNome())) {
					position++;
					user.setNome(rs.getString(position));
				}

				if (columns.contains(UsuarioEnum.SOBRENOME.getNome())) {
					position++;
					user.setSobrenome(rs.getString(position));
				}

				if (columns.contains(permissions)) {
					position++;
					user.setCad_user(rs.getBoolean(position));
					position++;
					user.setCad_car(rs.getBoolean(position));
					position++;
					user.setCad_gar(rs.getBoolean(position));
					position++;
					user.setCad_lin(rs.getBoolean(position));
					position++;
					user.setCad_tip_car(rs.getBoolean(position));
					position++;
					user.setCad_fun(rs.getBoolean(position));
					position++;
					user.setEd_user(rs.getBoolean(position));
					position++;
					user.setEd_car(rs.getBoolean(position));
					position++;
					user.setEd_gar(rs.getBoolean(position));
					position++;
					user.setEd_lin(rs.getBoolean(position));
					position++;
					user.setEd_tip_car(rs.getBoolean(position));
					position++;
					user.setEd_fun(rs.getBoolean(position));
					position++;
					user.setEm_rel(rs.getBoolean(position));
					position++;
					user.setCad_ed_hor(rs.getBoolean(position));
					position++;
					user.setPerm_user(rs.getBoolean(position));
					position++;
					user.setExc_user(rs.getBoolean(position));
					position++;
					user.setAt_des_user(rs.getBoolean(position));

				}

				if (columns.contains(UsuarioEnum.STATUS.getNome())) {
					position++;
					user.setStatus(rs.getBoolean(position));
				}

				list.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<TipoCarroModel> getCarTypeTable(List<String> columns) {

		List<TipoCarroModel> list = new ArrayList<TipoCarroModel>();
		ResultSet rs = reportPersistence.getCarTypeTable(columns);

		try {
			while (rs.next()) {
				int position = 0;
				TipoCarroModel carType = new TipoCarroModel();

				if (columns.contains(TipoCarroEnum.ID.getNome())) {
					position++;
					carType.setId(rs.getInt(position));
				}

				if (columns.contains(TipoCarroEnum.NOME.getNome())) {
					position++;
					carType.setNome(rs.getString(position));
				}

				if (columns.contains(TipoCarroEnum.LARGURA.getNome())) {
					position++;
					carType.setLargura(rs.getDouble(position));
				}

				if (columns.contains(TipoCarroEnum.COMPRIMENTO.getNome())) {
					position++;
					carType.setComprimento(rs.getDouble(position));
				}

				if (columns.contains(TipoCarroEnum.ALTURA.getNome())) {
					position++;
					carType.setAltura(rs.getDouble(position));
				}

				if (columns.contains(TipoCarroEnum.PESO.getNome())) {
					position++;
					carType.setPeso(rs.getDouble(position));
				}
				list.add(carType);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<HorarioModel> employeeSchedule(int employee) {

		List<HorarioModel> list = new ArrayList<HorarioModel>();

		ResultSet rs = reportPersistence.employeeSchedule(employee);
		try {
			while (rs.next()) {

				HorarioModel schedule = new HorarioModel();
				schedule.setCarro(rs.getString(1));
				schedule.setLinha(rs.getString(2));
				schedule.setDia(rs.getString(3));
				schedule.setHora(rs.getString(4));
				schedule.setGaragem(rs.getString(5));

				list.add(schedule);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	@Override
	public Object[][] generateEmployeeScheduleList(List<HorarioModel> list) {

		Object[][] ob = new Object[list.size()][5];

		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = list.get(i).getCarro();
			ob[i][1] = list.get(i).getLinha();
			ob[i][2] = list.get(i).getDia();
			ob[i][3] = list.get(i).getHora();
			ob[i][4] = list.get(i).getGaragem();

		}

		return ob;

	}

	@Override
	public GaragemModel getDataGarage(int id) {

		ResultSet rs = reportPersistence.getDataGarage(id);
		GaragemModel garage = new GaragemModel();

		try {
			rs.next();

			garage.setLargura(rs.getDouble(1));
			garage.setComprimento(rs.getDouble(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return garage;

	}

	@Override
	public List<RelatorioModel> getBusListOfGarage(int id, int param, int day) {
		ResultSet rs = reportPersistence.getBusListOfGarage(id, param, day);
		List<RelatorioModel> list = new ArrayList<RelatorioModel>();

		try {
			while (rs.next()) {
				RelatorioModel report = new RelatorioModel();
				report.setDia(rs.getString(1));
				report.setHora(rs.getString(2));
				report.setLinha(rs.getString(3));
				report.setCarro(rs.getInt(4));
				report.setMotorista(rs.getString(5));
				report.setCobrador(rs.getString(6));
				report.setLargura(rs.getDouble(7));
				report.setComprimento(rs.getDouble(8));

				list.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public List<String> listOfGarage() {

		return scheduleService.listOfGarage();
	}

	@Override
	public Object[][] generateScheduleList(List<RelatorioModel> list) {

		Object[][] ob = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			ob[i][0] = (i + 1);
			ob[i][1] = list.get(i).getCarro();
			ob[i][2] = list.get(i).getLinha();
			ob[i][3] = list.get(i).getMotorista();
			ob[i][4] = list.get(i).getCobrador();
			ob[i][5] = list.get(i).getHora();

		}

		return ob;

	}

}

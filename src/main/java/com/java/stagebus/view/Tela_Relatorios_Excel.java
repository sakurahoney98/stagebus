package com.java.stagebus.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.model.UsuarioModel;

public class Tela_Relatorios_Excel {

	private static List<CarroModel> listCar = new ArrayList<CarroModel>();
	private static List<FuncionarioModel> listEmployee = new ArrayList<FuncionarioModel>();
	private static List<GaragemModel> listGarage = new ArrayList<GaragemModel>();
	private static List<HorarioModel> listSchedule = new ArrayList<HorarioModel>();
	private static List<LinhaModel> listLine = new ArrayList<LinhaModel>();
	private static List<UsuarioModel> listUser = new ArrayList<UsuarioModel>();
	private static List<TipoCarroModel> listCarType = new ArrayList<TipoCarroModel>();
	private static List<String> header = new ArrayList<String>();
	private static List<String> columns = new ArrayList<String>();
	private static int param;

	public static void setParam(int i) {
		param = i;
	}

	public static void setHeader(List<String> l) {

		header = l;
	}

	public static void setColumns(List<String> l) {

		columns = l;
	}

	public static void setListCar(List<CarroModel> l) {

		listCar = l;
	}

	public static void setListEmployee(List<FuncionarioModel> l) {

		listEmployee = l;
	}

	public static void setListGarage(List<GaragemModel> l) {

		listGarage = l;
	}

	public static void setListSchedule(List<HorarioModel> l) {

		listSchedule = l;
	}

	public static void setListLine(List<LinhaModel> l) {

		listLine = l;
	}

	public static void setListUser(List<UsuarioModel> l) {

		listUser = l;
	}

	public static void setListCarType(List<TipoCarroModel> l) {

		listCarType = l;
	}

	public static void main(String[] args) {
		Workbook workbook = new XSSFWorkbook();
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

		String permissionsHeader = UsuarioEnum.CADASTRAR_USUARIO + " , " + UsuarioEnum.CADASTRAR_CARRO + " , "
				+ UsuarioEnum.CADASTRAR_GARAGEM + " , " + UsuarioEnum.CADASTRAR_LINHA + " , "
				+ UsuarioEnum.CADASTRAR_TIPO_CARRO + " , " + UsuarioEnum.CADASTRAR_FUNCIONARIO + " , "
				+ UsuarioEnum.EDITAR_USUARIO + " , " + UsuarioEnum.EDITAR_CARRO + " , " + UsuarioEnum.EDITAR_GARAGEM
				+ " , " + UsuarioEnum.EDITAR_LINHA + " , " + UsuarioEnum.EDITAR_TIPO_CARRO + " , "
				+ UsuarioEnum.EDITAR_FUNCIONARIO + " , " + UsuarioEnum.EMITIR_RELATORIO + " , "
				+ UsuarioEnum.CADASTRAR_EDITAR_HORARIO + " , " + UsuarioEnum.DAR_PERMISSAO_USUARIO + " , "
				+ UsuarioEnum.EXCLUIR_USUARIO + " , " + UsuarioEnum.ATIVAR_DESATIVAR_USUARIO;
		try {

			String file = salvarArquivo();

			// Criar uma planilha
			Sheet sheet = workbook.createSheet("Relatórios");

			// Criar a primeira linha do cabeçalho
			Row headerRow = sheet.createRow(0);

			if (param == 6 && columns.contains(permissions)) {
				List<String> aux = new ArrayList<String>();
				while (permissionsHeader.indexOf(",") > -1) {
					int end = permissionsHeader.indexOf(",");
					aux.add(permissionsHeader.substring(0, end));
					permissionsHeader = permissionsHeader.substring((end + 2));
				}
				aux.add(permissionsHeader);

				List<String> aux2 = new ArrayList<String>();
				aux2.addAll(header);

				header.clear();

				int pos = 0;
				if (columns.contains(UsuarioEnum.ID.getNome())) {
					header.add(aux2.get(pos));
					pos++;
				}
				if (columns.contains(UsuarioEnum.LOGIN.getNome())) {
					header.add(aux2.get(pos));
					pos++;
				}
				if (columns.contains(UsuarioEnum.NOME.getNome())) {
					header.add(aux2.get(pos));
					pos++;
				}
				if (columns.contains(UsuarioEnum.SOBRENOME.getNome())) {
					header.add(aux2.get(pos));
					pos++;
				}

				header.addAll(aux);
				pos++;

				if (columns.contains(UsuarioEnum.STATUS.getNome()))
					header.add(aux2.get(pos));

			}

			// Adiciona células à tabela (exemplo)
			for (int i = 0; i < header.size(); i++) {

				// Criar cabeçalhos de coluna
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(header.get(i));
			}

			switch (param) {
			case 1:
				for (int i = 0; i < listCar.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(CarroEnum.ID.getNome())) {
						dataRow.createCell(position).setCellValue(listCar.get(i).getNumero());
						position++;
					}

					if (columns.contains(CarroEnum.NOME.getNome())) {
						dataRow.createCell(position).setCellValue(listCar.get(i).getNome());
						position++;

					}

					if (columns.contains(CarroEnum.PLACA.getNome())) {
						dataRow.createCell(position).setCellValue(listCar.get(i).getPlaca());
						position++;
					}

					if (columns.contains(TipoCarroEnum.TABELA.getNome() + "." + TipoCarroEnum.NOME.getNome())) {
						dataRow.createCell(position).setCellValue(listCar.get(i).getTipo());
						position++;
					}

					if (columns.contains(StatusEnum.TABELA.getNome() + "." + StatusEnum.DESCRICAO.getNome())) {
						dataRow.createCell(position).setCellValue(listCar.get(i).getStatus());
						position++;
					}

					if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {
						dataRow.createCell(position).setCellValue(listCar.get(i).getGaragem());
						position++;
					}

				}

				break;

			case 2:
				for (int i = 0; i < listEmployee.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(FuncionarioEnum.ID.getNome())) {
						dataRow.createCell(position).setCellValue(listEmployee.get(i).getId());
						position++;
					}

					if (columns.contains(FuncionarioEnum.NOME.getNome())) {
						dataRow.createCell(position).setCellValue(listEmployee.get(i).getNome());
						position++;

					}

					if (columns.contains(FuncionarioEnum.APELIDO.getNome())) {
						dataRow.createCell(position).setCellValue(listEmployee.get(i).getApelido());
						position++;
					}

					if (columns.contains(
							TipoFuncionarioEnum.TABELA.getNome() + "." + TipoFuncionarioEnum.DESCRICAO.getNome())) {
						dataRow.createCell(position).setCellValue(listEmployee.get(i).getTipo());
						position++;
					}

					if (columns.contains(FuncionarioEnum.MATRICULA.getNome())) {
						dataRow.createCell(position).setCellValue(listEmployee.get(i).getMatricula());
						position++;
					}

				}

				break;

			case 3:
				for (int i = 0; i < listGarage.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(GaragemEnum.ID.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getId());
						position++;
					}

					if (columns.contains(GaragemEnum.NOME.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getNome());
						position++;
					}

					if (columns.contains(GaragemEnum.LARGURA.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getLargura());
						position++;
					}

					if (columns.contains(GaragemEnum.COMPRIMENTO.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getComprimento());
						position++;
					}

					if (columns.contains(GaragemEnum.ALTURA.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getAltura());
						position++;
					}

					if (columns.contains(GaragemEnum.RESPONSAVEL.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getResponsavel());
						position++;
					}

					if (columns.contains(GaragemEnum.LOCAL.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getLocal());
						position++;
					}

					if (columns.contains(GaragemEnum.MAXIMO.getNome())) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getMax());
						position++;
					}

					if (columns.contains(
							"COUNT (" + CarroEnum.TABELA.getNome() + "." + CarroEnum.GARAGEM.getNome() + ")")) {

						dataRow.createCell(position).setCellValue(listGarage.get(i).getOnibus());
						position++;
					}

				}

				break;

			case 4:
				for (int i = 0; i < listSchedule.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome())) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getDia());
						position++;
					}

					if (columns.contains(HorarioEnum.HORA.getNome())) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getHora());
						position++;
					}

					if (columns.contains("num." + LinhaEnum.NUMERO.getNome())) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getNum_linha());
						position++;
					}

					if (columns.contains("nome." + LinhaEnum.NOME.getNome())) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getLinha());
						position++;
					}

					if (columns.contains(HorarioEnum.CARRO.getNome())) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getIdCarro());
						position++;
					}

					if (columns.contains("mot." + FuncionarioEnum.APELIDO.getNome() + " as nome_motorista")) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getMotorista());
						position++;
					}

					if (columns.contains("cob." + FuncionarioEnum.APELIDO.getNome() + " as nome_cobrador")) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getCobrador());
						position++;
					}

					if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {

						dataRow.createCell(position).setCellValue(listSchedule.get(i).getGaragem());
						position++;
					}

				}

				break;

			case 5:
				for (int i = 0; i < listLine.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(LinhaEnum.ID.getNome())) {

						dataRow.createCell(position).setCellValue(listLine.get(i).getId());
						position++;
					}

					if (columns.contains(LinhaEnum.NUMERO.getNome())) {

						dataRow.createCell(position).setCellValue(listLine.get(i).getLinha());
						position++;
					}

					if (columns.contains(LinhaEnum.NOME.getNome())) {

						dataRow.createCell(position).setCellValue(listLine.get(i).getNome());
						position++;
					}

					if (columns.contains(LinhaEnum.IDA.getNome())) {

						dataRow.createCell(position).setCellValue(listLine.get(i).getIda());
						position++;
					}

					if (columns.contains(LinhaEnum.VOLTA.getNome())) {

						dataRow.createCell(position).setCellValue(listLine.get(i).getVolta());
						position++;
					}

				}

				break;

			case 6:
				for (int i = 0; i < listUser.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(UsuarioEnum.ID.getNome())) {

						dataRow.createCell(position).setCellValue(listUser.get(i).getId());
						position++;
					}

					if (columns.contains(UsuarioEnum.LOGIN.getNome())) {

						dataRow.createCell(position).setCellValue(listUser.get(i).getLogin());
						position++;
					}

					if (columns.contains(UsuarioEnum.NOME.getNome())) {

						dataRow.createCell(position).setCellValue(listUser.get(i).getNome());
						position++;
					}

					if (columns.contains(UsuarioEnum.SOBRENOME.getNome())) {

						dataRow.createCell(position).setCellValue(listUser.get(i).getSobrenome());
						position++;
					}

					if (columns.contains(permissions)) {

						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_user() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_car() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_gar() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_lin() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_tip_car() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_fun() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEd_user() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEd_car() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEd_gar() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEd_lin() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEd_tip_car() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEd_fun() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isEm_rel() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isCad_ed_hor() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isPerm_user() ? "SIM" : "NÃO");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isExc_user() ? "X" : "");
						position++;
						dataRow.createCell(position).setCellValue(listUser.get(i).isAt_des_user() ? "X" : "");
						position++;
					}
					if (columns.contains(UsuarioEnum.STATUS.getNome())) {

						dataRow.createCell(position).setCellValue(listUser.get(i).isStatus() ? "ATIVO" : "INATIVO");
						position++;
					}

				}

				break;

			case 7:
				for (int i = 0; i < listCarType.size(); i++) {
					Row dataRow = sheet.createRow((i + 1));
					int position = 0;

					if (columns.contains(TipoCarroEnum.ID.getNome())) {

						dataRow.createCell(position).setCellValue(listCarType.get(i).getId());
						position++;
					}

					if (columns.contains(TipoCarroEnum.NOME.getNome())) {

						dataRow.createCell(position).setCellValue(listCarType.get(i).getNome());
						position++;
					}

					if (columns.contains(TipoCarroEnum.LARGURA.getNome())) {

						dataRow.createCell(position).setCellValue(listCarType.get(i).getLargura());
						position++;
					}

					if (columns.contains(TipoCarroEnum.COMPRIMENTO.getNome())) {

						dataRow.createCell(position).setCellValue(listCarType.get(i).getComprimento());
						position++;
					}
					if (columns.contains(TipoCarroEnum.ALTURA.getNome())) {

						dataRow.createCell(position).setCellValue(listCarType.get(i).getAltura());
						position++;
					}
					if (columns.contains(TipoCarroEnum.PESO.getNome())) {

						dataRow.createCell(position).setCellValue(listCarType.get(i).getPeso());
						position++;
					}
				}

				break;

			default:
				break;
			}

			try (FileOutputStream fileOut = new FileOutputStream(file)) {
				workbook.write(fileOut);

			}

			openExccel(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String salvarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos do Excel", "xls", "xlsx");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			// Verifique se o arquivo possui a extensão desejada (xls ou xlsx)
			String filePath = selectedFile.getAbsolutePath();
			if (!filePath.toLowerCase().endsWith(".xls") && !filePath.toLowerCase().endsWith(".xlsx")) {
				// Adiciona a extensão .xls se não estiver presente
				filePath += ".xlsx";
			}

			return filePath;
		} else {
			return null; // Usuário cancelou a operação
		}
	}

	private static void openExccel(String filePath) {
		try {
			File file = new File(filePath);
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

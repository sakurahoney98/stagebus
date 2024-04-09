package com.java.stagebus.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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

public class Tela_Relatorios_PDF {

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

		try {
			Document document = new Document(PageSize.A4);
			String file = salvarArquivo();
			PdfWriter.getInstance(document, new FileOutputStream(file));

			document.open();

			// Adiciona uma tabela
			PdfPTable table = new PdfPTable(header.size());
			table.setWidthPercentage(100);

			// Adiciona células à tabela (exemplo)
			for (String s : header) {
				Paragraph paragraph = new Paragraph();
				float tam = 0f;
				if (header.size() > 4)
					tam = 8f;
				else
					tam = 10f;

				paragraph.setFont(new Font(FontFamily.HELVETICA, tam, Font.BOLD, new BaseColor(255, 255, 255)));
				paragraph.add(s);
				PdfPCell cell = new PdfPCell();
				cell.setBackgroundColor(new BaseColor(68, 114, 196));
				cell.addElement(paragraph);
				table.addCell(cell);
			}
			List<Float> widthColumns = new ArrayList<Float>();

			float percent;
			int amountColumns = header.size();
			switch (param) {

			case 1:
				if (columns.contains(CarroEnum.ID.getNome())) {
					percent = 0.09f;
					widthColumns.add((percent * amountColumns));

				}

				if (columns.contains(CarroEnum.NOME.getNome())) {
					percent = 0.4f;
					widthColumns.add((percent * amountColumns));

				}

				if (columns.contains(CarroEnum.PLACA.getNome())) {
					percent = 0.09f;
					widthColumns.add((percent * amountColumns));

				}
				if (columns.contains(TipoCarroEnum.TABELA.getNome() + "." + TipoCarroEnum.NOME.getNome())) {
					percent = 0.14f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(StatusEnum.TABELA.getNome() + "." + StatusEnum.DESCRICAO.getNome())) {
					percent = 0.14f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {
					percent = 0.14f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listCar.size(); i++) {

					if (columns.contains(CarroEnum.ID.getNome())) {

						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listCar.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listCar.get(i).getNumero()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

					}

					if (columns.contains(CarroEnum.NOME.getNome())) {

						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listCar.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listCar.get(i).getNome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

					}

					if (columns.contains(CarroEnum.PLACA.getNome())) {

						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listCar.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listCar.get(i).getPlaca());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

					}
					if (columns.contains(TipoCarroEnum.TABELA.getNome() + "." + TipoCarroEnum.NOME.getNome())) {

						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listCar.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listCar.get(i).getTipo());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

					}

					if (columns.contains(StatusEnum.TABELA.getNome() + "." + StatusEnum.DESCRICAO.getNome())) {

						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listCar.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listCar.get(i).getStatus());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

					}

					if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {

						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listCar.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listCar.get(i).getGaragem());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

					}

				}

				break;

			case 2:

				if (columns.contains(FuncionarioEnum.ID.getNome())) {
					percent = 0.1f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(FuncionarioEnum.NOME.getNome())) {
					percent = 0.35f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(FuncionarioEnum.APELIDO.getNome())) {
					percent = 0.2f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(
						TipoFuncionarioEnum.TABELA.getNome() + "." + TipoFuncionarioEnum.DESCRICAO.getNome())) {
					percent = 0.2f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(FuncionarioEnum.MATRICULA.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listEmployee.size(); i++) {

					if (columns.contains(FuncionarioEnum.ID.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listEmployee.get(i).getId()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}

					if (columns.contains(FuncionarioEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listEmployee.get(i).getNome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}

					if (columns.contains(FuncionarioEnum.APELIDO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listEmployee.get(i).getApelido());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}

					if (columns.contains(
							TipoFuncionarioEnum.TABELA.getNome() + "." + TipoFuncionarioEnum.DESCRICAO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listEmployee.get(i).getTipo());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}

					if (columns.contains(FuncionarioEnum.MATRICULA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listEmployee.get(i).getMatricula());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}

				}

				break;

			case 3:

				if (columns.contains(GaragemEnum.ID.getNome())) {
					percent = 0.07f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.NOME.getNome())) {
					percent = 0.25f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.LARGURA.getNome())) {
					percent = 0.07f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.COMPRIMENTO.getNome())) {
					percent = 0.07f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.ALTURA.getNome())) {
					percent = 0.07f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.RESPONSAVEL.getNome())) {
					percent = 0.2f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.LOCAL.getNome())) {
					percent = 0.2f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.MAXIMO.getNome())) {
					percent = 0.07f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns
						.contains("COUNT (" + CarroEnum.TABELA.getNome() + "." + CarroEnum.GARAGEM.getNome() + ")")) {
					percent = 0.07f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listGarage.size(); i++) {

					if (columns.contains(GaragemEnum.ID.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listGarage.get(i).getId()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listGarage.get(i).getNome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.LARGURA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listGarage.get(i).getLargura()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
					

					if (columns.contains(GaragemEnum.COMPRIMENTO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listGarage.get(i).getComprimento()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.ALTURA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listGarage.get(i).getAltura()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.RESPONSAVEL.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listGarage.get(i).getResponsavel());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.LOCAL.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listGarage.get(i).getLocal());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.MAXIMO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listGarage.get(i).getMax()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns
							.contains("COUNT (" + CarroEnum.TABELA.getNome() + "." + CarroEnum.GARAGEM.getNome() + ")")) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listGarage.get(i).getOnibus()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						
				}

				break;

			case 4:

				if (columns.contains(DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome())) {
					percent = 0.11f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(HorarioEnum.HORA.getNome())) {
					percent = 0.08f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains("num." + LinhaEnum.NUMERO.getNome())) {
					percent = 0.08f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains("nome." + LinhaEnum.NOME.getNome())) {
					percent = 0.29f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(HorarioEnum.CARRO.getNome())) {
					percent = 0.08f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains("mot." + FuncionarioEnum.APELIDO.getNome() + " as nome_motorista")) {
					percent = 0.12f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains("cob." + FuncionarioEnum.APELIDO.getNome() + " as nome_cobrador")) {
					percent = 0.12f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {
					percent = 0.12f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listSchedule.size(); i++) {

					if (columns.contains(DiaEnum.TABELA.getNome() + "." + DiaEnum.DESCRICAO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getDia());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
					

					if (columns.contains(HorarioEnum.HORA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getHora());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains("num." + LinhaEnum.NUMERO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getNum_linha());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains("nome." + LinhaEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getLinha());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(HorarioEnum.CARRO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listSchedule.get(i).getIdCarro()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains("mot." + FuncionarioEnum.APELIDO.getNome() + " as nome_motorista")) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getMotorista());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains("cob." + FuncionarioEnum.APELIDO.getNome() + " as nome_cobrador")) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getCobrador());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(GaragemEnum.TABELA.getNome() + "." + GaragemEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listSchedule.get(i).getGaragem());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

				}

				break;

			case 5:

				if (columns.contains(LinhaEnum.ID.getNome())) {
					percent = 0.1f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(LinhaEnum.NUMERO.getNome())) {
					percent = 0.1f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(LinhaEnum.NOME.getNome())) {
					percent = 0.2f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(LinhaEnum.IDA.getNome())) {
					percent = 0.3f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(LinhaEnum.VOLTA.getNome())) {
					percent = 0.3f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listLine.size(); i++) {

					if (columns.contains(LinhaEnum.ID.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listLine.get(i).getId()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(LinhaEnum.NUMERO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listLine.get(i).getLinha());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(LinhaEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listLine.get(i).getNome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(LinhaEnum.IDA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listLine.get(i).getIda());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(LinhaEnum.VOLTA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listLine.get(i).getVolta());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

				}

				break;

			case 6:
				String permissions = UsuarioEnum.CADASTRAR_USUARIO.getNome() + " , "
						+ UsuarioEnum.CADASTRAR_CARRO.getNome() + " , " + UsuarioEnum.CADASTRAR_GARAGEM.getNome()
						+ " , " + UsuarioEnum.CADASTRAR_LINHA.getNome() + " , "
						+ UsuarioEnum.CADASTRAR_TIPO_CARRO.getNome() + " , "
						+ UsuarioEnum.CADASTRAR_FUNCIONARIO.getNome() + " , " + UsuarioEnum.EDITAR_USUARIO.getNome()
						+ " , " + UsuarioEnum.EDITAR_CARRO.getNome() + " , " + UsuarioEnum.EDITAR_GARAGEM.getNome()
						+ " , " + UsuarioEnum.EDITAR_LINHA.getNome() + " , " + UsuarioEnum.EDITAR_TIPO_CARRO.getNome()
						+ " , " + UsuarioEnum.EDITAR_FUNCIONARIO.getNome() + " , "
						+ UsuarioEnum.EMITIR_RELATORIO.getNome() + " , "
						+ UsuarioEnum.CADASTRAR_EDITAR_HORARIO.getNome() + " , "
						+ UsuarioEnum.DAR_PERMISSAO_USUARIO.getNome() + " , " + UsuarioEnum.EXCLUIR_USUARIO.getNome()
						+ " , " + UsuarioEnum.ATIVAR_DESATIVAR_USUARIO.getNome();

				if (columns.contains(UsuarioEnum.ID.getNome())) {
					percent = 0.08f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(UsuarioEnum.LOGIN.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(UsuarioEnum.NOME.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(UsuarioEnum.SOBRENOME.getNome())) {
					percent = 0.2f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(permissions)) {
					percent = 0.32f;
					widthColumns.add((percent * amountColumns));
				}
				if (columns.contains(UsuarioEnum.STATUS.getNome())) {
					percent = 0.1f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listUser.size(); i++) {

					if (columns.contains(UsuarioEnum.ID.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listUser.get(i).getId()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(UsuarioEnum.LOGIN.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listUser.get(i).getLogin());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(UsuarioEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listUser.get(i).getNome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(UsuarioEnum.SOBRENOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listUser.get(i).getSobrenome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(permissions)) {
						Paragraph paragraph = new Paragraph();

						if (listUser.get(i).isCad_user()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_USUARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0, 1).toUpperCase()
									+ headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isCad_car()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_CARRO).replaceAll("_", " ");
							headerAux = headerAux.substring(0, 1).toUpperCase()
									+ headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isCad_gar()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_GARAGEM).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isCad_lin()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_LINHA).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isCad_tip_car()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_TIPO_CARRO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isCad_fun()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_FUNCIONARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isEd_user()) {
							String headerAux = String.valueOf(UsuarioEnum.EDITAR_USUARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isEd_car()) {
							String headerAux = String.valueOf(UsuarioEnum.EDITAR_CARRO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isEd_gar()) {
							String headerAux = String.valueOf(UsuarioEnum.EDITAR_GARAGEM).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isEd_lin()) {
							String headerAux = String.valueOf(UsuarioEnum.EDITAR_LINHA).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}

						if (listUser.get(i).isEd_tip_car()) {
							String headerAux = String.valueOf(UsuarioEnum.EDITAR_TIPO_CARRO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isEd_fun()) {
							String headerAux = String.valueOf(UsuarioEnum.EDITAR_FUNCIONARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isEm_rel()) {
							String headerAux = String.valueOf(UsuarioEnum.EMITIR_RELATORIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isCad_ed_hor()) {
							String headerAux = String.valueOf(UsuarioEnum.CADASTRAR_EDITAR_HORARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isPerm_user()) {
							String headerAux = String.valueOf(UsuarioEnum.DAR_PERMISSAO_USUARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isExc_user()) {
							String headerAux = String.valueOf(UsuarioEnum.EXCLUIR_USUARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						if (listUser.get(i).isAt_des_user()) {
							String headerAux = String.valueOf(UsuarioEnum.ATIVAR_DESATIVAR_USUARIO).replaceAll("_", " ");
							headerAux = headerAux.substring(0,1).toUpperCase() + headerAux.substring(1, headerAux.length()).toLowerCase();
							paragraph.add(headerAux);
							paragraph.add("\n");
						}
						PdfPCell cell = new PdfPCell();
						
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);

						
					}
					if (columns.contains(UsuarioEnum.STATUS.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listUser.get(i).isStatus() ? "ATIVO" : "INATIVO");
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}

						

				}

				break;

			case 7:

				if (columns.contains(TipoCarroEnum.ID.getNome())) {
					percent = 0.1f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(TipoCarroEnum.NOME.getNome())) {
					percent = 0.6f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(TipoCarroEnum.LARGURA.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(TipoCarroEnum.COMPRIMENTO.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(TipoCarroEnum.ALTURA.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				if (columns.contains(TipoCarroEnum.PESO.getNome())) {
					percent = 0.15f;
					widthColumns.add((percent * amountColumns));
				}

				for (int i = 0; i < listCarType.size(); i++) {
					if (columns.contains(TipoCarroEnum.ID.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listCarType.get(i).getId()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(TipoCarroEnum.NOME.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(listCarType.get(i).getNome());
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(TipoCarroEnum.LARGURA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listCarType.get(i).getLargura()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
					

					if (columns.contains(TipoCarroEnum.COMPRIMENTO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listCarType.get(i).getComprimento()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(TipoCarroEnum.ALTURA.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listCarType.get(i).getAltura()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

					if (columns.contains(TipoCarroEnum.PESO.getNome())) {
						PdfPCell cell = new PdfPCell();
						Paragraph paragraph = new Paragraph();
						if (listEmployee.size() > 4)
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8));
						else
							paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
						paragraph.add(String.valueOf(listCarType.get(i).getPeso()));
						if (i % 2 == 0)
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
						else
							cell.setBackgroundColor(new BaseColor(207, 213, 234));
						cell.addElement(paragraph);
						table.addCell(cell);
					}
						

				}

				break;

			default:
				break;
			}

			float[] colsWidth = new float[amountColumns];
			for (int i = 0; i < widthColumns.size(); i++)
				colsWidth[i] = widthColumns.get(i);

			table.setWidths(colsWidth);

			widthColumns.clear();

			// Adiciona a tabela ao documento
			document.add(table);

			document.close();

			openPDF(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String salvarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos PDF", "pdf");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			// Verifique se o arquivo possui a extensão desejada (por exemplo, .pdf)
			String filePath = selectedFile.getAbsolutePath();
			if (!filePath.toLowerCase().endsWith(".pdf")) {
				filePath += ".pdf";
			}

			return filePath;
		} else {
			return null; // Usuário cancelou a operação
		}
	}

	private static void openPDF(String filePath) {
		try {
			File file = new File(filePath);
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

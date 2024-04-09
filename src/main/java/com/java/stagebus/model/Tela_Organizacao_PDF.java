package com.java.stagebus.model;

import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.stagebus.model.RelatorioModel;

public class Tela_Organizacao_PDF {
	private static JFrame frame;
	private static List<RelatorioModel> listSchedules = new ArrayList<RelatorioModel>();
	private static boolean view = false;
	private static boolean list = true;
	private Graphics2D gResizedTest;
	
	public static void setView(boolean b) {
		
		view = b;
	}
	
public static void setList(boolean b) {
		
		list = b;
	}
	
	public static void setFrame(JFrame j) {
		
		frame = j;
	}
	
	public static void setListSchedules(List<RelatorioModel> l) {
		
		listSchedules = l;
	}

	 public static void main(String[] args) {
		 BufferedImage croppedImage = null;
		 Image resizedImage = null;
		 BufferedImage originalImage = null;
	     if(view) {  
		 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 1000);
	        frame.setVisible(true);

	        // Espera um pouco para garantir que o JFrame foi totalmente renderizado
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Captura o JFrame como uma imagem
	        originalImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g = originalImage.createGraphics();
	        frame.paint(g);
	        g.dispose();
	        frame.dispose();

	        // Redimensiona a imagem para 800x700
	        int targetWidth = 1400;
	        int targetHeight = 900;
	        resizedImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

	        // Converte a imagem redimensionada para BufferedImage
	        BufferedImage resizedBufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D gResized = resizedBufferedImage.createGraphics();
	        gResized.drawImage(resizedImage, 0, 0, null);
	        gResized.dispose();

	        // Corta a imagem para 700x700 a partir da posição (50, 0)
	       croppedImage  = resizedBufferedImage.getSubimage(50, 0, 700, 700);
	     }
	        // Adiciona a imagem cortada a um documento PDF
	        try {
	            Document document = new Document(PageSize.A4); // Use A4 ou outro tamanho desejado
	            String file = salvarArquivo();
	            PdfWriter.getInstance(document, new FileOutputStream(file));

	            document.open();
if(view) {
	            com.itextpdf.text.Image pdfImage = com.itextpdf.text.Image.getInstance(croppedImage, null);

	            // Define a posição absoluta da imagem no PDF (aqui, 100, 500 são coordenadas X e Y)
	            pdfImage.setAbsolutePosition(-50f, 50f);

	            document.add(pdfImage);
	            
	         // Adiciona uma nova página para a tabela
	            document.newPage();
	            
	            pdfImage = com.itextpdf.text.Image.getInstance(resizedImage, null);

	            // Define a posição absoluta da imagem no PDF (aqui, 100, 500 são coordenadas X e Y)
	            pdfImage.setAbsolutePosition(-50f, 50f);

	            document.add(pdfImage);
	            
	            // Adiciona uma nova página para a tabela
	            document.newPage();
	            
	            pdfImage = com.itextpdf.text.Image.getInstance(originalImage, null);

	            // Define a posição absoluta da imagem no PDF (aqui, 100, 500 são coordenadas X e Y)
	            pdfImage.setAbsolutePosition(-50f, 50f);

	            document.add(pdfImage);

	            if(list)
	            // Adiciona uma nova página para a tabela
	            document.newPage();
}
if(list) {
	            // Adiciona uma tabela à segunda página
	            PdfPTable table = new PdfPTable(6); // 3 colunas
	            table.setWidthPercentage(100);

	            // Adiciona células à tabela (exemplo)
	            table.addCell("Num");
	            table.addCell("Carro");
	            table.addCell("Linha");
	            table.addCell("Motorista");
	            table.addCell("Cobrador");
	            table.addCell("Hora");

	            for(int i = 0; i < listSchedules.size(); i++) {
	            	table.addCell(String.valueOf((i + 1)));
	            	table.addCell(String.valueOf(listSchedules.get(i).getCarro()));
	            	table.addCell(listSchedules.get(i).getLinha());
	            	table.addCell(listSchedules.get(i).getMotorista());
	            	table.addCell(listSchedules.get(i).getCobrador());
	            	table.addCell(listSchedules.get(i).getHora());
	            }

	            // Adiciona a tabela ao documento
	            document.add(table);
}
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

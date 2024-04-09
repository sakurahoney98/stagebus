package com.java.stagebus.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
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
		 
		
		 BufferedImage originalImage = null;
	     if(view) {  
		 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 1000);
	        frame.setVisible(true);
	        frame.setBackground(Color.WHITE);
	        

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
 g.setColor(Color.WHITE);
            g.fillRect(0, 0, originalImage.getWidth(), originalImage.getHeight());
            g.drawImage(originalImage, 0, 0, null);
            g.dispose();
	       
	     }
	       
	        try {
	            Document document = new Document(PageSize.A4); // Use A4 ou outro tamanho desejado
	            String file = salvarArquivo();
	            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
	            writer.setCompressionLevel(0); 

	            document.open();
if(view) {
	            com.itextpdf.text.Image pdfImage = com.itextpdf.text.Image.getInstance(originalImage, null);
	           

	           
	            // Calcula a escala necessária para ajustar a imagem à largura da página
                float aspectRatio = (float) originalImage.getHeight() / originalImage.getWidth();
                float scaledWidth = PageSize.A4.getWidth() * 2 + 10;
                float scaledHeight = scaledWidth * aspectRatio;

                // Redimensiona a imagem
                pdfImage.scaleAbsolute(scaledWidth, scaledHeight);

                // Define a posição absoluta da imagem no PDF (centralizada na página)
                float x = -document.left()/2;
                float y = document.bottom()*2;
                pdfImage.setAbsolutePosition(x, y);



	            document.add(pdfImage);
	            
	           

	            if(list)
	            // Adiciona uma nova página para a tabela
	            document.newPage();
}
if(list) {
	            // Adiciona uma tabela à segunda página
	            PdfPTable table = new PdfPTable(6); // 6 colunas
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

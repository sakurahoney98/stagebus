package com.java.stagebus.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.HorarioModel;
import com.java.stagebus.service.HorarioService;

public class RandomHorario {
	

	
	public static void main(String[] args) {
		StagebusApplication.setConexao("stagebus");
		HorarioService hs = new HorarioService();
		System.out.println("Quantidade de horarios: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde;) {

			HorarioModel horario = new HorarioModel();
			horario.setHora(gerarHora());
			horario.setIdCarro(gerarCarro());
			horario.setIdCobrador(gerarCobrador());
			horario.setIdDia(gerarDia());
			horario.setIdLinha(gerarLinha());
			horario.setIdMotorista(gerarMotorista());

			if (hs.insertScheduleRandom(horario.getIdDia(), horario.getHora(), horario.getIdLinha(), horario.getIdCarro(), horario.getIdMotorista(), horario.getIdCobrador()))
				i++;

		}
		
		System.out.println("Horários gerados.");
	}
	
	private static int gerarCarro() {
		HorarioService hs = new HorarioService();
		
		List<String> list = hs.listOfCar();
		
		Random random  = new Random();
		
		String format = list.get(random.nextInt(list.size()));
		
		format = format.substring(0, (format.indexOf("-") - 1));
		
		return Integer.parseInt(format);
		
		
	}
	
private static int gerarLinha() {
	HorarioService hs = new HorarioService();
		
		List<String> list = hs.listOfLine();
		
		Random random  = new Random();
		
		String format = list.get(random.nextInt(list.size()));
		
		format = format.substring(0, (format.indexOf("-") - 1));
		
		return Integer.parseInt(format);
		
		
	}

private static int gerarMotorista() {
	HorarioService hs = new HorarioService();
	
	List<String> list = hs.listOfDriver();
	
	list.add("0");
	
	Random random  = new Random();
	
	String format = list.get(random.nextInt(list.size()));
	
	if(!format.equals("0"))
	format = format.substring(0, (format.indexOf("-") - 1));
	
	return Integer.parseInt(format);
	
	
}

private static int gerarCobrador() {
	HorarioService hs = new HorarioService();
	
	List<String> list = hs.listOfConductor();
	
	list.add("0");
	
	Random random  = new Random();
	
	String format = list.get(random.nextInt(list.size()));
	
	if(!format.equals("0"))
	format = format.substring(0, (format.indexOf("-") - 1));
	
	return Integer.parseInt(format);
	
	
}

private static int gerarDia() {
	
	
	
	Random random  = new Random();
	

	
	return random.nextInt(7) + 1;
	
	
}

private static String gerarHora() {
	Random random  = new Random();
	
	  List<String> numerosA = new ArrayList<>();
      for (int i = 4; i <= 23; i++) {
          numerosA.add(String.format("%02d", i));
      }

      // Lista de números de 00 a 59 como strings
      List<String> numerosB = new ArrayList<>();
      for (int i = 0; i <= 59; i++) {
          numerosB.add(String.format("%02d", i));
      }
      
      return numerosA.get(random.nextInt(numerosA.size())) + ":" + numerosB.get(random.nextInt(numerosB.size()));
}

}

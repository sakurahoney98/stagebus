package com.java.stagebus.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.CarroModel;
import com.java.stagebus.service.CarroService;
import com.java.stagebus.service.HorarioService;

public class RandomCarro {

	
	public static void main(String[] args) {
		StagebusApplication.setConexao("stagebus");
		
		CarroService cs = new CarroService();
		HorarioService hs = new HorarioService();
		System.out.println("Quantidade de carros: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde;) {

			CarroModel carro = new CarroModel();
			carro.setNumero(gerarNumero());
			carro.setNome("Carro " + carro.getNumero());
			carro.setPlaca(gerarPlaca());
			carro.setIdGaragem(gerarGaragem());
			carro.setIdStatus(gerarStatus());
			carro.setIdTipo(gerarTipo());
			
			System.out.println(carro.toString());
			if (cs.insertCarRandom(carro.getNumero(), carro.getNome(), carro.getPlaca(), carro.getIdTipo(), carro.getIdStatus(), carro.getIdGaragem()))
				i++;
			

		}
		
		System.out.println("Carros gerados.");

	}
	
	
	private static int gerarNumero() {
		
		Random random = new Random();
		
		return random.nextInt(40000) + 10000;
	}
	
	private static String gerarPlaca() {
		
		Random random = new Random();
		
		int numeros = random.nextInt(9000) + 1000;
		
		 List<String> alfabeto = Arrays.asList(
	                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
	                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	        );
		 
		 String letras = "";
		
		for(int i = 0; i < 3; i++) 
			letras += alfabeto.get(random.nextInt(alfabeto.size()));
		
		return letras + numeros;
		
	}
	
	
	private static int gerarStatus() {
		Random random = new Random();
		CarroService cs = new CarroService();
		
		List<String> lista = cs.listOfStatus();
		
		String status = lista.get(random.nextInt(lista.size()));
		
		return Integer.parseInt(status.substring(0, (status.indexOf("-") - 1)));
		
	}
	
	private static int gerarGaragem() {
		Random random = new Random();
		HorarioService hs = new HorarioService();
		
		
		List<String> lista = hs.listOfGarage();
		
		String garagem = lista.get(random.nextInt(lista.size()));
		
		return Integer.parseInt(garagem.substring(0, (garagem.indexOf("-") - 1)));
		
	}
	
	private static int gerarTipo() {
		Random random = new Random();
		CarroService cs = new CarroService();
		
		List<String> lista = cs.listOfType();
		
		String tipo = lista.get(random.nextInt(lista.size()));
		
		return Integer.parseInt(tipo.substring(0, (tipo.indexOf("-") - 1)));
		
	}
}

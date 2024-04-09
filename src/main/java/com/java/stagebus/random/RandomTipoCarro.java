package com.java.stagebus.random;

import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.TipoCarroModel;
import com.java.stagebus.service.TipoCarroService;

public class RandomTipoCarro {
	
	
	public static void main(String[] args) {
		StagebusApplication.setConexao("stagebus");
		System.out.println("Quantidade de tipos de carro: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde;) {
			
			
			TipoCarroService ts = new TipoCarroService();
			TipoCarroModel tipo = new TipoCarroModel();
			tipo.setId(ts.genarateID());
			tipo.setAltura(gerarAltura());
			tipo.setComprimento(gerarComprimento());
			tipo.setLargura(gerarLargura());
			tipo.setNome("Tipo de Carro " + tipo.getId());
			tipo.setPeso(gerarPeso());
			
			
			
			

			
			
			if(ts.insertCarTypeRandom(tipo.getId(), tipo.getNome(), tipo.getComprimento()+"", tipo.getLargura()+"", tipo.getAltura()+"", tipo.getPeso()+""))
				i++;
			
			

		}
		
		System.out.println("Tipos de carro criados");
	}
	
	private static int gerarComprimento() {
		
		Random random = new Random();
		
		return random.nextInt(7) + 12;
	}
	
private static Double gerarLargura() {
		
		Random random = new Random();
		
		return random.nextDouble(0.3) + 2.5;
	}

private static Double gerarAltura() {
	
	Random random = new Random();
	
	return random.nextDouble(1.6) + 3;
}

private static int gerarPeso() {
	
	Random random = new Random();
	
	return random.nextInt(13) + 8;
}
}

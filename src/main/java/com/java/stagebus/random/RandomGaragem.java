package com.java.stagebus.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.service.GaragemService;

public class RandomGaragem {

	public static void main(String[] args) {
		StagebusApplication.setConexao("stagebus");
		
		
		GaragemService gs = new GaragemService();

		System.out.println("Quantidade de garagens: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde;) {

			GaragemModel garagem = new GaragemModel();

			garagem.setId(gs.generateID());
			garagem.setComprimento(gerarComprimento());
			garagem.setLargura(gerarLargura(garagem.getComprimento()));
			garagem.setAltura(gerarAltura());
			garagem.setNome("Garagem " + garagem.getId());
			garagem.setAltura(gerarAltura());
			garagem.setLocal(gerarLocal());
			garagem.setResponsavel(gerarResponsavel());
			garagem.setMax(gerarMax());
			

			if (gs.insertGarageRandom(garagem.getId(), garagem.getNome(), garagem.getComprimento()+"", garagem.getLargura()+"", garagem.getAltura()+"", garagem.getResponsavel(), garagem.getLocal(), garagem.getMax()+""))
				i++;

		}
		
		System.out.println("Garagens geradas.");
	}
	
	private static int gerarMax() {

		Random random = new Random();

		return random.nextInt(11) + 10;

	}

	private static double gerarComprimento() {

		Random random = new Random();

		return random.nextDouble(11) + 60;

	}

	private static double gerarLargura(double comprimento) {

		return comprimento / 2;

	}

	private static double gerarAltura() {

		Random random = new Random();

		return random.nextDouble(6) + 3.5;

	}

	private static String gerarLocal() {
		Random random = new Random();

		List<String> bairrosSalvador = Arrays.asList("Barra", "Rio Vermelho", "Itapuã", "Pituba", "Cajazeiras",
				"Canela", "Stella Maris", "Costa Azul", "Bonfim", "Brotas", "Imbuí", "São Caetano", "Cabula", "Ribeira",
				"Pau da Lima", "Nordeste de Amaralina", "São Marcos", "Federação", "Comércio", "Graça",
				"Arraial do Retiro", "Paripe", "Periperi", "Boca do Rio", "Tancredo Neves", "São Tomé de Paripe",
				"Liberdade", "Calabar", "Vila Laura", "Santa Cruz", "Castelo Branco", "Engenho Velho da Federação",
				"Canabrava", "São Cristóvão", "Pernambués", "Sete de Abril", "Alto do Cabrito", "Nazaré", "Plataforma",
				"Cosme de Farias", "Bonoco", "Cabula VI", "Tancredo Neves", "Boca do Rio");

		return bairrosSalvador.get(random.nextInt(bairrosSalvador.size()));
	}
	
	private static String gerarResponsavel() {
		String name = "";

		List<String> maleNames = Arrays.asList("Joao", "Carlos", "Pedro", "Andre", "Lucas", "Fernando", "Gustavo",
				"Rafael", "Matheus", "Gabriel", "Daniel", "Bruno", "Diego", "Vinicius", "Ricardo", "Alexandre",
				"Eduardo", "Felipe", "Hugo", "Igor", "Julio", "Kevin", "Leonardo", "Marcelo", "Nathan", "Oscar",
				"Paulo", "Quincy", "Rodrigo", "Samuel", "Fernando", "Ivan", "Hector", "Joaquim", "Benjamin", "Mateus",
				"Henry", "Luciano", "Raul", "Carlos", "Alan", "Enzo", "Leon", "Arthur", "Thiago");

		List<String> femaleNames = Arrays.asList("Ana", "Maria", "Carla", "Fernanda", "Gabriela", "Isabela", "Juliana",
				"Larissa", "Mariana", "Natalia", "Patricia", "Renata", "Sofia", "Tatiane", "Vitoria", "Beatriz",
				"Camila", "Diana", "Evelyn", "Flavia", "Giovanna", "Helena", "Ingrid", "Jasmine", "Kamila", "Leticia",
				"Mirella", "Nina", "Olivia", "Priscila", "Raquel", "Eva", "Mariane", "Alice", "Larissa", "Valentina",
				"Beatriz", "Sophie", "Clara", "Amanda", "Luiza", "Caroline", "Isabel", "Nicole", "Leticia");

		Random random = new Random();

		int qtdName = random.nextInt(2) + 1;

		int gender = random.nextInt(2);

		if (gender == 0) {

			for (int j = 0; j < qtdName; j++) {
				name += maleNames.get(random.nextInt(maleNames.size()));
				if (j + 1 < qtdName)
					name += " ";
			}

		} else {
			for (int j = 0; j < qtdName; j++) {
				name += femaleNames.get(random.nextInt(femaleNames.size()));
				if (j + 1 < qtdName)
					name += " ";
			}
		}
		
		String lastName = "";

		

		List<String> lastNames = Arrays.asList("Silva", "da Silva", "Santos", "dos Santos", "Oliveira", "de Oliveira",
				"Pereira", "Costa", "da Costa", "Lima", "Fernandes", "Rodrigues", "Almeida", "Souza", "de Souza",
				"Martins", "Barbosa", "Rocha", "da Rocha", "Gomes", "Nascimento", "do Nascimento", "Melo", "Cunha",
				"da Cunha", "Machado", "Sousa", "de Sousa", "Freitas", "de Freitas", "Goncalves", "Pinto", "Correia",
				"Lopes", "Araujo", "de Araujo", "Ferreira", "Carvalho", "de Carvalho", "Teixeira", "Monteiro",
				"Fonseca", "da Fonseca", "Cardoso", "Vieira", "Mendes", "Lopes", "Dias", "Marques", "Pires", "Correa",
				"Vargas", "Leal", "Farias", "Campos", "Goulart", "Xavier", "Abreu", "de Abreu");

		qtdName = random.nextInt(4) + 1;

		for (int j = 0; j < qtdName; j++) {
			lastName += lastNames.get(random.nextInt(lastNames.size()));
			if (j + 1 < qtdName)
				lastName += " ";
		}
		
		return name + " " + lastName;

	}

}

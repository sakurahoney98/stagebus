package com.java.stagebus.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.service.FuncionarioService;

public class RandomFuncionario {
	
	public static void main(String[] args) {
		StagebusApplication.setConexao("stagebus");
		FuncionarioService fs = new FuncionarioService();
		
		System.out.println("Quantidade de funcionarios: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde;) {

			FuncionarioModel funcionario = new FuncionarioModel();
			funcionario.setId(fs.generateID());
			funcionario.setNome(gerarNome());
			funcionario.setApelido(gerarApelido(funcionario.getNome()));
			funcionario.setMatricula(gerarMatricula());
			funcionario.setIdTipo(gerarTipo());

			if (fs.insertEmployeeRandom(funcionario.getId(), funcionario.getNome(), funcionario.getApelido(), funcionario.getMatricula(), funcionario.getIdTipo()))
				i++;

		}
		
		System.out.println("Funcionarios gerados.");
	}
	
	private static int gerarTipo() {
		Random random = new Random();
		
		return random.nextInt(3) + 1;
	}
	
	private static String gerarMatricula() {
		Random random = new Random();
		
		return random.nextInt(9000) + 1000 + "";
	}
	
	private static String gerarApelido(String name) {
		String apelido = "";
		
		

		apelido = name.substring(0, name.indexOf(" ")) + " " + name.substring(name.lastIndexOf(" ") + 1, name.length());
		
	
		
		return apelido;

	}
	
	private static String gerarNome() {
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

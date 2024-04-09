package com.java.stagebus.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.UsuarioModel;
import com.java.stagebus.persistence.UsuarioPersistence;
import com.java.stagebus.service.UsuarioService;

public class RandomUsuario {

	public static void main(String[] args) {

		StagebusApplication.setConexao("stagebus");

		UsuarioPersistence userPersistence = new UsuarioPersistence();

		System.out.println("Quantidade de usuários: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();

		for (int i = 0; i < qtde;) {
			
			
			UsuarioService us = new UsuarioService();
			
			
			

			UsuarioModel user = new UsuarioModel();
			user.setNome(generateName());
			user.setSobrenome(generateLastName());
			user.setId(us.generateID());
			String name = user.getNome() + " " + user.getSobrenome();
			user.setLogin(generateLogin(name));
			user.setSenha(user.getLogin() + user.getId());
			
			if(us.insertUserRandom(user.getId(), user.getLogin(), user.getSenha(), user.getSenha(), user.getNome(), user.getSobrenome(), generatePermissions()))
				i++;
			
			

		}
		
		System.out.println("Usuários criados");

	}

	private static String generateName() {

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

		return name;

	}

	private static String generateLastName() {
		String lastName = "";

		Random random = new Random();

		List<String> lastNames = Arrays.asList("Silva", "da Silva", "Santos", "dos Santos", "Oliveira", "de Oliveira",
				"Pereira", "Costa", "da Costa", "Lima", "Fernandes", "Rodrigues", "Almeida", "Souza", "de Souza",
				"Martins", "Barbosa", "Rocha", "da Rocha", "Gomes", "Nascimento", "do Nascimento", "Melo", "Cunha",
				"da Cunha", "Machado", "Sousa", "de Sousa", "Freitas", "de Freitas", "Goncalves", "Pinto", "Correia",
				"Lopes", "Araujo", "de Araujo", "Ferreira", "Carvalho", "de Carvalho", "Teixeira", "Monteiro",
				"Fonseca", "da Fonseca", "Cardoso", "Vieira", "Mendes", "Lopes", "Dias", "Marques", "Pires", "Correa",
				"Vargas", "Leal", "Farias", "Campos", "Goulart", "Xavier", "Abreu", "de Abreu");

		int qtdName = random.nextInt(4) + 1;

		for (int j = 0; j < qtdName; j++) {
			lastName += lastNames.get(random.nextInt(lastNames.size()));
			if (j + 1 < qtdName)
				lastName += " ";
		}

		return lastName;

	}

	private static String generateLogin(String name) {
		String login = "";
		
		

		login = name.substring(0, name.indexOf(" ")) + "." + name.substring(name.lastIndexOf(" ") + 1, name.length());
		
	
		
		return login.toLowerCase();

	}

	private static List<String> generatePermissions() {
		Random random = new Random();

		List<String> operacoes = new ArrayList<>();

		operacoes.add("cad_user");
		operacoes.add("cad_car");
		operacoes.add("cad_gar");
		operacoes.add("cad_lin");
		operacoes.add("cad_tip_car");
		operacoes.add("cad_fun");
		operacoes.add("ed_user");
		operacoes.add("ed_car");
		operacoes.add("ed_gar");
		operacoes.add("ed_lin");
		operacoes.add("ed_tip_car");
		operacoes.add("ed_fun");
		operacoes.add("em_rel");
		operacoes.add("cad_ed_hor");
		operacoes.add("perm_user");
		operacoes.add("exc_user");

		int qtdePerm = random.nextInt(operacoes.size());

		for (int i = 0; i < qtdePerm; i++)
			operacoes.remove(random.nextInt(operacoes.size()));

		operacoes.add("status_ativo");

		return operacoes;

	}
}

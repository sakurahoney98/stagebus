package com.java.stagebus.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.java.stagebus.main.StagebusApplication;
import com.java.stagebus.model.LinhaModel;
import com.java.stagebus.service.LinhaService;

public class RandomLinha {

	public static void main(String[] args) {
		StagebusApplication.setConexao("stagebus");
		LinhaService ls = new LinhaService();

		System.out.println("Quantidade de usuários: ");
		Scanner sc = new Scanner(System.in);
		int qtde = sc.nextInt();
		
		
		for (int i = 0; i < qtde;) {

			LinhaModel linha = new LinhaModel();
			linha.setId(ls.generateID());
			linha.setLinha(gerarNumero());
			linha.setNome(gerarNome());
			linha.setIda(gerarItinerarioIda());
			linha.setVolta(gerarItinerarioVolta(linha.getIda()));

			if (ls.insertLineRandom(linha.getId(), linha.getLinha(), linha.getNome(), linha.getIda(), linha.getVolta()))
				i++;

		}

		System.out.println("Linhas criadas");

	}

	private static String gerarNumero() {

		Random random = new Random();

		List<String> prefixo = Arrays.asList("0", "1", "2", "L", "R", "T", "E");
		List<String> sufixo = Arrays.asList("00", "01", "02");

		return prefixo.get(random.nextInt(prefixo.size())) + (random.nextInt(600) + 100) + "-"
				+ sufixo.get(random.nextInt(sufixo.size()));

	}

	private static String gerarNome() {
		String nome = "";

		Random random = new Random();

		List<String> bairros = Arrays.asList("Acupe", "Aeroporto", "Águas Claras", "Alto da Terezinha",
				"Alto das Pombas", "Alto do Cabrito", "Alto do Coqueirinho", "Amaralina", "Areia Branca", "Arenoso",
				"Arraial do Retiro", "Bairro da Paz", "Baixa de Quintas", "Barbalho", "Barra", "Barreiras", "Barris",
				"Beiru/Tancredo Neves", "Boa Viagem", "Boa Vista de Brotas", "Boa Vista de São Caetano", "Boca da Mata",
				"Boca do Rio", "Bom Juá", "Bonfim", "Brotas", "Cabula", "Cabula VI", "Caixa D’Água", "Cajazeiras II",
				"Cajazeiras IV", "Cajazeiras V", "Cajazeiras VI", "Cajazeiras VII", "Cajazeiras VIII", "Cajazeiras X",
				"Cajazeiras XI", "Calabar", "Calabetão", "Calçada", "Caminho das Árvores", "Caminho de Areia",
				"Campinas de Pirajá", "Canabrava", "Candeal", "Canela", "Capelinha", "Cassange", "Castelo Branco",
				"Centro", "CAB", "Centro Histórico", "Chapada do Rio Vermelho", "Cidade Nova", "Comércio",
				"Cosme de Farias", "Costa Azul", "Coutos", "Curuzu", "Dom Avelar", "Engenho Velho da Federação",
				"Engenho Velho de Brotas", "Engomadeira", "Fazenda Coutos", "Fazenda Grande do Retiro",
				"Fazenda Grande I", "Fazenda Grande II", "Fazenda Grande III", "Fazenda Grande IV", "Federação",
				"Garcia", "Graça", "Granjas Rurais Presidente Vargas", "IAPI", "Ilha de Bom Jesus dos Passos",
				"Ilha de Maré", "Ilha dos Frades", "Imbuí", "Itacaranha", "Itaigara", "Itapuã", "Itinga", "Jaguaripe I",
				"Jardim Armação", "Jardim Cajazeiras", "Jardim das Margaridas", "Jardim Nova Esperança",
				"Jardim Santo Inácio", "Lapinha", "Liberdade", "Lobato", "Luiz Anselmo", "Macaúbas", "Mangueira",
				"Marechal Rondon", "Mares", "Massaranduba", "Mata Escura", "Matatu", "Monte Serrat", "Moradas da Lagoa",
				"Mussurunga", "Narandiba", "Nazaré", "Nordeste de Amaralina", "Nova Brasília", "Nova Constituinte",
				"Nova Esperança", "Nova Sussuarana", "Novo Horizonte", "Novo Marotinho", "Ondina", "Palestina",
				"Paripe", "Patamares", "Pau da Lima", "Pau Miúdo", "Periperi", "Pernambués", "Pero Vaz", "Piatã",
				"Pirajá", "Pituaçu", "Pituba", "Plataforma", "Porto Seco Pirajá", "Praia Grande", "Resgate", "Retiro",
				"Ribeira", "Rio Sena", "Rio Vermelho", "Roma", "Saboeiro", "Santa Cruz", "Santa Luzia", "Santa Mônica",
				"Santo Agostinho", "Santo Antônio", "São Caetano", "São Cristóvão", "São Gonçalo",
				"São João do Cabrito", "São Marcos", "São Rafael", "São Tomé", "Saramandaia", "Saúde", "Sete de Abril",
				"Stella Maris", "STIEP", "Sussuarana", "Tororó", "Trobogy", "Uruguai", "Vale das Pedrinhas",
				"Vale dos Lagos", "Valéria", "Vila Canária", "Vila Laura", "Vila Ruy Barbosa/Jardim Cruzeiro",
				"Vitória");

		int qtde = random.nextInt(2) + 2;

		for (int i = 0; i < qtde; i++) {
			nome += bairros.get(random.nextInt(bairros.size()));
			if (i + 1 < qtde)
				nome += " / ";
		}

		return nome;
	}

	private static String gerarItinerarioIda() {
		String ida = "";

		Random random = new Random();

		List<String> ruas = Arrays.asList("Rua da Liberdade da Valéria", "Rua Nossa Senhora da Escada",
				"Rua Luís de Mata Escura", "Conjunto Recanto das Ilhas", "2ª Travessa Wilson Teixeira",
				"Rua Bahia de Paripe", "Travessa Tancredo Neves da Ceasa", "Travessa Santo Expedito",
				"Rua Petronília Dércia", "Travessa José Pereira da Silva", "3ª Travessa Isabel Gentil", "Vila Ulicia",
				"Rua Bom Retiro", "1ª Lourival Alves", "Estrada Santa Cruz", "Rua Doutora Arminda de Souza",
				"3ª Babilônia", "Vila Gradil", "2ª Travessa Esperança", "Rua Sandra Monteiro",
				"4ª Travessa de 2 Fevereiro", "Travessa do Queimado", "2ª Travessa Pacheco", "Rua Nova das Flores",
				"Rua do Cemitério", "1ª Travessa Estaleiro", "2ª Gabriel Monteiro de Castro",
				"3ª Travessa Maria Amélia", "Rua Bambuzal", "1ª Travessa Assis Sampaio", "Travessa João Salomé",
				"Rua Suíno Bahia", "Rua Adelaide Guimarães", "Travessa João Durval", "Rua Otacílio Santos",
				"Rua Buriti do Joanes", "Rua Apolônio", "Rua Professor Evaristo", "Acesso 4-A", "2ª Travessa Jaguarari",
				"Travessa Júlio David", "Rua Sheila Matos", "1ª Luís Conceição", "Via Coletora B",
				"Rua Papa Clemente X", "1ª Travessa João Durval", "Rua Sônia Assis de Moura", "Avenida Nonato",
				"Rua Deputado Cristóvão", "Travessa União do Bosque Real", "Rua Direta do Cruzeiro",
				"Rua Abelardo Andrade de Carvalho", "3ª Avenida do Curuzu", "Alto Boa Vista", "Rua Barreto Costa",
				"Rua Estrela Guia", "Rua Resende Costa", "Rua José Feitosa", "1ª Flaviano Rodrigues",
				"2ª Travessa Teódulo de Albuquerque", "2ª Jerusalém", "Alameda Jardim Pituaçu",
				"Travessa Alto Nova Brasília", "2ª Apolinário de Santana", "Rua Albano", "1ª Travessa Santa Catarina",
				"Rua Gilberto Maltez", "Rua Calabetão", "3ª Comodoro", "Avenida Valdomiro", "1ª Travessa Contorno",
				"Vila Pero Vaz", "Rua Engenheiro Jaime Zaverucha", "2ª Bonfim de Tancredo Neves",
				"4ª Travessa Luís Eduardo Magalhães", "Ladeira Mato Grosso", "Alameda Guedeville", "Alameda Suburbana",
				"2ª João Ramos", "Praça 19 de Março", "Rua Professora Candolina Cerqueira", "Rua da Felicidade",
				"Alameda G-3", "3ª Centro Administrativo da Bahia", "Travessa Santo Inácio", "3ª Cosme e Damião",
				"Rua Tenente Guido", "Caminho 8-F", "Travessa 18 de Maio", "3ª Travessa Mário Fiúza", "Rua Subaé",
				"2ª Travessa Jaime Vieira Lima", "1ª Matriz", "Rua Gonçalves Cezimbra", "Avenida Fruta-Pão",
				"Avenida Barbosa de São Cristovão", "Rua Miguel dos Campos", "Travessa Edgar Pereira da Cruz",
				"Rua Maciel de Cima", "Rua Jorge Leal Gonçalves", "Avenida Dois Irmãos", "1ª Travessa Paulo Avelar",
				"Rua Maricá", "Avenida 13 de Maio", "Avenida Euzébio de Queiroz", "Travessa Gilberto Bastos do Arenoso",
				"Rua Elias Barreto", "Rua São João Batista de Periperi", "1ª Goianases", "Travessa Vila Mel",
				"1ª Vila Oliveira", "Avenida Manoel da Hora", "Rua 19 de Outubro", "3ª Travessa São José do Egito",
				"Travessa Marotinho", "Avenida Blanco", "Rua do Porto", "Rua Hilda Dias dos Santos",
				"Avenida Palmeiras de Cajazeiras", "4ª Travessa Pilão sem Tampa", "2ª Travessa Guatarana",
				"4ª Travessa Paulo Afonso", "Travessa Icaraí", "Rua Olival", "Travessa Gordo",
				"1ª Travessa General Liberato de Matos", "Rua Natanael Palma", "Jardim Jaguaribe",
				"Alameda Vila Tropical", "Alameda Capimirim", "Rua Oswaldo Cruz", "Largo Palma", "Avenida Suburbana",
				"Travessa Doutor Tancredo Neves", "Rua Visconde de Itaborahy", "1ª Travessa Rio Doce", "Travessa Guiné",
				"Rua Engenheiro Marcondes Ferraz", "Rua América Dourada", "Vila Leonídio", "Rua Esportes",
				"6ª Travessa de 24 Junho", "1ª Travessa União", "Vila Venância", "Travessa Almiro Nery",
				"Rua Cabo Valverde", "Rua Mármore Neto", "Rua Luís Dias", "Rua José Gomes Aguiar", "Avenida Beta",
				"Avenida Índios do Brasil", "Alameda Vênus", "Travessa São Francisco de Paula", "Rua Jaime Loureiro",
				"Rua Jayme Vieira Lima", "Rua Guadalajara", "Rua Nova da Estação", "Rua Marcos Medrado", "Rua Israel",
				"Loteamento Jardim Iara", "Avenida Vale do Ogunjá", "Travessa Caio", "2ª Subida Sergipana",
				"Rua da Gardênia", "Largo de Santana", "Rua Maria Felipa", "2ª Travessa Mário Kertész", "Rua Cantagalo",
				"Rua Coronel Azevedo", "Rua da Paz de Castelo Branco", "3ª Travessa Antônio Carlos Magalhães",
				"Travessa Belo Horizonte de Praia Grande", "Vila Pilão sem Tampa", "1ª Gabriel Monteiro de Castro",
				"Rua 20 Quadra 20", "Travessa Arpa", "Travessa Lázaro de Cima", "1ª Travessa Alto do Girassol",
				"Rua Parangabá", "Avenida São Tomé", "Rua Coronel Nilton Sá", "Travessa das Virgens",
				"Rua Papa Sisto V", "Loteamento Alto de São Jorge", "1ª Cachoeira da Prata", "Travessa Beto Gaban",
				"Rua Urubupungá", "3ª Travessa Darcy Vargas", "Travessa Professor Walson Lopes", "Ladeira do Cacau",
				"2ª Baixa da Pedreira", "4ª Travessa Princesa Isabel", "Avenida Paulo Gonçalves da Silva",
				"1ª Travessa Primeiro de Novembro", "Alameda Praia da Tailândia", "Rua Custódio de Melo",
				"Rua Capela Nova", "Avenida Frederico Pontes", "Rua do Romance", "Vila Luíza");

		int qtde = random.nextInt(5) + 5;

		for (int i = 0; i < qtde; i++) {

			ida += ruas.get(random.nextInt(ruas.size()));

			if (i + 1 < qtde)
				ida += " - ";

		}
		return ida;
	}

	private static String gerarItinerarioVolta(String ida) {
		String volta = "";

		while (ida.indexOf("-") != -1) {
			int ref = ida.lastIndexOf("-");
			volta += ida.substring(ref + 1, ida.length()) + " - ";

			ida = ida.substring(0, ref - 1);
		}

		volta += ida;

		return volta;

	}

}

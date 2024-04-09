package com.java.stagebus.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.java.stagebus.model.GaragemModel;
import com.java.stagebus.model.RelatorioModel;

public class Tela_Organizacao_Visualizacao extends JFrame {

	private static GaragemModel garage;
	private static List<RelatorioModel> busList;
	private static boolean calculateDistance;
	private static List<Integer> distances;

	public static void setCalculateDistance(boolean b) {
		calculateDistance = b;
	}

	public static void setDistance(List<Integer> l) {
		distances = l;
	}

	public static void setGarage(GaragemModel g) {
		garage = g;
	}

	public static void setBusList(List<RelatorioModel> l) {
		busList = l;
	}

	public Tela_Organizacao_Visualizacao() {

		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new Principal());
		setExtendedState(MAXIMIZED_BOTH);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Tela_Organizacao_Visualizacao().setVisible(true);
		});
	}

	class Principal extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			setBackground(Color.white);

			// Inserindo manualmente o tamanho da garagem
			double larguraGaragem = garage.getLargura();
			double comprimentoGaragem = garage.getComprimento();

			// Inserindo tamanhos minimos de distancia
			int distanciaLargura = distances.get(0), distanciaComprimento = distances.get(1);

			double aux;

			// Escala que sera usada
			double escala = 10.0;

			// O tamanho máximo para o redmensionamento é 1000 pixels, quando a escala é
			// aplicada, se esse valor é ultrapassado, a escala é recalculada
			while ((larguraGaragem * escala) > 1000 || (comprimentoGaragem * escala) > 1000) {
				if ((escala -= 1.0) <= 0)
					escala -= 0.1;
				else
					escala -= 1.0;

			}

			aux = distanciaLargura * escala;
			distanciaLargura = (int) aux;
			aux = distanciaComprimento * escala;
			distanciaComprimento = (int) aux;

			// Atribuindo a escala as medidas da garagem
			aux = escala * larguraGaragem;
			int eLarguraGaragem = (int) aux;

			aux = escala * comprimentoGaragem;
			int eComprimentoGaragem = (int) aux;

			// Simulando uma lista de ônibus de uma garagem
			List<RelatorioModel> list = busList;

			// Desenhando a garagem no painel
			int xGaragem = (getWidth() - eLarguraGaragem) / 2; // Coordenada x do quadrado
			int yGaragem = (getHeight() - eComprimentoGaragem) / 2; // Coordenada y do quadrado

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.black);

			// Configura a largura da linha
			float strokeWidth = 2.0f;
			g2d.setStroke(new BasicStroke(strokeWidth));

			g2d.drawRect(xGaragem, yGaragem, eLarguraGaragem, eComprimentoGaragem);

			// Variáveis opara ajudar no controle da organização
			int larguraGaragemRestante = eLarguraGaragem;
			int comprimentoGaragemRestante = eComprimentoGaragem;
			double maiorComprimentoOnibus = 0;
			List<Integer> qtdePorFila = new ArrayList<Integer>();
			List<Integer> distanciaFila = new ArrayList<Integer>();
			List<Integer> maiorComprimentoFila = new ArrayList<Integer>();
			int qtdeOnibus = 0;
			int eLarguraOnibus = 0;
			int eComprimentoOnibus = 0;
			int i = 0;

			// Atribuindo a escala as medidas do ônibus
			aux = escala * list.get(i).getLargura();
			eLarguraOnibus = (int) aux;
			aux = escala * list.get(i).getComprimento();
			eComprimentoOnibus = (int) aux;

			// Esse primeiro momento não serão desenhados os ônibus. Apenas fazendo uma
			// simulação de como eles ficariam

			// Enquanto for possível adicionar ônibus na vertical e ainda houver ônibus na
			// lista
			while ((eComprimentoOnibus + distanciaComprimento) < (comprimentoGaragemRestante - distanciaComprimento)
					&& i < list.size()) {

				// Enquanto for possível adicionar ônibus na horizontal e ainda houver ônibus na
				// lista
				while ((eLarguraOnibus + distanciaLargura) < (larguraGaragemRestante - distanciaLargura)
						&& i < list.size()) {
					// Adiciona ônibus no espaço
					qtdeOnibus++;

					// Subtrai o espaço ocupado pelo ônibus no espaço restante
					larguraGaragemRestante -= eLarguraOnibus + distanciaLargura;

					// Verificando qual o ônibus de maior comprimento
					if (eComprimentoOnibus > maiorComprimentoOnibus)
						maiorComprimentoOnibus = eComprimentoOnibus;

					// Passando para o próximo ônibus da lista
					i++;

					// Capturando as medidas do próximo ônibus
					if (i < list.size()) {
						aux = escala * list.get(i).getLargura();
						eLarguraOnibus = (int) aux;
						aux = escala * list.get(i).getComprimento();
						eComprimentoOnibus = (int) aux;
					}

				}

				if (calculateDistance)
					// Fazendo o calculo da distancia entre ônibus para melhor aproveitamento de
					// espaço
					distanciaFila.add(distanciaLargura
							+ (Math.floorDiv((larguraGaragemRestante - distanciaLargura), qtdeOnibus + 1)));
				else
					distanciaFila.add(distanciaLargura);

				// Guardando a quantidade de ônibus da fila
				qtdePorFila.add(qtdeOnibus);

				// Guardando o maior ônibus da fila
				maiorComprimentoFila.add((int) maiorComprimentoOnibus);

				// Limpando a quantidade de ônibus da fila para passar para próxima fila
				qtdeOnibus = 0;

				// Diminuindo o comprimento restante da garagem
				comprimentoGaragemRestante -= maiorComprimentoOnibus + distanciaComprimento;
				larguraGaragemRestante = eLarguraGaragem;

				// Limpando o maior ônibus da fila
				maiorComprimentoOnibus = 0;

			}

			// Verificando se houve sobra de ônibus para mudar a forma de organizar
			int org = 0;

			for (; i < list.size();) {

				aux = escala * list.get(i).getLargura();
				eLarguraOnibus = (int) aux;
				aux = escala * list.get(i).getComprimento();
				eComprimentoOnibus = (int) aux;

				// Verificando se a organização é na horizontal
				if ((eLarguraOnibus + distanciaComprimento) < (comprimentoGaragemRestante - distanciaComprimento)) {
					qtdeOnibus++;
					comprimentoGaragemRestante -= eLarguraOnibus + distanciaComprimento;
					org = 1;

					// Na vertical
				} else if ((eComprimentoOnibus + distanciaLargura) < (larguraGaragemRestante - distanciaLargura)) {
					qtdeOnibus++;
					larguraGaragemRestante -= eLarguraOnibus + distanciaLargura;
					org = 2;

					// Ou se não é possível organizar
				} else {
					System.out.println("Não foi possível organizar todos os carros.");
					break;

				}
				// Passando para o próximo
				i++;

			}
			if (calculateDistance)
				// Calculando a distaância do comprimento
				distanciaComprimento += Math.floorDiv(comprimentoGaragemRestante - distanciaComprimento,
						(qtdePorFila.size() + qtdeOnibus + 1));

			// Desenhando os ônibus
			int iterar = 0;
			aux = escala * list.get(iterar).getLargura();
			eLarguraOnibus = (int) aux;
			aux = escala * list.get(iterar).getComprimento();
			eComprimentoOnibus = (int) aux;
			int auxIterar = 0;
			int xOnibus = xGaragem + (eLarguraGaragem - eLarguraOnibus) - distanciaFila.get(0);
			int yOnibus = yGaragem;

			int xAnt = xOnibus;
			int yAnt = yOnibus;

			for (int j = 0; j < qtdePorFila.size(); j++) {
				for (int k = 0; k < qtdePorFila.get(j); k++) {

					// As copordenadas já foram definidas antes do loop, então agora iremos pegar
					// apenas as medidas do ônibus
					aux = escala * list.get(iterar).getLargura();
					eLarguraOnibus = (int) aux;
					aux = escala * list.get(iterar).getComprimento();
					eComprimentoOnibus = (int) aux;
					yOnibus = yAnt + (eComprimentoGaragem - eComprimentoOnibus) - distanciaComprimento;

					// Desenhando o ônibus
					g.drawRect(xOnibus, yOnibus, eLarguraOnibus, eComprimentoOnibus);

					// Desenhando número nos carros
					String texto = (auxIterar + 1) + "";
					Font fonte = new Font("Arial", Font.BOLD, 12);
					g.setFont(fonte);
					int xTexto = xOnibus + (eLarguraOnibus / 2) - texto.length(); // Ajuste para centralizar o texto
					int yTexto = yOnibus + eComprimentoOnibus / 2; // Ajuste para centralizar o texto verticalmente
					g.drawString(texto, xTexto, yTexto);

					// Pegando a próxima medida para a verificação correta do bloco de repetição,
					// partindo do pressuposto que o próximo ônibus da lista tenha largura diferente
					// do atual. Se esse fosse o caso, e o próximo tivesse largura maior do que o
					// atual, a condição de repetição seria avaliada erroneamente
					// Caso entre na estrutura, isso não irá afetar o código
					if (k < (qtdePorFila.get(j) - 1)) {
						aux = escala * list.get(iterar + 1).getLargura();
						eLarguraOnibus = (int) aux;
					}

					xOnibus = xAnt - distanciaFila.get(j) - eLarguraOnibus; // Coordenada x do ônibus

					xAnt = xOnibus;

					iterar++;
					auxIterar++;
				}

				// Estando a fila preenchida mudando os parametroa para os valores inicias para
				// começar a nova fila com o ônibus no mesmo canto da primeira
				if (iterar < list.size()) {
					aux = escala * list.get(iterar).getLargura();
					eLarguraOnibus = (int) aux;
					xOnibus = xGaragem + (eLarguraGaragem - eLarguraOnibus) - distanciaFila.get(j);
				}
				
				//Alterando o valor da coordenada y
				yOnibus = yAnt - distanciaComprimento - maiorComprimentoFila.get(j);
				
				
				if (j < qtdePorFila.size() - 1) {

					xOnibus = xGaragem + (eLarguraGaragem - eLarguraOnibus) - distanciaFila.get(j + 1);
				}
				iterar = 0;
				yAnt = yOnibus;
				xAnt = xOnibus;
			}
			i = auxIterar;
			int auxContMaior = 0;

			// Verificando o tamanho já ocupado do comprimento da garagem
			for (int cont = 0; cont < maiorComprimentoFila.size(); cont++) {
				auxContMaior += maiorComprimentoFila.get(cont);
			}

			yOnibus = (yGaragem + eComprimentoGaragem) - (qtdePorFila.size() * distanciaComprimento) - auxContMaior;
			yAnt = yOnibus;

			// Fazendo organização dos ônibus restante
			for (int l = 0; l < qtdeOnibus; l++) {

				aux = escala * list.get(i).getLargura();
				eComprimentoOnibus = (int) aux;
				aux = escala * list.get(i).getComprimento();
				eLarguraOnibus = (int) aux;

				// O primeiro ônibus sempre sendo organizando no canto da garagem
				if (l == 0) {
					yOnibus = yAnt - distanciaComprimento - eComprimentoOnibus;
					yAnt = yOnibus;
					xOnibus = xGaragem + distanciaLargura;
					xAnt = xOnibus;
				}
				g.drawRect(xOnibus, yOnibus, eLarguraOnibus, eComprimentoOnibus);

				// Atribuindo números aos ônibus
				String texto = (auxIterar + 1) + "";
				Font fonte = new Font("Arial", Font.BOLD, 12);
				g.setFont(fonte);
				int xTexto = xOnibus + (eLarguraOnibus / 2) - texto.length(); // Ajuste para centralizar o texto
				int yTexto = yOnibus + eComprimentoOnibus / 2; // Ajuste para centralizar o texto verticalmente
				g.drawString(texto, xTexto, yTexto);

				auxIterar++;

				// Verificando como deve ser feita a organização
				if (org == 1) {
					xOnibus = xAnt; // Coordenada x do retângulo
					yOnibus = yAnt - distanciaComprimento - eComprimentoOnibus; // Coordenada y do retângulo

				} else {

					xOnibus = xAnt + distanciaLargura + eLarguraOnibus; // Coordenada x do retângulo
					yOnibus = yAnt; // Coordenada y do retângulo

				}

				xAnt = xOnibus;
				yAnt = yOnibus;

				i++;
			}
			aux = distanciaComprimento / escala;
			String texto = "Distância vertical: " + aux + "m";
			Font fonte = new Font("Arial", Font.BOLD, 12);
			g.setFont(fonte);
			int xTexto = xGaragem + eLarguraGaragem + 20; // Ajuste para centralizar o texto
			int yTexto = yGaragem + eComprimentoGaragem / 2; // Ajuste para centralizar o texto verticalmente
			g.drawString(texto, xTexto, yTexto);

			yTexto += 20;

			texto = "Distância entre os ônibus das filas:";
			g.drawString(texto, xTexto, yTexto);

			for (int k = 0; k < distanciaFila.size(); k++) {
				yTexto += 20;
				aux = distanciaFila.get(k) / escala;
				texto = "Fila " + (k + 1) + ": " + aux + "m";
				g.drawString(texto, xTexto, yTexto);
			}
		}

	}
}

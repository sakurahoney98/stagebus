package com.java.stagebus.view;

import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.java.stagebus.controller.CarroController;
import com.java.stagebus.controller.HorarioController;
import com.java.stagebus.controller.RelatorioController;
import com.java.stagebus.model.RelatorioModel;

/**
 *
 * @author User
 */
public class Tela_Organizacao extends javax.swing.JFrame {
	private HorarioController scheduleController = new HorarioController();
	private CarroController carController = new CarroController();

	/**
	 * Creates new form Tela_1
	 */
	public Tela_Organizacao() {
		initComponents();
		getContentPane().setBackground(java.awt.Color.WHITE);

		setExtendedState(MAXIMIZED_BOTH);

		ImageIcon icon = new ImageIcon("src/main/resources/Images/titulo_lista_organizacao.png");
		Image image = icon.getImage().getScaledInstance(jLabelTitulo.getWidth(), jLabelTitulo.getHeight(),
				Image.SCALE_SMOOTH);
		jLabelTitulo.setIcon(new ImageIcon(image));

		icon = new ImageIcon("src/main/resources/Images/btn_voltar.png");
		image = icon.getImage().getScaledInstance(jButtonVoltar.getWidth(), jButtonVoltar.getHeight(),
				Image.SCALE_SMOOTH);
		jButtonVoltar.setIcon(new ImageIcon(image));

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroupOrganizacao = new javax.swing.ButtonGroup();
		jLabelTitulo = new javax.swing.JLabel();
		jLabelDia = new javax.swing.JLabel();
		jComboBoxDia = new javax.swing.JComboBox<>();
		jLabelGaragem = new javax.swing.JLabel();
		jComboBoxGaragem = new javax.swing.JComboBox<>();
		jLabelDistancia = new javax.swing.JLabel();
		jTextFieldDistanciaVertical = new javax.swing.JTextField();
		jTextFieldDistanciaHorizontal = new javax.swing.JTextField();
		jCheckBoxCalcularDistancia = new javax.swing.JCheckBox();
		jLabelOrganizarPor = new javax.swing.JLabel();
		jRadioButtonHoraSaida = new javax.swing.JRadioButton();
		jRadioButtonNumeroCarro = new javax.swing.JRadioButton();
		jRadioButtonNumeroLinha = new javax.swing.JRadioButton();
		jLabelGerar = new javax.swing.JLabel();
		jCheckBoxVisualizacao = new javax.swing.JCheckBox();
		jCheckBoxLista = new javax.swing.JCheckBox();
		jCheckBoxPDF = new javax.swing.JCheckBox();
		jButtonVoltar = new javax.swing.JButton();
		jButtonGerar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

		jLabelDia.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelDia.setForeground(new java.awt.Color(68, 114, 196));
		jLabelDia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabelDia.setText("Dia:");
		jLabelDia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jComboBoxDia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jComboBoxDia.setForeground(new java.awt.Color(127, 127, 127));
		jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(
				scheduleController.generateObjectList(scheduleController.listOfDay())));
		jComboBoxDia.setBorder(null);

		jLabelGaragem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelGaragem.setForeground(new java.awt.Color(68, 114, 196));
		jLabelGaragem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabelGaragem.setText("Garagem:");
		jLabelGaragem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jComboBoxGaragem.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jComboBoxGaragem.setForeground(new java.awt.Color(127, 127, 127));
		jComboBoxGaragem.setModel(
				new javax.swing.DefaultComboBoxModel<>(carController.generateObjectList(carController.listOfGarage())));
		jComboBoxGaragem.setBorder(null);

		jLabelDistancia.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jLabelDistancia.setForeground(new java.awt.Color(68, 114, 196));
		jLabelDistancia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabelDistancia.setText("Distância mínima (m)");
		jLabelDistancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jTextFieldDistanciaVertical.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
		jTextFieldDistanciaVertical.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextFieldDistanciaVertical.setText("Vertical");
		jTextFieldDistanciaVertical.setNextFocusableComponent(jTextFieldDistanciaHorizontal);
		jTextFieldDistanciaVertical.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextFieldDistanciaVerticalFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jTextFieldDistanciaVerticalFocusLost(evt);
			}
		});
		jTextFieldDistanciaVertical.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextFieldDistanciaVerticalKeyReleased(evt);
			}
		});

		jTextFieldDistanciaHorizontal.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
		jTextFieldDistanciaHorizontal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextFieldDistanciaHorizontal.setText("Horizontal");
		jTextFieldDistanciaHorizontal.setNextFocusableComponent(jCheckBoxCalcularDistancia);
		jTextFieldDistanciaHorizontal.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextFieldDistanciaHorizontalFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jTextFieldDistanciaHorizontalFocusLost(evt);
			}
		});
		jTextFieldDistanciaHorizontal.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextFieldDistanciaHorizontalKeyReleased(evt);
			}
		});

		jCheckBoxCalcularDistancia.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
		jCheckBoxCalcularDistancia.setText("Calcular melhor distância");
		jCheckBoxCalcularDistancia.setNextFocusableComponent(jRadioButtonHoraSaida);

		jLabelOrganizarPor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jLabelOrganizarPor.setForeground(new java.awt.Color(68, 114, 196));
		jLabelOrganizarPor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabelOrganizarPor.setText("Organizar por:");
		jLabelOrganizarPor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jRadioButtonHoraSaida.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroupOrganizacao.add(jRadioButtonHoraSaida);
		jRadioButtonHoraSaida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButtonHoraSaida.setForeground(new java.awt.Color(127, 127, 127));
		jRadioButtonHoraSaida.setText("Hora de saída");
		jRadioButtonHoraSaida.setNextFocusableComponent(jCheckBoxVisualizacao);
		jRadioButtonHoraSaida.setSelected(true);

		jRadioButtonNumeroCarro.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroupOrganizacao.add(jRadioButtonNumeroCarro);
		jRadioButtonNumeroCarro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButtonNumeroCarro.setForeground(new java.awt.Color(127, 127, 127));
		jRadioButtonNumeroCarro.setText("Número do carro");
		jRadioButtonNumeroCarro.setNextFocusableComponent(jCheckBoxVisualizacao);

		jRadioButtonNumeroLinha.setBackground(new java.awt.Color(255, 255, 255));
		buttonGroupOrganizacao.add(jRadioButtonNumeroLinha);
		jRadioButtonNumeroLinha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButtonNumeroLinha.setForeground(new java.awt.Color(127, 127, 127));
		jRadioButtonNumeroLinha.setText("Número da linha");
		jRadioButtonNumeroLinha.setNextFocusableComponent(jCheckBoxVisualizacao);

		jLabelGerar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jLabelGerar.setForeground(new java.awt.Color(68, 114, 196));
		jLabelGerar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabelGerar.setText("Gerar:");
		jLabelGerar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jCheckBoxVisualizacao.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBoxVisualizacao.setForeground(new java.awt.Color(127, 127, 127));
		jCheckBoxVisualizacao.setText("Visualização");
		jCheckBoxVisualizacao.setNextFocusableComponent(jCheckBoxLista);

		jCheckBoxLista.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBoxLista.setForeground(new java.awt.Color(127, 127, 127));
		jCheckBoxLista.setText("Lista");
		jCheckBoxLista.setNextFocusableComponent(jCheckBoxPDF);

		jCheckBoxPDF.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBoxPDF.setForeground(new java.awt.Color(127, 127, 127));
		jCheckBoxPDF.setText("PDF");
		jCheckBoxPDF.setNextFocusableComponent(jComboBoxDia);

		jButtonVoltar.setBorder(null);
		jButtonVoltar.setBorderPainted(false);
		jButtonVoltar.setContentAreaFilled(false);
		jButtonVoltar.setCursor(new Cursor(HAND_CURSOR));
		jButtonVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonVoltarMouseClicked(evt);
			}

		});

		jButtonGerar.setBackground(new java.awt.Color(68, 114, 196));
		jButtonGerar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
		jButtonGerar.setForeground(new java.awt.Color(255, 255, 255));
		jButtonGerar.setText("Gerar");
		jButtonGerar.setBorder(null);
		jButtonGerar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonGerarMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(100, 100, 100)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(
												jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 650,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jComboBoxDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGap(50, 50, 50)
												.addComponent(jLabelGaragem, javax.swing.GroupLayout.PREFERRED_SIZE,
														150, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														jComboBoxGaragem, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabelDistancia,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jTextFieldDistanciaVertical,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jTextFieldDistanciaHorizontal,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jCheckBoxCalcularDistancia,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
														Short.MAX_VALUE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jLabelOrganizarPor,
																javax.swing.GroupLayout.DEFAULT_SIZE, 250,
																Short.MAX_VALUE)
														.addComponent(jRadioButtonHoraSaida,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jRadioButtonNumeroCarro,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(
																jRadioButtonNumeroLinha,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
														Short.MAX_VALUE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jLabelGerar, javax.swing.GroupLayout.DEFAULT_SIZE,
																250, Short.MAX_VALUE)
														.addComponent(jCheckBoxVisualizacao,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jCheckBoxLista,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jCheckBoxPDF,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))))
										.addContainerGap(65, Short.MAX_VALUE)))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(100, 100, 100)
										.addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(50, 50, 50)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelGaragem, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jComboBoxGaragem, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(100, 100, 100)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelDistancia, javax.swing.GroupLayout.PREFERRED_SIZE,
														30, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabelOrganizarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabelGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextFieldDistanciaVertical,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jRadioButtonHoraSaida)
														.addComponent(jCheckBoxVisualizacao)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextFieldDistanciaHorizontal,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jRadioButtonNumeroCarro)
														.addComponent(jCheckBoxLista)))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jRadioButtonNumeroLinha)
																.addComponent(jCheckBoxPDF)))
												.addGroup(layout.createSequentialGroup().addGap(24, 24, 24)
														.addComponent(jCheckBoxCalcularDistancia)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123,
												Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(71, 71, 71)));

		pack();
	}// </editor-fold>

	private void jTextFieldDistanciaVerticalKeyReleased(java.awt.event.KeyEvent evt) {
		jTextFieldDistanciaVertical.setText(jTextFieldDistanciaVertical.getText().replaceAll("[^a-zA-Z0-9]", ""));
		jTextFieldDistanciaVertical.setText(jTextFieldDistanciaVertical.getText().replaceAll("[^\\d]", ""));
	}

	private void jTextFieldDistanciaHorizontalKeyReleased(java.awt.event.KeyEvent evt) {
		jTextFieldDistanciaHorizontal.setText(jTextFieldDistanciaHorizontal.getText().replaceAll("[^a-zA-Z0-9]", ""));
		jTextFieldDistanciaHorizontal.setText(jTextFieldDistanciaHorizontal.getText().replaceAll("[^\\d]", ""));
	}

	private void jTextFieldDistanciaVerticalFocusLost(java.awt.event.FocusEvent evt) {
		if (jTextFieldDistanciaVertical.getText().replaceAll(" ", "").equals(""))
			jTextFieldDistanciaVertical.setText("Vertical");
	}

	private void jTextFieldDistanciaHorizontalFocusLost(java.awt.event.FocusEvent evt) {
		if (jTextFieldDistanciaHorizontal.getText().replaceAll(" ", "").equals(""))
			jTextFieldDistanciaHorizontal.setText("Horizontal");
	}

	private void jTextFieldDistanciaHorizontalFocusGained(java.awt.event.FocusEvent evt) {
		jTextFieldDistanciaHorizontal.setText("");
	}

	private void jTextFieldDistanciaVerticalFocusGained(java.awt.event.FocusEvent evt) {
		jTextFieldDistanciaVertical.setText("");
	}

	private void jButtonVoltarMouseClicked(java.awt.event.MouseEvent evt) {
		new Tela_Inicial().setVisible(true);
		setVisible(false);
	}

	private void jButtonGerarMouseClicked(java.awt.event.MouseEvent evt) {
		String garage = jComboBoxGaragem.getSelectedItem().toString();
		garage = garage.substring(0, (garage.indexOf("-")-1));
		String dia = jComboBoxDia.getSelectedItem().toString();
		dia = dia.substring(0, (dia.indexOf("-")-1));
		
		List<Integer> listAux = new ArrayList<Integer>();
		
		if (jTextFieldDistanciaHorizontal.getText().replaceAll(" ", "").equals("") || jTextFieldDistanciaHorizontal.getText().equalsIgnoreCase("Horizontal"))
			listAux.add(1);

		else
			listAux.add(Integer.parseInt(jTextFieldDistanciaHorizontal.getText()));
		
		if (jTextFieldDistanciaVertical.getText().replaceAll(" ", "").equals("") || jTextFieldDistanciaVertical.getText().equalsIgnoreCase("Vertical"))
			listAux.add(1);
		else
			listAux.add(Integer.parseInt(jTextFieldDistanciaVertical.getText()));
		int param = 0;
		
		if(jRadioButtonHoraSaida.isSelected())
			param = 1;
		else if (jRadioButtonNumeroCarro.isSelected())
			param = 2;
		else
			param = 3;
		
		List<RelatorioModel> listShedule = new RelatorioController().getBusListOfGarage(Integer.parseInt(garage), param , Integer.parseInt(dia));
		
		if(!listShedule.isEmpty()) {
		
		
		
		
		
		
		Tela_Organizacao_Visualizacao.setCalculateDistance(jCheckBoxCalcularDistancia.isSelected());
		
		Tela_Organizacao_Visualizacao.setGarage(new RelatorioController().getDataGarage(Integer.parseInt(garage)));
		
		
		Tela_Organizacao_Visualizacao.setBusList(listShedule);
		Tela_Organizacao_Visualizacao.setDistance(listAux);
		
		if(jCheckBoxVisualizacao.isSelected())
			new Tela_Organizacao_Visualizacao().setVisible(true);
		if(jCheckBoxLista.isSelected() && !jCheckBoxPDF.isSelected()) {
			Tela_Organizacao_Lista.setScheduleList(listShedule);
			new Tela_Organizacao_Lista().setVisible(true);
		}
		if(jCheckBoxPDF.isSelected() && (jCheckBoxLista.isSelected() || jCheckBoxVisualizacao.isSelected())) {
			Tela_Organizacao_PDF.setFrame(new Tela_Organizacao_Visualizacao());
			Tela_Organizacao_PDF.setListSchedules(listShedule);
			Tela_Organizacao_PDF.setList(jCheckBoxLista.isSelected());
			Tela_Organizacao_PDF.setView(jCheckBoxVisualizacao.isSelected());
			
			new Tela_Organizacao_PDF().main(null);
		}
		}else
			System.out.println("Vazio");

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Tela_Organizacao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Tela_Organizacao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Tela_Organizacao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Tela_Organizacao.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Tela_Organizacao().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroupOrganizacao;
	private javax.swing.JButton jButtonGerar;
	private javax.swing.JButton jButtonVoltar;
	private javax.swing.JCheckBox jCheckBoxCalcularDistancia;
	private javax.swing.JCheckBox jCheckBoxLista;
	private javax.swing.JCheckBox jCheckBoxPDF;
	private javax.swing.JCheckBox jCheckBoxVisualizacao;
	private javax.swing.JComboBox<String> jComboBoxDia;
	private javax.swing.JComboBox<String> jComboBoxGaragem;
	private javax.swing.JLabel jLabelDia;
	private javax.swing.JLabel jLabelDistancia;
	private javax.swing.JLabel jLabelGaragem;
	private javax.swing.JLabel jLabelGerar;
	private javax.swing.JLabel jLabelOrganizarPor;
	private javax.swing.JLabel jLabelTitulo;
	private javax.swing.JRadioButton jRadioButtonHoraSaida;
	private javax.swing.JRadioButton jRadioButtonNumeroCarro;
	private javax.swing.JRadioButton jRadioButtonNumeroLinha;
	private javax.swing.JTextField jTextFieldDistanciaHorizontal;
	private javax.swing.JTextField jTextFieldDistanciaVertical;
	// End of variables declaration
}
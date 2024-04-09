/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.stagebus.view;

import java.util.List;

import javax.swing.SwingWorker;

/**
 *
 * @author User
 */
public class Tela_Mensagem_Redirecionar extends javax.swing.JFrame {

	private static String redirecionar;

	public static void setRedirecionar(String s) {

		redirecionar = s;
	}

	/**
	 * Creates new form Tela_Mensagem
	 */
	public Tela_Mensagem_Redirecionar() {
		initComponents();
		getContentPane().setBackground(java.awt.Color.WHITE);

		setExtendedState(MAXIMIZED_BOTH);

		contador();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabelMensagem = new javax.swing.JLabel();
		jLabelNumero = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabelMensagem.setBackground(new java.awt.Color(255, 255, 255));
		jLabelMensagem.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
		jLabelMensagem.setForeground(new java.awt.Color(68, 114, 196));
		jLabelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		if (redirecionar.contains("e"))
			jLabelMensagem.setText("Alteração(ões) realizada(s)! Redirecionando em:");
		else if (redirecionar.contains("d"))
			jLabelMensagem.setText("Exclusão realizada! Redirecionando em:");
		else
			jLabelMensagem.setText("Cadastro realizado! Redirecionando em:");
		jLabelMensagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jLabelNumero.setBackground(new java.awt.Color(255, 255, 255));
		jLabelNumero.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
		jLabelNumero.setForeground(new java.awt.Color(68, 114, 196));
		jLabelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelNumero.setText("3");
		jLabelNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(78, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 743,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 743,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(79, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(74, Short.MAX_VALUE)
										.addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(120, Short.MAX_VALUE)));

		pack();

	}// </editor-fold>

	public void contador() {
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (int i = 3; i >= 0; i--) {
					publish(i); // Atualiza o número na EDT

					Thread.sleep(1000);
				}
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// Atualiza a interface gráfica com o número atual
				int numeroAtual = chunks.get(chunks.size() - 1);
				jLabelNumero.setText(String.valueOf(numeroAtual));
			}

			@Override
			protected void done() {
				// Quando o contador chegar a 0, redireciona para a nova tela
				switch (redirecionar) {
				case "f", "fe", "fd": {
					new Tela_Funcionario_Geral().setVisible(true);
					setVisible(false);
					break;
				}
				case "l", "le", "ld": {
					new Tela_Linha_Geral().setVisible(true);
					setVisible(false);
					break;
				}

				case "t", "te", "td": {
					new Tela_TipoCarro_Geral().setVisible(true);
					setVisible(false);
					break;
				}

				case "c", "ce", "cd": {
					new Tela_Carro_Geral().setVisible(true);
					setVisible(false);
					break;
				}

				case "g", "ge", "gd": {
					new Tela_Garagem_Geral().setVisible(true);
					setVisible(false);
					break;
				}

				case "h", "he", "hd": {
					new Tela_Horario_Geral().setVisible(true);
					setVisible(false);
					break;
				}

				case "u", "ue", "ud": {
					new Tela_Usuario_Geral().setVisible(true);
					setVisible(false);
					break;
				}
				

				default:
					throw new IllegalArgumentException("Unexpected value: " + redirecionar);
				}

			}
		};

		// Execute o SwingWorker
		worker.execute();

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
			java.util.logging.Logger.getLogger(Tela_Mensagem_Redirecionar.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Tela_Mensagem_Redirecionar.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Tela_Mensagem_Redirecionar.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Tela_Mensagem_Redirecionar.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Tela_Mensagem_Redirecionar().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabelMensagem;
	private javax.swing.JLabel jLabelNumero;
	// End of variables declaration
}

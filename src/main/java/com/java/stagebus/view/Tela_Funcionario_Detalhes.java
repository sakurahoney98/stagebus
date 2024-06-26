/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.stagebus.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.java.stagebus.controller.FuncionarioController;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.UsuarioModel;

/**
 *
 * @author User
 */
public class Tela_Funcionario_Detalhes extends javax.swing.JFrame {
	
	private static UsuarioModel userModel;
	private static FuncionarioModel employee = new FuncionarioModel();
	private FuncionarioController employeeController = new FuncionarioController();
	
	

    /**
     * Creates new form Tela_1
     */
    public Tela_Funcionario_Detalhes() {
    	userModel = Tela_1.getDataUser();
    	employee = Tela_Funcionario_Geral.getEmployee();
        initComponents();
         getContentPane().setBackground(java.awt.Color.WHITE);
      
        setExtendedState(MAXIMIZED_BOTH);
        
        ImageIcon icon = new ImageIcon("src/main/resources/Images/imagem_funcionario_default.png");
        Image image = icon.getImage().getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_SMOOTH);
        jLabelImagem.setIcon(new ImageIcon(image));
        
       
        icon = new ImageIcon("src/main/resources/Images/btn_voltar.png");
        image = icon.getImage().getScaledInstance(jButtonVoltar.getWidth(), jButtonVoltar.getHeight(), Image.SCALE_SMOOTH);
        jButtonVoltar.setIcon(new ImageIcon(image));
        
        ImageIcon icon2;
       
     
        if(userModel.isEd_fun()) {
        	icon = new ImageIcon("src/main/resources/Images/btn_editar.png");
        icon2 = new ImageIcon("src/main/resources/Images/btn_excluir.png");
        }
        else {
        	icon2 = new ImageIcon("src/main/resources/Images/btn_excluir_bloq.png");
        	 icon = new ImageIcon("src/main/resources/Images/btn_editar_bloq.png");
        	 jButtonEditar.setEnabled(false);
        	 jButtonExcluir.setEnabled(false);
        }
        
        image = icon.getImage().getScaledInstance(jButtonEditar.getWidth(), jButtonEditar.getHeight(), Image.SCALE_SMOOTH);
        jButtonEditar.setIcon(new ImageIcon(image));
        
        image = icon2.getImage().getScaledInstance(jButtonExcluir.getWidth(), jButtonExcluir.getHeight(), Image.SCALE_SMOOTH);
        jButtonExcluir.setIcon(new ImageIcon(image));
        
        
    

  
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabelImagem = new javax.swing.JLabel();
        jLabelApelido = new javax.swing.JLabel();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelFuncao = new javax.swing.JLabel();
        jLabelApelidoValue = new javax.swing.JLabel();
        jLabelFuncaoValue = new javax.swing.JLabel();
        jLabelMatriculaValue = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jLabelVinculos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabelNome.setFont(new java.awt.Font("Calibri", 1, 38)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(127, 127, 127));
        jLabelNome.setText(employee.getNome());
        
        

        jButtonEditar.setBorder(null);
		jButtonEditar.setBackground(Color.WHITE);
		jButtonEditar.setBorderPainted(false);
		jButtonEditar.setContentAreaFilled(false);
		jButtonEditar.setCursor(new Cursor(HAND_CURSOR));
		jButtonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonEditarMouseClicked(evt);
			}

		});

		jButtonExcluir.setBorder(null);
		jButtonExcluir.setBorderPainted(false);
		jButtonExcluir.setContentAreaFilled(false);
		jButtonExcluir.setCursor(new Cursor(HAND_CURSOR));
		jButtonExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonExcluirMouseClicked(evt);
			}

		});

		jButtonVoltar.setBorder(null);
		jButtonVoltar.setBorderPainted(false);
		jButtonVoltar.setContentAreaFilled(false);
		jButtonVoltar.setCursor(new Cursor(HAND_CURSOR));
		jButtonVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonVoltarMouseClicked(evt);
			}

		});

        jLabelApelido.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelApelido.setForeground(new java.awt.Color(68, 114, 196));
        jLabelApelido.setText("Apelido:");

        jLabelMatricula.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelMatricula.setForeground(new java.awt.Color(68, 114, 196));
        jLabelMatricula.setText("Matrícula:");

        jLabelFuncao.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelFuncao.setForeground(new java.awt.Color(68, 114, 196));
        jLabelFuncao.setText("Função:");

        jLabelApelidoValue.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelApelidoValue.setForeground(new java.awt.Color(127, 127, 127));
        jLabelApelidoValue.setText(employee.getApelido());

        jLabelFuncaoValue.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelFuncaoValue.setForeground(new java.awt.Color(127, 127, 127));
        jLabelFuncaoValue.setText(employee.getTipo());

        jLabelMatriculaValue.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelMatriculaValue.setForeground(new java.awt.Color(127, 127, 127));
        jLabelMatriculaValue.setText(employee.getMatricula());
        
        jLabelVinculos.setBackground(new java.awt.Color(255, 255, 255));
        jLabelVinculos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelVinculos.setForeground(new java.awt.Color(68, 114, 196));
        jLabelVinculos.setText("Visualizar vínculos com horários");
        jLabelVinculos.setCursor(new Cursor(HAND_CURSOR));
        jLabelVinculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVinculosMouseClicked(evt);
            }
        });
        

       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelVinculos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jLabelApelido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelApelidoValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMatriculaValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelFuncaoValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(941, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelApelidoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMatriculaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFuncaoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addComponent(jLabelVinculos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(666, Short.MAX_VALUE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(90, 90, 90)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void jButtonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarMouseClicked
        if(jButtonEditar.isEnabled()) {
        	new Tela_Funcionario_Editar().setVisible(true);
        	setVisible(false);
        }
    }//GEN-LAST:event_jButtonEditarMouseClicked

    private void jButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirMouseClicked
    	 if(jButtonExcluir.isEnabled()) {
      	   Tela_Mensagem_Confirmacao.setRedirecionar("f");
             new Tela_Mensagem_Confirmacao().setVisible(true);
             setVisible(false);
         }
    }//GEN-LAST:event_jButtonExcluirMouseClicked



    private void jButtonVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVoltar1MouseClicked
       new Tela_Funcionario_Geral().setVisible(true);
       setVisible(false);
    	// TODO add your handling code here:
    }//GEN-LAST:event_jButtonVoltar1MouseClicked
    
    private void jLabelVinculosMouseClicked(java.awt.event.MouseEvent evt) { 
    	Tela_Funcionario_Horario.setIdEmployee(employee.getId());
      new Tela_Funcionario_Horario().setVisible(true);
       setVisible(false);
    }  


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Funcionario_Detalhes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelApelido;
    private javax.swing.JLabel jLabelApelidoValue;
    private javax.swing.JLabel jLabelFuncao;
    private javax.swing.JLabel jLabelFuncaoValue;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelMatriculaValue;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelVinculos;
    // End of variables declaration//GEN-END:variables
}

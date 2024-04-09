/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.stagebus.view;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.java.stagebus.controller.FuncionarioController;
import com.java.stagebus.model.FuncionarioModel;
import com.java.stagebus.model.UsuarioModel;

/**
 *
 * @author User
 */
public class Tela_Funcionario_Editar extends javax.swing.JFrame {
	
	private FuncionarioController employeeController = new FuncionarioController();
	private static UsuarioModel userModel;
	private FuncionarioModel employee;

    /**
     * Creates new form Tela_Funcionario_Novo
     */
    public Tela_Funcionario_Editar() {
		userModel = Tela_1.getDataUser();
		employee = Tela_Funcionario_Geral.getEmployee();
		initComponents();
		getContentPane().setBackground(java.awt.Color.WHITE);

		setExtendedState(MAXIMIZED_BOTH);

		ImageIcon icon = new ImageIcon("src/main/resources/Images/titulo_editar_funcionario.png");
		Image image = icon.getImage().getScaledInstance(jLabelTitulo.getWidth(), jLabelTitulo.getHeight(),
				Image.SCALE_SMOOTH);
		jLabelTitulo.setIcon(new ImageIcon(image));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	 jLabelTitulo = new javax.swing.JLabel();
         jLabelNome = new javax.swing.JLabel();
         jTextFieldNomeValue = new javax.swing.JTextField();
         jLabelApelido = new javax.swing.JLabel();
         jTextFieldApelidoValue = new javax.swing.JTextField();
         jLabelMatricula = new javax.swing.JLabel();
         jTextFieldMatriculaValue = new javax.swing.JTextField();
         jLabelTipo = new javax.swing.JLabel();
         jComboBoxTipo = new javax.swing.JComboBox<>();
         jButtonCancelar = new javax.swing.JButton();
         jButtonSalvar = new javax.swing.JButton();
         jScrollPane1 = new javax.swing.JScrollPane();
         jTextAreaMensagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(68, 114, 196));
        jLabelNome.setText("Nome completo:");

        jTextFieldNomeValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldNomeValue.setForeground(new java.awt.Color(127, 127, 127));
        jTextFieldNomeValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
        jTextFieldNomeValue.setText(employee.getNome());

   

        jLabelApelido.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelApelido.setForeground(new java.awt.Color(68, 114, 196));
        jLabelApelido.setText("Apelido:");

        jTextFieldApelidoValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldApelidoValue.setForeground(new java.awt.Color(127, 127, 127));
        jTextFieldApelidoValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
        jTextFieldApelidoValue.setText(employee.getApelido());
     

        jLabelMatricula.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelMatricula.setForeground(new java.awt.Color(68, 114, 196));
        jLabelMatricula.setText("Matrícula:");

        jTextFieldMatriculaValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextFieldMatriculaValue.setForeground(new java.awt.Color(127, 127, 127));
        jTextFieldMatriculaValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
        jTextFieldMatriculaValue.setText(employee.getMatricula());

        jLabelTipo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(68, 114, 196));
        jLabelTipo.setText("Tipo:");

        String[] listType = employeeController.generateListOfTypeEmployee(employeeController.listOfTypeEmployee());
        
        jComboBoxTipo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jComboBoxTipo.setForeground(new java.awt.Color(127, 127, 127));
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(listType));
        jComboBoxTipo.setBorder(null);
        
        for (int i = 0; i < listType.length; i++) {
			String aux = listType[i].substring(0, (listType[i].indexOf("-") - 1));
			if (Integer.parseInt(aux) == employee.getIdTipo()) {
				jComboBoxTipo.setSelectedIndex(i);
				break;
			}
		}

        jButtonCancelar.setBackground(new java.awt.Color(68, 114, 196));
        jButtonCancelar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(68, 114, 196));
        jButtonSalvar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setBorder(null);
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseClicked(evt);
            }
        });

        jTextAreaMensagem.setEditable(false);
        jTextAreaMensagem.setColumns(20);
        jTextAreaMensagem.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jTextAreaMensagem.setForeground(new java.awt.Color(255, 0, 0));
        jTextAreaMensagem.setLineWrap(true);
        jTextAreaMensagem.setRows(3);
        jTextAreaMensagem.setWrapStyleWord(true);
        jTextAreaMensagem.setBorder(null);
        
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaMensagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomeValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldApelidoValue)
                            .addComponent(jLabelApelido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMatriculaValue)
                            .addComponent(jLabelMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldApelidoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMatriculaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        pack();
        
    }// </editor-fold>                        

                                                       

    private void jButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {                                           
      if(employeeController.update(userModel.getId(), employee, jTextFieldNomeValue.getText(), jTextFieldApelidoValue.getText(), jTextFieldMatriculaValue.getText(), jComboBoxTipo.getSelectedItem().toString())) {
    	 Tela_Mensagem_Redirecionar.setRedirecionar("fe");
    	  new Tela_Mensagem_Redirecionar().setVisible(true);
    	  setVisible(false);
      }else
    	  
    	  jTextAreaMensagem.setText(employeeController.getMessage());
    	  
    }                                          

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {                                             
        new Tela_Funcionario_Detalhes().setVisible(true);
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
            java.util.logging.Logger.getLogger(Tela_Funcionario_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Funcionario_Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Funcionario_Editar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabelApelido;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMensagem;
    private javax.swing.JTextField jTextFieldApelidoValue;
    private javax.swing.JTextField jTextFieldCodigoValue;
    private javax.swing.JTextField jTextFieldMatriculaValue;
    private javax.swing.JTextField jTextFieldNomeValue;
    // End of variables declaration                   
}
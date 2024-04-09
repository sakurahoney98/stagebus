package com.java.stagebus.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.java.stagebus.controller.UsuarioController;
import com.java.stagebus.model.UsuarioModel;

/**
 *
 * @author User
 */
@SuppressWarnings("serial")
public class Tela_Usuario_Geral extends javax.swing.JFrame {
	
	private UsuarioController userController = new UsuarioController();
	private static UsuarioModel userModel;
	private static UsuarioModel user = new UsuarioModel();
	
	public static UsuarioModel getUser() {
		return user;
	}

    /**
     * Creates new form Tela_1
     */
    public Tela_Usuario_Geral() {
    	userModel = Tela_1.getDataUser();
        initComponents();
         getContentPane().setBackground(java.awt.Color.WHITE);
      
        setExtendedState(MAXIMIZED_BOTH);
        
       
        ImageIcon icon = new ImageIcon("src/main/resources/Images/titulo_usuario.png");
        Image image = icon.getImage().getScaledInstance(jLabelTitulo.getWidth(), jLabelTitulo.getHeight(), Image.SCALE_SMOOTH);
        jLabelTitulo.setIcon(new ImageIcon(image));
        
        icon = new ImageIcon("src/main/resources/Images/btn_home.png");
        image = icon.getImage().getScaledInstance(jButtonHome.getWidth(), jButtonHome.getHeight(), Image.SCALE_SMOOTH);
        jButtonHome.setIcon(new ImageIcon(image));
        
       
        
       
                
       
                 
  
      
       
  
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  
	private void initComponents() {

    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButtonHome = new javax.swing.JButton();
        
        // Dados da tabela
        Object[][] dados = userController.generateUserList(userController.listOfUsers());

        // Nomes das colunas
        String[] colunas = {"Id", "Nome", "Login"};

        // Modelo da tabela
        DefaultTableModel model = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Torna todas as células não editáveis
            }
        };

        // Tabela com modelo personalizado
        jTableUsuarios = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);

                // Alterna a cor de fundo de linhas ímpares e pares
                if (!isRowSelected(row)) {
                    comp.setBackground(row % 2 == 0 ? new Color(207, 213, 234) : new Color(233, 235, 245));
                }

                return comp;
            }
        };
       
        
    

        

        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldBuscar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jTextFieldBuscar.setForeground(new java.awt.Color(127, 127, 127));
        jTextFieldBuscar.setText("Buscar...");
        jTextFieldBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
        jTextFieldBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldBuscarMouseClicked(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
        });

        jButtonNovo.setCursor(new Cursor(HAND_CURSOR));
        jButtonNovo.setBackground(Color.WHITE);
        jButtonNovo.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jButtonNovo.setForeground(new java.awt.Color(127, 127, 127));
        jButtonNovo.setText("NOVO USUÁRIO");
        jButtonNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 127, 127), 2, true));
        jButtonNovo.setEnabled(false);
        if(userModel.isCad_user()) {
        jButtonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	jButtonNovoMouseClicked(evt);
            }
        });
        
        jButtonNovo.setEnabled(true);
        }
        	
        	

       
     

        jButtonHome.setBorder(null);
        jButtonHome.setCursor(new Cursor(HAND_CURSOR));
        jButtonHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	jButtonHomeMouseClicked(evt);
            }
        });
        
        jTableUsuarios.setFont(new java.awt.Font("Calibri", 1, 18));
        jTableUsuarios.setForeground(new Color(68, 114, 196));
        jTableUsuarios.setRowHeight(30);
        jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
    	jTableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(900);
    	jTableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
      
       
        
        JTableHeader header = jTableUsuarios.getTableHeader();
        header.setBackground(new Color(68, 114, 196));
        header.setFont(new java.awt.Font("Calibri", 1, 18));
        header.setForeground(Color.BLACK);
        
        jScrollPane1.setViewportView(jTableUsuarios);

        add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>                        

    private void jTextFieldBuscarMouseClicked(java.awt.event.MouseEvent evt) {                                              
       jTextFieldBuscar.setText("");
    }                                             

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {                                          
        
    	  Object[][] dados = userController.generateUserList(userController.search(jTextFieldBuscar.getText()));
    	    DefaultTableModel model = (DefaultTableModel) jTableUsuarios.getModel();
    	    model.setDataVector(dados, new String[]{"Id", "Nome", "Login"});
    }

   
                                        

   

    
    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {
    	
    	Object value = jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 0);
    	int id = Integer.parseInt(value.toString());
        user = userController.searchByID(id); 
        new Tela_Usuario_Detalhes().setVisible(true);
        setVisible(false);
    }  
    
    private void jButtonHomeMouseClicked(java.awt.event.MouseEvent evt) {                                          
        new Tela_Inicial().setVisible(true);
        setVisible(false);
    } 
    
    private void jButtonNovoMouseClicked(java.awt.event.MouseEvent evt) {                                          
       new Tela_Usuario_Novo().setVisible(true);
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
            java.util.logging.Logger.getLogger(Tela_Usuario_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Usuario_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Usuario_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Usuario_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Usuario_Geral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration                   
}


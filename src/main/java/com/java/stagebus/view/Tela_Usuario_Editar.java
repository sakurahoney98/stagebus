/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.java.stagebus.view;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import com.java.stagebus.controller.UsuarioController;
import com.java.stagebus.model.UsuarioModel;

/**
 *
 * @author User
 */
public class Tela_Usuario_Editar extends javax.swing.JFrame {

	private List<JCheckBox> checks;

	private List<String> permissions = new ArrayList<String>();
	private UsuarioController userController = new UsuarioController();
	private static UsuarioModel userModel;
	private UsuarioModel user = new UsuarioModel();

	/**
	 * Creates new form Tela_Funcionario_Novo
	 */
	public Tela_Usuario_Editar() {
		userModel = Tela_1.getDataUser();
		user = Tela_Usuario_Geral.getUser();
		initComponents();
		getContentPane().setBackground(java.awt.Color.WHITE);

		setExtendedState(MAXIMIZED_BOTH);

		ImageIcon icon = new ImageIcon("src/main/resources/Images/titulo_editar_usuario.png");
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
		jButtonCancelar = new javax.swing.JButton();
		jButtonSalvar = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaMensagem = new javax.swing.JTextArea();
		jLabelSobrenome = new javax.swing.JLabel();
		jLabelLogin = new javax.swing.JLabel();
		jLabelSenha = new javax.swing.JLabel();
		jLabelConfirmacao = new javax.swing.JLabel();
		jTextFieldNomeValue = new javax.swing.JTextField();
		jTextFieldSobrenomeValue = new javax.swing.JTextField();
		jTextFieldLoginValue = new javax.swing.JTextField();
		jTextFieldSenhaValue = new javax.swing.JPasswordField();
		jTextFieldConfirmacaoValue = new javax.swing.JPasswordField();
		jLabelPermissoes = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jCheckBox3 = new javax.swing.JCheckBox();
		jCheckBox4 = new javax.swing.JCheckBox();
		jCheckBox5 = new javax.swing.JCheckBox();
		jCheckBox6 = new javax.swing.JCheckBox();
		jCheckBox7 = new javax.swing.JCheckBox();
		jCheckBox8 = new javax.swing.JCheckBox();
		jCheckBox9 = new javax.swing.JCheckBox();
		jCheckBox10 = new javax.swing.JCheckBox();
		jCheckBox11 = new javax.swing.JCheckBox();
		jCheckBox12 = new javax.swing.JCheckBox();
		jCheckBox13 = new javax.swing.JCheckBox();
		jCheckBox14 = new javax.swing.JCheckBox();
		jCheckBox15 = new javax.swing.JCheckBox();
		jCheckBox16 = new javax.swing.JCheckBox();
		jCheckBox17 = new javax.swing.JCheckBox();
		jCheckBox18 = new javax.swing.JCheckBox();

		checks = Arrays.asList(jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6, jCheckBox7,
				jCheckBox8, jCheckBox9, jCheckBox10, jCheckBox11, jCheckBox12, jCheckBox13, jCheckBox14, jCheckBox15,
				jCheckBox16, jCheckBox17, jCheckBox18);
		
		if(!userModel.isPerm_user()) {
			for(JCheckBox c : checks) {
				c.setEnabled(false);
				c.setForeground(new Color(191, 191, 191));
			}
		}
		
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabelNome.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelNome.setForeground(new java.awt.Color(68, 114, 196));
		jLabelNome.setText("Nome:");

	

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

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
		jScrollPane1.setBorder(null);

		jTextAreaMensagem.setEditable(false);
		jTextAreaMensagem.setColumns(20);
		jTextAreaMensagem.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
		jTextAreaMensagem.setForeground(new java.awt.Color(255, 0, 0));
		jTextAreaMensagem.setLineWrap(true);
		jTextAreaMensagem.setRows(3);
		jTextAreaMensagem.setWrapStyleWord(true);
		jTextAreaMensagem.setBorder(null);
		jScrollPane1.setViewportView(jTextAreaMensagem);

		jLabelSobrenome.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelSobrenome.setForeground(new java.awt.Color(68, 114, 196));
		jLabelSobrenome.setText("Sobrenome");

		jLabelLogin.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelLogin.setForeground(new java.awt.Color(68, 114, 196));
		jLabelLogin.setText("Login:");

		jLabelSenha.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelSenha.setForeground(new java.awt.Color(68, 114, 196));
		jLabelSenha.setText("Senha:");

		jLabelConfirmacao.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelConfirmacao.setForeground(new java.awt.Color(68, 114, 196));
		jLabelConfirmacao.setText("Confirmação:");

		jTextFieldNomeValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jTextFieldNomeValue.setForeground(new java.awt.Color(127, 127, 127));
		jTextFieldNomeValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
		jTextFieldNomeValue.setText(user.getNome());

		jTextFieldSobrenomeValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jTextFieldSobrenomeValue.setForeground(new java.awt.Color(127, 127, 127));
		jTextFieldSobrenomeValue
				.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
		jTextFieldSobrenomeValue.setText(user.getSobrenome());

		jTextFieldLoginValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jTextFieldLoginValue.setForeground(new java.awt.Color(127, 127, 127));
		jTextFieldLoginValue
				.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
		jTextFieldLoginValue.setText(user.getLogin());

		jTextFieldSenhaValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jTextFieldSenhaValue.setForeground(new java.awt.Color(127, 127, 127));
		jTextFieldSenhaValue
				.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));
		

		jTextFieldConfirmacaoValue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		jTextFieldConfirmacaoValue.setForeground(new java.awt.Color(127, 127, 127));
		jTextFieldConfirmacaoValue
				.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));

		jLabelPermissoes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		jLabelPermissoes.setForeground(new java.awt.Color(68, 114, 196));
		jLabelPermissoes.setText("Permissões:");

		jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox1.setText("Cadastrar usuário");
		jCheckBox1.setName("cad_user"); // NOI18N
		jCheckBox1.setSelected(user.isCad_user());

		jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox2.setText("Cadastrar carro");
		jCheckBox2.setName("cad_car"); // NOI18N
		jCheckBox2.setSelected(user.isCad_car());

		jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox3.setText("Cadastrar garagem");
		jCheckBox3.setName("cad_gar"); // NOI18N
		jCheckBox3.setSelected(user.isCad_gar());

		jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox4.setText("Cadastrar linha");
		jCheckBox4.setName("cad_lin"); // NOI18N
		jCheckBox4.setSelected(user.isCad_lin());

		jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox5.setText("Cadastrar tipo de carro");
		jCheckBox5.setName("cad_tip_car"); // NOI18N
		jCheckBox5.setSelected(user.isCad_tip_car());

		jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox6.setText("Cadastrar funcionário");
		jCheckBox6.setName("cad_fun"); // NOI18N
		jCheckBox6.setSelected(user.isCad_fun());

		jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox7.setText("Editar usuário");
		jCheckBox7.setName("ed_user"); // NOI18N
		jCheckBox7.setSelected(user.isEd_user());

		jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox8.setText("Editar carro");
		jCheckBox8.setName("ed_car"); // NOI18N
		jCheckBox8.setSelected(user.isEd_car());

		jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox9.setText("Editar garagem");
		jCheckBox9.setName("ed_gar"); // NOI18N
		jCheckBox9.setSelected(user.isEd_gar());

		jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox10.setText("Editar linha");
		jCheckBox10.setName("ed_lin"); // NOI18N
		jCheckBox10.setSelected(user.isEd_lin());

		jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox11.setText("Editar tipo de carro");
		jCheckBox11.setName("ed_tip_car"); // NOI18N
		jCheckBox11.setSelected(user.isEd_tip_car());

		jCheckBox12.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox12.setText("Editar funcionário");
		jCheckBox12.setName("ed_fun"); // NOI18N
		jCheckBox12.setSelected(user.isEd_fun());

		jCheckBox13.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox13.setText("Emitir relatórios");
		jCheckBox13.setName("em_rel"); // NOI18N
		jCheckBox13.setSelected(user.isEm_rel());

		jCheckBox14.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox14.setText("Criar/editar horários");
		jCheckBox14.setName("cad_ed_hor"); // NOI18N
		jCheckBox14.setSelected(user.isCad_ed_hor());

		jCheckBox15.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox15.setText("Atribuir função usuário");
		jCheckBox15.setName("perm_user"); // NOI18N
		jCheckBox15.setSelected(user.isPerm_user());

		jCheckBox16.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox16.setText("Ativar/desativar usuário");
		jCheckBox16.setName("at_des_user"); // NOI18N
		jCheckBox16.setSelected(user.isAt_des_user());

		jCheckBox17.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox17.setText("Excluir usuário");
		jCheckBox17.setName("exc_user"); // NOI18N
		jCheckBox17.setSelected(user.isExc_user());

		jCheckBox18.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox18.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		jCheckBox18.setText("Ativo");
		jCheckBox18.setName("status_ativo"); // NOI18N
		jCheckBox18.setSelected(user.isStatus());

		 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(332, Short.MAX_VALUE)
	                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(40, 40, 40)
	                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(454, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(100, 100, 100)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane1)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(0, 0, Short.MAX_VALUE)))
	                        .addGap(166, 166, 166))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabelLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jTextFieldNomeValue, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jTextFieldLoginValue, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabelPermissoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addGap(46, 46, 46)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabelSobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jTextFieldSobrenomeValue)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jTextFieldSenhaValue)
	                                    .addComponent(jLabelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addGap(50, 50, 50)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jTextFieldConfirmacaoValue)
	                                    .addComponent(jLabelConfirmacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                        .addGap(200, 200, 200))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
	                        .addGap(61, 61, 61)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
	                        .addGap(61, 61, 61)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jCheckBox16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jCheckBox17, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
	                            .addComponent(jCheckBox18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
	                        .addGap(564, 564, 564))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(100, 100, 100)
	                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabelSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jTextFieldNomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jTextFieldSobrenomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabelConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jTextFieldLoginValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jTextFieldSenhaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jTextFieldConfirmacaoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(jLabelPermissoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(jCheckBox1)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox2)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox3)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox4)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox5)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox6))
	                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                            .addComponent(jCheckBox13)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox14)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox15)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox16)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox17)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jCheckBox18)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jCheckBox7)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jCheckBox8)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jCheckBox9)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jCheckBox10)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jCheckBox11)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jCheckBox12)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(50, 50, 50))
	        );

	        jCheckBox1.getAccessibleContext().setAccessibleName("");
	        jCheckBox2.getAccessibleContext().setAccessibleName("");
	        jCheckBox3.getAccessibleContext().setAccessibleName("");
	        jCheckBox4.getAccessibleContext().setAccessibleName("");
	        jCheckBox5.getAccessibleContext().setAccessibleName("");

	        pack();
	}// </editor-fold>

	private void jButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {
		for (JCheckBox c : checks) {
			if (c.isSelected())
				permissions.add(c.getName());
		}

		if (userController.update(userModel.getId(), user,
				jTextFieldLoginValue.getText(), jTextFieldSenhaValue.getText(), jTextFieldConfirmacaoValue.getText(),
				jTextFieldNomeValue.getText(), jTextFieldSobrenomeValue.getText(), permissions)) {
			Tela_Mensagem_Redirecionar.setRedirecionar("ue");
			new Tela_Mensagem_Redirecionar().setVisible(true);
			setVisible(false);
		} else
			jTextAreaMensagem.setText(userController.getMessage());

	}

	private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {
		new Tela_Usuario_Geral().setVisible(true);
		setVisible(false);
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
			java.util.logging.Logger.getLogger(Tela_Usuario_Editar.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Tela_Usuario_Editar.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Tela_Usuario_Editar.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Tela_Usuario_Editar.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Tela_Usuario_Editar().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JButton jButtonSalvar;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox10;
	private javax.swing.JCheckBox jCheckBox11;
	private javax.swing.JCheckBox jCheckBox12;
	private javax.swing.JCheckBox jCheckBox13;
	private javax.swing.JCheckBox jCheckBox14;
	private javax.swing.JCheckBox jCheckBox15;
	private javax.swing.JCheckBox jCheckBox16;
	private javax.swing.JCheckBox jCheckBox17;
	private javax.swing.JCheckBox jCheckBox18;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JCheckBox jCheckBox4;
	private javax.swing.JCheckBox jCheckBox5;
	private javax.swing.JCheckBox jCheckBox6;
	private javax.swing.JCheckBox jCheckBox7;
	private javax.swing.JCheckBox jCheckBox8;
	private javax.swing.JCheckBox jCheckBox9;
	private javax.swing.JLabel jLabelConfirmacao;
	private javax.swing.JLabel jLabelLogin;
	private javax.swing.JLabel jLabelNome;
	private javax.swing.JLabel jLabelPermissoes;
	private javax.swing.JLabel jLabelSenha;
	private javax.swing.JLabel jLabelSobrenome;
	private javax.swing.JLabel jLabelTitulo;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextAreaMensagem;
	private javax.swing.JPasswordField jTextFieldConfirmacaoValue;
	private javax.swing.JTextField jTextFieldLoginValue;
	private javax.swing.JTextField jTextFieldNomeValue;
	private javax.swing.JPasswordField jTextFieldSenhaValue;
	private javax.swing.JTextField jTextFieldSobrenomeValue;
	// End of variables declaration
}

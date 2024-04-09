package com.java.stagebus.model;

public class UsuarioModel {
	private static final int DEFAULT_ID = 1;
	private static final String DEFAULT_NOME = "NAME";
	private static final String DEFAULT_SOBRENOME = "LAST_NAME";
	private static final String DEFAULT_LOGIN = "LOGIN";
	private static final String DEFAULT_SENHA = "PASSWORD";
	private static final boolean DEFAULT_CAD_USER = false;
	private static final boolean DEFAULT_CAD_CAR = false;
	private static final boolean DEFAULT_CAD_GAR = false;
	private static final boolean DEFAULT_CAD_LIN = false;
	private static final boolean DEFAULT_CAD_TIP_CAR = false;
	private static final boolean DEFAULT_CAD_FUN = false;
	private static final boolean DEFAULT_ED_USER = false;
	private static final boolean DEFAULT_ED_CAR = false;
	private static final boolean DEFAULT_ED_GAR = false;
	private static final boolean DEFAULT_ED_LIN = false;
	private static final boolean DEFAULT_ED_TIP_CAR = false;
	private static final boolean DEFAULT_ED_FUN = false;
	private static final boolean DEFAULT_EM_REL = false;
	private static final boolean DEFAULT_CAD_ED_HOR = false;
	private static final boolean DEFAULT_PERM_USER = false;
	private static final boolean DEFAULT_EXC_USER = false;
	private static final boolean DEFAULT_AT_DES_USER = false;
	private static final boolean DEFAULT_STATUS_ATIVO = false;

	private int id = DEFAULT_ID;
	private String nome = DEFAULT_NOME;
	private String sobrenome = DEFAULT_SOBRENOME;
	private String login = DEFAULT_LOGIN;
	private String senha = DEFAULT_SENHA;
	private boolean cad_user = DEFAULT_CAD_USER;
	private boolean cad_car = DEFAULT_CAD_CAR;
	private boolean cad_gar = DEFAULT_CAD_GAR;
	private boolean cad_lin = DEFAULT_CAD_LIN;
	private boolean cad_tip_car = DEFAULT_CAD_TIP_CAR;
	private boolean cad_fun = DEFAULT_CAD_FUN;
	private boolean ed_user = DEFAULT_ED_USER;
	private boolean ed_car = DEFAULT_ED_CAR;
	private boolean ed_gar = DEFAULT_ED_GAR;
	private boolean ed_lin = DEFAULT_ED_LIN;
	private boolean ed_tip_car = DEFAULT_ED_TIP_CAR;
	private boolean ed_fun = DEFAULT_ED_FUN;
	private boolean em_rel = DEFAULT_EM_REL;
	private boolean cad_ed_hor = DEFAULT_CAD_ED_HOR;
	private boolean perm_user = DEFAULT_PERM_USER;
	private boolean exc_user = DEFAULT_EXC_USER;
	private boolean at_des_user = DEFAULT_AT_DES_USER;
	private boolean status = DEFAULT_STATUS_ATIVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isCad_user() {
		return cad_user;
	}

	public void setCad_user(boolean cad_user) {
		this.cad_user = cad_user;
	}

	public boolean isCad_car() {
		return cad_car;
	}

	public void setCad_car(boolean cad_car) {
		this.cad_car = cad_car;
	}

	public boolean isCad_gar() {
		return cad_gar;
	}

	public void setCad_gar(boolean cad_gar) {
		this.cad_gar = cad_gar;
	}

	public boolean isCad_lin() {
		return cad_lin;
	}

	public void setCad_lin(boolean cad_lin) {
		this.cad_lin = cad_lin;
	}

	public boolean isCad_tip_car() {
		return cad_tip_car;
	}

	public void setCad_tip_car(boolean cad_tip_car) {
		this.cad_tip_car = cad_tip_car;
	}

	public boolean isCad_fun() {
		return cad_fun;
	}

	public void setCad_fun(boolean cad_fun) {
		this.cad_fun = cad_fun;
	}

	public boolean isEd_user() {
		return ed_user;
	}

	public void setEd_user(boolean ed_user) {
		this.ed_user = ed_user;
	}

	public boolean isEd_car() {
		return ed_car;
	}

	public void setEd_car(boolean ed_car) {
		this.ed_car = ed_car;
	}

	public boolean isEd_gar() {
		return ed_gar;
	}

	public void setEd_gar(boolean ed_gar) {
		this.ed_gar = ed_gar;
	}

	public boolean isEd_lin() {
		return ed_lin;
	}

	public void setEd_lin(boolean ed_lin) {
		this.ed_lin = ed_lin;
	}

	public boolean isEd_tip_car() {
		return ed_tip_car;
	}

	public void setEd_tip_car(boolean ed_tip_car) {
		this.ed_tip_car = ed_tip_car;
	}

	public boolean isEd_fun() {
		return ed_fun;
	}

	public void setEd_fun(boolean ed_fun) {
		this.ed_fun = ed_fun;
	}

	public boolean isEm_rel() {
		return em_rel;
	}

	public void setEm_rel(boolean em_rel) {
		this.em_rel = em_rel;
	}

	public boolean isCad_ed_hor() {
		return cad_ed_hor;
	}

	public void setCad_ed_hor(boolean cad_ed_hor) {
		this.cad_ed_hor = cad_ed_hor;
	}

	public boolean isPerm_user() {
		return perm_user;
	}

	public void setPerm_user(boolean perm_user) {
		this.perm_user = perm_user;
	}

	public boolean isExc_user() {
		return exc_user;
	}

	public void setExc_user(boolean exc_user) {
		this.exc_user = exc_user;
	}

	public boolean isAt_des_user() {
		return at_des_user;
	}

	public void setAt_des_user(boolean at_des_user) {
		this.at_des_user = at_des_user;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

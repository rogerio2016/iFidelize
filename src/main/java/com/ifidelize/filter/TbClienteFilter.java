package com.ifidelize.filter;

import java.io.Serializable;

public class TbClienteFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String des_cpf;
	private String des_rg;
	private String des_nome;
	
	public String getDes_cpf() {
		return des_cpf;
	}
	public void setDes_cpf(String des_cpf) {
		this.des_cpf = des_cpf == null?null :des_cpf.toUpperCase();
	}
	public String getDes_rg() {
		return des_rg;
	}
	public void setDes_rg(String des_rg) {
		this.des_rg = des_rg == null?null :des_rg.toUpperCase();
	}
	public String getDes_nome() {
		return des_nome;
	}
	public void setDes_nome(String des_nome) {
		this.des_nome = des_nome == null?null :des_nome.toUpperCase();		
	}
}

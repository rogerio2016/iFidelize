package com.ifidelize.filter;

import java.io.Serializable;

public class TbEmpresaFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String des_cnpj;	
	private String des_nome;
	
	public String getDes_cnpj() {
		return des_cnpj;
	}
	public void setDes_cnpj(String des_cnpj) {
		this.des_cnpj = des_cnpj == null?null :des_cnpj.toUpperCase();
	}
	
	public String getDes_nome() {
		return des_nome;
	}
	public void setDes_nome(String des_nome) {
		this.des_nome = des_nome == null?null :des_nome.toUpperCase();		
	}
}

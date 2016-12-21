package com.ifidelize.filter;

import java.io.Serializable;

public class TbUsuarioFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String des_nome;
	
	public String getDes_nome() {
		return des_nome;
	}
	public void setDes_nome(String des_nome) {
		this.des_nome = des_nome == null?null :des_nome.toUpperCase();		
	}
}

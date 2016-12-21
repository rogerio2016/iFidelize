package com.ifidelize.filter;

import java.io.Serializable;

public class TbTributacaoFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String des_descricao;

	public String getDes_descricao() {
		return des_descricao;
	}

	public void setDes_descricao(String des_descricao) {
		this.des_descricao = des_descricao == null?null :des_descricao.toUpperCase();
	}
	

}

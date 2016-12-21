package com.ifidelize.filter;

import java.io.Serializable;

public class TbProdutoFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer num_plu;
	private String des_codbarra;
	private String des_descricao;
	
	public Integer getNum_plu() {
		return num_plu;
	}
	public void setNum_plu(Integer num_plu) {
		this.num_plu = num_plu== null ? null :num_plu;
	}
	public String getDes_codbarra() {
		return des_codbarra;
	}
	public void setDes_codbarra(String des_codbarra) {
		this.des_codbarra = des_codbarra == null?null :des_codbarra.toUpperCase();
	}
	public String getDes_descricao() {
		return des_descricao;
	}
	public void setDes_descricao(String des_descricao) {
		this.des_descricao = des_descricao ==null?null:des_descricao.toUpperCase();
	}
	

}

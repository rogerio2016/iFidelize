package com.ifidelize.model;

public enum EnumTipoPessoa {

	FISICA("FISICA"), 
	JURIDICA("JURIDICA");
	
	private String descricao;

	EnumTipoPessoa(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

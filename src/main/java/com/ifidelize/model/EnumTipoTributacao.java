package com.ifidelize.model;

public enum EnumTipoTributacao {

	II("ISENTO"), 
	FF("SUBSTITUICAO"),
	NN("NAO TRIBUTADO"),
	TT("TRIBUTADO");
	
	private String descricao;

	EnumTipoTributacao(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

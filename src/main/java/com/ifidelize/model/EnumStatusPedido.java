package com.ifidelize.model;

public enum EnumStatusPedido {

	ORCAMENTO("ORÇAMENTO"),
	EMITIDO("EMITIDO"), 
	CANCELADO("CANCELADO");

	private String descricao;

	EnumStatusPedido(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

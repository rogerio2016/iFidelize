package com.ifidelize.model;

public enum enumTipoRegime {

	REGIME_SIMPLES("REGIME SIMPLES"), 
	REGIME_NORMAL("REGIME NORMAL"),
	REGIME_REAL("REGIME REAL");
	
	private String descricao;

	enumTipoRegime(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

package com.ifidelize.model;

public enum EnumUnidade {
	UN("UN"),
	KG("KG"),
	LT("LT"),
	VS("VS"),
	PC("PC"),
	MG("MG"),
	ML("ML");
	
	private String descricao;

	EnumUnidade(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}

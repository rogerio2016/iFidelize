package com.ifidelize.model;

public enum EnumFormaPagamento {

	DINHEIRO("DINHEIRO"), 
	CARTAO_CREDITO("CARTÃO CREDITO"), 
	CARTAO_DEBITO("CARTÃO DEBITO"),
	CHEQUE_VISTA("CHEQUE A VISTA"),
	CHEQUE_PRE("CHEQUE PRE"), 	
	BOLETO_BANCARIO("BOLETO BANCARIO"), 
	DEPOSITO_BANCARIO("DEPÓSITO BANCARIO");
	
	private String descricao;

	EnumFormaPagamento(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
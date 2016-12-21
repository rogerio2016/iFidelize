package com.ifidelize.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifidelize.model.EnumTipoTributacao;
import com.ifidelize.model.TbTributacao;
import com.ifidelize.service.TbCadastroTributacaoService;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTributacaoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private TbTributacao tributacao;
	@Inject
	private TbCadastroTributacaoService cadastroTributacaoService;
	
	public CadastroTributacaoBean() {
		limpar();
	}
		
	public void inicializar() {
		
		if (FacesUtil.isNotPostback()) {
	
		}
	}

	public EnumTipoTributacao[] getTipoTributacao() {
		return EnumTipoTributacao.values();
	}
	
	public void salvar(){
		this.tributacao = cadastroTributacaoService.salvar(this.tributacao);
		limpar();
		
		FacesUtil.addInfoMessage("Tributacao salva com sucesso!");
	}

	public TbTributacao getTributacao() {
		return tributacao;
	}

	public void setTributacao(TbTributacao tributacao) {
		this.tributacao = tributacao;
	}	
	
	private void limpar() {
		this.tributacao      = new TbTributacao();
	}

	public boolean isEditando() {
		return this.tributacao.getId() != null;
	}
}
 
package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifidelize.filter.TbTributacaoFilter;
import com.ifidelize.model.TbTributacao;
import com.ifidelize.repository.TbTributacaoRepository;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTributacaoBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private TbTributacaoRepository tributacaoRepository;
	
	private TbTributacaoFilter filtro;
	private List<TbTributacao> tributacoesFiltrados;
	private TbTributacao tributacaoSelecionado;
	
	public TbTributacao getTributacaoSelecionado() {
		return tributacaoSelecionado;
	}

	public void setTributacaoSelecionado(TbTributacao tributacaoSelecionado) {
		this.tributacaoSelecionado = tributacaoSelecionado;
	}

	public PesquisaTributacaoBean() {
		filtro = new TbTributacaoFilter();
	}
	
	public void pesquisar() {
		tributacoesFiltrados = tributacaoRepository.filtrados(filtro);
	}

	public void excluir() {
		tributacaoRepository.remover(tributacaoSelecionado);
		tributacoesFiltrados.remove(tributacaoSelecionado);
		
		FacesUtil.addInfoMessage("Tributacao " + tributacaoSelecionado.getDes_descricao()+ " excluído com sucesso.");
	}
	
	public List<TbTributacao> gettributacoesFiltrados() {
		return tributacoesFiltrados;
	}

	public TbTributacaoFilter getFiltro() {
		return filtro;
	}
	
}
 package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.ifidelize.model.EnumUnidade;
import com.ifidelize.model.TbGrupo;
import com.ifidelize.model.TbProduto;
import com.ifidelize.model.TbSubGrupo;
import com.ifidelize.model.TbTributacao;
import com.ifidelize.repository.TbGrupoRepository;
import com.ifidelize.repository.TbSubGrupoRepository;
import com.ifidelize.repository.TbTributacaoRepository;
import com.ifidelize.service.TbCadastroProdutoService;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private TbProduto produto;
	private List<TbGrupo> listarGrupo;
	private TbGrupo cod_grupo;
	private TbSubGrupo cod_subgrupo;
	private List<TbSubGrupo> listarSubGrupo;
	private List<TbTributacao> listarTributacao;
	@Inject
	private TbGrupoRepository grupoRepositorio;
	@Inject
	private TbSubGrupoRepository subGrupoRepository;
	@Inject 
	private TbTributacaoRepository tributacaoRepository;
	@Inject
	private TbCadastroProdutoService cadastroProdutoService;

	public EnumUnidade[] getUnidade() {
		return EnumUnidade.values();
	}
	
	public CadastroProdutoBean() {
		limpar();
	}
	
	public void inicializar() {
		
		if (FacesUtil.isNotPostback()) {
			System.out.println("Inicializando...");		
			listarGrupo 	 = grupoRepositorio.buscaGrupo();		
			listarTributacao = tributacaoRepository.buscaTributacao();			
		}
	}
	
	public void salvar(){
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	public void carregarSubGrupo() {
		listarSubGrupo = subGrupoRepository.subGruposDe(cod_grupo);
	}

	public void carregarTributacao(){
		listarTributacao = tributacaoRepository.buscaTributacao();
	}
	
	public TbProduto getProduto() {
		return produto;
	}

	public void setProduto(TbProduto produto) {
		this.produto = produto;
		if (this.produto != null) {
			this.cod_grupo = this.produto.getCod_grupo();
		}

	}	
	
	public List<TbGrupo> getListarGrupo() {
		return listarGrupo;
	}

	public TbGrupo getCod_grupo() {
		return cod_grupo;
	}

	public void setCod_grupo(TbGrupo cod_grupo) {
		this.cod_grupo = cod_grupo;
	}

	public List<TbSubGrupo> getListarSubGrupo() {
		return listarSubGrupo;
	}

	public void setCod_subgrupo(TbSubGrupo cod_subgrupo) {
		this.cod_subgrupo = cod_subgrupo;
	}
	
	public TbSubGrupo getCod_subgrupo() {
		return cod_subgrupo;
	}
	
	public List<TbTributacao> getListarTributacao() {
		return listarTributacao;
	}

	private void limpar() {
		this.produto      = new TbProduto();
		this.cod_grupo    = null;
		this.cod_subgrupo = null;
	}

	public boolean isEditando() {
		return this.produto.getId() != null;
	}
}

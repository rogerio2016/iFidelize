package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifidelize.filter.TbProdutoFilter;
import com.ifidelize.model.TbProduto;
import com.ifidelize.repository.TbProdutoRepository;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private TbProdutoRepository produtoRepository;
	
	private TbProdutoFilter filtro;
	private List<TbProduto> produtosFiltrados;
	private TbProduto produtoSelecionado;
	
	public TbProduto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(TbProduto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public PesquisaProdutosBean() {
		filtro = new TbProdutoFilter();
	}
	
	public void pesquisar() {
		produtosFiltrados = produtoRepository.filtrados(filtro);
	}

	public void excluir() {
		produtoRepository.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getNum_codbarra()+" - "+produtoSelecionado.getDes_descricao()
				+ " excluído com sucesso.");
	}
	
	public List<TbProduto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public TbProdutoFilter getFiltro() {
		return filtro;
	}
	
}
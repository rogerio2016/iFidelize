package com.ifidelize.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ifidelize.model.TbProduto;
import com.ifidelize.repository.TbProdutoRepository;
import com.ifidelize.util.jpa.Transacao;

public class TbCadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbProdutoRepository produtoRepository;
	@Transacao
	public TbProduto salvar(TbProduto produto) {
		TbProduto codBarraExistente = produtoRepository.porCodBarra(produto.getNum_codbarra());
		TbProduto pluExistente = produtoRepository.porPLU(produto.getNum_plu());
		if (codBarraExistente != null && !codBarraExistente.equals(produto) && produto.getId()==null) {
			throw new NegocioException("Já existe um produto com o Código de Barras informado.");
		}
		
		if (pluExistente != null && !pluExistente.equals(produto)) {
			throw new NegocioException("Já existe um produto com o PLU informado.");
		}
		
		return produtoRepository.guardar(produto);
	}
	
	public Integer qtdProdutoTotal(){	
		return 5000;
	}
	
}

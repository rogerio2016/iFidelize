package com.ifidelize.service;

import java.io.Serializable;

import javax.inject.Inject;
import com.ifidelize.model.TbItemPedido;
import com.ifidelize.model.TbPedido;
import com.ifidelize.repository.TbPedidoRepository;
import com.ifidelize.util.jpa.Transacao;

public class EstoqueService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbPedidoRepository pedidoRepository;
	
	@Transacao
	public void baixarItensEstoque(TbPedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		
		for (TbItemPedido item : pedido.getItens()) {
			item.getCod_produto().baixarEstoque(item.getNum_qtd());
		}
	}
	public void retornarItensEstoque(TbPedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		
		for (TbItemPedido item : pedido.getItens()) {
			item.getCod_produto().adicionarEstoque(item.getNum_qtd());
		}
	}

}

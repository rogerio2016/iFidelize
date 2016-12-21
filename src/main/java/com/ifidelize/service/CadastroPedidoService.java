package com.ifidelize.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.ifidelize.model.EnumStatusPedido;
import com.ifidelize.model.TbPedido;
import com.ifidelize.repository.TbPedidoRepository;
import com.ifidelize.util.jpa.Transacao;

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbPedidoRepository pedidoRepository;
	
	@Transacao
	public TbPedido salvar(TbPedido pedido) {
		if (pedido.isNovo()) {
			pedido.setDta_criacao(new Date());
			pedido.setStatus(EnumStatusPedido.ORCAMENTO);
		}
		
		pedido.recalcularValorTotal();

		if (pedido.isNaoAlteravel()) {
			throw new NegocioException("Pedido não pode ser alterado no status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		if (pedido.getItens().isEmpty()) {
			throw new NegocioException("O pedido deve possuir pelo menos um item.");
		}
		
		if (pedido.isValorTotalNegativo()) {
			throw new NegocioException("Valor total do pedido não pode ser negativo.");
		}
		
		pedido = this.pedidoRepository.guardar(pedido);
		return pedido;
	}
	
	public Integer qtdVendaTotal(){	
		return 1000;
	}
}

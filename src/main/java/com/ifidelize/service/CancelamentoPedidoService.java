package com.ifidelize.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ifidelize.model.EnumStatusPedido;
import com.ifidelize.model.TbPedido;
import com.ifidelize.repository.TbPedidoRepository;
import com.ifidelize.util.jpa.Transacao;

public class CancelamentoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbPedidoRepository pedidoRepository;
	
	@Inject
	private EstoqueService estoqueService;
	
	@Transacao
	public TbPedido cancelar(TbPedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		
		if (pedido.isNaoCancelavel()) {
			throw new NegocioException("Pedido não pode ser cancelado no status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		if (pedido.isEmitido()) {
			this.estoqueService.retornarItensEstoque(pedido);
		}
		
		pedido.setStatus(EnumStatusPedido.CANCELADO);
		
		pedido = this.pedidoRepository.guardar(pedido);
		
		return pedido;
	}
}

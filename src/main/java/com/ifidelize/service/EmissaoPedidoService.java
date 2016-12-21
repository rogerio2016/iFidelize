package com.ifidelize.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ifidelize.model.EnumStatusPedido;
import com.ifidelize.model.TbPedido;
import com.ifidelize.repository.TbPedidoRepository;
import com.ifidelize.util.jpa.Transacao;

public class EmissaoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private EstoqueService estoqueService;
	
	@Inject
	private TbPedidoRepository pedidoRepository;
	
	@Transacao
	public TbPedido emitir(TbPedido pedido) {
		pedido = this.cadastroPedidoService.salvar(pedido);
		
		if (pedido.isNaoEmissivel()) {
			throw new NegocioException("Pedido não pode ser emitido com status "
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		this.estoqueService.baixarItensEstoque(pedido);
		
		pedido.setStatus(EnumStatusPedido.EMITIDO);
		
		pedido = this.pedidoRepository.guardar(pedido);
		
		return pedido;
	}
}
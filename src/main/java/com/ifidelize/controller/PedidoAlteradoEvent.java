package com.ifidelize.controller;

import com.ifidelize.model.TbPedido;

public class PedidoAlteradoEvent {

	private TbPedido pedido;
	
	public PedidoAlteradoEvent(TbPedido pedido) {
		this.pedido = pedido;
	}

	public TbPedido getPedido() {
		return pedido;
	}
	
}

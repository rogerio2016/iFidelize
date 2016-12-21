package com.ifidelize.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.ifidelize.filter.TbPedidoFilter;
import com.ifidelize.model.EnumStatusPedido;
import com.ifidelize.model.TbPedido;
import com.ifidelize.repository.TbPedidoRepository;

@Named
@ViewScoped
public class PesquisaPedidosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TbPedidoRepository pedidoRepository;
	
	private TbPedidoFilter filtro;
	private List<TbPedido> pedidosFiltrados;
	
	public PesquisaPedidosBean() {
		filtro = new TbPedidoFilter();
		pedidosFiltrados = new ArrayList<>();
	}

	public void pesquisar() {
		pedidosFiltrados = pedidoRepository.filtrados(filtro);
	}

	public EnumStatusPedido[] getStatus() {
		return EnumStatusPedido.values();
	}
	public TbPedidoFilter getFiltro() {
		return filtro;
	}

	public List<TbPedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}
	
}
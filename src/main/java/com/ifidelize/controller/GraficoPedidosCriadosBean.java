package com.ifidelize.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.ifidelize.model.TbUsuario;
import com.ifidelize.repository.TbPedidoRepository;
import com.ifidelize.security.UsuarioLogado;
import com.ifidelize.security.UsuarioSistema;
import com.ifidelize.service.CadastroPedidoService;
import com.ifidelize.service.TbCadastroClienteService;
import com.ifidelize.service.TbCadastroProdutoService;

@Named
@RequestScoped
public class GraficoPedidosCriadosBean {

	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM");
	
	@Inject
	private TbPedidoRepository pedidos;
	
	@Inject
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;
	
	@Inject
	private TbCadastroClienteService clienteService;
	
	@Inject 
	private TbCadastroProdutoService produtoService;

	@Inject
	private CadastroPedidoService pedidoService;
	
	private CartesianChartModel model;
	
	public void preRender() {
		this.model = new CartesianChartModel();
		
		adicionarSerie("Todos os pedidos", null);
		adicionarSerie("Meus pedidos", usuarioLogado.getUsuario());
	}
	
	private void adicionarSerie(String rotulo, TbUsuario criadoPor) {
		Map<Date, BigDecimal> valoresPorData = this.pedidos.valoresTotaisPorData(15, criadoPor);
		
		ChartSeries series = new ChartSeries(rotulo);
		
		for (Date data : valoresPorData.keySet()) {
			series.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}
		
		this.model.addSeries(series);
	}
	public CartesianChartModel getModel() {
		return model;
	}		
	public Integer getTotalCliente(){		
		return clienteService.qtdClienteTotal();
	}
	public Integer getTotalVendas(){		
		return clienteService.qtdClienteTotal();
	}
	public Integer getTotalProduto(){
		return produtoService.qtdProdutoTotal();
	}
	public Integer getTotalVenda(){
		return pedidoService.qtdVendaTotal();
	}
	
}

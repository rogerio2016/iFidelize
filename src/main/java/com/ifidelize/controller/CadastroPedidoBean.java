package com.ifidelize.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifidelize.model.EnumFormaPagamento;
import com.ifidelize.model.TbCliente;
import com.ifidelize.model.TbEnderecoEntrega;
import com.ifidelize.model.TbItemPedido;
import com.ifidelize.model.TbPedido;
import com.ifidelize.model.TbProduto;
import com.ifidelize.model.TbUsuario;
import com.ifidelize.repository.TbClienteRepository;
import com.ifidelize.repository.TbProdutoRepository;
import com.ifidelize.repository.TbUsuarioRepository;
import com.ifidelize.service.TbCadastroPedidoService;
import com.ifidelize.util.jsf.FacesUtil;
import com.ifidelize.validation.CodBarra;

import org.apache.commons.lang3.StringUtils;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Produces
	@PedidoEdicao
	private TbPedido pedido;
	@Inject
	private TbClienteRepository clienteRepository;
	@Inject
	private TbUsuarioRepository usuarioRepository;
	@Inject
	private TbProdutoRepository produtoRepository;
	@Inject
	private TbCadastroPedidoService cadastroPedidoService;

	private TbProduto produtoLinhaEditavel;

	private String codbarra;
	private String plu;
	
	public CadastroPedidoBean() {
		limpar();
	}

	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}

	private boolean existeItemComProduto(TbProduto produto) {
		boolean existeItem = false;

		for (TbItemPedido item : this.getPedido().getItens()) {
			if (produto.equals(item.getCod_produto())) {
				existeItem = true;
				break;
			}
		}

		return existeItem;
	}

	public void carregarProdutoLinhaEditavel() {
		TbItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil
						.addErrorMessage("Jรก existe um item no pedido com o produto informado.");
			} else {
				item.setCod_produto(this.produtoLinhaEditavel);
				item.setVal_unitario(this.produtoLinhaEditavel
						.getVal_valor_venda());

				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.codbarra = null;
				this.plu = null;

				this.pedido.recalcularValorTotal();
			}
		}
	}

	public void atualizarQuantidade(TbItemPedido item, int linha) {
		BigDecimal valor = new BigDecimal(1);
		if (item.getNum_qtd().compareTo(valor) < 0.01) {
			if (linha == 0) {
				item.setNum_qtd(valor);
			} else {
				this.getPedido().getItens().remove(linha);
			}
		}

		this.pedido.recalcularValorTotal();
	}

	public void carregarProdutoPorCodBarra() {
		if (StringUtils.isNotEmpty(this.codbarra)) {
			this.produtoLinhaEditavel = this.produtoRepository
					.porCodBarra(this.codbarra);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void carregarProdutoPorPLU() {
		if (StringUtils.isNotEmpty(this.plu)) {
			this.produtoLinhaEditavel = this.produtoRepository
					.porPLU(this.plu);
			this.carregarProdutoLinhaEditavel();
		}
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.pedido.adicionarItemVazio();
			this.recalcularPedido();
		}
	}

	public EnumFormaPagamento[] getFormasPagamento() {
		return EnumFormaPagamento.values();
	}

	public List<TbProduto> completarProduto(String descricao) {
		return this.produtoRepository.porDescricao(descricao);
	}

	public List<TbCliente> completarCliente(String nome) {
		return this.clienteRepository.porNome(nome);
	}

	public List<TbUsuario> completarVendedor(String nome) {
		return this.usuarioRepository.porNome(nome);
	}

	private void limpar() {
		pedido = new TbPedido();
		pedido.setCod_enderecoEntrega(new TbEnderecoEntrega());
	}

	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
	}
	
	public void salvar() {
		if (pedido.isNovo()) {
			pedido.setDta_criacao(new Date());
		}
		this.pedido.removerItemVazio();
		try {
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);

			FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
		} finally {
			this.pedido.adicionarItemVazio();
		}
	}

	public void setPedido(TbPedido pedido) {
		this.pedido = pedido;
	}

	public TbPedido getPedido() {
		return pedido;
	}

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

	@CodBarra
	public String getCodbarra() {
		return codbarra;
	}

	public void setCodbarra(String codbarra) {
		this.codbarra = codbarra;
	}

	public TbProduto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(TbProduto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public String getPlu() {
		return plu;
	}

	public void setPlu(String plu) {
		this.plu = plu;
	}

}
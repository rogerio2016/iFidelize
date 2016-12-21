package com.ifidelize.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_pedido")
public class TbPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dta_criacao;	
	private String des_observacao;
	private Date dta_entrega;
	private BigDecimal val_frete = BigDecimal.ZERO;
	private BigDecimal val_desconto = BigDecimal.ZERO;
	private BigDecimal val_total = BigDecimal.ZERO;
	private EnumStatusPedido status = EnumStatusPedido.ORCAMENTO;
	private EnumFormaPagamento formaPagamento;
	private TbUsuario cod_vendedor;
	private TbCliente cod_cliente;
	private TbEnderecoEntrega cod_enderecoEntrega;
	private List<TbItemPedido> itens = new ArrayList<>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	@Column(columnDefinition = "text")
	public String getDes_observacao() {
		return des_observacao;
	}

	public void setDes_observacao(String des_observacao) {
		this.des_observacao = des_observacao;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_criacao", nullable = false)
	public Date getDta_criacao() {
		return dta_criacao;
	}

	public void setDta_criacao(Date dta_criacao) {
		this.dta_criacao = dta_criacao;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "dta_entrega", nullable = false)
	public Date getDta_entrega() {
		return dta_entrega;
	}

	public void setDta_entrega(Date dta_entrega) {
		this.dta_entrega = dta_entrega;
	}
	@Column(name = "val_frete", nullable = false, precision = 10, scale = 2)
	public BigDecimal getVal_frete() {
		return val_frete;
	}

	public void setVal_frete(BigDecimal val_frete) {
		this.val_frete = val_frete;
	}
	@Column(name = "val_desconto", nullable = false, precision = 10, scale = 2)
	public BigDecimal getVal_desconto() {
		return val_desconto;
	}

	public void setVal_desconto(BigDecimal val_desconto) {
		this.val_desconto = val_desconto;
	}

	public void setVal_total(BigDecimal val_total) {
		this.val_total = val_total;
	}
	
	@Column(name = "val_total", nullable = false, precision = 10, scale = 2)
	public BigDecimal getVal_total() {
		return val_total;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cod_vendedor", nullable = false)
	public TbUsuario getCod_vendedor() {
		return cod_vendedor;
	}

	public void setCod_vendedor(TbUsuario cod_vendedor) {
		this.cod_vendedor = cod_vendedor;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cod_cliente", nullable = false)
	public TbCliente getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(TbCliente cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	@Embedded
	public TbEnderecoEntrega getCod_enderecoEntrega() {
		return cod_enderecoEntrega;
	}

	public void setCod_enderecoEntrega(TbEnderecoEntrega cod_enderecoEntrega) {
		this.cod_enderecoEntrega = cod_enderecoEntrega;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public EnumStatusPedido getStatus() {
		return status;
	}

	public void setStatus(EnumStatusPedido status) {
		this.status = status;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pagamento", length = 20)
	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@OneToMany(mappedBy = "cod_pedido", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	public List<TbItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<TbItemPedido> itens) {
		this.itens = itens;
	}
	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
	
	@Transient
	public boolean isExistente() {
		return !isNovo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cod_cliente == null) ? 0 : cod_cliente.hashCode());
		result = prime
				* result
				+ ((cod_enderecoEntrega == null) ? 0 : cod_enderecoEntrega
						.hashCode());
		result = prime * result
				+ ((cod_vendedor == null) ? 0 : cod_vendedor.hashCode());
		result = prime * result
				+ ((des_observacao == null) ? 0 : des_observacao.hashCode());
		result = prime * result
				+ ((dta_criacao == null) ? 0 : dta_criacao.hashCode());
		result = prime * result
				+ ((dta_entrega == null) ? 0 : dta_entrega.hashCode());
		result = prime * result
				+ ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((val_desconto == null) ? 0 : val_desconto.hashCode());
		result = prime * result
				+ ((val_frete == null) ? 0 : val_frete.hashCode());
		result = prime * result
				+ ((val_total == null) ? 0 : val_total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbPedido other = (TbPedido) obj;
		if (cod_cliente == null) {
			if (other.cod_cliente != null)
				return false;
		} else if (!cod_cliente.equals(other.cod_cliente))
			return false;
		if (cod_enderecoEntrega == null) {
			if (other.cod_enderecoEntrega != null)
				return false;
		} else if (!cod_enderecoEntrega.equals(other.cod_enderecoEntrega))
			return false;
		if (cod_vendedor == null) {
			if (other.cod_vendedor != null)
				return false;
		} else if (!cod_vendedor.equals(other.cod_vendedor))
			return false;
		if (des_observacao == null) {
			if (other.des_observacao != null)
				return false;
		} else if (!des_observacao.equals(other.des_observacao))
			return false;
		if (dta_criacao == null) {
			if (other.dta_criacao != null)
				return false;
		} else if (!dta_criacao.equals(other.dta_criacao))
			return false;
		if (dta_entrega == null) {
			if (other.dta_entrega != null)
				return false;
		} else if (!dta_entrega.equals(other.dta_entrega))
			return false;
		if (formaPagamento != other.formaPagamento)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (status != other.status)
			return false;
		if (val_desconto == null) {
			if (other.val_desconto != null)
				return false;
		} else if (!val_desconto.equals(other.val_desconto))
			return false;
		if (val_frete == null) {
			if (other.val_frete != null)
				return false;
		} else if (!val_frete.equals(other.val_frete))
			return false;
		if (val_total == null) {
			if (other.val_total != null)
				return false;
		} else if (!val_total.equals(other.val_total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TbPedido [id=" + id + ", dta_criacao=" + dta_criacao
				+ ", des_observacao=" + des_observacao + ", dta_entrega="
				+ dta_entrega + ", val_frete=" + val_frete + ", val_desconto="
				+ val_desconto + ", val_total=" + val_total + ", status="
				+ status + ", formaPagamento=" + formaPagamento
				+ ", cod_vendedor=" + cod_vendedor + ", cod_cliente="
				+ cod_cliente + ", cod_enderecoEntrega=" + cod_enderecoEntrega
				+ ", itens=" + itens + "]";
	}

	@Transient
	public BigDecimal getValorSubtotal() {
		return this.getVal_total().subtract(this.getVal_frete()).add(this.getVal_desconto());
	}

	public void recalcularValorTotal() {
		BigDecimal total = BigDecimal.ZERO;		
		total = total.add(this.getVal_frete()).subtract(this.getVal_desconto());
	
		for (TbItemPedido item : this.getItens()) {
			if (item.getCod_produto() != null && item.getCod_produto().getId() != null) {				
				total = total.add(item.getValorTotal());	
			}
		}				
		this.setVal_total(total);
		System.out.println("Valor Calculado 3 "+ this.getVal_total().toString());		
	}
	public void adicionarItemVazio() {
		if (this.isOrcamento()) {
			TbProduto produto = new TbProduto();
			
			TbItemPedido item = new TbItemPedido();
			item.setCod_produto(produto);
			item.setCod_pedido(this);
			
			this.getItens().add(0, item);
		}
	}

	public void removerItemVazio() {
		TbItemPedido primeiroItem = this.getItens().get(0);
		
		if (primeiroItem != null && primeiroItem.getCod_produto().getId() == null) {
			this.getItens().remove(0);
		}
	}

	@Transient
	public boolean isValorTotalNegativo() {
		return this.getVal_total().compareTo(BigDecimal.ZERO) < 0;
	}
	
	@Transient
	public boolean isOrcamento() {
		return EnumStatusPedido.ORCAMENTO.equals(this.getStatus());
	}
	
	@Transient
	public boolean isEmitido() {
		return EnumStatusPedido.EMITIDO.equals(this.getStatus());
	}

	@Transient
	public boolean isNaoEmissivel() {
		return !this.isEmissivel();
	}

	@Transient
	public boolean isEmissivel() {
		return this.isExistente() && this.isOrcamento();
	}
	@Transient
	public boolean isCancelavel() {
		return this.isExistente() && !this.isCancelado();
	}

	@Transient
	private boolean isCancelado() {
		return EnumStatusPedido.CANCELADO.equals(this.getStatus());
	}

	@Transient
	public boolean isNaoCancelavel() {
		return !this.isCancelavel();
	}

	@Transient
	public boolean isAlteravel() {
		return this.isOrcamento();
	}
	
	@Transient
	public boolean isNaoAlteravel() {
		return !this.isAlteravel();
	}

}
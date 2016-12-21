package com.ifidelize.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_item_pedido")
public class TbItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private BigDecimal num_qtd = BigDecimal.ONE;
	private BigDecimal val_unitario = BigDecimal.ZERO;;
	private TbProduto cod_produto;
	private TbPedido cod_pedido;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 3, precision = 10, scale = 2)
	public BigDecimal getNum_qtd() {
		return num_qtd;
	}

	public void setNum_qtd(BigDecimal num_qtd) {
		this.num_qtd = num_qtd;
	}

	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	public BigDecimal getVal_unitario() {
		return val_unitario;
	}

	public void setVal_unitario(BigDecimal val_unitario) {
		this.val_unitario = val_unitario;
	}

	@ManyToOne
	@JoinColumn(name = "cod_produto", nullable = false)
	public TbProduto getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(TbProduto cod_produto) {
		this.cod_produto = cod_produto;
	}

	@ManyToOne
	@JoinColumn(name = "cod_pedido", nullable = false)
	public TbPedido getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(TbPedido cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	@Transient
	public BigDecimal getValorTotal() {
		return this.getVal_unitario().multiply(this.getNum_qtd());
	}
	
	@Transient
	public boolean isProdutoAssociado() {
		return this.getCod_produto() != null && this.getCod_produto().getId() != null;
	}

	
	@Transient
	public boolean isEstoqueSuficiente() {
		return this.getCod_pedido().isEmitido() || this.getCod_produto().getId() == null 
		/*|| this.getCod_produto().getVal_estoque().compareTo(this.getNum_qtd()) >= 0;*/
				|| this.getCod_produto().getVal_estoque().doubleValue() >= this.getNum_qtd().doubleValue();
	}
	
	@Transient
	public boolean isEstoqueInsuficiente() {
		return !this.isEstoqueSuficiente();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cod_pedido == null) ? 0 : cod_pedido.hashCode());
		result = prime * result
				+ ((cod_produto == null) ? 0 : cod_produto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((num_qtd == null) ? 0 : num_qtd.hashCode());
		result = prime * result
				+ ((val_unitario == null) ? 0 : val_unitario.hashCode());
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
		TbItemPedido other = (TbItemPedido) obj;
		if (cod_pedido == null) {
			if (other.cod_pedido != null)
				return false;
		} else if (!cod_pedido.equals(other.cod_pedido))
			return false;
		if (cod_produto == null) {
			if (other.cod_produto != null)
				return false;
		} else if (!cod_produto.equals(other.cod_produto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (num_qtd == null) {
			if (other.num_qtd != null)
				return false;
		} else if (!num_qtd.equals(other.num_qtd))
			return false;
		if (val_unitario == null) {
			if (other.val_unitario != null)
				return false;
		} else if (!val_unitario.equals(other.val_unitario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TbItemPedido [id=" + id + ", num_qtd=" + num_qtd
				+ ", val_unitario=" + val_unitario + ", cod_produto="
				+ cod_produto + ", cod_pedido=" + cod_pedido + "]";
	}


}

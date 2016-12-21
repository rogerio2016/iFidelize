package com.ifidelize.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ifidelize.service.NegocioException;
import com.ifidelize.validation.CodBarra;

@Entity
@Table(name="TB_PRODUTO")
public class TbProduto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String num_plu;
	private String num_codbarra;
	private Long num_ncm;
	private String des_descricao;
	private String des_chave_ibpt;
	private BigDecimal val_valor_custo = BigDecimal.ZERO;	
	private BigDecimal val_valor_venda = BigDecimal.ZERO;
	private BigDecimal val_valor_promocao = BigDecimal.ZERO;
	private BigDecimal val_valor_especial = BigDecimal.ZERO;
	private BigDecimal val_estoque = BigDecimal.ZERO;
	private BigDecimal val_aliq_icms = BigDecimal.ZERO;
	private BigDecimal val_aliq_pis = BigDecimal.ZERO;
	private BigDecimal val_aliq_cofins = BigDecimal.ZERO;
	private BigDecimal val_perc_imposto = BigDecimal.ZERO;
	private BigDecimal val_perc_imposto_estadual = BigDecimal.ZERO;
	private BigDecimal val_perc_imposto_federal = BigDecimal.ZERO;
	private BigDecimal val_perc_imposto_municipal = BigDecimal.ZERO;
	private TbTributacao cod_tributacao;
	private EnumUnidade des_unidade;
	private TbGrupo cod_grupo;
	private TbSubGrupo cod_subgrupo;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNum_ncm() {
		return num_ncm;
	}
	public void setNum_ncm(Long num_ncm) {
		this.num_ncm = num_ncm;
	}
	@NotNull(message="Deve ser informado")
	@Column(nullable=false, name="des_descricao", length=60)
	public String getDes_descricao() {
		return des_descricao;
	}
	public void setDes_descricao(String des_descricao) {
		this.des_descricao = des_descricao;
	}

	@Column(length=60)
	public String getDes_chave_ibpt() {
		return des_chave_ibpt;
	}
	public void setDes_chave_ibpt(String des_chave_ibpt) {
		this.des_chave_ibpt = des_chave_ibpt;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_valor_custo() {
		return val_valor_custo;
	}
	public void setVal_valor_custo(BigDecimal val_valor_custo) {
		this.val_valor_custo = val_valor_custo;
	}
	@NotNull(message="É Obrigatório")
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_valor_venda() {
		return val_valor_venda;
	}
	public void setVal_valor_venda(BigDecimal val_valor_venda) {
		this.val_valor_venda = val_valor_venda;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_valor_especial() {
		return val_valor_especial;
	}
	public void setVal_valor_especial(BigDecimal val_valor_especial) {
		this.val_valor_especial = val_valor_especial;
	}
	@NotNull(message="Deve ser informado")
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_estoque() {
		return val_estoque;
	}
	public void setVal_estoque(BigDecimal val_estoque) {
		this.val_estoque = val_estoque;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_aliq_icms() {
		return val_aliq_icms;
	}
	public void setVal_aliq_icms(BigDecimal val_aliq_icms) {
		this.val_aliq_icms = val_aliq_icms;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_aliq_pis() {
		return val_aliq_pis;
	}
	public void setVal_aliq_pis(BigDecimal val_aliq_pis) {
		this.val_aliq_pis = val_aliq_pis;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_aliq_cofins() {
		return val_aliq_cofins;
	}
	public void setVal_aliq_cofins(BigDecimal val_aliq_cofins) {
		this.val_aliq_cofins = val_aliq_cofins;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_perc_imposto() {
		return val_perc_imposto;
	}
	public void setVal_perc_imposto(BigDecimal val_perc_imposto) {
		this.val_perc_imposto = val_perc_imposto;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_perc_imposto_estadual() {
		return val_perc_imposto_estadual;
	}
	public void setVal_perc_imposto_estadual(BigDecimal val_perc_imposto_estadual) {
		this.val_perc_imposto_estadual = val_perc_imposto_estadual;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_perc_imposto_municipal() {
		return val_perc_imposto_municipal;
	}
	public void setVal_perc_imposto_municipal(BigDecimal val_perc_imposto_municipal) {
		this.val_perc_imposto_municipal = val_perc_imposto_municipal;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_perc_imposto_federal() {
		return val_perc_imposto_federal;
	}
	public void setVal_perc_imposto_federal(BigDecimal val_perc_imposto_federal) {
		this.val_perc_imposto_federal = val_perc_imposto_federal;
	}

	@ManyToOne	
	@JoinColumn(name = "cod_tributacao", nullable = false)
	public TbTributacao getCod_tributacao() {
		return cod_tributacao;
	}
	public void setCod_tributacao(TbTributacao cod_tributacao) {
		this.cod_tributacao = cod_tributacao;
	}
	@NotNull(message="Deve ser informado")
	@ManyToOne
	@JoinColumn(name = "cod_grupo", nullable = false)
	public TbGrupo getCod_grupo() {
		return cod_grupo;
	}
	public void setCod_grupo(TbGrupo cod_grupo) {
		this.cod_grupo = cod_grupo;
	}
	
	@CodBarra
	@Column(length=13)
	public String getNum_codbarra() {
		return num_codbarra;
	}
	public void setNum_codbarra(String num_codBarra) {
		this.num_codbarra = num_codBarra;
	}
	public String getNum_plu() {
		return num_plu;
	}
	public void setNum_plu(String num_plu) {
		this.num_plu = num_plu;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_valor_promocao() {
		return val_valor_promocao;
	}
	public void setVal_valor_promocao(BigDecimal val_valor_promocao) {
		this.val_valor_promocao = val_valor_promocao;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	public EnumUnidade getDes_unidade() {
		return des_unidade;
	}
	public void setDes_unidade(EnumUnidade des_unidade) {
		this.des_unidade = des_unidade;
	}
	@ManyToOne
	@JoinColumn(name = "cod_subgrupo")
	public TbSubGrupo getCod_subgrupo() {
		return cod_subgrupo;
	}
	public void setCod_subgrupo(TbSubGrupo cod_subgrupo) {
		this.cod_subgrupo = cod_subgrupo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cod_grupo == null) ? 0 : cod_grupo.hashCode());
		result = prime * result
				+ ((cod_subgrupo == null) ? 0 : cod_subgrupo.hashCode());
		result = prime * result
				+ ((cod_tributacao == null) ? 0 : cod_tributacao.hashCode());
		result = prime * result
				+ ((des_chave_ibpt == null) ? 0 : des_chave_ibpt.hashCode());
		result = prime * result
				+ ((des_descricao == null) ? 0 : des_descricao.hashCode());
		result = prime * result
				+ ((des_unidade == null) ? 0 : des_unidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((num_codbarra == null) ? 0 : num_codbarra.hashCode());
		result = prime * result + ((num_ncm == null) ? 0 : num_ncm.hashCode());
		result = prime * result + ((num_plu == null) ? 0 : num_plu.hashCode());
		result = prime * result
				+ ((val_aliq_cofins == null) ? 0 : val_aliq_cofins.hashCode());
		result = prime * result
				+ ((val_aliq_icms == null) ? 0 : val_aliq_icms.hashCode());
		result = prime * result
				+ ((val_aliq_pis == null) ? 0 : val_aliq_pis.hashCode());
		result = prime * result
				+ ((val_estoque == null) ? 0 : val_estoque.hashCode());
		result = prime
				* result
				+ ((val_perc_imposto == null) ? 0 : val_perc_imposto.hashCode());
		result = prime
				* result
				+ ((val_perc_imposto_estadual == null) ? 0
						: val_perc_imposto_estadual.hashCode());
		result = prime
				* result
				+ ((val_perc_imposto_federal == null) ? 0
						: val_perc_imposto_federal.hashCode());
		result = prime
				* result
				+ ((val_perc_imposto_municipal == null) ? 0
						: val_perc_imposto_municipal.hashCode());
		result = prime * result
				+ ((val_valor_custo == null) ? 0 : val_valor_custo.hashCode());
		result = prime
				* result
				+ ((val_valor_especial == null) ? 0 : val_valor_especial
						.hashCode());
		result = prime
				* result
				+ ((val_valor_promocao == null) ? 0 : val_valor_promocao
						.hashCode());
		result = prime * result
				+ ((val_valor_venda == null) ? 0 : val_valor_venda.hashCode());
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
		TbProduto other = (TbProduto) obj;
		if (cod_grupo == null) {
			if (other.cod_grupo != null)
				return false;
		} else if (!cod_grupo.equals(other.cod_grupo))
			return false;
		if (cod_subgrupo == null) {
			if (other.cod_subgrupo != null)
				return false;
		} else if (!cod_subgrupo.equals(other.cod_subgrupo))
			return false;
		if (cod_tributacao == null) {
			if (other.cod_tributacao != null)
				return false;
		} else if (!cod_tributacao.equals(other.cod_tributacao))
			return false;
		if (des_chave_ibpt == null) {
			if (other.des_chave_ibpt != null)
				return false;
		} else if (!des_chave_ibpt.equals(other.des_chave_ibpt))
			return false;
		if (des_descricao == null) {
			if (other.des_descricao != null)
				return false;
		} else if (!des_descricao.equals(other.des_descricao))
			return false;
		if (des_unidade != other.des_unidade)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (num_codbarra == null) {
			if (other.num_codbarra != null)
				return false;
		} else if (!num_codbarra.equals(other.num_codbarra))
			return false;
		if (num_ncm == null) {
			if (other.num_ncm != null)
				return false;
		} else if (!num_ncm.equals(other.num_ncm))
			return false;
		if (num_plu == null) {
			if (other.num_plu != null)
				return false;
		} else if (!num_plu.equals(other.num_plu))
			return false;
		if (val_aliq_cofins == null) {
			if (other.val_aliq_cofins != null)
				return false;
		} else if (!val_aliq_cofins.equals(other.val_aliq_cofins))
			return false;
		if (val_aliq_icms == null) {
			if (other.val_aliq_icms != null)
				return false;
		} else if (!val_aliq_icms.equals(other.val_aliq_icms))
			return false;
		if (val_aliq_pis == null) {
			if (other.val_aliq_pis != null)
				return false;
		} else if (!val_aliq_pis.equals(other.val_aliq_pis))
			return false;
		if (val_estoque == null) {
			if (other.val_estoque != null)
				return false;
		} else if (!val_estoque.equals(other.val_estoque))
			return false;
		if (val_perc_imposto == null) {
			if (other.val_perc_imposto != null)
				return false;
		} else if (!val_perc_imposto.equals(other.val_perc_imposto))
			return false;
		if (val_perc_imposto_estadual == null) {
			if (other.val_perc_imposto_estadual != null)
				return false;
		} else if (!val_perc_imposto_estadual
				.equals(other.val_perc_imposto_estadual))
			return false;
		if (val_perc_imposto_federal == null) {
			if (other.val_perc_imposto_federal != null)
				return false;
		} else if (!val_perc_imposto_federal
				.equals(other.val_perc_imposto_federal))
			return false;
		if (val_perc_imposto_municipal == null) {
			if (other.val_perc_imposto_municipal != null)
				return false;
		} else if (!val_perc_imposto_municipal
				.equals(other.val_perc_imposto_municipal))
			return false;
		if (val_valor_custo == null) {
			if (other.val_valor_custo != null)
				return false;
		} else if (!val_valor_custo.equals(other.val_valor_custo))
			return false;
		if (val_valor_especial == null) {
			if (other.val_valor_especial != null)
				return false;
		} else if (!val_valor_especial.equals(other.val_valor_especial))
			return false;
		if (val_valor_promocao == null) {
			if (other.val_valor_promocao != null)
				return false;
		} else if (!val_valor_promocao.equals(other.val_valor_promocao))
			return false;
		if (val_valor_venda == null) {
			if (other.val_valor_venda != null)
				return false;
		} else if (!val_valor_venda.equals(other.val_valor_venda))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TbProduto [id=" + id + ", num_plu=" + num_plu
				+ ", num_codbarra=" + num_codbarra + ", num_ncm=" + num_ncm
				+ ", des_descricao=" + des_descricao + ", des_chave_ibpt="
				+ des_chave_ibpt + ", val_valor_custo=" + val_valor_custo
				+ ", val_valor_venda=" + val_valor_venda
				+ ", val_valor_promocao=" + val_valor_promocao
				+ ", val_valor_especial=" + val_valor_especial
				+ ", val_estoque=" + val_estoque + ", val_aliq_icms="
				+ val_aliq_icms + ", val_aliq_pis=" + val_aliq_pis
				+ ", val_aliq_cofins=" + val_aliq_cofins
				+ ", val_perc_imposto=" + val_perc_imposto
				+ ", val_perc_imposto_estadual=" + val_perc_imposto_estadual
				+ ", val_perc_imposto_federal=" + val_perc_imposto_federal
				+ ", val_perc_imposto_municipal=" + val_perc_imposto_municipal
				+ ", cod_tributacao=" + cod_tributacao + ", des_unidade="
				+ des_unidade + ", cod_grupo=" + cod_grupo + ", cod_subgrupo="
				+ cod_subgrupo + "]";
	}

	
	public void baixarEstoque(BigDecimal quantidade) {
		Double novaQuantidade = this.getVal_estoque().doubleValue()- quantidade.doubleValue();
		System.out.println("Nova Qtd: "+novaQuantidade);
		System.out.println("V1: "+this.getVal_estoque().doubleValue());
		System.out.println("V2: "+quantidade);
			
		if (novaQuantidade < 0) {
			throw new NegocioException("Não há disponibilidade no estoque de "
					+ quantidade + " itens do produto " + this.getNum_codbarra() + ".");
		}
		
		this.setVal_estoque(new BigDecimal(novaQuantidade));
	}

	public void adicionarEstoque(BigDecimal quantidade) {
		Double novaQuantidade = this.getVal_estoque().doubleValue() + quantidade.doubleValue();
		this.setVal_estoque(new BigDecimal(novaQuantidade));
	}

		
}


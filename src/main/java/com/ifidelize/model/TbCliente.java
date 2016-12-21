package com.ifidelize.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_CLIENTE")
public class TbCliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String des_nome;
	private String des_cpf;
	private String des_rg;
	private String des_endereco;
	private String des_numero;
	private String des_bairro;
	private String des_cep;
	private String des_email;
	private String des_telefone;
	private String des_senha;
	private Boolean bol_situacao;
	private Date dta_nascimento;
	private Date dta_cadastro;
	private BigDecimal val_limite_conv = BigDecimal.ZERO;
	private BigDecimal val_desconto    = BigDecimal.ZERO;
	private BigDecimal val_limite_cheq = BigDecimal.ZERO;
	private EnumTipoPessoa tipo;
	private TbCidade cod_cidade;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 60)
	public String getDes_nome() {
		return des_nome;
	}
	
	public void setDes_nome(String des_nome) {
		this.des_nome = des_nome;
	}
	@Column(nullable = false, length = 20)
	public String getDes_cpf() {
		return des_cpf;
	}
	
	public void setDes_cpf(String des_cpf) {
		this.des_cpf = des_cpf;
	}
	@Column(length = 20)
	public String getDes_rg() {
		return des_rg;
	}
	public void setDes_rg(String des_rg) {
		this.des_rg = des_rg;
	}
	@Column(length = 60)
	public String getDes_endereco() {
		return des_endereco;
	}
	public void setDes_endereco(String des_endereco) {
		this.des_endereco = des_endereco;
	}
	@Column(length = 5)
	public String getDes_numero() {
		return des_numero;
	}
	public void setDes_numero(String des_numero) {
		this.des_numero = des_numero;
	}
	@Column(length = 60)
	public String getDes_bairro() {
		return des_bairro;
	}
	public void setDes_bairro(String des_bairro) {
		this.des_bairro = des_bairro;
	}
	@Column(length = 14)
	public String getDes_cep() {
		return des_cep;
	}
	public void setDes_cep(String des_cep) {
		this.des_cep = des_cep;
	}
	@Column(length = 60)
	public String getDes_email() {
		return des_email;
	}
	public void setDes_email(String des_email) {
		this.des_email = des_email;
	}
	@Column(length = 15)
	public String getDes_telefone() {
		return des_telefone;
	}
	public void setDes_telefone(String des_telefone) {
		this.des_telefone = des_telefone;
	}
	@Column(length = 10)
	public String getDes_senha() {
		return des_senha;
	}
	public void setDes_senha(String des_senha) {
		this.des_senha = des_senha;
	}
	public Boolean getBol_situacao() {
		return bol_situacao;
	}
	public void setBol_situacao(Boolean bol_situacao) {
		this.bol_situacao = bol_situacao;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_nascimento")
	public Date getDta_nascimento() {
		return dta_nascimento;
	}
	public void setDta_nascimento(Date dta_nascimento) {
		this.dta_nascimento = dta_nascimento;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_cadastro", nullable = false)
	public Date getDta_cadastro() {
		return dta_cadastro;
	}
	public void setDta_cadastro(Date dta_cadastro) {
		
		this.dta_cadastro = dta_cadastro ;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_limite_conv() {
		return val_limite_conv;
	}
	public void setVal_limite_conv(BigDecimal val_limite_conv) {
		this.val_limite_conv = val_limite_conv;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_limite_cheq() {
		return val_limite_cheq;
	}
	public void setVal_limite_cheq(BigDecimal val_limite_cheq) {
		this.val_limite_cheq = val_limite_cheq;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_desconto() {
		return val_desconto;
	}
	public void setVal_desconto(BigDecimal val_desconto) {
		this.val_desconto = val_desconto;
	}
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public EnumTipoPessoa getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoPessoa tipo) {
		this.tipo = tipo;
	}
	@ManyToOne
	@JoinColumn(name = "cod_cidade", nullable = false)
	public TbCidade getCod_cidade() {
		return cod_cidade;
	}
	public void setCod_cidade(TbCidade cod_cidade) {
		this.cod_cidade = cod_cidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bol_situacao == null) ? 0 : bol_situacao.hashCode());
		result = prime * result
				+ ((cod_cidade == null) ? 0 : cod_cidade.hashCode());
		result = prime * result
				+ ((des_bairro == null) ? 0 : des_bairro.hashCode());
		result = prime * result + ((des_cep == null) ? 0 : des_cep.hashCode());
		result = prime * result + ((des_cpf == null) ? 0 : des_cpf.hashCode());
		result = prime * result
				+ ((des_email == null) ? 0 : des_email.hashCode());
		result = prime * result
				+ ((des_endereco == null) ? 0 : des_endereco.hashCode());
		result = prime * result
				+ ((des_nome == null) ? 0 : des_nome.hashCode());
		result = prime * result
				+ ((des_numero == null) ? 0 : des_numero.hashCode());
		result = prime * result + ((des_rg == null) ? 0 : des_rg.hashCode());
		result = prime * result
				+ ((des_senha == null) ? 0 : des_senha.hashCode());
		result = prime * result
				+ ((des_telefone == null) ? 0 : des_telefone.hashCode());
		result = prime * result
				+ ((dta_cadastro == null) ? 0 : dta_cadastro.hashCode());
		result = prime * result
				+ ((dta_nascimento == null) ? 0 : dta_nascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((val_desconto == null) ? 0 : val_desconto.hashCode());
		result = prime * result
				+ ((val_limite_cheq == null) ? 0 : val_limite_cheq.hashCode());
		result = prime * result
				+ ((val_limite_conv == null) ? 0 : val_limite_conv.hashCode());
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
		TbCliente other = (TbCliente) obj;
		if (bol_situacao == null) {
			if (other.bol_situacao != null)
				return false;
		} else if (!bol_situacao.equals(other.bol_situacao))
			return false;
		if (cod_cidade == null) {
			if (other.cod_cidade != null)
				return false;
		} else if (!cod_cidade.equals(other.cod_cidade))
			return false;
		if (des_bairro == null) {
			if (other.des_bairro != null)
				return false;
		} else if (!des_bairro.equals(other.des_bairro))
			return false;
		if (des_cep == null) {
			if (other.des_cep != null)
				return false;
		} else if (!des_cep.equals(other.des_cep))
			return false;
		if (des_cpf == null) {
			if (other.des_cpf != null)
				return false;
		} else if (!des_cpf.equals(other.des_cpf))
			return false;
		if (des_email == null) {
			if (other.des_email != null)
				return false;
		} else if (!des_email.equals(other.des_email))
			return false;
		if (des_endereco == null) {
			if (other.des_endereco != null)
				return false;
		} else if (!des_endereco.equals(other.des_endereco))
			return false;
		if (des_nome == null) {
			if (other.des_nome != null)
				return false;
		} else if (!des_nome.equals(other.des_nome))
			return false;
		if (des_numero == null) {
			if (other.des_numero != null)
				return false;
		} else if (!des_numero.equals(other.des_numero))
			return false;
		if (des_rg == null) {
			if (other.des_rg != null)
				return false;
		} else if (!des_rg.equals(other.des_rg))
			return false;
		if (des_senha == null) {
			if (other.des_senha != null)
				return false;
		} else if (!des_senha.equals(other.des_senha))
			return false;
		if (des_telefone == null) {
			if (other.des_telefone != null)
				return false;
		} else if (!des_telefone.equals(other.des_telefone))
			return false;
		if (dta_cadastro == null) {
			if (other.dta_cadastro != null)
				return false;
		} else if (!dta_cadastro.equals(other.dta_cadastro))
			return false;
		if (dta_nascimento == null) {
			if (other.dta_nascimento != null)
				return false;
		} else if (!dta_nascimento.equals(other.dta_nascimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo != other.tipo)
			return false;
		if (val_desconto == null) {
			if (other.val_desconto != null)
				return false;
		} else if (!val_desconto.equals(other.val_desconto))
			return false;
		if (val_limite_cheq == null) {
			if (other.val_limite_cheq != null)
				return false;
		} else if (!val_limite_cheq.equals(other.val_limite_cheq))
			return false;
		if (val_limite_conv == null) {
			if (other.val_limite_conv != null)
				return false;
		} else if (!val_limite_conv.equals(other.val_limite_conv))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TbCliente [id=" + id + ", des_nome=" + des_nome + ", des_cpf="
				+ des_cpf + ", des_rg=" + des_rg + ", des_endereco="
				+ des_endereco + ", des_numero=" + des_numero + ", des_bairro="
				+ des_bairro + ", des_cep=" + des_cep + ", des_email="
				+ des_email + ", des_telefone=" + des_telefone + ", des_senha="
				+ des_senha + ", bol_situacao=" + bol_situacao
				+ ", dta_nascimento=" + dta_nascimento + ", dta_cadastro="
				+ dta_cadastro + ", val_limite_conv=" + val_limite_conv
				+ ", val_desconto=" + val_desconto + ", val_limite_cheq="
				+ val_limite_cheq + ", tipo=" + tipo + ", cod_cidade="
				+ cod_cidade + "]";
	}
	
	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
}	
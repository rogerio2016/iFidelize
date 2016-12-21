package com.ifidelize.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TB_TRIBUTACAO")
public class TbTributacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String des_descricao;
	private Integer cod_referencia;
	private BigDecimal val_icms = BigDecimal.ZERO;
	private EnumTipoTributacao des_tipo_tributacao;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	@Column(precision = 10, scale = 2)
	public BigDecimal getVal_icms() {
		return val_icms;
	}
	public void setVal_icms(BigDecimal val_icms) {
		this.val_icms = val_icms;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@NotBlank
	@Column(length=30)
	public String getDes_descricao() {
		return des_descricao;
	}
	public void setDes_descricao(String des_descricao) {
		this.des_descricao = des_descricao;
	}
	public Integer getCod_referencia() {
		return cod_referencia;
	}
	public void setCod_referencia(Integer cod_referencia) {
		this.cod_referencia = cod_referencia;
	}	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 2)
	public EnumTipoTributacao getDes_tipo_tributacao() {
		return des_tipo_tributacao;
	}
	public void setDes_tipo_tributacao(EnumTipoTributacao des_tipo_tributacao) {
		this.des_tipo_tributacao = des_tipo_tributacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cod_referencia == null) ? 0 : cod_referencia.hashCode());
		result = prime * result
				+ ((des_descricao == null) ? 0 : des_descricao.hashCode());
		result = prime
				* result
				+ ((des_tipo_tributacao == null) ? 0 : des_tipo_tributacao
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((val_icms == null) ? 0 : val_icms.hashCode());
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
		TbTributacao other = (TbTributacao) obj;
		if (cod_referencia == null) {
			if (other.cod_referencia != null)
				return false;
		} else if (!cod_referencia.equals(other.cod_referencia))
			return false;
		if (des_descricao == null) {
			if (other.des_descricao != null)
				return false;
		} else if (!des_descricao.equals(other.des_descricao))
			return false;
		if (des_tipo_tributacao != other.des_tipo_tributacao)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (val_icms == null) {
			if (other.val_icms != null)
				return false;
		} else if (!val_icms.equals(other.val_icms))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TbTributacao [id=" + id + ", des_descricao=" + des_descricao
				+ ", cod_referencia=" + cod_referencia + ", val_icms="
				+ val_icms + ", des_tipo_tributacao=" + des_tipo_tributacao
				+ "]";
	}	
		
}

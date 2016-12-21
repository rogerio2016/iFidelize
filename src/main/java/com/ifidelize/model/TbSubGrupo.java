package com.ifidelize.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TB_SUBGRUPO")
public class TbSubGrupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String des_descricao;
	private TbGrupo cod_grupo;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable=false, length=60)
	public String getDes_descricao() {
		return des_descricao;
	}
	public void setDes_descricao(String des_descricao) {
		this.des_descricao = des_descricao;
	}
	@ManyToOne
	@JoinColumn(nullable = false)
	public TbGrupo getCod_grupo() {
		return cod_grupo;
	}
	public void setCod_grupo(TbGrupo cod_grupo) {
		this.cod_grupo = cod_grupo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cod_grupo == null) ? 0 : cod_grupo.hashCode());
		result = prime * result
				+ ((des_descricao == null) ? 0 : des_descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TbSubGrupo other = (TbSubGrupo) obj;
		if (cod_grupo == null) {
			if (other.cod_grupo != null)
				return false;
		} else if (!cod_grupo.equals(other.cod_grupo))
			return false;
		if (des_descricao == null) {
			if (other.des_descricao != null)
				return false;
		} else if (!des_descricao.equals(other.des_descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TbSubGrupo [id=" + id + ", des_descricao=" + des_descricao
				+ ", cod_grupo=" + cod_grupo + "]";
	}

}

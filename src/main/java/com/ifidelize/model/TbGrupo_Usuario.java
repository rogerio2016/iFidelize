package com.ifidelize.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class TbGrupo_Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String des_nome;
	private String des_descricao;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable=false, length=40)
	public String getDes_Nome() {
		return des_nome;
	}

	public void setDes_Nome(String des_nome) {
		this.des_nome = des_nome;
	}

	@Column(nullable=false, length=80)
	public String getDes_Descricao() {
		return des_descricao;
	}

	public void setDes_Descricao(String des_descricao) {
		this.des_descricao = des_descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((des_descricao == null) ? 0 : des_descricao.hashCode());
		result = prime * result
				+ ((des_nome == null) ? 0 : des_nome.hashCode());
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
		TbGrupo_Usuario other = (TbGrupo_Usuario) obj;
		if (des_descricao == null) {
			if (other.des_descricao != null)
				return false;
		} else if (!des_descricao.equals(other.des_descricao))
			return false;
		if (des_nome == null) {
			if (other.des_nome != null)
				return false;
		} else if (!des_nome.equals(other.des_nome))
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
		return "tbGrupo_Usuario [id=" + id + ", des_nome=" + des_nome
				+ ", des_descricao=" + des_descricao + "]";
	}

}
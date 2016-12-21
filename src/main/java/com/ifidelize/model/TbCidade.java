package com.ifidelize.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TB_CIDADE")
public class TbCidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer num_estado;
	private String des_uf;
	private String des_nome;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNum_estado() {
		return num_estado;
	}
	public void setNum_estado(Integer num_estado) {
		this.num_estado = num_estado;
	}
	@NotBlank
	@Column(length=4)
	public String getDes_uf() {
		return des_uf;
	}
	public void setDes_uf(String des_uf) {
		this.des_uf = des_uf;
	}
	@NotBlank
	@Column(length=50)
	public String getDes_nome() {
		return des_nome;
	}
	public void setDes_nome(String des_nome) {
		this.des_nome = des_nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((des_nome == null) ? 0 : des_nome.hashCode());
		result = prime * result + ((des_uf == null) ? 0 : des_uf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((num_estado == null) ? 0 : num_estado.hashCode());
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
		TbCidade other = (TbCidade) obj;
		if (des_nome == null) {
			if (other.des_nome != null)
				return false;
		} else if (!des_nome.equals(other.des_nome))
			return false;
		if (des_uf == null) {
			if (other.des_uf != null)
				return false;
		} else if (!des_uf.equals(other.des_uf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (num_estado == null) {
			if (other.num_estado != null)
				return false;
		} else if (!num_estado.equals(other.num_estado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "tbCidade [id=" + id + ", num_estado=" + num_estado
				+ ", des_uf=" + des_uf + ", des_nome=" + des_nome + "]";
	}
		
}

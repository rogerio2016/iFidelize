package com.ifidelize.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class TbEnderecoEntrega implements Serializable {

	private static final long serialVersionUID = 1L;

	private String des_logradouro;
	private String des_numero;
	private String des_complemento;
	private String des_cep;

	@NotBlank @Size(max = 150)
	@Column(name = "des_logradouro", nullable = false, length = 150)
	public String getDes_logradouro() {
		return des_logradouro;
	}

	public void setDes_logradouro(String des_logradouro) {
		this.des_logradouro = des_logradouro;
	}

	@Column(name = "des_numero", nullable = false, length = 20)
	public String getDes_numero() {
		return des_numero;
	}

	public void setDes_numero(String des_numero) {
		this.des_numero = des_numero;
	}

	@Column(name = "des_complemento", length = 150)
	public String getDes_complemento() {
		return des_complemento;
	}

	public void setDes_complemento(String des_complemento) {
		this.des_complemento = des_complemento;
	}
	@NotBlank
	@Size(max = 9 )
	@Column(name = "des_cep", nullable = false, length = 9)
	public String getDes_cep() {
		return des_cep;
	}

	public void setDes_cep(String des_cep) {
		this.des_cep = des_cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((des_cep == null) ? 0 : des_cep.hashCode());
		result = prime * result
				+ ((des_complemento == null) ? 0 : des_complemento.hashCode());
		result = prime * result
				+ ((des_logradouro == null) ? 0 : des_logradouro.hashCode());
		result = prime * result
				+ ((des_numero == null) ? 0 : des_numero.hashCode());
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
		TbEnderecoEntrega other = (TbEnderecoEntrega) obj;
		if (des_cep == null) {
			if (other.des_cep != null)
				return false;
		} else if (!des_cep.equals(other.des_cep))
			return false;
		if (des_complemento == null) {
			if (other.des_complemento != null)
				return false;
		} else if (!des_complemento.equals(other.des_complemento))
			return false;
		if (des_logradouro == null) {
			if (other.des_logradouro != null)
				return false;
		} else if (!des_logradouro.equals(other.des_logradouro))
			return false;
		if (des_numero == null) {
			if (other.des_numero != null)
				return false;
		} else if (!des_numero.equals(other.des_numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "tbEnderecoEntrega [des_logradouro=" + des_logradouro
				+ ", des_numero=" + des_numero + ", des_complemento="
				+ des_complemento + ", des_cep=" + des_cep + "]";
	}
	
	
}

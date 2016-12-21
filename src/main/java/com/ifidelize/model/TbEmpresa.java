package com.ifidelize.model;

import java.io.Serializable;
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
@Table(name="TB_EMPRESA")
public class TbEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String des_nome;
	private String des_fantasia;
	private String des_endereco;
	private String des_numero;
	private String des_bairro;
	private String des_cep;
	private String des_telefone;
	private String des_cnpj;
	private String des_ie;
	private String des_im;
	private enumTipoRegime enumTipoRegime;
	private TbCidade cod_cidade;
	private Date dta_cadastro;
	private String des_mensagempinpad;
	private String des_iptef;
	private String des_caminhocarga;
	private String des_email;
	
	
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
	@Column(nullable = false, length = 60)
	public String getDes_fantasia() {
		return des_fantasia;
	}
	public void setDes_fantasia(String des_fantasia) {
		this.des_fantasia = des_fantasia;
	}
	@Column(nullable = false, length = 60)
	public String getDes_endereco() {
		return des_endereco;
	}
	public void setDes_endereco(String des_endereco) {
		this.des_endereco = des_endereco;
	}
	@Column(nullable = false, length = 60)
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
	@Column(length = 60)
	public String getDes_cep() {
		return des_cep;
	}
	public void setDes_cep(String des_cep) {
		this.des_cep = des_cep;
	}
	@Column(length = 60)
	public String getDes_telefone() {
		return des_telefone;
	}
	public void setDes_telefone(String des_telefone) {
		this.des_telefone = des_telefone;
	}
	@Column(nullable = false, length = 20)
	public String getDes_cnpj() {
		return des_cnpj;
	}
	public void setDes_cnpj(String des_cnpj) {
		this.des_cnpj = des_cnpj;
	}
	@Column(nullable = false, length = 20)
	public String getDes_im() {
		return des_ie;
	}
	public void setDes_ie(String des_ie) {
		this.des_ie = des_ie;
	}
	public void setDes_im(String des_im) {
		this.des_im = des_im;
	}
	@ManyToOne
	@JoinColumn(name = "cod_cidade", nullable = false)
	public TbCidade getCod_cidade() {
		return cod_cidade;
	}
	public void setCod_cidade(TbCidade cod_cidade) {
		this.cod_cidade = cod_cidade;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_cadastro", nullable = false)
	public Date getDta_cadastro() {
		return dta_cadastro;
	}
	public void setDta_cadastro(Date dta_cadastro) {
		this.dta_cadastro = dta_cadastro;
	}
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public enumTipoRegime getEnumTipoRegime() {
		return enumTipoRegime;
	}
	public void setEnumTipoRegime(enumTipoRegime enumTipoRegime) {
		this.enumTipoRegime = enumTipoRegime;
	}
	@Column(nullable = false, length = 20)
	public String getDes_mensagempinpad() {
		return des_mensagempinpad;
	}
	public void setDes_mensagempinpad(String des_mensagempinpad) {
		this.des_mensagempinpad = des_mensagempinpad;
	}
	@Column(nullable = false, length = 20)
	public String getDes_iptef() {
		return des_iptef;
	}
	public void setDes_iptef(String des_iptef) {
		this.des_iptef = des_iptef;
	}
	@Column(nullable = false, length = 50)
	public String getDes_caminhocarga() {
		return des_caminhocarga;
	}
	public void setDes_caminhocarga(String des_caminhocarga) {
		this.des_caminhocarga = des_caminhocarga;
	}
	@Column(nullable = false, length = 20)
	public String getDes_ie() {
		return des_ie;
	}
	@Column(nullable = false, length = 100)
	public String getDes_email() {
		return des_email;
	}
	public void setDes_email(String des_email) {
		this.des_email = des_email;
	}			
	
	@Override
	public String toString() {
		return "TbEmpresa [id=" + id + ", des_nome=" + des_nome + ", des_fantasia=" + des_fantasia + ", des_endereco="
				+ des_endereco + ", des_numero=" + des_numero + ", des_bairro=" + des_bairro + ", des_cep=" + des_cep
				+ ", des_telefone=" + des_telefone + ", des_cnpj=" + des_cnpj + ", des_ie=" + des_ie + ", des_im="
				+ des_im + ", enumTipoRegime=" + enumTipoRegime + ", cod_cidade=" + cod_cidade + ", dta_cadastro="
				+ dta_cadastro + ", des_mensagempinpad=" + des_mensagempinpad + ", des_iptef=" + des_iptef
				+ ", des_caminhocarga=" + des_caminhocarga + ", des_email=" + des_email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_cidade == null) ? 0 : cod_cidade.hashCode());
		result = prime * result + ((des_bairro == null) ? 0 : des_bairro.hashCode());
		result = prime * result + ((des_caminhocarga == null) ? 0 : des_caminhocarga.hashCode());
		result = prime * result + ((des_cep == null) ? 0 : des_cep.hashCode());
		result = prime * result + ((des_cnpj == null) ? 0 : des_cnpj.hashCode());
		result = prime * result + ((des_email == null) ? 0 : des_email.hashCode());
		result = prime * result + ((des_endereco == null) ? 0 : des_endereco.hashCode());
		result = prime * result + ((des_fantasia == null) ? 0 : des_fantasia.hashCode());
		result = prime * result + ((des_ie == null) ? 0 : des_ie.hashCode());
		result = prime * result + ((des_im == null) ? 0 : des_im.hashCode());
		result = prime * result + ((des_iptef == null) ? 0 : des_iptef.hashCode());
		result = prime * result + ((des_mensagempinpad == null) ? 0 : des_mensagempinpad.hashCode());
		result = prime * result + ((des_nome == null) ? 0 : des_nome.hashCode());
		result = prime * result + ((des_numero == null) ? 0 : des_numero.hashCode());
		result = prime * result + ((des_telefone == null) ? 0 : des_telefone.hashCode());
		result = prime * result + ((dta_cadastro == null) ? 0 : dta_cadastro.hashCode());
		result = prime * result + ((enumTipoRegime == null) ? 0 : enumTipoRegime.hashCode());
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
		TbEmpresa other = (TbEmpresa) obj;
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
		if (des_caminhocarga == null) {
			if (other.des_caminhocarga != null)
				return false;
		} else if (!des_caminhocarga.equals(other.des_caminhocarga))
			return false;
		if (des_cep == null) {
			if (other.des_cep != null)
				return false;
		} else if (!des_cep.equals(other.des_cep))
			return false;
		if (des_cnpj == null) {
			if (other.des_cnpj != null)
				return false;
		} else if (!des_cnpj.equals(other.des_cnpj))
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
		if (des_fantasia == null) {
			if (other.des_fantasia != null)
				return false;
		} else if (!des_fantasia.equals(other.des_fantasia))
			return false;
		if (des_ie == null) {
			if (other.des_ie != null)
				return false;
		} else if (!des_ie.equals(other.des_ie))
			return false;
		if (des_im == null) {
			if (other.des_im != null)
				return false;
		} else if (!des_im.equals(other.des_im))
			return false;
		if (des_iptef == null) {
			if (other.des_iptef != null)
				return false;
		} else if (!des_iptef.equals(other.des_iptef))
			return false;
		if (des_mensagempinpad == null) {
			if (other.des_mensagempinpad != null)
				return false;
		} else if (!des_mensagempinpad.equals(other.des_mensagempinpad))
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
		if (enumTipoRegime != other.enumTipoRegime)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
	
}
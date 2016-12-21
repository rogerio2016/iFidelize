package com.ifidelize.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class TbUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String des_nome;
	private String des_email;
	private String des_senha;
	private List<TbGrupo_Usuario> grupos = new ArrayList<>();
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 80)
	public String getDes_nome() {
		return des_nome;
	}
	public void setDes_nome(String des_nome) {
		this.des_nome = des_nome;
	}
	
	@Column(nullable = false, unique = true, length = 255)
	public String getDes_email() {
		return des_email;
	}
	public void setDes_email(String des_email) {
		this.des_email = des_email;
	}
	
	@Column(nullable = false, length = 20)
	public String getDes_senha() {
		return des_senha;
	}
	public void setDes_senha(String des_senha) {
		this.des_senha = des_senha;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	public List<TbGrupo_Usuario> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<TbGrupo_Usuario> grupos) {
		this.grupos = grupos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TbUsuario other = (TbUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
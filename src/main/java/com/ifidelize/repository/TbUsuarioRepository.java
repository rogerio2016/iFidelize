package com.ifidelize.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.ifidelize.model.TbUsuario;

public class TbUsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public TbUsuario porId(Long id) {
		return this.manager.find(TbUsuario.class, id);
	}
	
	public List<TbUsuario> porNome(String des_nome) {
		return this.manager.createQuery("from TbUsuario " +
				"where upper(des_nome) like :des_nome", TbUsuario.class)
				.setParameter("des_nome", des_nome.toUpperCase() + "%")
				.getResultList();
	}
	
	public List<TbUsuario> vendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from TbUsuario", TbUsuario.class).getResultList();
	}


	public TbUsuario porEmail(String email) {
		TbUsuario usuario = null;
		
		try {
			usuario = this.manager.createQuery("from TbUsuario where lower(des_email) = :email", TbUsuario.class)
				.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}
		
		return usuario;
	}

}
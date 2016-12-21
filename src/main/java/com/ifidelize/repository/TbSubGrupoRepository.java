package com.ifidelize.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ifidelize.model.TbGrupo;
import com.ifidelize.model.TbSubGrupo;

public class TbSubGrupoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public TbSubGrupo porId(Long id){
		return manager.find(TbSubGrupo.class, id);
	}
	
	public List<TbSubGrupo> buscaSubGrupo(){
		return manager.createQuery("from TbSubGrupo", TbSubGrupo.class).getResultList();
	}
	
	public List<TbSubGrupo> subGruposDe(TbGrupo grupo_id) {
		return manager.createQuery("from TbSubGrupo where cod_grupo = :id", 
				TbSubGrupo.class).setParameter("id", grupo_id).getResultList();
	}

}

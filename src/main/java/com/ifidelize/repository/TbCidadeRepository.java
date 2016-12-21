package com.ifidelize.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.ifidelize.model.TbCidade;

public class TbCidadeRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public TbCidade porId(Long id){
		return manager.find(TbCidade.class, id);
	}
	
	public List<TbCidade> buscaCidade(){
		return manager.createQuery("from TbCidade", TbCidade.class).getResultList();
	}
}

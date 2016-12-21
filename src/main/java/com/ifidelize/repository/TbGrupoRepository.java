package com.ifidelize.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.ifidelize.filter.TbGrupoFilter;
import com.ifidelize.model.TbGrupo;
import com.ifidelize.service.NegocioException;
import com.ifidelize.util.jpa.Transacao;

public class TbGrupoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TbGrupo guardar(TbGrupo grupo) {
		
		return manager.merge(grupo);
	}
	
	public TbGrupo porDescricao(String descricao) {
		try {
			return manager.createQuery("from TbGrupo where des_descricao = :descricao", TbGrupo.class)
				.setParameter("descricao", descricao)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	
	
	public TbGrupo porId(Long id) {
		return manager.find(TbGrupo.class, id);
	}
	
	@Transacao
	public void remover(TbGrupo grupo) {
		try {
			grupo = porId(grupo.getId());
			manager.remove(grupo);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Grupo não pode ser excluído.");
		}
	}


	@SuppressWarnings("unchecked")
	public List<TbGrupo> filtrados(TbGrupoFilter filtro) {
		Session session   = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TbGrupo.class);
	
		if (StringUtils.isNotBlank(filtro.getDes_descricao())) {
			criteria.add(Restrictions.ilike("des_descricao", filtro.getDes_descricao(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}

	public List<TbGrupo> buscaGrupo() {
		return manager.createQuery("from TbGrupo", TbGrupo.class).getResultList();
	}
}

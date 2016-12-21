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

import com.ifidelize.filter.TbTributacaoFilter;
import com.ifidelize.model.TbTributacao;
import com.ifidelize.service.NegocioException;
import com.ifidelize.util.jpa.Transacao;

public class TbTributacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TbTributacao guardar(TbTributacao tributacao) {
		
		return manager.merge(tributacao);
	}
	
	public TbTributacao porDescricao(String descricao) {
		try {
			return manager.createQuery("from TbTributacao where des_descricao = :descricao", TbTributacao.class)
				.setParameter("descricao", descricao)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	
	
	public TbTributacao porId(Long id) {
		return manager.find(TbTributacao.class, id);
	}
	
	@Transacao
	public void remover(TbTributacao tributacao) {
		try {
			tributacao = porId(tributacao.getId());
			manager.remove(tributacao);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Tributacao não pode ser excluído.");
		}
	}


	@SuppressWarnings("unchecked")
	public List<TbTributacao> filtrados(TbTributacaoFilter filtro) {
		Session session   = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TbTributacao.class);
	
		if (StringUtils.isNotBlank(filtro.getDes_descricao())) {
			criteria.add(Restrictions.ilike("des_descricao", filtro.getDes_descricao(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("id")).list();
	}

	public List<TbTributacao> buscaTributacao() {
		return manager.createQuery("from TbTributacao", TbTributacao.class).getResultList();
	}
}

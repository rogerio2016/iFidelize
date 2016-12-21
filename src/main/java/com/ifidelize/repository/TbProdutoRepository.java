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

import com.ifidelize.filter.TbProdutoFilter;
import com.ifidelize.model.TbProduto;
import com.ifidelize.service.NegocioException;
import com.ifidelize.util.jpa.Transacao;

public class TbProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TbProduto guardar(TbProduto produto) {
		
		return manager.merge(produto);
	}

	public TbProduto porCodBarra(String codBarra) {
		try {
			return manager.createQuery("from TbProduto where upper(num_codbarra) = :codBarra", TbProduto.class)
				.setParameter("codBarra", codBarra.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public TbProduto porPLU(String plu) {
		try {
			return manager.createQuery("from TbProduto where num_plu = :plu", TbProduto.class)
				.setParameter("plu", plu)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	
	
	public TbProduto porId(Long id) {
		return manager.find(TbProduto.class, id);
	}
	
	@Transacao
	public void remover(TbProduto produto) {
		try {
			produto = porId(produto.getId());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído.");
		}
	}


	@SuppressWarnings("unchecked")
	public List<TbProduto> filtrados(TbProdutoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TbProduto.class);
		
		if (filtro.getNum_plu() != null) {
			// id deve ser menor ou igual (le = lower or equal) a filtro.numeroDe
			criteria.add(Restrictions.eq("num_plu", filtro.getNum_plu()));
		}


		if (StringUtils.isNotBlank(filtro.getDes_codbarra())) {
			criteria.add(Restrictions.eq("num_codbarra", filtro.getDes_codbarra()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDes_descricao())) {
			criteria.add(Restrictions.ilike("des_descricao", filtro.getDes_descricao(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("des_descricao")).list();
	}
	public List<TbProduto> porDescricao(String des_descricao) {
		return this.manager.createQuery("from TbProduto where upper(des_descricao) like :des_descricao", TbProduto.class)
				.setParameter("des_descricao", des_descricao.toUpperCase() + "%").getResultList();
	}

}

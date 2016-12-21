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
import com.ifidelize.filter.TbEmpresaFilter;
import com.ifidelize.model.TbEmpresa;
import com.ifidelize.service.NegocioException;
import com.ifidelize.util.jpa.Transacao;

public class TbEmpresaRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public TbEmpresa guardar(TbEmpresa empresa){
		return manager.merge(empresa);
	}

	public TbEmpresa porCNPJ(String cnpj) {
		try {
			return manager.createQuery("from TbEmpresa where upper(des_cnpj) = :cnpj", TbEmpresa.class)
				.setParameter("cnpj", cnpj.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {			
			return null;
		}
	}
	public List<TbEmpresa> porNome(String des_nome) {
		return this.manager.createQuery("from TbEmpresa " +
				"where upper(des_nome) like :des_nome", TbEmpresa.class)
				.setParameter("des_nome", des_nome.toUpperCase() + "%")
				.getResultList();
	}
	
	public TbEmpresa porId(Long id) {
		return manager.find(TbEmpresa.class, id);
	}
	
	@Transacao
	public void remover(TbEmpresa empresa) {
		try {
			empresa = porId(empresa.getId());
			manager.remove(empresa);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Empresa não pode ser excluído.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<TbEmpresa> filtrados(TbEmpresaFilter filtro) {
		Session session   = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TbEmpresa.class);

		if (StringUtils.isNotBlank(filtro.getDes_cnpj())) {
			criteria.add(Restrictions.eq("des_cnpj", filtro.getDes_cnpj()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDes_nome())) {
			criteria.add(Restrictions.ilike("des_nome", filtro.getDes_nome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("id")).list();
	}
}
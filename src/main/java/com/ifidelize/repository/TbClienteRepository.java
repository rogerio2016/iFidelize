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
import com.ifidelize.filter.TbClienteFilter;
import com.ifidelize.model.TbCliente;
import com.ifidelize.service.NegocioException;
import com.ifidelize.util.jpa.Transacao;

public class TbClienteRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Inject
	private EntityManager manager;
	
	public TbCliente guardar(TbCliente cliente) {
		
		return manager.merge(cliente);
	}

	public TbCliente porCPF(String cpf) {
		try {
			return manager.createQuery("from TbCliente where upper(des_cpf) = :cpf", TbCliente.class)
				.setParameter("cpf", cpf.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public TbCliente porRG(String rg) {
		try {
			return manager.createQuery("from TbCliente where des_rg = :rg", TbCliente.class)
				.setParameter("rg", rg)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	
	
	public TbCliente porEMAIL(String email) {
		try {
			return manager.createQuery("from TbCliente where des_email = :email", TbCliente.class)
				.setParameter("email", email)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}	

	public List<TbCliente> porNome(String des_nome) {
		return this.manager.createQuery("from TbCliente " +
				"where upper(des_nome) like :des_nome", TbCliente.class)
				.setParameter("des_nome", des_nome.toUpperCase() + "%")
				.getResultList();
	}
	
	public TbCliente porId(Long id) {
		return manager.find(TbCliente.class, id);
	}
	
	@Transacao
	public void remover(TbCliente cliente) {
		try {
			cliente = porId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}


	@SuppressWarnings("unchecked")
	public List<TbCliente> filtrados(TbClienteFilter filtro) {
		Session session   = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TbCliente.class);

		if (StringUtils.isNotBlank(filtro.getDes_cpf())) {
			criteria.add(Restrictions.eq("des_cpf", filtro.getDes_cpf()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDes_rg())) {
			criteria.add(Restrictions.ilike("des_rg", filtro.getDes_rg(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getDes_nome())) {
			criteria.add(Restrictions.ilike("des_nome", filtro.getDes_nome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("id")).list();
	}
}

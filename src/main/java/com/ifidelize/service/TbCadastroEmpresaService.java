package com.ifidelize.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.ifidelize.model.TbEmpresa;
import com.ifidelize.repository.TbEmpresaRepository;
import com.ifidelize.util.jpa.Transacao;

public class TbCadastroEmpresaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private TbEmpresaRepository empresaRepository;
	
	@Transacao
	public TbEmpresa salvar(TbEmpresa empresa){
		if (empresa.isNovo()) {
			empresa.setDta_cadastro(new Date());			
		}
				
		TbEmpresa cnpjExistente = empresaRepository.porCNPJ(empresa.getDes_cnpj());

		if (cnpjExistente != null && !cnpjExistente.equals(empresa) && empresa.getId()==null) {
			throw new NegocioException("Já existe um empresa com o CNPJ informado.");
		}
		
		return empresaRepository.guardar(empresa);
	}
	
}

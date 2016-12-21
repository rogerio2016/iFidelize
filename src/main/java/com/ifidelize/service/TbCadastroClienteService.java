package com.ifidelize.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;
import com.ifidelize.model.TbCliente;
import com.ifidelize.repository.TbClienteRepository;
import com.ifidelize.util.jpa.Transacao;

public class TbCadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbClienteRepository clienteRepository;
	
	@Transacao
	public TbCliente salvar(TbCliente cliente) {
		if (cliente.isNovo()) {
			cliente.setDta_cadastro(new Date());			
		}
		
		TbCliente codCPFExistente = clienteRepository.porCPF(cliente.getDes_cpf());
		//TbCliente emailExistente  = clienteRepository.porEMAIL(cliente.getDes_email());
		
		if (codCPFExistente != null && !codCPFExistente.equals(cliente) && cliente.getId()==null) {
			throw new NegocioException("Já existe um cliente com o CPF informado.");
		}
				
		return clienteRepository.guardar(cliente);
	}
	
	public Integer qtdClienteTotal(){	
		return 100;
	}

}

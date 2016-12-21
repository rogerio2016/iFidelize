package com.ifidelize.service;

import java.io.Serializable;
import javax.inject.Inject;
import com.ifidelize.model.TbTributacao;
import com.ifidelize.repository.TbTributacaoRepository;
import com.ifidelize.util.jpa.Transacao;

public class TbCadastroTributacaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbTributacaoRepository tributacaoRepository;
	
	@Transacao
	public TbTributacao salvar(TbTributacao tributacao) {		
		TbTributacao descricaoExistente = tributacaoRepository.porDescricao(tributacao.getDes_descricao());		
		if (descricaoExistente != null && !descricaoExistente.equals(tributacao) && tributacao.getId()==null) {
			throw new NegocioException("Já existe um tributacao com a descrição informada.");
		}
				
		return tributacaoRepository.guardar(tributacao);
	}
	
}

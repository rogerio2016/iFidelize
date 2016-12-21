package com.ifidelize.service;

import java.io.Serializable;
import javax.inject.Inject;
import com.ifidelize.model.TbGrupo;
import com.ifidelize.repository.TbGrupoRepository;
import com.ifidelize.util.jpa.Transacao;

public class TbCadastroGrupoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TbGrupoRepository grupoRepository;
	
	@Transacao
	public TbGrupo salvar(TbGrupo grupo) {		
		TbGrupo descricaoExistente = grupoRepository.porDescricao(grupo.getDes_descricao());		
		if (descricaoExistente != null && !descricaoExistente.equals(grupo) && grupo.getId()==null) {
			throw new NegocioException("Já existe um grupo com a descrição informada.");
		}
				
		return grupoRepository.guardar(grupo);
	}
	
}

package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.ifidelize.filter.TbGrupoFilter;
import com.ifidelize.model.TbGrupo;
import com.ifidelize.repository.TbGrupoRepository;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaGruposBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private TbGrupoRepository grupoRepository;
	
	private TbGrupoFilter filtro;
	private List<TbGrupo> gruposFiltrados;
	private TbGrupo grupoSelecionado;
	
	public TbGrupo getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(TbGrupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public PesquisaGruposBean() {
		filtro = new TbGrupoFilter();
	}
	
	public void pesquisar() {
		gruposFiltrados = grupoRepository.filtrados(filtro);
	}

	public void excluir() {
		grupoRepository.remover(grupoSelecionado);
		gruposFiltrados.remove(grupoSelecionado);
		
		FacesUtil.addInfoMessage("Grupo " + grupoSelecionado.getId()+" - "+grupoSelecionado.getDes_descricao()
				+ " excluído com sucesso.");
	}
	
	public List<TbGrupo> getGruposFiltrados() {
		return gruposFiltrados;
	}

	public TbGrupoFilter getFiltro() {
		return filtro;
	}
	
}
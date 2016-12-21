package com.ifidelize.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.ifidelize.model.TbGrupo;
import com.ifidelize.service.TbCadastroGrupoService;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private TbGrupo grupo;
	@Inject
	private TbCadastroGrupoService cadastroGrupoService;
	
	public CadastroGrupoBean() {
		limpar();
	}
		
	public void inicializar() {
		
		if (FacesUtil.isNotPostback()) {
	
		}
	}
	
	public void salvar(){
		this.grupo = cadastroGrupoService.salvar(this.grupo);
		limpar();
		
		FacesUtil.addInfoMessage("Grupo salva com sucesso!");
	}

	public TbGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(TbGrupo grupo) {
		this.grupo = grupo;
	}	
	
	private void limpar() {
		this.grupo      = new TbGrupo();
	}

	public boolean isEditando() {
		return this.grupo.getId() != null;
	}
}
 
package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifidelize.filter.TbClienteFilter;
import com.ifidelize.filter.TbEmpresaFilter;
import com.ifidelize.model.TbCliente;
import com.ifidelize.model.TbEmpresa;
import com.ifidelize.repository.TbClienteRepository;
import com.ifidelize.repository.TbEmpresaRepository;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaEmpresasBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private TbEmpresaRepository empresaRepository;
	
	private TbEmpresaFilter filtro;
	private List<TbEmpresa> empresasFiltrados;
	private TbEmpresa empresaSelecionado;
	
	public TbEmpresa getEmpresaSelecionado() {
		return empresaSelecionado;
	}

	public void setEmpresaSelecionado(TbEmpresa empresaSelecionado) {
		this.empresaSelecionado = empresaSelecionado;
	}

	public PesquisaEmpresasBean() {
		filtro = new TbEmpresaFilter();
	}
	
	public void pesquisar() {
		empresasFiltrados = empresaRepository.filtrados(filtro);
	}

	public void excluir() {
		empresaRepository.remover(empresaSelecionado);
		empresasFiltrados.remove(empresaSelecionado);
		
		FacesUtil.addInfoMessage("Empresa " + empresaSelecionado.getDes_cnpj()+" - "+empresaSelecionado.getDes_nome()
				+ " excluído com sucesso.");
	}
	
	public List<TbEmpresa> getEmpresasFiltrados() {
		return empresasFiltrados;
	}

	public TbEmpresaFilter getFiltro() {
		return filtro;
	}
	
}
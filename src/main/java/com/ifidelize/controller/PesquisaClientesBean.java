package com.ifidelize.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.Document;

import org.dom4j.DocumentException;

import com.ifidelize.filter.TbClienteFilter;
import com.ifidelize.model.TbCliente;
import com.ifidelize.repository.TbClienteRepository;
import com.ifidelize.util.jsf.FacesUtil;

import java.awt.Image;
import java.io.File;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private TbClienteRepository clienteRepository;
	
	private TbClienteFilter filtro;
	private List<TbCliente> clientesFiltrados;
	private TbCliente clienteSelecionado;
	
	public TbCliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(TbCliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public PesquisaClientesBean() {
		filtro = new TbClienteFilter();
	}
	
	public void pesquisar() {
		clientesFiltrados = clienteRepository.filtrados(filtro);
	}

	public void excluir() {
		clienteRepository.remover(clienteSelecionado);
		clientesFiltrados.remove(clienteSelecionado);
		
		FacesUtil.addInfoMessage("Cliente " + clienteSelecionado.getDes_cpf()+" - "+clienteSelecionado.getDes_nome()
				+ " excluído com sucesso.");
	}
	
	public List<TbCliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public TbClienteFilter getFiltro() {
		return filtro;
	}

}
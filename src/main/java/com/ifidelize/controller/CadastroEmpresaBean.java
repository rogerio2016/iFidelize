package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.ifidelize.model.TbCidade;
import com.ifidelize.model.TbEmpresa;
import com.ifidelize.model.enumTipoRegime;
import com.ifidelize.repository.TbCidadeRepository;
import com.ifidelize.service.TbCadastroEmpresaService;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEmpresaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TbEmpresa empresa;
	private List<TbCidade> listarCidade;
	private TbCidade cod_cidade;
	@Inject
	private TbCidadeRepository cidadeRepositorio;
	@Inject
	private TbCadastroEmpresaService empresaService;
	
	
	public TbEmpresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(TbEmpresa empresa) {
		this.empresa = empresa;
		if (this.empresa != null) {
			this.cod_cidade = this.empresa.getCod_cidade();
		}
	}

	public List<TbCidade> getListarCidade() {
		return listarCidade;
	}

	public TbCidade getCod_cidade() {
		return cod_cidade;
	}

	public void setCod_cidade(TbCidade cod_cidade) {
		this.cod_cidade = cod_cidade;
	}

	public enumTipoRegime[] getTipoRegime() {
		return enumTipoRegime.values();
	}
	
	public CadastroEmpresaBean(){
		limpar();
	}
	public void inicializar() {

		if (FacesUtil.isNotPostback()) {
			System.out.println("Inicializando...");
			listarCidade = cidadeRepositorio.buscaCidade();
			if (listarCidade.isEmpty()) {
			  //cadastroClienteService.carregaCidades();	
			  listarCidade = cidadeRepositorio.buscaCidade();
			}
		}
	}

	public void salvar() {
		this.empresa = empresaService.salvar(this.empresa);
		limpar();

		FacesUtil.addInfoMessage("Registro salvo com sucesso!");
	}

	public void carregarCidade() {
		listarCidade = cidadeRepositorio.buscaCidade();
	}

	private void limpar() {
		this.empresa = new TbEmpresa();
		this.cod_cidade = null;

	}

	public boolean isEditando() {
		return this.empresa.getId() != null;
	}
}
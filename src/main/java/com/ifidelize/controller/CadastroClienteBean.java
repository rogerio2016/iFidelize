package com.ifidelize.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.ifidelize.model.EnumTipoPessoa;
import com.ifidelize.model.TbCidade;
import com.ifidelize.model.TbCliente;
import com.ifidelize.repository.TbCidadeRepository;
import com.ifidelize.service.TbCadastroClienteService;
import com.ifidelize.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TbCliente cliente;
	private List<TbCidade> listarCidade;
	private TbCidade cod_cidade;
	@Inject
	private TbCidadeRepository cidadeRepositorio;
	@Inject
	private TbCadastroClienteService cadastroClienteService;

	public TbCliente getCliente() {
		return cliente;
	}

	public void setCliente(TbCliente cliente) {
		this.cliente = cliente;
		if (this.cliente != null) {
			this.cod_cidade = this.cliente.getCod_cidade();
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

	public EnumTipoPessoa[] getTipoPessoa() {
		return EnumTipoPessoa.values();
	}

	public CadastroClienteBean() {
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
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();

		FacesUtil.addInfoMessage("Registro salvo com sucesso!");
	}

	public void carregarCidade() {
		listarCidade = cidadeRepositorio.buscaCidade();
	}

	private void limpar() {
		this.cliente = new TbCliente();
		this.cod_cidade = null;

	}

	public boolean isEditando() {
		return this.cliente.getId() != null;
	}
}

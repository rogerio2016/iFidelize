package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.ifidelize.model.TbProduto;
import com.ifidelize.repository.TbProdutoRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbProduto.class)
public class TbProdutoConverter implements Converter{
	

	//@Inject
	private TbProdutoRepository produtoRepository;
	
	public TbProdutoConverter() {
		produtoRepository = CDIServiceLocator.getBean(TbProdutoRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbProduto retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = produtoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TbProduto produto = (TbProduto) value;
			return produto.getId() == null ? null : produto.getId().toString();
		}
		
		return "";
	}
}

package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import com.ifidelize.model.TbTributacao;
import com.ifidelize.repository.TbTributacaoRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbTributacao.class)
public class TbTributacaoConverter implements Converter{
	
	@Inject
	private TbTributacaoRepository tributacaoRepository;
	
	public TbTributacaoConverter(){

		tributacaoRepository = CDIServiceLocator.getBean(TbTributacaoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbTributacao retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = tributacaoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			TbTributacao tributacao = (TbTributacao) value;
			return tributacao.getId() == null ? null : tributacao.getId().toString();
		}
		
		return "";
	}

}

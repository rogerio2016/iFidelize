package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.ifidelize.model.TbCidade;
import com.ifidelize.repository.TbCidadeRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbCidade.class)
public class TbCidadeConverter implements Converter{
	

	//@Inject
	private TbCidadeRepository cidadeRepository;
	
	public TbCidadeConverter() {
		cidadeRepository = CDIServiceLocator.getBean(TbCidadeRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbCidade retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = cidadeRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((TbCidade) value).getId().toString();
		}
		
		return "";
	}
}
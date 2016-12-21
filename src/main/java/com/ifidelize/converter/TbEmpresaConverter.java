package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.ifidelize.model.TbEmpresa;
import com.ifidelize.repository.TbEmpresaRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbEmpresa.class)
public class TbEmpresaConverter implements Converter{
	

	//@Inject
	private TbEmpresaRepository empresaRepository;
	
	public TbEmpresaConverter() {
		empresaRepository = CDIServiceLocator.getBean(TbEmpresaRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbEmpresa retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = empresaRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TbEmpresa empresa = (TbEmpresa) value;
			return empresa.getId() == null ? null : empresa.getId().toString();
		}
		
		return "";
	}
}

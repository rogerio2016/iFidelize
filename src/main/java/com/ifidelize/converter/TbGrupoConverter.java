package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.ifidelize.model.TbGrupo;
import com.ifidelize.repository.TbGrupoRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbGrupo.class)
public class TbGrupoConverter implements Converter{
	
	@Inject
	private TbGrupoRepository grupoRepository;
	
	public TbGrupoConverter(){

		grupoRepository = CDIServiceLocator.getBean(TbGrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbGrupo retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = grupoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			TbGrupo grupo = (TbGrupo) value;
			return grupo.getId() == null ? null : grupo.getId().toString();
		}
		
		return "";
	}
}

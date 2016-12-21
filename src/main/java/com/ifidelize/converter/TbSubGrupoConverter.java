package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import com.ifidelize.model.TbSubGrupo;
import com.ifidelize.repository.TbSubGrupoRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbSubGrupo.class)
public class TbSubGrupoConverter implements Converter{
	
	@Inject
	private TbSubGrupoRepository subGrupoRepository;
	
	public TbSubGrupoConverter(){

		subGrupoRepository = CDIServiceLocator.getBean(TbSubGrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbSubGrupo retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = subGrupoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((TbSubGrupo) value).getId().toString();
		}
		
		return "";
	}


}

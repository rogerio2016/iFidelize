package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.ifidelize.model.TbUsuario;
import com.ifidelize.repository.TbUsuarioRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbUsuario.class)
public class TbUsuarioConverter implements Converter{
	

	//@Inject
	private TbUsuarioRepository usuarioRepository;
	
	public TbUsuarioConverter() {
		usuarioRepository = CDIServiceLocator.getBean(TbUsuarioRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbUsuario retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = usuarioRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TbUsuario usuario = (TbUsuario) value;
			return usuario.getId() == null ? null : usuario.getId().toString();
		}
		
		return "";
	}
}

package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.ifidelize.model.TbCliente;
import com.ifidelize.repository.TbClienteRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbCliente.class)
public class TbClienteConverter implements Converter{
	

	//@Inject
	private TbClienteRepository clienteRepository;
	
	public TbClienteConverter() {
		clienteRepository = CDIServiceLocator.getBean(TbClienteRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbCliente retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = clienteRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TbCliente cliente = (TbCliente) value;
			return cliente.getId() == null ? null : cliente.getId().toString();
		}
		
		return "";
	}
}

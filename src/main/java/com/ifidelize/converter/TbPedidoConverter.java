package com.ifidelize.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ifidelize.model.TbPedido;
import com.ifidelize.repository.TbPedidoRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TbPedido.class)
public class TbPedidoConverter implements Converter {

	//@Inject
	private TbPedidoRepository pedidoRepository;
	
	public TbPedidoConverter() {
		pedidoRepository = CDIServiceLocator.getBean(TbPedidoRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TbPedido retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = pedidoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TbPedido pedido = (TbPedido) value;
			return pedido.getId() == null ? null : pedido.getId().toString();
		}
		
		return "";
	}

}

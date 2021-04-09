package br.com.fdp.pedidos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fdp.pedidos.model.Pedido;
import br.com.fdp.pedidos.repository.PedidoRepository;




@Component
public class PedidoConverter implements Converter{
	
	@Autowired
	private PedidoRepository orderRepository;

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			Pedido order = orderRepository.findOne(new Long(value));
			return order;
		} catch (Exception e) {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Pedido) {
			Pedido order = (Pedido) value;
			return order.getId().toString();
		} else {
			return null;
		}
	}

}

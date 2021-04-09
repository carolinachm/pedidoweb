package br.com.fdp.pedidos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Estado;
import br.com.fdp.pedidos.repository.ClienteRepository;



@Component
public class ClienteConverter implements Converter{
	
	@Autowired
	private ClienteRepository clientRepository;

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			Cliente client = clientRepository.findOne(new Long(value));
			return client;
		} catch (Exception e) {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Cliente) {
			Cliente client = (Cliente) value;
			return client.getId().toString();
		} else {
			return null;
		}
	}

}

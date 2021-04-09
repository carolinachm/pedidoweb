package br.com.fdp.pedidos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fdp.pedidos.model.Estado;
import br.com.fdp.pedidos.repository.EstadoRepository;



@Component
public class EstadoConverter implements Converter{
	
	@Autowired
	private EstadoRepository stateRepository;

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			Estado state = stateRepository.findOne(new Long(value));
			return state;
		} catch (Exception e) {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Estado) {
			Estado state = (Estado) value;
			return state.getId().toString();
		} else {
			return null;
		}
	}

}

package br.com.fdp.pedidos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fdp.pedidos.model.Embrulho;
import br.com.fdp.pedidos.repository.EmbrulhoRepository;



@Component
public class EmbrulhoConverter implements Converter{
	
	@Autowired
	private EmbrulhoRepository embrulhoRepository;

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			Embrulho embrulho = embrulhoRepository.findOne(new Long(value));
			return embrulho;
		} catch (Exception e) {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Embrulho) {
			Embrulho embrulho = (Embrulho) value;
			return embrulho.getId().toString();
		} else {
			return null;
		}
	}

}

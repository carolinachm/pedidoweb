package br.com.fdp.pedidos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fdp.pedidos.model.Produto;
import br.com.fdp.pedidos.repository.ProdutoRepository;



@Component
public class ProdutoConverter implements Converter{
	
	@Autowired
	private ProdutoRepository productRepository;

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			Produto product = productRepository.findOne(new Long(value));
			return product;
		} catch (Exception e) {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Produto) {
			Produto product = (Produto) value;
			return product.getId().toString();
		} else {
			return null;
		}
	}

}

package br.com.fdp.pedidos.model;


import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


@Embeddable
public class Endereco {
	@Getter@Setter
	private String cep;// = null;
	@Getter@Setter
	private String logradouro, bairro, cidade, numero, complemento;

	
	
}

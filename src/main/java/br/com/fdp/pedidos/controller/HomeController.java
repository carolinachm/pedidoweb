package br.com.fdp.pedidos.controller;

import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;

import br.com.fdp.pedidos.repository.GreetingsService;


@Named
@Scope("request")
public class HomeController {

	public static final String BEAN_NAME = "homeController";

	@ManagedProperty(value = "#{" + GreetingsService.COMP_NAME + "}")
	@Getter@Setter
	private GreetingsService service;
	@Getter@Setter
	private String grettings;
	
	 public void sayHello() {
	        this.grettings = this.service.sayHello();
	    }

}

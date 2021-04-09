package br.com.fdp.pedidos.controller;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("Request")
public class NavigatorController {
	
	 public static final String BEAN_NAME  = "navigatorController";

	    public String home() {
	        return "home";
	    }

	    public String settings() {
	        return "settings";
	    }

}

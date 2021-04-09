package br.com.fdp.pedidos.controller;


import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import br.com.fdp.pedidos.model.Usuario;
import br.com.fdp.pedidos.service.UsuarioService;

@Named
@RequestScoped
public class LoginController {
	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioLogadoController usuarioLogado;

	public String efetuaLogin() {
		if (usuarioService.existe(usuario)) {
			usuarioLogado.loga(usuario);
			return "home.xhtml";
		}
		return "login";
	}
	
	public String deslogar() {
		this.usuarioLogado.desloga();
		
		return "login";
	}

	

}

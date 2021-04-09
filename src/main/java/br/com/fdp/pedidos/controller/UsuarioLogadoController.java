package br.com.fdp.pedidos.controller;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import br.com.fdp.pedidos.model.Usuario;
import org.springframework.web.context.annotation.SessionScope;

@Named
@SessionScope
public class UsuarioLogadoController {
	@Getter @Setter
	private Usuario usuario;
	
	public UsuarioLogadoController() {
		System.out.println("logado");
	}

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public void desloga() {
		this.usuario = null;
	}
	
}

package br.com.fdp.pedidos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.pedidos.model.Usuario;
import br.com.fdp.pedidos.repository.UsuarioRepository;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@ViewScoped
public class UsuarioController {
	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	@Getter
	@Setter
	private List<Usuario> usuarios;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Getter
	@Setter
	private boolean modoEdicao = false;
	
	
	@PostConstruct
	public void init() {
		usuarios = usuarioRepository.findAll();
	}

	public void salvar() {
		try {
			usuarioRepository.save(getUsuario());
			if (!isModoEdicao())
				usuarios.add(usuario);
			setModoEdicao(false);
			usuario = new Usuario();
			MensagemUtil.mensagemInfo("Salvo com sucesso");
		} catch (ServiceException e) {
			e.printStackTrace();
			MensagemUtil.mensagemError("Ocorreu um erro ao tentar salvar o usuario");
		}

	}

	public void excluir(Usuario usuario){
		try{
		usuarioRepository.delete(usuario);
		usuarios.remove(usuario);
		MensagemUtil.mensagemInfo("Excluido com sucesso");
		}catch(ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Ocorreu um erro ao tentar excluir o usuario");
		}
		
	}

	public void editar(Usuario usuario) {
		
		setUsuario(usuario);
		setModoEdicao(true);
		
	}

	public void cancelar() {
		usuario = new Usuario();
		setModoEdicao(false);
	}
	
}

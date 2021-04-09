package br.com.fdp.pedidos.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import br.com.fdp.pedidos.model.Usuario;

/**
 * @author carolina
 *
 */
@Service
public class UsuarioService {
	
	@Inject
	private EntityManager manager;
	/*Verificar se o usuario existe*/
	public boolean existe(Usuario usuario) {
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha")
						.setParameter("login", usuario.getLogin())
						.setParameter("senha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}

}

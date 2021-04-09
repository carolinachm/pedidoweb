package br.com.fdp.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("select u from Usuario u where u.login =:login")
	public List<Usuario> buscarUsuarioPorLogin(@Param("login") String login);
}

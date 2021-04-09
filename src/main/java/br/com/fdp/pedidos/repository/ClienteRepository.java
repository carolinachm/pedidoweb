package br.com.fdp.pedidos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	@Query("select c from Cliente c where c.cpf=:cpf")
	public Cliente buscarClienteCPF(@Param("cpf") String cpf);
	@Query("select c from Cliente c where c.id=:id")
	public Cliente buscarClientePorId(@Param("id")Long id);
}

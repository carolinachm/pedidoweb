package br.com.fdp.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Cerimonial;
import br.com.fdp.pedidos.model.Cliente;
@Repository
public interface CerimonialRepository extends JpaRepository<Cerimonial, Long>{
	
	@Query("select c from Cerimonial c where c.nome=:nome")
	public List<Cerimonial> buscarCerimonialPorNome(@Param("nome") String nome);

}

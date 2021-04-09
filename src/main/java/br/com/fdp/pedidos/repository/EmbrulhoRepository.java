package br.com.fdp.pedidos.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Embrulho;
import br.com.fdp.pedidos.model.Pedido;
@Repository
public interface EmbrulhoRepository extends JpaRepository<Embrulho, Long> {
	
	@Query("select e from Embrulho e where e.descricao=:descricao")
	public List<Embrulho> buscarEmbrulhoPorDescricao(@Param("descricao") String descricao);

}

package br.com.fdp.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("select p from Produto p where p.id=:id")
	public Produto buscarProdutoPorId(@Param("id")Long id);
}

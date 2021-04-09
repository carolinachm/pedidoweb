package br.com.fdp.pedidos.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fdp.pedidos.model.ItemPedido;


public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
	@Query("select ip from ItemPedido ip where ip.id=:id")
	public ItemPedido buscarItemPedidoPorId(@Param("id") Long id);
	
	
	

}

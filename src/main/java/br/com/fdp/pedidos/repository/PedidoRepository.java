package br.com.fdp.pedidos.repository;


import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	
	@Query("select p from Pedido p where p.dataPedido=:dataPedido ")
	public Pedido buscarPorDataEntrega(@Param("dataPedido") String dataPedido);
	//@Query("select o from Pedido o where o.data>=:dataInicial and o.data<=:dataFinal ")
	@Query("select p from Pedido p where p.dataPedido between :dataInicial and :dataFinal ")
	public List<Pedido> buscarPorIntervaloPedido(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal );
	@Query("select p from Pedido p where p.dataEntrega between :dataInicial and :dataFinal ")
	public List<Pedido> buscarPorIntervaloEntrega(@Param("dataInicial")  Date dataInicial, @Param("dataFinal")  Date dataFinal );
	@Query("select p from Pedido p where p.cliente=:contratante")
	public List<Pedido> buscarPorCliente(@Param("contratante")String contratante);
	@Query("select p from Pedido p where p.id=:id")
	public Pedido buscarClientePorId(@Param("id")Long id);
	@Query("select p from Pedido p where p.cliente=:cpf")
	public Pedido buscarClientePorCPF(@Param("cpf") String cpf);
	
	
	

}

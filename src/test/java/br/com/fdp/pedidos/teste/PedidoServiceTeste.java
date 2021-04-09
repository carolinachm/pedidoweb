package br.com.fdp.pedidos.teste;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.fdp.pedidos.filtro.PedidoFiltro;
import br.com.fdp.pedidos.model.Pedido;
import br.com.fdp.pedidos.service.PedidoService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,
// replace=Replace.NONE)
public class PedidoServiceTeste {
	@Autowired
	private PedidoService pedidoService;
	@Test
	public void pesquisarTeste(){
		
		PedidoFiltro filtro = new PedidoFiltro();
		
		filtro.setContratante("Jao");
		
		
		List<Pedido> filtrados = pedidoService.filtrados(filtro);
		
		assertThat(filtrados.size() > 0);
		
		System.out.println(filtrados);
	}
	
}

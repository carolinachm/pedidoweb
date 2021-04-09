package br.com.fdp.pedidos.teste;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fdp.pedidos.model.Cerimonial;
import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Embrulho;
import br.com.fdp.pedidos.model.Endereco;
import br.com.fdp.pedidos.model.ItemPedido;
import br.com.fdp.pedidos.model.Pedido;
import br.com.fdp.pedidos.model.Produto;
import br.com.fdp.pedidos.repository.PedidoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PedidoRepositoryTest {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	EntityManager entityManager;

	@Test
	@Ignore
	public void save() {

		Pedido pedido = new Pedido();
		Cliente clinete = new Cliente();
		Cerimonial cerimonial = new Cerimonial();

		
		pedido.setCerimonial(pedido.getCerimonial());
		pedido.setEnderecoEntrega(new Endereco());
		pedido.setDataPedido(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setValorTotal(new BigDecimal("13.00"));
		
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		assertThat(pedidoSalvo.getId()).isNotNull();

	}

	@Test
	@Ignore
	public void adicionarItemPedido() {

	}
	@Test
	@Ignore
	public void calcular() {

	}
	

}

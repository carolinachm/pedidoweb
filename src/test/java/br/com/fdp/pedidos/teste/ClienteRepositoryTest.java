package br.com.fdp.pedidos.teste;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,
// replace=Replace.NONE)
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	EntityManager entityManager;

	@Test
	@Ignore
	public void testSalvar() {

		Cliente cli = new Cliente();
		cli.setNomeNoivo("Jão");
		cli.setEmail("Jão@Jão.com.br");
		Cliente cliSalvo = clienteRepository.save(cli);
		assertThat(cliSalvo.getId()).isNotNull();

	}

	@Test
	@Ignore
	public void testeBuscaPorEmail() {

		Cliente cli = new Cliente();
		cli.setNomeNoivo("Jão");
		cli.setEmail("Jao@htcursos.com");
		entityManager.persist(cli);
		System.out.println(cli);

		assertThat(cli.getNomeNoivo()).isEqualTo("Jão");
		assertThat(cli.getEmail()).isEqualTo("Jao@htcursos.com");

	}

	@Test
	@Ignore
	public void buscarTodos() {

		Cliente cliente = new Cliente();
		cliente.setNomeNoivo("Jão");
		cliente.setEmail("Jao@htcursos.com");
		entityManager.persist(cliente);

		Cliente cliente1 = new Cliente();
		cliente1.setNomeNoivo("Ze");
		cliente1.setEmail("Ze@htcursos.com");
		entityManager.persist(cliente1);

		Cliente cliente2 = new Cliente();
		cliente2.setNomeNoivo("Maria");
		cliente2.setEmail("Maria@htcursos.com");
		entityManager.persist(cliente2);

		Cliente cliente3 = new Cliente();
		cliente3.setNomeNoivo("Ana");
		cliente3.setEmail("Ana@htcursos.com");
		entityManager.persist(cliente3);

		Cliente cliente4 = new Cliente();
		cliente4.setNomeNoivo("Maria1");
		cliente4.setEmail("Maria1@htcursos.com");
		entityManager.persist(cliente4);

		List<String> clientes = Arrays.asList("Jão", "Ze", "Maria", "Ana",
				"Maria1");

		assertThat(clientes).containsExactly("Jão", "Ze", "Maria", "Ana",
				"Maria1");
		System.out.println(clientes);

	}
	@Test
	public void buscarClienteNome(){
		
		Cliente filtro = new Cliente();
		filtro.setContratante("Jao");
		
		
		
	}
}
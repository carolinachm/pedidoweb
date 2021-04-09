package br.com.fdp.pedidos.teste;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.fdp.pedidos.model.Cerimonial;
import br.com.fdp.pedidos.repository.CerimonialRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CeremonialRepositoryTest {
	@Autowired
	private CerimonialRepository ceremonialRepository;
	@Test
	public void save(){
		
		Cerimonial ceremonial = new Cerimonial();
		ceremonial.setNome("Maria");
		ceremonial.setTelefone("1234-5678");
		
		Cerimonial ceremonialSalvo = ceremonialRepository.save(ceremonial);
		
		assertThat(ceremonialSalvo.getNome());
		
	}
}

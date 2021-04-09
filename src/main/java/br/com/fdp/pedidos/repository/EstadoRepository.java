package br.com.fdp.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fdp.pedidos.model.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	

	

}

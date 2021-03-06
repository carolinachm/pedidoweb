package br.com.fdp.pedidos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 80, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String sabor;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorProduto = BigDecimal.ZERO;
	

	
	

}

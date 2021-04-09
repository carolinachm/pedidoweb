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
import lombok.ToString;

@Entity
@Table(name="tb_embrulho")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Embrulho {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorEmbrulho;
	

}

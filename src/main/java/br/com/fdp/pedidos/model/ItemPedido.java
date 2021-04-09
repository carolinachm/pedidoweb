package br.com.fdp.pedidos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Produto produto;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Embrulho embrulho;
	private int quantidade;
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorProduto;
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorEmbrulho;
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal precoParcial = BigDecimal.ZERO;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pedido pedido;
	
	
	
	public void setProduto(Produto produto){
		this.produto = produto;
	}

}

package br.com.fdp.pedidos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.fdp.pedidos.enumerador.FormaPagamento;

@Entity
@Table(name = "tb_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	 @Embedded
	private Endereco enderecoEntrega = new Endereco();
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorTotal = BigDecimal.ZERO;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cerimonial cerimonial;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REMOVE }, mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	private String nomeBuffet;

	
	



}
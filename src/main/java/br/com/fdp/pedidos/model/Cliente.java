package br.com.fdp.pedidos.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	private String contratante;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String email;
	private String telefone;
	private String cpf;
	private String nomeNoivo;
	@Embedded
	private Endereco endereco = new Endereco();
	/*
	 * @OneToMany(cascade=CascadeType.ALL, mappedBy="cliente") private
	 * List<Pedido> pedidos = new ArrayList<>();
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

}
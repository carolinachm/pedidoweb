package br.com.fdp.pedidos.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario  {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String login;

	@NotEmpty
	private String senha;

	@Transient
	private String confirmaSenha;

	@NotEmpty
	private String email;

	private Boolean status;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date cadastro;
	
	private String papel;


}

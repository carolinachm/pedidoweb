package br.com.fdp.pedidos.controller.pesquisa;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.transaction.Transactional;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.fdp.pedidos.filtro.ClienteFiltro;
import br.com.fdp.pedidos.filtro.PedidoFiltro;
import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.service.ClienteService;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@Scope("view")
public class PesquisaClienteController {
	@Autowired
	private ClienteService clienteService;
	@Getter @Setter
	private Cliente cliente = new Cliente();
	@Getter @Setter
	private ClienteFiltro filtro ;
	@Getter @Setter
	private List<Cliente> clientes;
	
	
	public PesquisaClienteController() {
		filtro = new ClienteFiltro();
		clientes = new ArrayList<>();
	}

	
		
}

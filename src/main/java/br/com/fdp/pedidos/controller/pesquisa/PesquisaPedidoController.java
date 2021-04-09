package br.com.fdp.pedidos.controller.pesquisa;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.fdp.pedidos.controller.CepService;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.com.fdp.pedidos.filtro.PedidoFiltro;
import br.com.fdp.pedidos.model.Cerimonial;
import br.com.fdp.pedidos.model.Embrulho;
import br.com.fdp.pedidos.model.ItemPedido;
import br.com.fdp.pedidos.model.Pedido;
import br.com.fdp.pedidos.model.Produto;
import br.com.fdp.pedidos.service.PedidoService;

@Named
@SessionScope
public class PesquisaPedidoController {
	@Autowired
	private PedidoService pedidoService;

	@Getter
	@Setter
	private Pedido pedido = new Pedido();
	@Getter
	@Setter
	private ItemPedido itemPedido;
	@Getter
	@Setter
	private PedidoFiltro filtro;
	@Getter
	@Setter
	private List<Pedido> pedidosFiltrados ;
	
	public PesquisaPedidoController() {
	
		filtro = new PedidoFiltro();
		pedidosFiltrados = new ArrayList<Pedido>();
		itemPedido = new ItemPedido();
	}

	@Transactional
	public void pesquisar() {
		pedidosFiltrados = pedidoService.filtrados(filtro);
		filtro = new PedidoFiltro();

	}

	public void cancelar() {
		filtro = new PedidoFiltro();
	}
	public String irParaContrato(Pedido pedido){
		setPedido(pedido);
		pedido = new Pedido();
		return "contrato";
	}

}

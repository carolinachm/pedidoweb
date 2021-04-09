package br.com.fdp.pedidos.controller;

import br.com.fdp.pedidos.controller.pesquisa.PesquisaClienteController;
import br.com.fdp.pedidos.enumerador.FormaPagamento;
import br.com.fdp.pedidos.model.*;
import br.com.fdp.pedidos.repository.*;
import br.com.fdp.pedidos.util.MensagemUtil;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import java.math.BigDecimal;
import java.util.List;

@Named
@Scope("view")
public class PedidoController {
	@Getter
	@Setter
	private Pedido pedido = new Pedido();
	@Getter
	@Setter
	private Cliente cliente = new Cliente();
	@Getter
	@Setter
	private Produto produto = new Produto();
	@Getter
	@Setter
	private Embrulho embrulho = new Embrulho();
	@Getter
	@Setter
	private ItemPedido itemPedido = new ItemPedido();
	@Setter
	private FormaPagamento formaPagamento;
	@Getter
	@Setter
	private List<Pedido> pedidos;
	@Getter
	@Setter
	private List<Cliente> clientes;
	@Getter
	@Setter
	private List<Cerimonial> cerimoniais;
	@Getter
	@Setter
	private List<Produto> produtos;
	@Getter
	@Setter
	private List<Embrulho> embrulhos;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CerimonialRepository cerimonialRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EmbrulhoRepository embrulhoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemRepository;
	@Autowired
	private CepService cepService;


	@PostConstruct
	public void init() {

		pedidos = pedidoRepository.findAll();
		clientes = clienteRepository.findAll();
		cerimoniais = cerimonialRepository.findAll();
		produtos = produtoRepository.findAll();
		embrulhos = embrulhoRepository.findAll();

	}



	public String salvar() {


		if (pedido.getId() == null) {
			pedidoRepository.save(getPedido());
			pedidos.add(pedido);

			pedido = new Pedido();
		}
		return "listaPedido.xhtml";

	}

	public String excluir(Pedido pedido) {
		try {
			pedidoRepository.delete(pedido);
			pedidos.remove(pedido);
			pedido = new Pedido();
			MensagemUtil.mensagemInfo("Pedido excluido com sucesso");
		} catch (ServiceException e) {
			MensagemUtil
					.mensagemError("Ocorreu um erro ao tentar excluir o pedido");
		}
		return "listaPedido.xhtml";
	}

	public String editar(Pedido pedido) {
		setPedido(pedido);
		pedido = new Pedido();
		return "cadastroPedido.xhtml";

	}

	public String novo() {
		pedido = new Pedido();
		return "cadastroPedido.xhtml";

	}

	public String cancelar() {
		pedido = new Pedido();
		return "listaPedido.xhtml";
	}

	public void carregarValorProduto(ValueChangeEvent evento) {

		if (evento.getNewValue() != evento.getOldValue()) {
			produto = (Produto) evento.getNewValue();
			itemPedido.setValorProduto(produto.getValorProduto());

		}
	}

	public void carregarValorEmbrulho(ValueChangeEvent evento) {

		if (evento.getNewValue() != evento.getOldValue()) {
			embrulho = (Embrulho) evento.getNewValue();
			itemPedido.setValorEmbrulho(embrulho.getValorEmbrulho());

		}
	}

	public void adicionarItemPedido() {
		itemPedido.setPedido(pedido);
		pedido.getItensPedido().add(itemPedido);
		BigDecimal total1 = BigDecimal.ZERO;
		BigDecimal total2 = BigDecimal.ZERO;
		total1 = BigDecimal.valueOf(itemPedido.getQuantidade()).multiply(
				itemPedido.getValorProduto());
		total2 = BigDecimal.valueOf(itemPedido.getQuantidade()).multiply(
				itemPedido.getValorEmbrulho());
		BigDecimal precoParcial = total1.add(total2);
		itemPedido.setPrecoParcial(precoParcial);
		calcular();
		itemPedido = new ItemPedido();
	}

	public void calcular() {
		pedido.setValorTotal(new BigDecimal("0.00"));
		for (int posicao = 0; posicao < pedido.getItensPedido().size(); posicao++) {
			ItemPedido itemPedido = pedido.getItensPedido().get(posicao);
			pedido.setValorTotal(pedido.getValorTotal().add(
					itemPedido.getPrecoParcial()));
		}
	}

	public void excluirPedido(ItemPedido itemPedido) {
		pedido.getItensPedido().remove(itemPedido);
		pedido.setValorTotal(pedido.getValorTotal().subtract(
				itemPedido.getPrecoParcial()));
		itemPedido = new ItemPedido();
	}

	public FormaPagamento[] getFormaPagamento() {
		return FormaPagamento.values();
	}

	public void buscar() {

		pedido = pedidoRepository.buscarClientePorId(pedido.getId());
	}

	public void buscarCep() {

		Endereco enderecoEntrega = cepService.encontraCEP(pedido
				.getEnderecoEntrega().getCep());

		if (enderecoEntrega != null) {
			pedido.setEnderecoEntrega(enderecoEntrega);
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Servidor não está respondendo",
							"Servidor não está respondendo"));
		}
	}

	public String adicionarCliente() {
		return "cliente.xhtml";
	}

public  void buscarClientePorCPF(){

		cliente = clienteRepository.buscarClienteCPF(cliente.getCpf());
		if(cliente != null){
			pedido.setCliente(cliente);
		}else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Cliente não esta cadastrado","Relize o cadastro"));
		}

}

}

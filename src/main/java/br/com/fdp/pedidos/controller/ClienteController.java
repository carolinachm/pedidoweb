package br.com.fdp.pedidos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;




import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;




import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Endereco;
import br.com.fdp.pedidos.model.Estado;
import br.com.fdp.pedidos.repository.ClienteRepository;
import br.com.fdp.pedidos.repository.EstadoRepository;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@Scope("view")
public class ClienteController {
	@Getter@Setter
	private Cliente cliente = new Cliente();
	
	@Getter@Setter
	private List<Cliente> clientes;
	
	@Getter@Setter
	private List<Estado> estados;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CepService cepService;
	
	@Autowired
	private EstadoRepository
			estadoRespository;
	@Getter@Setter
	private boolean modoEdicao = false;

	@PostConstruct
	public void init() {

		clientes = clienteRepository.findAll();
	
		estados = estadoRespository.findAll();

	}

	
	public void salvar() {

	try {
				if (!isModoEdicao())
					clientes.add(cliente);

				clienteRepository.save(getCliente());
				cliente = new Cliente();
				MensagemUtil.mensagemInfo("Salvo com sucesso");

		}catch (ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Ocorreu ao salvar o cliente");
		}
		



	}

	public void excluir(Cliente cliente){
		try{
			clienteRepository.delete(cliente);
			clientes.remove(cliente);
			MensagemUtil.mensagemInfo("Exluirdo com sucesso");
		}catch (ServiceException e){
			MensagemUtil.mensagemWarn("Esse cliente esta vinculado com pedido");
		}

        }


	public void editar(Cliente cliente) {
		try {
			setCliente(cliente);
			setModoEdicao(true);
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	public void cancelar() {
		cliente = new Cliente();
		setModoEdicao(false);
	}

	public void novo() {

		cliente = new Cliente();
	}
	public void buscar(){
	cliente = clienteRepository.buscarClientePorId(cliente.getId());
}
	
	public void buscarCep(){
		
		Endereco endereco = cepService.encontraCEP(cliente.getEndereco().getCep());
		
		if(endereco != null){
			cliente.setEndereco(endereco);
		}else{
			FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Servidor não está respondendo", "Servidor não está respondendo"));
		}
	}
	 
}

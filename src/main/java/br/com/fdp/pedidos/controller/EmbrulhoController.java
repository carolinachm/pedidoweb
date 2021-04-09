package br.com.fdp.pedidos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.pedidos.model.Embrulho;
import br.com.fdp.pedidos.repository.EmbrulhoRepository;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@ViewScoped
public class EmbrulhoController {
	@Getter@Setter
	private Embrulho embrulho = new Embrulho();
	@Getter@Setter
	private List<Embrulho> embrulhos;

	@Autowired
	private EmbrulhoRepository embrulhoRepository;
	@Getter@Setter
	private boolean modoEdicao = false;

	@PostConstruct
	public void init() {

		embrulhos = embrulhoRepository.findAll();
		
	}

	public void salvar() {
		try{
		embrulhoRepository.save(getEmbrulho());
		if (!isModoEdicao())
			embrulhos.add(embrulho);
		embrulho = new Embrulho();
		setModoEdicao(false);
		MensagemUtil.mensagemInfo("Salvo com sucesso");
		}catch(ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Ocorreu um erro ao salvar o embrulho");
		}
	}
	public void excluir(Embrulho embrulho){
		try{
		embrulhoRepository.delete(embrulho);
		embrulhos.remove(embrulho);
		MensagemUtil.mensagemInfo("Excluido com sucesso");
		}catch(ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Ocorreu um erro ao excluir o embrulho");
		}
	}
	public void editar(Embrulho embrulho){

		setEmbrulho(embrulho);
		setModoEdicao(true);

	}
	public void cancelar(){
		embrulho = new Embrulho();
		setModoEdicao(false);
	}
	
}

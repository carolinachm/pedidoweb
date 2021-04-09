package br.com.fdp.pedidos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;




import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.pedidos.model.Cerimonial;
import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.repository.CerimonialRepository;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@ViewScoped
public class CerimonialController {
	@Getter@Setter
	private Cerimonial cerimonial = new Cerimonial();
	@Getter@Setter
	private List<Cerimonial> cerimoniais;

	@Autowired
	private CerimonialRepository cerimonialRepository;
	@Getter@Setter
	private boolean modoEdicao = false;

	@PostConstruct
	public void init() {

		cerimoniais = cerimonialRepository.findAll();
		
	}

	public void salvar() {
		try{
		cerimonialRepository.save(getCerimonial());
		if (!isModoEdicao())
			cerimoniais.add(cerimonial);
		cerimonial = new Cerimonial();
		setModoEdicao(false);
		MensagemUtil.mensagemInfo("Salvo com sucesso");
		}catch(ServiceException e){
			MensagemUtil.mensagemError("Ocorreu um erro ao tentar salvar o cerimonial");
		}
	}
	public void excluir(Cerimonial cerimonial){
		try{
		cerimonialRepository.delete(cerimonial);
		cerimoniais.remove(cerimonial);
		cerimonial = new Cerimonial();
		MensagemUtil.mensagemInfo("Excluido com sucesso");
		}catch(ServiceException e){
			MensagemUtil.mensagemError("Ocorreu um erro ao tentar excluir o cerimonial");
		}
	}
	public void editar(Cerimonial cerimonial){

		setCerimonial(cerimonial);

		setModoEdicao(true);
		

		
	}
	public void cancelar(){
		cerimonial = new Cerimonial();
		setModoEdicao(false);
	}

	
}

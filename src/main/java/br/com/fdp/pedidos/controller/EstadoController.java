package br.com.fdp.pedidos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.fdp.pedidos.repository.EstadoRepository;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.pedidos.model.Estado;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@ViewScoped
public class EstadoController {
	@Getter
	@Setter
	private Estado estado = new Estado();
	@Getter
	@Setter
	private List<Estado> estados;
	@Autowired
	private EstadoRepository estadoRepository;
	@Getter
	@Setter
	private boolean modoEdicao = false;

	@PostConstruct
	public void init() {
		estados = estadoRepository.findAll();
	}

	public void salvar() {
		try {
			estadoRepository.save(getEstado());
			if (!isModoEdicao())
				estados.add(estado);
			estado = new Estado();
			setModoEdicao(false);
			MensagemUtil.mensagemInfo("Salvo com sucesso");
		} catch (ServiceException e) {
			e.printStackTrace();
			MensagemUtil.mensagemError("Erro ao salva." + e.getMessage());
		}
	}

	public void excluir(Estado estado) {
		try {
			estadoRepository.delete(estado);
			estados.remove(estado);
			MensagemUtil.mensagemInfo("Excluido com sucesso");
		} catch (ServiceException e) {
			e.printStackTrace();
			MensagemUtil.mensagemError("Erro ao deletar." + e.getMessage());
		}

	}

	public void editar(Estado estado) {
		try {
			setEstado(estado);
			setModoEdicao(true);
		}catch (ServiceException e) {
			e.printStackTrace();

		}


	}

	public void cancelar() {
		estado = new Estado();
		setModoEdicao(false);
	}
}


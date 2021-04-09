package br.com.fdp.pedidos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fdp.pedidos.model.Produto;
import br.com.fdp.pedidos.util.MensagemUtil;

@Named
@ViewScoped
public class ProdutoController {
	
	@Getter@Setter
	private Produto produto = new Produto();
	@Getter@Setter
	private List<Produto> produtos;
	@Autowired
	private br.com.fdp.pedidos.repository.ProdutoRepository produtoRepository;
	@Getter@Setter
	private boolean modoEdicao = false;
	@PostConstruct
	public void init(){
		
		produtos = produtoRepository.findAll();
		
	}
	public void salvar(){
		try{
		produtoRepository.save(getProduto());
		if(!isModoEdicao())
		produtos.add(produto);
		produto = new Produto();
		setModoEdicao(false);
		MensagemUtil.mensagemInfo("Salvo com sucesso");
		}catch(ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Error ao salva." + e.getMessage());
		}
	}
	public void excluir(Produto produto){
		try{
		produtoRepository.delete(produto);
		produtos.remove(produto);
		produto = new Produto();
		MensagemUtil.mensagemInfo("Excluido com sucesso");
		}catch(ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Error ao excluido." + e.getMessage());
		}
	}
	public void editar(Produto produto){
		try{
		setProduto(produto);
		setModoEdicao(true);
		}catch(ServiceException e){
			e.printStackTrace();
			MensagemUtil.mensagemError("Error ao alterar." + e.getMessage());
		}
	}
	public void cancelar(){
		produto = new Produto();
		setModoEdicao(false);
	}


}
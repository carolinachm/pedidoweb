package br.com.fdp.pedidos.filtro;

import java.util.Date;

import lombok.Data;


@Data
public class PedidoFiltro {
	
	
	private String contratante;

	private Date dataCriacaoDe;

	private Date dataCriacaoAte;
	


}
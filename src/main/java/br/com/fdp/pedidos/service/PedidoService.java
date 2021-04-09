package br.com.fdp.pedidos.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import br.com.fdp.pedidos.filtro.PedidoFiltro;
import br.com.fdp.pedidos.model.Pedido;

@Service
public class PedidoService {
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Pedido> filtrados(PedidoFiltro filtro) {

		Session session = this.manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Pedido.class)
				.createAlias("cliente", "c");

		
		if (filtro.getDataCriacaoDe() != null)
			criteria.add(Restrictions.ge("dataCriacao",
					filtro.getDataCriacaoDe()));

		if (filtro.getDataCriacaoAte() != null)
			criteria.add(Restrictions.le("dataCriacao",
					filtro.getDataCriacaoAte()));
		
		if (StringUtils.isNotBlank(filtro.getContratante())) {

			criteria.add(Restrictions.ilike("c.contratante", filtro.getContratante(), MatchMode.ANYWHERE));
		}

		return criteria.list();
	}

}

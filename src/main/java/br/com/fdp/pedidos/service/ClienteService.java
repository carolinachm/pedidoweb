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

import br.com.fdp.pedidos.filtro.ClienteFiltro;
import br.com.fdp.pedidos.model.Cliente;
import br.com.fdp.pedidos.model.Pedido;

@Service
public class ClienteService {
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Cliente> filtrados(ClienteFiltro filtro) {

		Session session = this.manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Pedido.class)
				.createAlias("cliente", "c");

		
		if (StringUtils.isNotBlank(filtro.getCpf())) {

			criteria.add(Restrictions.ilike("c.cpf", filtro.getCpf(), MatchMode.ANYWHERE));
		}

		return criteria.list();
	}

}

package br.com.spring.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.spring.mvc.mudi.model.Pedido;

@Repository
public class PedidoRepository_JPA {
	
	/*
	 * Nesse modelo não esta usando o springDATA
	 * somente usa o JPA
	 */
	
	@PersistenceContext
	private EntityManager entityMananger;
	
	public List<Pedido> recuperaTodosOsPedidos(){
		Query query = entityMananger.createQuery("Select p from Pedido p", Pedido.class);
		return query.getResultList();

	}
}

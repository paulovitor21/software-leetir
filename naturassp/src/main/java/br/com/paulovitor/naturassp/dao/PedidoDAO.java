package br.com.paulovitor.naturassp.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.paulovitor.naturassp.model.Cliente;
import br.com.paulovitor.naturassp.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
	
	public ArrayList<Pedido> findAllByCliente(Cliente cliente);
}

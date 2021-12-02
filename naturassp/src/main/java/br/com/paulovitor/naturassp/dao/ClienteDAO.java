package br.com.paulovitor.naturassp.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.paulovitor.naturassp.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
	
	public Cliente findByEmailOrTelefone(String email, String telefone);
}

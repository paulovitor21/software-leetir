package br.com.paulovitor.naturassp.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.paulovitor.naturassp.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByUsernameOrEmail(String username, String email);
}

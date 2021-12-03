package br.com.paulovitor.naturassp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paulovitor.naturassp.dao.UsuarioDAO;
import br.com.paulovitor.naturassp.model.Usuario;

@Component
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario recuperarUsuario(Usuario original) {
	
		return dao.findByUsernameOrEmail(original.getUsername(), original.getEmail());
	}
}

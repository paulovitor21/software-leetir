package br.com.paulovitor.naturassp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulovitor.naturassp.model.Usuario;
import br.com.paulovitor.naturassp.security.JWTToken;
import br.com.paulovitor.naturassp.security.JWTTokenUtil;
import br.com.paulovitor.naturassp.services.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/login")
	public ResponseEntity<JWTToken> fazerLogin(@RequestBody Usuario dadosLogin) {
		Usuario user = service.recuperarUsuario(dadosLogin);
		if (user != null) { // usuario existe, preciso conferir agora a senha
			if (user.getSenha().equals(dadosLogin.getSenha())) {
				// aqui eu preciso criar o token do usuario
				JWTToken jwtToken = new JWTToken();
				
				jwtToken.setToken(JWTTokenUtil.generateToken(user));
				
				return ResponseEntity.ok(jwtToken);
			}
			return ResponseEntity.status(403).build(); // usuário não tem autorização
		}
		return ResponseEntity.notFound().build();
	}
	
}

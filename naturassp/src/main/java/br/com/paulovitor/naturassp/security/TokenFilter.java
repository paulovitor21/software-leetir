package br.com.paulovitor.naturassp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		/* segredo do sucesso
		 * requisições que não precisam de autenticação, não levam em conta um item do cabeçalho
		 * 	- Authorization 
		 * 
		 * requisições que precisam de autenticação, vão precisar de uma informação de autorização
		 * no cabeçalho.
		 * 	- se o token for válido, eu monto um cabeçalho de autorização e encaminho a requisição
		 * */
		
		System.out.println("Requisição passou pelo filtro");
		
		
		/* a mágica acontece aqui então?
		 * SIM
		 */
		
		if (request.getHeader("Authorization") != null) {
			// se eu tiver um cabeçalho com token, preciso decodificar este token
			Authentication auth = JWTTokenUtil.decodeToken(request);
			
			// se for válido, vai para o contexto da requisição um objeto que representa o token
			// senão vai null
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		filterChain.doFilter(request, response);
		
	}

}

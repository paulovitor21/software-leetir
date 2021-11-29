package br.com.paulovitor.naturassp.services;

import java.util.ArrayList;

import br.com.paulovitor.naturassp.model.Categoria;

public interface ICategoriaService {
	// este método recebe uma categoria só com o nome preenchido e vai inserir no banco
	public Categoria inserirNovaCategoria(Categoria categoria);
	
	/* este método vai alterar a categoria existente e retorná-la se o update deu certo 
	 * e null caso contrario*/
	public Categoria alterarCategoria(Categoria categoria);
	
	// este método vai recuperar todas as categorias sem filtro
	public ArrayList<Categoria> recuperarTodasCategorias();
	
	// este método vai recuperar todas as categorias por palavra chave
	public ArrayList<Categoria> recuperarPorPalavraChave(String palavraChave);
}

package br.com.paulovitor.naturassp.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.paulovitor.naturassp.model.Categoria;
import br.com.paulovitor.naturassp.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
	
	public ArrayList<Produto> findAllByDisponivel(int disponivel);
	public ArrayList<Produto> findAllByDisponivelAndCategoria(int disponivel, Categoria cat);
	public ArrayList<Produto> findAllByCategoria(Categoria categoria);
}

package br.com.paulovitor.naturassp.dao;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import br.com.paulovitor.naturassp.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{

	// consultas customizadas
	
	// 1 - categoria por palavra chave
	public ArrayList<Categoria> findByNomeContaining(String palavra);
}

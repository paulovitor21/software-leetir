package br.com.paulovitor.naturassp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paulovitor.naturassp.dao.ProdutoDAO;
import br.com.paulovitor.naturassp.model.Categoria;
import br.com.paulovitor.naturassp.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService {
	
	@Autowired
	private ProdutoDAO dao;
	@Override
	public Produto inserirNovoProduto(Produto produto) {
		// TODO Auto-generated method stub
		try {
			dao.save(produto);
			return produto;
		}
		catch(Exception ex) {
			System.out.println("----- ProdutoService.inserirNovoProduto ---");
			ex.printStackTrace();
			System.out.println("-------------------------------------------");
		}
		return null;
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		// TODO Auto-generated method stub
		try {
			dao.save(produto);
			return produto;
		}
		catch (Exception ex) {
			System.out.println("----- ProdutoService.alterarProduto ---");
			ex.printStackTrace();
			System.out.println("---------------------------------------");
		}
		return null;
	}

	@Override
	public ArrayList<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Produto>)dao.findAllByCategoria(null);
	}

	@Override
	public ArrayList<Produto> listarDisponiveis() {
		// TODO Auto-generated method stub
		return dao.findAllByDisponivel(1); // considera todos os produtos 1 como disponível
	}

	@Override
	public ArrayList<Produto> listarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return dao.findAllByDisponivelAndCategoria(1, categoria);
	}

	@Override
	public ArrayList<Produto> listarIndisponiveis() {
		// TODO Auto-generated method stub
		return dao.findAllByDisponivel(0);
	}

	@Override
	public Produto recuperarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
	
}

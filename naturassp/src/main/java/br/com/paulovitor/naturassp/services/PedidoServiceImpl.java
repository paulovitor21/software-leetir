package br.com.paulovitor.naturassp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paulovitor.naturassp.dao.PedidoDAO;
import br.com.paulovitor.naturassp.model.ItemPedido;
import br.com.paulovitor.naturassp.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido inserirPedido(Pedido novo) {
		
		try {
			double total = 0.0;
			/* aqui em tese vem a regra de negócios */
			for (ItemPedido item: novo.getItensPedido()) {
				item.setPrecoUnitario(item.getProduto().getPreco());
				
				if (item.getQtdeItem() >= 5 ) { // vou dar 20% de desconto
					item.setPrecoTotal(item.getPrecoUnitario() * item.getQtdeItem() * 0.8);
				}
				else {
					item.setPrecoTotal(item.getPrecoUnitario() * item.getQtdeItem());
				}
				total += item.getPrecoTotal();
			}
			/* ----- */
			for (ItemPedido item: novo.getItensPedido()) {
				item.setPedido(novo);
			}
			novo.setValorTotal(total);
			dao.save(novo);
			return novo;
		}
		catch (Exception ex) {
			
		}
		return null;
	}
}

package acmestore.model.entities.builders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import acmestore.model.entities.Cliente;
import acmestore.model.entities.Pagamento;
import acmestore.model.entities.Produto;

public class PagamentoBuilder {
	private List<Produto> produtos = new ArrayList<>();
	private LocalDateTime dataCompra;
	private Cliente cliente;
	
	public PagamentoBuilder(Cliente c) {
		this.cliente = c;
	}
	
	public PagamentoBuilder setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
		return this;
	}
	
	public PagamentoBuilder setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
		return this;
	}
	
	public Pagamento getEntity() {
		return new Pagamento(produtos, dataCompra, cliente);
	}
}
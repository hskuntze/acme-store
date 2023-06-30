package acmestore.model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pagamento {
	private List<Produto> produtos = new ArrayList<>();
	private LocalDateTime dataCompra;
	private Cliente cliente;
	
	public Pagamento() {
	}
	
	public Pagamento(List<Produto> produtos, LocalDateTime dataCompra, Cliente cliente) {
		this.produtos = produtos;
		this.dataCompra = dataCompra;
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String formatarData(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		return data.format(formatter);
	}

	@Override
	public String toString() {
		return "Pagamento do Cliente: " + cliente.getName() + ", data: " + formatarData(dataCompra) + ". Produtos: " + produtos;
	}
}
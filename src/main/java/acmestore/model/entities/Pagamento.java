package acmestore.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import acmestore.model.exceptions.DelayedPaymentException;

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

	public static BigDecimal calcularTotal(List<Produto> list) {
		return list.stream().map(Produto::getPreco).reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
	}
	
	public static BigDecimal calcularTotal(Assinatura a, Pagamento p) {
		if(!a.isAtrasado()) {
			return p.getProdutos().stream().map(Produto::getPreco).reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
		} else {
			throw new DelayedPaymentException("Pagamento pendente: Você não será capaz de efetuar compras se sua assinatura estiver com pagamentos pendentes.");
		}
	}

	@Override
	public String toString() {
		return "Pagamento do Cliente: " + cliente.getName() + ", data: " + formatarData(dataCompra) + ". Produtos: " + produtos;
	}
}
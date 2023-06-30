package acmestore.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import acmestore.model.entities.enums.AssinaturaType;

public class Assinatura {
	private BigDecimal mensalidade;
	private LocalDateTime begin;
	private Optional<LocalDateTime> end;
	private Cliente cliente;
	private boolean atraso;
	private AssinaturaType tipo;

	public Assinatura() {
	}

	public Assinatura(BigDecimal mensalidade, LocalDateTime begin, Cliente cliente, boolean atraso, AssinaturaType tipo) {
		this.mensalidade = mensalidade;
		this.begin = begin;
		this.end = Optional.empty();
		this.cliente = cliente;
		this.atraso = atraso;
		this.tipo = tipo;
	}

	public Assinatura(BigDecimal mensalidade, LocalDateTime begin, Optional<LocalDateTime> end, Cliente cliente,
			boolean atraso, AssinaturaType tipo) {
		this.mensalidade = mensalidade;
		this.begin = begin;
		this.end = end;
		this.cliente = cliente;
		this.atraso = atraso;
		this.tipo = tipo;
	}

	public BigDecimal getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}

	public LocalDateTime getBegin() {
		return begin;
	}

	public void setBegin(LocalDateTime begin) {
		this.begin = begin;
	}

	public Optional<LocalDateTime> getEnd() {
		return end;
	}

	public void setEnd(Optional<LocalDateTime> end) {
		this.end = end;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isAtraso() {
		return atraso;
	}

	public void setAtraso(boolean atraso) {
		this.atraso = atraso;
	}
	
	public AssinaturaType getTipo() {
		return tipo;
	}

	public void setTipo(AssinaturaType tipo) {
		this.tipo = tipo;
	}

	private String formatAtraso() {
		return atraso == true ? "Sim" : "Não";
	}
	
	public double calcularTaxa(double valorTotal) {
		switch(tipo) {
			case ANUAL:
				return 0.0;
			case SEMESTRAL:
				return valorTotal * 0.03;
			case TRIMESTRAL:
				return valorTotal * 0.05;
			default:
				return 0.0;
		}
	}

	@Override
	public String toString() {
		return "Assinatura: Mensalidade " + mensalidade + ", início: " + begin + ", final: " + end + ", cliente: "
				+ cliente.getName() + ". Atrasada: " + formatAtraso() + ". Tipo: " + tipo;
	}
}
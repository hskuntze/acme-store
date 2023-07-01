package acmestore.model.entities.builders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import acmestore.model.entities.Assinatura;
import acmestore.model.entities.Cliente;
import acmestore.model.entities.enums.AssinaturaType;

public class AssinaturaBuilder {
	private BigDecimal mensalidade;
	private LocalDateTime begin;
	private Optional<LocalDateTime> end = Optional.empty();
	private Cliente cliente;
	private boolean atraso;
	private AssinaturaType tipo;
	
	public AssinaturaBuilder(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public AssinaturaBuilder setBegin(LocalDateTime begin) {
		this.begin = begin;
		return this;
	}
	
	public AssinaturaBuilder setEnd(LocalDateTime end) {
		this.end = Optional.of(end);
		return this;
	}
	
	public AssinaturaBuilder setCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}
	
	public AssinaturaBuilder setAtraso(boolean atraso) {
		this.atraso = atraso;
		return this;
	}
	
	public AssinaturaBuilder setTipo(AssinaturaType tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public Assinatura getEntity() {
		if(end.isEmpty()) {
			return new Assinatura(mensalidade, begin, cliente, atraso, tipo);
		} else {
			return new Assinatura(mensalidade, begin, end, cliente, atraso, tipo);
		}
	}
}
package acmestore.model.entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

	public boolean isAtrasado() {
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
		return atraso ? "Sim" : "Não";
	}
	
	public BigDecimal calcularTaxa(BigDecimal valorTotal) {
		switch(tipo) {
			case ANUAL:
				return BigDecimal.valueOf(0.0);
			case SEMESTRAL:
				return valorTotal.multiply(BigDecimal.valueOf(0.03));
			case TRIMESTRAL:
				return valorTotal.multiply(BigDecimal.valueOf(0.05));
			default:
				return BigDecimal.valueOf(0.0);
		}
	}

	public static BigDecimal calcularTotalAssinatura(Assinatura a) {
		LocalDateTime b = a.getBegin();
		LocalDateTime e = a.getEnd().orElse(LocalDateTime.now());

		long months = ChronoUnit.MONTHS.between(b, e);
		return a.getMensalidade().multiply(BigDecimal.valueOf(months));
	}

	public static void exibirTotalAssinatura(Assinatura a) {
		LocalDateTime b = a.getBegin();
		LocalDateTime e = a.getEnd().orElse(LocalDateTime.now());

		long months = ChronoUnit.MONTHS.between(b, e);
		System.out.println(formatBigDecimal(a.getMensalidade().multiply(BigDecimal.valueOf(months))));
	}

	public static void calcularDiferencaMeses(Assinatura a) {
		LocalDateTime b = a.getBegin();
		LocalDateTime e = a.getEnd().orElse(LocalDateTime.now());

		System.out.println(ChronoUnit.MONTHS.between(b, e));
	}
	
	public static String formatBigDecimal(BigDecimal valor) {
		return "R$ " + new DecimalFormat("#,##0.00").format(valor.doubleValue());
	}

	@Override
	public String toString() {
		return "Assinatura: Mensalidade " + mensalidade + ", início: " + begin + ", final: " + end + ", cliente: "
				+ cliente.getName() + ". Atrasada: " + formatAtraso() + ". Tipo: " + tipo;
	}
}
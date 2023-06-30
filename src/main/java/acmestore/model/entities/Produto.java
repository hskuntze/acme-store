package acmestore.model.entities;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.text.DecimalFormat;

public class Produto {
	private String nome;
	private Path file;
	private BigDecimal preco;
	
	public Produto() {
	}
	
	public Produto(String nome, Path file, BigDecimal preco) {
		this.nome = nome;
		this.file = file;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Path getFile() {
		return file;
	}

	public void setFile(Path file) {
		this.file = file;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return nome + " de preço " + new DecimalFormat("#,##0.00").format(preco) + ". Arquivo: " + file;
	}
}
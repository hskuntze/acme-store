package acmestore.model.entities.builders;

import java.math.BigDecimal;
import java.nio.file.Path;

import acmestore.model.entities.Produto;

public class ProdutoBuilder {

	private String nome;
	private Path file;
	private BigDecimal preco;
	
	public ProdutoBuilder(String nome) {
		this.nome = nome;
	}
	
	public ProdutoBuilder setFile(Path file) {
		this.file = file;
		return this;
	}
	
	public ProdutoBuilder setPreco(BigDecimal preco) {
		this.preco = preco;
		return this;
	}
	
	public Produto getEntity() {
		return new Produto(nome, file, preco);
	}
}
package acmestore.model.entities;

import java.util.Objects;

public class Cliente {
	private String nome;
	
	public Cliente() {
	}
	
	public Cliente(String name) {
		this.nome = name;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	@Override
	public String toString() {
		return "Cliente [name=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nome, other.nome);
	}
}
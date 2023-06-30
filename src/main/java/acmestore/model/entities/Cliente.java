package acmestore.model.entities;

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
}
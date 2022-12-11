package classes;

public abstract class Animal {
	
	private String nome;
	private int id;
	
	public Animal(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getId() {
		return this.id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

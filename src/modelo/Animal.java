package modelo;

/**
 * 
 * Classe usada para representar um Animal.
 *
 */

public abstract class Animal {
	
	private String nome;
	
	/**
	 * Constroi um objeto Animal.
	 * 
	 * @param nome nome do animal.
	 */
	public Animal(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

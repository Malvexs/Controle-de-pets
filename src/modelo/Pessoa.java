package modelo;

import java.util.*;

/**
 * Classe usada para representar uma pessoa e extende a classe Animal.
 * 
 *
 */

public class Pessoa extends Animal {
	
	private String email;
	private ArrayList<Pet> pets = new ArrayList<>();
	
	/**
	 * Constroi um objeto da classe Pessoa recebendo um nome e email
	 * 
	 * @param nome nome 
	 * @param email email
	 */
	
	public Pessoa(String nome, String email) {
		super(nome);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addPet(Pet pet) {
		this.pets.add(pet);
	}
	
	public void removePet(Pet pet) {
		this.pets.remove(pet);
	}
	
}

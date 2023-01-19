package modelo;

import java.util.*;

public class Pessoa extends Animal {
	
	private String email;
	private ArrayList<Pet> pets = new ArrayList<>();
	
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

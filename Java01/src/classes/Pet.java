package classes;

import java.util.*;

public class Pet extends Animal {

	private String temperamento;
	private String especie;
	private String raca;
	private char sexo;
	private Date dataNasc;
	private double pesoKg;
	private ArrayList<Vacina> vacinas = new ArrayList<>();

	
	public Pet(String nome, int id, String temperamento, String especie,
				String raca, char sexo, Date dataNasc, double pesoKg) {
		

		super(nome, id);
		this.temperamento = temperamento;
		this.especie = especie;
		this.raca = raca;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.pesoKg = pesoKg;
	}
	
	public ArrayList<Vacina> getVacinas(){
		return vacinas;
	}
	
	public void addVacina(Vacina vac) {
		this.vacinas.add(vac);
	}
	
	public void removeVacina(Vacina vac) {
		this.vacinas.remove(vac);
	}
	
	public String getTemperamento() {
		return this.temperamento;
	}
	
	public String getEspecie() {
		return this.especie;
	}
	
	public String getRaca() {
		return this.raca;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public Date getDataNasc() {
		return this.dataNasc;
	}
	
	public double getPesoKg() {
		return this.pesoKg;
	}
	
	public void setTemperamento(String temeperamento) {
		this.temperamento = temeperamento;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}
	
}

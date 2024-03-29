package modelo;

import java.util.*;

/**
 * Classe utilizada para representar uma vacina.
 * 
 *
 */

public class Vacina {

	private String nome;
	private Date dataVac;
	private String lab;
	private int serial;
	private int intervalRev;
	private String intervalTipo;
	
	/**
	 * Cria um objeto da classe Vacina.
	 * 
	 * @param nome nome da vacina.
	 * @param dataVac data de vacinação.
	 * @param lab laboratório responsável pela vacinação.
	 * @param serial serial da vacina.
	 * @param intervalRev periodo de revacinação.
	 * @param intervalTipo periodo. ex: Anual
	 */
	
	public Vacina(String nome, Date dataVac, String lab, 
			      int serial, int intervalRev, String intervalTipo) {
		this.nome = nome;
		this.dataVac = dataVac;
		this.lab = lab;
		this.serial = serial;
		this.intervalRev = intervalRev;
		this.intervalTipo = intervalTipo;
	}

	
	public String getNome() {
		return this.nome;
	}
	
	public Date getDataVac() {
		return this.dataVac;
	}
	
	public String getLab() {
		return this.lab;
	}
	
	public int getSerial() {
		return this.serial;
	}
	
	public int getIntervalRev() {
		return this.intervalRev;
	}
	
	public String getIntervalTipo() {
		return this.intervalTipo;
	}
		
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDateVac(Date dataVac) {
		this.dataVac = dataVac;
	}
	
	public void setLab(String lab) {
		this.lab = lab;
	}
	
	public void setSerial(int serial) {
		this.serial = serial;
	}
	
	public void setIntervalRev(int intervalRev) {
		this.intervalRev = intervalRev;
	}
	
	public void setIntervalTipo(String intervalTipo) {
		this.intervalTipo = intervalTipo;
	}
	
}

package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import classes.*;

public class test {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		
		Date dataNasc1;
    	Date dataVac;
		
		try {
			
			dataNasc1 = formatter.parse("01/02/2015");
			dataVac = formatter.parse("10/02/2015");
			
        } catch (ParseException e) {

        	dataNasc1 = new Date();
        	dataVac = new Date();
        }
		
		
		Pessoa pessoa = new Pessoa("test", 0, "test@gmail.com");
		
		Pet pet1 = new Pet("Ajax", 1, "calmo", "Cachorro", "Pastor alemao", 
							'M', dataNasc1, 20.5);
		
		Vacina vacina1 = new Vacina("V6", dataVac, "Umbrella", 1, 0, "0");
		
		pet1.addVacina(vacina1);
		
		pessoa.addPet(pet1);		
		
		
		ArrayList<Pet> pPetArray = pessoa.getPets();
		ArrayList<Vacina> pVacinasArray = pPetArray.get(0).getVacinas();
		
		System.out.println("Nome do dono: " + pessoa.getNome());
		System.out.println("Email do dono: " + pessoa.getEmail());
		System.out.println("--------------------");
		
		System.out.println("Nome do pet: " + pPetArray.get(0).getNome() );
		System.out.println("Nome do especie: " + pPetArray.get(0).getEspecie() );
		System.out.println("Nome do raca: " + pPetArray.get(0).getRaca() );
		System.out.println("Sexo: " + pPetArray.get(0).getSexo() );
		System.out.println("data de nascimento: " + 
										formatter.format(pPetArray.get(0).getDataNasc()) );
		System.out.println("--------------------");
		
		System.out.println("Nome da vacina do pet: " + pVacinasArray.get(0).getNome() );
		System.out.println("Lab q produziu a vacina: " + pVacinasArray.get(0).getLab() );
		System.out.println("data de vacinacao: " + 
										formatter.format(pVacinasArray.get(0).getDataVac()) );

		
		
		
	}
	
}


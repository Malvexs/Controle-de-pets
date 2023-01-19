package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import modelo.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;


public class TelaPrincipal implements ActionListener {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private static JFrame janela = new JFrame("Controle de pets");
	private static JButton addpet = new JButton("Add pet");
	private static JButton refresh = new JButton("Refresh");
	private static JButton edit = new JButton("Editar");
	private static JButton deletar = new JButton("Deletar");
	private static JButton vacinas = new JButton("Vacinas");
	
	private static ArrayList<Pet> pets = new ArrayList<>();
	private static JList<String> listaPets = new JList<String>();
	private static JScrollPane scroll_panel_pets = new JScrollPane();
	
	public static void main(String[] args) {
		
		JLabel titulo = new JLabel("Pets Cadastradas");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(100, 10, 250, 30);
		
		addpet.setBounds(100, 320, 100, 30);
        refresh.setBounds(100, 370, 100, 30);
        edit.setBounds(250,320,100,30);
        deletar.setBounds(250, 370, 100, 30);
        vacinas.setBounds(480, 50, 100, 30);
        
        scroll_panel_pets.setViewportView(listaPets);
        showPets();
        scroll_panel_pets.setBounds(100, 50, 350, 120);
        
        janela.add(titulo);
        janela.add(addpet);
        janela.add(scroll_panel_pets);
        janela.add(refresh);
        janela.add(edit);
        janela.add(deletar);
        janela.add(vacinas);
        
        janela.setSize(640,480);
        janela.setLayout(null);
        janela.setVisible(true);
        
        
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TelaPrincipal tprincipal = new TelaPrincipal();
        
        addpet.addActionListener(tprincipal);
        refresh.addActionListener(tprincipal);
        edit.addActionListener(tprincipal);
		deletar.addActionListener(tprincipal);
		vacinas.addActionListener(tprincipal);
        
		Date dataNasc1;
    	Date dataVac;
		
		try {
			
			dataNasc1 = formatter.parse("01/02/2015");
			dataVac = formatter.parse("10/02/2015");
			
        } catch (ParseException e) {

        	dataNasc1 = new Date();
        	dataVac = new Date();
        }
        
		for(int x = 0;x<10;x++) {
	        Pet pet1 = new Pet("Pet"+Integer.toString(x) , "calmo", "Cachorro", "dogo", 
					'F', dataNasc1, 20.5);
			pets.add(pet1);
			Vacina vacina1 = new Vacina("V"+Integer.toString(x), dataVac, "Umbrella", 1, 0, "0");
			pets.get(x).addVacina(vacina1);
		}
		
		Pessoa pessoa = new Pessoa("test", "test@gmail.com");
		
		Vacina vacina1 = new Vacina("V6", dataVac, "Umbrella", 1, 0, "0");
		
		showPets();
		
	}

	
	private static void showPets() { //mostra todos os usuarios no scrollPane
		
		String l[] = new String[pets.size()];
		
		for(int x = 0;x < pets.size();x++) {
			l[x] = pets.get(x).getNome();
		}
        
		try {
			listaPets.setListData(l);
		} catch (Exception e) {
			listaPets = new JList<String>(l);
		}
		
		listaPets.updateUI();
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == addpet) {
			new PainelPet(pets);
			showPets();
		}else
		if(event.getSource() == refresh) {
			showPets();
		}else
		if(event.getSource() == edit) {
			if(listaPets.getSelectedIndex() > -1) {
				new PainelPet(pets).editPet(listaPets.getSelectedIndex());
			}
			showPets();
		}else
		if(event.getSource() == deletar) {
			if(listaPets.getSelectedIndex() > -1) {
				pets.remove(listaPets.getSelectedIndex());
				JOptionPane.showMessageDialog(null, "Pet REMOVIDO com sucesso!", "SUCESS", 
						JOptionPane.INFORMATION_MESSAGE);
				showPets();
			}
		}else
		if(event.getSource() == vacinas) {
			if(listaPets.getSelectedIndex() > -1) {
				new PainelVacina(pets.get(listaPets.getSelectedIndex()).getVacinas());
			}
		}
	
		
	}
	
	
	
}


package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * Tela principal do programa que executa o metodo main 
 * 
 *
 */
public class TelaPrincipal implements ActionListener {
	
	private static String dateFormat = null;

	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private static JFrame janela = new JFrame("Controle de pets");
	private static JButton addpet = new JButton("Add pet");
	private static JButton refresh = new JButton("Refresh");
	private static JButton edit = new JButton("Editar");
	private static JButton deletar = new JButton("Deletar");
	private static JButton vacinas = new JButton("Vacinas");
	
	private static JTextField jt_pesquisa_pet = new JTextField(100);
	private static JLabel titulo = new JLabel("Pets Cadastradas");
	private static JLabel lpesquisa = new JLabel("Pesquisar : ");
	
	private static ArrayList<Pet> pets = new ArrayList<>();
	private static JList<String> listaPets = new JList<String>();
	private static JScrollPane scroll_panel_pets = new JScrollPane();
	
	/**
	 * Cria os objetos da GUI da tela principal.
	 * Cria pets e adiciona vacinas para agilizar os testes.
	 * 
	 */
	public static void main(String[] args) {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(100, 10, 250, 30);
		
		addpet.setBounds(100, 320, 100, 30);
		refresh.setBounds(100, 370, 100, 30);
		edit.setBounds(250,320,100,30);
		deletar.setBounds(250, 370, 100, 30);
		vacinas.setBounds(480, 50, 100, 30);
		jt_pesquisa_pet.setBounds(180,180,150,25);
		lpesquisa.setBounds(100,180,80,25);
        
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
        janela.add(jt_pesquisa_pet);
        janela.add(lpesquisa);
        
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
		jt_pesquisa_pet.addActionListener(tprincipal);
		
		//gera pets com dados aleatorios 
		Date dataNasc1;
    	Date dataVac;
    	
    	Random random = new Random();
    	    	
    	for(int x=0;x<6;x++) {
    		
    		try {
    			int ano1 = 2000 + random.nextInt(23);
    			
    			dataNasc1 = formatter.parse(random.nextInt(30)+"/"
    							+random.nextInt(12)+"/"+ano1);
    			
    			int ano2 = 2000 + random.nextInt(23);
    			dataVac = formatter.parse(random.nextInt(30)+"/"
    					+random.nextInt(12)+"/"+ano2);
    			
            } catch (ParseException e) {

            	dataNasc1 = new Date();
            	dataVac = new Date();
            }
    		
    		Pet pet = new Pet("Pet"+x, "x", "x", "x", 'x', dataNasc1, random.nextInt(25));
    		
    		for(int y=0;y<3;y++) {
    			Vacina vacina = new Vacina("V"+random.nextInt(25), dataVac, "Umbrella", 
    					random.nextInt(25), random.nextInt(25), "Ano");
    			pet.addVacina(vacina);
  
    		}
    		pets.add(pet);
    		
    	
    	}
		
				
		showPets();
		
	}
	
	/**
	 * Abstração para showPets("")
	 * 
	 */
	private static void showPets() {
		showPets("");
	}
	
	/**
	 * Função responsável por listas todos os pets no objeto `scroll_panel_pets`.
	 * 
	 * @param search String para a filtragem de Pets a serem exibidos no 
	 * `scroll_panel_pets`.
	 * 
	 */
	private static void showPets(String search) { 
		
		ArrayList<String> l = new ArrayList<>();
		
		for(int x = 0;x < pets.size();x++) {
			if(search.isBlank() ) {
				l.add(pets.get(x).getNome());
			}else{
				if(pets.get(x).getNome().toLowerCase().indexOf(search.toLowerCase()) != -1) {
					l.add(pets.get(x).getNome());
				}
					
			}
			
		}
		String[] l_array = l.toArray(new String[0]);

		try {
			listaPets.setListData(l_array);
		} catch (Exception e) {
			listaPets = new JList<String>(l_array);
		}
		
		listaPets.updateUI();
		
	}
	
	
	/**
	 * O método escuta uma ação executada nos botões.
	 * Executa uma ação dependendo de qual botão foi pressionado.
	 * 
	 */
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
		}else
		if(event.getSource() == jt_pesquisa_pet) {
			showPets(jt_pesquisa_pet.getText());
		}
		
	}
	
	
	
}


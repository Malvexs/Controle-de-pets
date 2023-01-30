package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Pet;

/**
 * Cria uma GUI para o CRUD de objetos da classe `Pet`.
 * 
 */
public class PainelPet implements ActionListener {
	
	private JFrame janela = new JFrame("Pet");
	private JLabel titulo = new JLabel("Adicionar pet");
	private JLabel ln = new JLabel("Nome:               ");
	private JLabel lt = new JLabel("Temperamento:       ");
	private JLabel le = new JLabel("especie:            ");
	private JLabel lr = new JLabel("raça:               ");
	private JLabel ls = new JLabel("sexo:               ");
	private JLabel ldn = new JLabel("data de nascimento:");
	private JLabel lp = new JLabel("peso:               ");
	
	private JTextField jt_n = new JTextField(100);
	private JTextField jt_t = new JTextField(100);
	private JTextField jt_e = new JTextField(100);
	private JTextField jt_r = new JTextField(100);
	private JTextField jt_s = new JTextField(1);
	private JTextField jt_dn = new JTextField(100);
	private JTextField jt_p = new JTextField(100);
	
	private JButton save = new JButton("Salvar");
	private ArrayList<Pet> pets;
	
	private int pet_list_index = -1;
	
	/**
	 * Constroi um objeto da classe `PainelPet' para o CRUD de dados.
	 * Cria a GUI dos formulários e botoões.
	 * 
	 * @param pets ArrayList de objetos da classe `Pet` que serão manipulados.
	 */
	public PainelPet(ArrayList<Pet> pets){
		
		this.pets = pets;
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200,10, 250, 30);
		
		ln.setBounds(20,50,200,30);
		lr.setBounds(20,90, 200, 30);
		ls.setBounds(20,130, 200, 30);
		lp.setBounds(20,170,200, 30);
		ldn.setBounds(20,210, 200, 30);
		lt.setBounds(20,250,200,  30);
		le.setBounds(20,290, 200, 30);
		
		jt_n.setBounds(200, 55, 200, 25);
		jt_r.setBounds(200, 95, 200, 25);
		jt_s.setBounds(200, 135, 200, 25);
		jt_p.setBounds(200, 175, 200, 25);
		jt_dn.setBounds(200,215, 200, 25);
		jt_t.setBounds(200, 255,  200, 25);
		jt_e.setBounds(200, 295, 200, 25);
		
		save.setBounds(20,350,100,30);

		janela.add(ln);
		janela.add(le);
		janela.add(lr);
		janela.add(ls);
		janela.add(lp);
		janela.add(ldn);
		janela.add(lt);
		
		janela.add(jt_n);
		janela.add(jt_e);
		janela.add(jt_r);
		janela.add(jt_s);
		janela.add(jt_p);
		janela.add(jt_dn);
		janela.add(jt_t);
		
		janela.add(save);
		janela.add(titulo);
		
		janela.setSize(640, 440);
		janela.setLayout(null);
		janela.setVisible(true);
		
		save.addActionListener(this);
		
	}
	
	/**
	 * Adiciona as informações do Pet selecionado aos formularios para serem alteradas.
	 * 
	 * 
	 * @param pet_list_index Index do objeto Pet do ArrayList<Pet> que será editado.
	 */
	public void editPet(int pet_list_index) {
		
		this.pet_list_index = pet_list_index;
		
		titulo.setText("Edit pet");
		
		jt_n.setText(pets.get(pet_list_index).getNome());
		jt_e.setText(pets.get(pet_list_index).getEspecie());
		jt_r.setText(pets.get(pet_list_index).getRaca());
		jt_s.setText( Character.toString(pets.get(pet_list_index).getSexo()));
		jt_p.setText( Double.toString(pets.get(pet_list_index).getPesoKg()));
		try {
			jt_dn.setText(TelaPrincipal.formatter.format(pets.get(pet_list_index).getDataNasc()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		jt_t.setText(pets.get(pet_list_index).getTemperamento());
	}

	/**
	 * Controla o evento do botão `save`.
	 * Se `pet_list_index` for igual a -1, um novo objeto Pet será criado e adicionado ao
	 * ArrayList<Pet>. 
	 * Caso contrario as informações do objeto Pet no ArrayList<Pet> serão alteradas.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == save) {
					
			if(( jt_n.getText().isBlank())||
				(jt_t.getText().isBlank())||
				(jt_e.getText().isBlank())||
				(jt_r.getText().isBlank())||
				(jt_s.getText().isBlank())||
				(jt_p.getText().isBlank())||
				(jt_dn.getText().isBlank())
				) {
				
				JOptionPane.showMessageDialog(null,"Não foi possivel salvar os dados!", "ERROR", 
						JOptionPane.ERROR_MESSAGE);

			}else {
				
				double ppeso = 0;
				
				String pnome = jt_n.getText();
				String ptemp = jt_t.getText();
				String pesp = jt_e.getText();
				String praca = jt_r.getText();
				char psexo = jt_s.getText().charAt(0);
				try {
					ppeso = Double.parseDouble(jt_p.getText());
				} catch (Exception e2) {
				}
				String pdata_nasc = jt_dn.getText();
				
				Date dataNasc1 = null;
				
				try {
					dataNasc1 = TelaPrincipal.formatter.parse(pdata_nasc);			
		        } catch (ParseException e1) {
		        	
		        }
					
				Pet pet = new Pet(pnome, ptemp, pesp, praca, 
						psexo, dataNasc1, ppeso);
				
				if(pet_list_index == -1) {
					pets.add(pet);
					
					JOptionPane.showMessageDialog(null, "Pet ADICIONADO com sucesso!", "SUCESS", 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					pet.setVacinas(pets.get(pet_list_index).getVacinas());
					pets.set(pet_list_index, pet);
					
					JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!", "SUCESS", 
							JOptionPane.INFORMATION_MESSAGE);
				}
				janela.dispose();
				
			}
					
			
		}
		
		
	}
	

	

}

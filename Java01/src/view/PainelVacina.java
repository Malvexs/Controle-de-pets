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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.Pet;
import modelo.Vacina;

public class PainelVacina implements ActionListener {

	private JFrame janela = new JFrame("Vacinas");
	private JLabel titulo = new JLabel("Adicionar vacina");
	private JLabel titulo2 = new JLabel("Vacinas do pet");
	private JLabel ln = new JLabel("Nome:               	 ");
	private JLabel ldv = new JLabel("Data de vacinação:       ");
	private JLabel ll = new JLabel("Laboratorio:           	 ");
	private JLabel ls = new JLabel("Serial:               	 ");
	private JLabel lir = new JLabel("Intervalo revacinação:	 ");
	private JLabel lp = new JLabel("Periodo:	             ");
	
	private JTextField jt_n = new JTextField(100);
	private JTextField jt_dv = new JTextField(100);
	private JTextField jt_l = new JTextField(100);
	private JTextField jt_s = new JTextField(100);
	private JTextField jt_ir = new JTextField(1);
	private JTextField jt_p = new JTextField(100);
	
	private JButton addvacina = new JButton("Add");
	private JButton refresh = new JButton("Refresh");
	private JButton deletar = new JButton("Deletar");
	private JButton editvac = new JButton("Editar");
	
	private JList<String> listaVacinas = new JList<String>();
	private JScrollPane scroll_panel_vacinas = new JScrollPane();
	private ArrayList<Vacina> vacinas;
	
	private int vac_list_index = -1;
	
	public PainelVacina(ArrayList<Vacina> vacinas){
		
		this.vacinas = vacinas;
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200,10, 250, 30);
		titulo2.setFont(new Font("Arial", Font.BOLD, 20));
		titulo2.setBounds(500, 10, 250, 30);
		
		scroll_panel_vacinas.setViewportView(listaVacinas);
		scroll_panel_vacinas.setBounds(450, 50, 350, 120);
		
		ln.setBounds(20,50,200,30);
		ldv.setBounds(20,90, 200, 30);
		ll.setBounds(20,130, 200, 30);
		ls.setBounds(20,170,200, 30);
		lir.setBounds(20,210, 200, 30);
		lp.setBounds(20,250,200,  30);
		
		jt_n.setBounds(200, 55, 200, 25);
		jt_dv.setBounds(200, 95, 200, 25);
		jt_l.setBounds(200, 135, 200, 25);
		jt_s.setBounds(200, 175, 200, 25);
		jt_ir.setBounds(200,215, 200, 25);
		jt_p.setBounds(200, 255,  200, 25);
		
		addvacina.setBounds(20,350,100,30);
		refresh.setBounds(140,350,100,30);
		deletar.setBounds(260,350,100,30);
		editvac.setBounds(380,350,100,30);

		janela.add(scroll_panel_vacinas);
		
		janela.add(ln);
		janela.add(ldv);
		janela.add(ll);
		janela.add(ls);
		janela.add(lir);
		janela.add(lp);
		
		janela.add(jt_n);
		janela.add(jt_dv);
		janela.add(jt_l);
		janela.add(jt_s);
		janela.add(jt_ir);
		janela.add(jt_p);
		
		janela.add(addvacina);
		janela.add(titulo);
		janela.add(titulo2);
		janela.add(refresh);
		janela.add(deletar);
		janela.add(editvac);
		
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		janela.setSize(840, 440);
		janela.setLayout(null);
		janela.setVisible(true);
		
        
		addvacina.addActionListener(this);
		refresh.addActionListener(this);
		deletar.addActionListener(this);
		editvac.addActionListener(this);
		
		
		showVacinas();
		
	}
	
	public void editVacina() {
						
		jt_n.setText(vacinas.get(vac_list_index).getNome());
		jt_l.setText(vacinas.get(vac_list_index).getLab());
		jt_p.setText(vacinas.get(vac_list_index).getIntervalTipo());
		try {
			jt_s.setText(Integer.toString(vacinas.get(vac_list_index).getSerial()));
			jt_ir.setText(Integer.toString(vacinas.get(vac_list_index).getIntervalRev()));
			jt_dv.setText(TelaPrincipal.formatter.format(vacinas.get(vac_list_index).getDataVac()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	private void showVacinas() { //mostra todos os usuarios no scrollPane
			
			String l[] = new String[vacinas.size()];
			
			for(int x = 0;x < vacinas.size();x++) {
				String vac_data = "00/00/0000";
				try {
					vac_data = TelaPrincipal.formatter.format(vacinas.get(x).getDataVac());
				} catch (Exception e) {
					// TODO: handle exception
				}
				l[x] = vacinas.get(x).getNome() + "   " + vac_data;
			}
	        
			try {
				this.listaVacinas.setListData(l);
			} catch (Exception e) {
				this.listaVacinas = new JList<String>(l);
			}
			
			this.listaVacinas.updateUI();
			
		}
	
	private void addVacina() {
		
		if(
				(jt_n.getText().isBlank())||
				(jt_dv.getText().isBlank())||
				(jt_l.getText().isBlank())||
				(jt_s.getText().isBlank())||
				(jt_ir.getText().isBlank())||
				(jt_p.getText().isBlank())
				) {
				
				JOptionPane.showMessageDialog(null,"Não foi possivel salvar os dados!", "ERROR", 
						JOptionPane.ERROR_MESSAGE);

		}else {
			
			int vserial = 0;
			int vir = 0;
			
			String vnome = jt_n.getText();
			String vlab = jt_l.getText();
	
			try {
				vir = Integer.parseInt(jt_ir.getText());
				vserial = Integer.parseInt(jt_s.getText());
			} catch (Exception e2) {
			}
			String vdata_vac = jt_dv.getText();
			
			Date datavac = null;
			
			try {
				datavac = TelaPrincipal.formatter.parse(vdata_vac);			
	        } catch (ParseException e1) {
	        }
			
			Vacina vacina = new Vacina(vnome, datavac, vlab, 1, 0, "0");
			
			if(vac_list_index == -1) {
				vacinas.add(vacina);
				
				JOptionPane.showMessageDialog(null, "Vacina adicionada com sucesso!", "SUCESS", 
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				vacinas.set(vac_list_index, vacina);
				
				JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!", "SUCESS", 
						JOptionPane.INFORMATION_MESSAGE);
				vac_list_index = -1;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addvacina) {
					
			addVacina();
			showVacinas();
			
		}else
		if(e.getSource() == editvac) {
			if(listaVacinas.getSelectedIndex() > -1) {
				
				vac_list_index = listaVacinas.getSelectedIndex();
				
				editVacina();
				
				showVacinas();
			}
			
		}else
		if(e.getSource() == refresh) {
			showVacinas();
		}else
		if(e.getSource() == deletar) {
			if(listaVacinas.getSelectedIndex() > -1) {
				vacinas.remove(listaVacinas.getSelectedIndex());
				JOptionPane.showMessageDialog(null, "Vacina REMOVIDa com sucesso!", "SUCESS", 
						JOptionPane.INFORMATION_MESSAGE);
				showVacinas();
			}
		}
		
	}

	
}

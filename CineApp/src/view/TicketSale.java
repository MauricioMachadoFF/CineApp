package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import control.DataControl;
import control.SessionControl;

public class TicketSale implements ActionListener,  ItemListener{
	private JFrame window;
	private JLabel title;
	private JButton newTicket;
	private static DataControl data;
	private JList<String> listTickets;
	private String[] ticketsNames = new String[100];
	private int salePos;
	
	//Quando iniciada mais de uma vez
	//Multiplas telas abrem de uma vez
	//Para diversas vendas
	public void showData(DataControl d, int salePos){
		data = d;
		this.salePos = salePos;
		System.out.println("No ticket Sale o valor da posiçao da venda eh" + salePos);
		ticketsNames = new SessionControl(data).getSessionDetails();
		listTickets = new JList<String>(ticketsNames);
		listTickets.setLayoutOrientation(JList.VERTICAL);
			
		
		window = new JFrame("Ingressos");
		title = new JLabel("Ingressos Vendidos");
		newTicket = new JButton("Vender Ingresso");

		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(150, 10, 250, 30);
		listTickets.setBounds(100, 50, 300, 160);
		listTickets.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listTickets.setVisibleRowCount(30);

		newTicket.setBounds(10, 250, 200, 30);

		window.setLayout(null);

		window.add(title);
		window.add(listTickets);
		window.add(newTicket);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		newTicket.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == newTicket) {
			if (!listTickets.isSelectionEmpty()) {
//			System.out.println(data.getSession().get(listTickets.getSelectedIndex()).getSeatsAvailable());
				if( data.getSession().get(listTickets.getSelectedIndex()).getSeatsAvailable() > 0){
					data.getSession().get(listTickets.getSelectedIndex()).setSeatsAvailable(
							data.getSession().get(listTickets.getSelectedIndex()).getSeatsAvailable()-1
					);
					data.getSales().get(salePos).addTicket(data.getSession().get(listTickets.getSelectedIndex()));
					
					//Update Total Amount
					data.getSales().get(salePos).setTotal(data.getSales().get(salePos).getTotal() + 
							data.getSession().get(listTickets.getSelectedIndex()).getRoom().getPrice());
					
					System.out.println(data.getSales().get(salePos).toString());
					JOptionPane.showMessageDialog(null, 
												"Ingresso para " + data.getSession().get(listTickets.getSelectedIndex()).getMovie().getName() + " adicionado com sucesso! \n" +
												"Assentos disponíveis para essa sessão: " + data.getSession().get(listTickets.getSelectedIndex()).getSeatsAvailable(),
												"Informação",
												1);
				} else {
					JOptionPane.showMessageDialog(null, "Sem assentos disponíveis!", "Erro", 0);
				}
				listTickets.clearSelection();
			} else {
				JOptionPane.showMessageDialog(null, "Nenhuma sessão selecionada", "Erro", 0);
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.DataControl;
import control.SessionControl;
import control.TicketControl;

public class TicketSale implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton newTicket;
	private JButton refresh;
	private static DataControl data;
	private JList<String> listTickets;
	private String[] ticketsNames = new String[100];
	
	public void showData(DataControl d){
		data = d;

		ticketsNames = new TicketControl(data).getTicketDetail();
		listTickets = new JList<String>(ticketsNames);
		listTickets.setLayoutOrientation(JList.VERTICAL);
			
		
		window = new JFrame("Ingressos");
		title = new JLabel("Ingressos Vendidos");
		newTicket = new JButton("Vender Ingresso");
		refresh = new JButton("Atualizar");

		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(150, 10, 250, 30);
		listTickets.setBounds(100, 50, 300, 160);
		listTickets.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listTickets.setVisibleRowCount(30);

		newTicket.setBounds(10, 250, 150, 30);
		refresh.setBounds(330, 250, 150, 30);

		window.setLayout(null);

		window.add(title);
		window.add(listTickets);
		window.add(newTicket);
		window.add(refresh);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		newTicket.addActionListener(this);
		refresh.addActionListener(this);
		listTickets.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == newTicket) {
			//new SessionItem().addEdit(1, data, this, 1);
		}
		//atualiza a lista de lanches
		if(src == refresh) {
			listTickets.setListData(new SessionControl(data).getSessionDetails());
			listTickets.updateUI();
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listTickets) {
			new TicketItem().addView(2, data, this, 
			listTickets.getSelectedIndex());
		}
		
	}
}
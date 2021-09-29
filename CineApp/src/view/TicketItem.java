package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import control.DataControl;
import control.MovieControl;
import control.SessionControl;

public class TicketItem implements ActionListener {
	private JFrame window;
	private JLabel labelSessionId;
	private JLabel sessionId;
	private JLabel labelMovieName= new JLabel("Filme: ");
	private JLabel movieName;
	private JLabel seats;
	private JList<String> listSessions;
	private String[] sessionName = new String[100];
	private JButton delete = new JButton("Excluir");
	private JButton save = new JButton("Salvar");
	private String[] newRoom = new String[4];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	public void addView(int op, DataControl d, 
			TicketSale room, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Novo Ingresso";
			labelSessionId= new JLabel("Selecione a sessão abaixo: ");
		}
		if (op == 2) {
			windowLabel = "Visualizar Ingresso";
			labelSessionId= new JLabel("Sessão selecionada: ");
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			
			sessionName = new SessionControl(data).getSessionDetails();
			listSessions = new JList<String>(sessionName);
			listSessions.setLayoutOrientation(JList.VERTICAL);
			listSessions.setBounds(100, 30, 150, 160);
			listSessions.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listSessions.setVisibleRowCount(30);
			this.window.add(listSessions);

			
			
			save.setBounds(245, 190, 115, 30);
			this.window.add(save);
			
			break;
			
		case 2:
			sessionId = new JLabel(String.valueOf(data.getTickets().get(p).getSession().getSessionId()));
			movieName = new JLabel(data.getTickets().get(p).getSession().getMovie().getName());
			save.setBounds(120, 190, 115, 30);
			delete.setBounds(245, 190, 115, 30);
			
			this.window.add(save);
			this.window.add(delete);
			
			break;
		
		default:
			break;
		
		}
		
		
		
		this.window.add(listSessions);
		this.window.add(save);

		this.window.setLayout(null);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		delete.addActionListener(this);
		save.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == save) {
			
		}
		if(source == delete) {
			data.deleteTicket(position);
		}
	}
}

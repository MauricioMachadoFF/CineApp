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

public class SessionSubMenu implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton createSession;
	private JButton refreshSession;
	private static DataControl data;
	private JList<String> listSessions;
	private String[] sessionsNames = new String[100];
	
	public void showData(DataControl d){
		data = d;

			sessionsNames = new SessionControl(data).getSessionDetails();
			listSessions = new JList<String>(sessionsNames);
			listSessions.setLayoutOrientation(JList.VERTICAL);
			
			
			window = new JFrame("Sessões");
			title = new JLabel("Sessões Cadastradas");
			createSession = new JButton("Nova Sessão");
			refreshSession = new JButton("Atualizar");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(150, 10, 250, 30);
			listSessions.setBounds(100, 50, 300, 160);
			listSessions.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listSessions.setVisibleRowCount(30);

			createSession.setBounds(10, 250, 150, 30);
			refreshSession.setBounds(330, 250, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listSessions);
			window.add(createSession);
			window.add(refreshSession);

			window.setSize(500, 350);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			createSession.addActionListener(this);
			refreshSession.addActionListener(this);
			listSessions.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createSession) {
			new SessionItem().addEdit(1, data, this, 1);
		}
		//atualiza
		if(src == refreshSession) {
			listSessions.setListData(new SessionControl(data).getSessionDetails());
			listSessions.updateUI();
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listSessions) {
			new SessionItem().addEdit(2, data, this, 
			listSessions.getSelectedIndex());
		}
		
	}

}


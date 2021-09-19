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

import control.*;

public class SnackScreen implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton createSnack;
	private JButton updateSnack;
	private static DataControl data;
	private JList<String> listSnacks;
	private String[] snacksNames = new String[100];
	
	public void showData(DataControl d, int option){
		data = d;

		switch (option) {
		case 1:
			snacksNames = new SnackControl(data).getSnacksName();
			listSnacks = new JList<String>(snacksNames);
			
			window = new JFrame("Lanches");
			title = new JLabel("Lanches Cadastrados");
			createSnack = new JButton("Cadastrar");
			updateSnack = new JButton("Atualizar");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(90, 10, 250, 30);
			listSnacks.setBounds(20, 50, 350, 120);
			listSnacks.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listSnacks.setVisibleRowCount(10);

			createSnack.setBounds(70, 177, 100, 30);
			updateSnack.setBounds(200, 177, 100, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listSnacks);
			window.add(createSnack);
			window.add(updateSnack);

			window.setSize(400, 250);
			window.setVisible(true);

			createSnack.addActionListener(this);
			updateSnack.addActionListener(this);
			listSnacks.addListSelectionListener(this);
			
			break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createSnack) {
			new SnackDetailScreen().addEdit(1, data, this, 0);
		}
		//atualiza a lista de lanches
		if(src == updateSnack) {
			listSnacks.setListData(new SnackControl(data).getSnacksName());
			listSnacks.updateUI();
			

		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listSnacks) {
			new SnackDetailScreen().addEdit(2, data, this, 
					listSnacks.getSelectedIndex());
		}
		
	}
}

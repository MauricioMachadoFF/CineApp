package view;

import control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuScreen implements ActionListener {
	
	private static JFrame window = new JFrame("Sistema do Cinema");
	private static JLabel title = new JLabel("Menu Principal");
	private static JButton snack = new JButton("Lanche");
	public static DataControl data = new DataControl();
	
	public MenuScreen() {
		title.setBounds(120, 10, 150, 30);
		snack.setBounds(140, 50, 100, 30);
		
		window.setLayout(null);
		
		window.add(title);
		window.add(snack);
		
		window.setSize(400, 250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuScreen menu = new MenuScreen();
		
		snack.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == snack)
			new SnackScreen().showData(data, 1);
	}
}

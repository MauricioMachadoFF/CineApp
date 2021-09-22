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
	private static JButton food = new JButton("Gerenciar Lanches e Bebidas");
	private static JButton employee = new JButton("Gerenciar Funcionarios");
	private static JButton movie = new JButton("Gerenciar Filmes");
	private static JButton room = new JButton("Gerenciar Salas");
	private static JButton session = new JButton("Gerenciar Sessoes");
	private static JButton sale = new JButton("Realizar Venda");
	public static DataControl data = new DataControl();
	
	public MenuScreen() {
		title.setBounds(200, 10, 300, 20);
		sale.setBounds(100, 50, 300, 30);
		food.setBounds(100, 90, 300, 30);
		employee.setBounds(100, 130, 300, 30);
		movie.setBounds(100, 170, 300, 30);
		room.setBounds(100, 210, 300, 30);
		session.setBounds(100, 250, 300, 30);
		
		window.setLayout(null);
		
		window.add(title);
		window.add(sale);
		window.add(food);
		window.add(movie);
		window.add(room);
		window.add(session);
		window.add(employee);
		
		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuScreen menu = new MenuScreen();
		
		food.addActionListener(menu);
		movie.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == food) {
			new FoodScreen().showData(data);
		}
		else if (src == movie) {
			new MovieSubMenu().showData(data);
		}
			
	}
}

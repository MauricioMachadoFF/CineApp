package view;

import control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Menu inicial da aplicação. Permite navegar entre as opções/ operações possíveis em toda a aplicação.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */

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
	
	
	/**
	 * Construtor da tela Menu. Define o tamanho da janela, os componentes e seus respectivos tamanhos.
	 */
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
	
	/**
	 * Função main da aplicação responsável por integrar o menu principal, com os submenus.
	 * @param args
	 */
	public static void main(String[] args) {
		MenuScreen menu = new MenuScreen();
		
		sale.addActionListener(menu);
		food.addActionListener(menu);
		movie.addActionListener(menu);
		employee.addActionListener(menu);
		room.addActionListener(menu);
		session.addActionListener(menu);
	}
	
	/**
	 * Escuta por eventos de cliques nos botões declarados. Abre um submenu específico dependendo do botão clicado.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == food) {
			new FoodSubMenu().showData(data);
		}
		else if (src == movie) {
			new MovieSubMenu().showData(data);
		}
		else if (src == employee) {
			new EmployeeSubMenu().showData(data);
		}
		else if (src == room) {
			new RoomSubMenu().showData(data);
		}
		else if (src == session) {
			new SessionSubMenu().showData(data);
		}
		else if(src == sale) {
			new SaleSubMenu().showData(data);
		}
			
	}
}

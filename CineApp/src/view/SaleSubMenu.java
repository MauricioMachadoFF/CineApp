package view;

import control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Submenu para operações relacionados com vendas.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class SaleSubMenu implements ActionListener {
	
	private static JFrame window = new JFrame("Gerenciamento de Vendas");
	private static JLabel title = new JLabel("Menu Vendas");
	private static JButton addSale = new JButton("Adicionar Venda");
	public static DataControl data = new DataControl();
	
	
	public SaleSubMenu() {
		title.setBounds(200, 10, 300, 20);
		addSale.setBounds(100, 130, 300, 30);

		
		window.setLayout(null);
		
		window.add(title);
		window.add(addSale);
		
		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	/**
	 * Geração do submenu de salas.
	 * || (1) Permite adicionar novas vendas
	 * @param d Passagem dos dados já cadastrados no início da aplicação.
	 */
	public void showData(DataControl d) {
		SaleSubMenu menu = new SaleSubMenu();
		data = d;
		
		addSale.addActionListener(menu);
	}
	
	/**
	 * Escuta eventos de clique em botões.
	 * || (1) Adicionar sala
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == addSale) {
			new AddSaleItem().showData(data);
		}
	}
}

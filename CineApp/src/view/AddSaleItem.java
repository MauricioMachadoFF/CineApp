package view;

import control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Janela para adição de dados a uma nova venda.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 *
 */
public class AddSaleItem implements ActionListener {
	
	private static JFrame window = new JFrame("Gerenciamento de Vendas");
	private static JLabel title = new JLabel("Nova Venda");
	private static JButton foodSale = new JButton("Vender comida");
	private static JButton ticketSale = new JButton("Vender ingresso");
	private static JButton finishSale = new JButton("Finalizar Venda");
	public static DataControl data = new DataControl();
	private int salePosition;
	
	public AddSaleItem() {
		foodSale.setBounds(100, 50, 300, 30);
		ticketSale.setBounds(100, 90, 300, 30);
		finishSale.setBounds(100, 130, 300, 30);
		title.setBounds(180, 10, 300, 20);
		
		window.setLayout(null);
		
		window.add(foodSale);
		window.add(ticketSale);
		window.add(finishSale);
		window.add(title);
		
		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		setSalePosition(data.getSales().size());
	}
	
	/**
	 * Geração do submenu de adicionar venda.
	 * || (1) Permite adicionar comidas na compra
	 * || (2) Permite adicionar ingressos na compra.
	 * || (3) Permite finalizar a compra, pedindo as informações finais.
	 * @param d Passagem dos dados já cadastrados no início da aplicação.
	 */
	public void showData(DataControl d) {
		AddSaleItem menu = new AddSaleItem();
		data = d;
		data.addSale();
		
		foodSale.addActionListener(menu);
		ticketSale.addActionListener(menu);
		finishSale.addActionListener(menu);
	}
	
	/**
	 * Escuta eventos de botões para definir qual opção foi selecionada.
	 * || (1) Permite finalizar a compra, pedindo as informações finais.
	 * || (2) Permite adicionar ingressos na compra.
	 * || (3) Permite adicionar comidas na compra
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == finishSale) {
			new FinishSaleItem().addEdit(data, this, 1, this.salePosition);
			
		} else if(src==ticketSale) {
			new TicketSale().showData(data, this.salePosition);
		}
		else if(src==foodSale) {
			new FoodSale().showData(data, this.salePosition);
		}
		
	}
	
	private void setSalePosition(int salePos) {
		this.salePosition = salePos;
	}
}

package view;

import control.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AddSaleItem implements ActionListener {
	
	private static JFrame window = new JFrame("Gerenciamento de Vendas");
	private static JLabel title = new JLabel("Geração de venda 1 (trocar numero dps)");
	private static JButton foodSale = new JButton("Vender comida");
	private static JButton ticketSale = new JButton("Vender ingresso");
	private static JButton finishSale = new JButton("Finalizar Venda");
	public static DataControl data = new DataControl();
	private int salePosition;
	
	public AddSaleItem() {
		title.setBounds(200, 10, 300, 20);
		foodSale.setBounds(100, 50, 300, 30);
		ticketSale.setBounds(100, 90, 300, 30);
		finishSale.setBounds(100, 130, 300, 30);

		
		window.setLayout(null);
		
		window.add(title);
		window.add(foodSale);
		window.add(ticketSale);
		window.add(finishSale);
		
		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		setSalePosition(data.getSales().size());
	}
	
	public void showData(DataControl d) {
		AddSaleItem menu = new AddSaleItem();
		data = d;
		data.addSale();
		
		foodSale.addActionListener(menu);
		ticketSale.addActionListener(menu);
		finishSale.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == finishSale) {
			new FinishSaleItem().addEdit(data, this, 1);
			
		} else if(src==ticketSale) {
			new TicketSale().showData(data, this.salePosition);
		}
		else if(src==foodSale) {
			new FoodSale().showData(data);
		}
		
	}
	
	private void setSalePosition(int salePos) {
		this.salePosition = salePos;
	}
}

package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import control.*;

/**
 * Menu para adição de comidas e bebidas para uma venda
 * @author Mauricio Machado 
 * @version 1.0 (Out 2021)
 */
public class FoodSale implements ActionListener{
	private JFrame window;
	private JLabel title;
	private JButton addItem;
	private static DataControl data;
	private JList<String> listSnacks;
	private JList<String> listBeverages;
	private String[] snacksNames = new String[100];
	private String[] beveragesNames = new String[100];
	private int salePos;
	
	/**
	 * Geração do Menu de venda de comidas.
	 * @param d
	 * @param salePos Posição da nova venda
	 */
	public void showData(DataControl d, int salePos){
			data = d;
			this.salePos = salePos;
			
			snacksNames = new SnackControl(data).getSnacksName();
			listSnacks = new JList<String>(snacksNames);
			listSnacks.setLayoutOrientation(JList.VERTICAL);
			
			beveragesNames = new BeverageControl(data).getBeverageName();
			listBeverages = new JList<String>(beveragesNames);
			listBeverages.setLayoutOrientation(JList.VERTICAL);
			
			window = new JFrame("Vendas: Bebidas e Lanches");
			title = new JLabel("Lanches e Bebidas Disponíveis");
			addItem = new JButton("Adicionar Item");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(150, 10, 250, 30);
			listSnacks.setBounds(100, 50, 150, 160);
			listSnacks.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listSnacks.setVisibleRowCount(30);
			listBeverages.setBounds(270, 50, 150, 160);
			listBeverages.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listBeverages.setVisibleRowCount(data.getBeverages().size());

			addItem.setBounds(10, 250, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listSnacks);
			window.add(listBeverages);
			window.add(addItem);

			window.setSize(500, 350);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			addItem.addActionListener(this);
			
	}
	/**
	 * Escuta eventos de botões. Além disso valida os eventos para que comidas/bebidas sem estoque
	 * não sejam vendidas.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == addItem) {
			if (!listSnacks.isSelectionEmpty()) {
				if(data.getSnacks().get(listSnacks.getSelectedIndex()).getStockQuantity()>0) {
					
					data.getSnacks().get(listSnacks.getSelectedIndex()).setStockQuantity(
						data.getSnacks().get(listSnacks.getSelectedIndex()).getStockQuantity()-1
					);
					
					//Add data to the current Sale and see on the console if it's correct
					data.getSales().get(salePos).addSnack(data.getSnacks().get(listSnacks.getSelectedIndex()));
					//Update Total Amount
					data.getSales().get(salePos).setTotal(data.getSales().get(salePos).getTotal()+data.getSnacks().get(listSnacks.getSelectedIndex()).getPrice());
					
					JOptionPane.showMessageDialog(null, data.getSnacks().get(listSnacks.getSelectedIndex()).getName() + " adicionado com sucesso!", "Informação", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Sem estoque disponível!", "Erro", 0);
				}
				listSnacks.clearSelection();
			} else if(!listBeverages.isSelectionEmpty()) {
				if(data.getBeverages().get(listBeverages.getSelectedIndex()).getStockQuantity()>0) {
					data.getBeverages().get(listBeverages.getSelectedIndex()).setStockQuantity(
							data.getBeverages().get(listBeverages.getSelectedIndex()).getStockQuantity()-1
					);
					
					//Add data to the current Sale and see on the console if it's correct
					data.getSales().get(salePos).addBeverage(data.getBeverages().get(listBeverages.getSelectedIndex()));
					//Update Total Amount
					data.getSales().get(salePos).setTotal(data.getSales().get(salePos).getTotal()+data.getBeverages().get(listBeverages.getSelectedIndex()).getPrice());
					
					JOptionPane.showMessageDialog(null, data.getBeverages().get(listBeverages.getSelectedIndex()).getName() + " adicionado com sucesso!", "Informação", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Sem estoque disponível!", "Erro", 0);
				}
				listBeverages.clearSelection();
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum alimento selecionado", "Erro", 0);
			}
		}
		
	}
}

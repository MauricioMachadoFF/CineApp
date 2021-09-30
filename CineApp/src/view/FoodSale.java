package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import control.BeverageControl;
import control.DataControl;
import control.SnackControl;
import model.Snack;

public class FoodSale implements ActionListener{
	private JFrame window;
	private JLabel title;
	private JButton addItem;
	private static DataControl data;
	private JList<String> listSnacks;
	private JList<String> listBeverages;
	private ArrayList<Snack> snacks = new ArrayList<Snack>();
	private String[] snacksNames = new String[100];
	private String[] beveragesNames = new String[100];
	
	public void showData(DataControl d){
			data = d;

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

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == addItem) {
			snacks.add(data.getSnacks().get(listSnacks.getSelectedIndex()));
		}
		
	}
}
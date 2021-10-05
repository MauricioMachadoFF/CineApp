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

import control.BeverageControl;
import control.DataControl;
import control.SnackControl;

/**
 * Submenu para operações relacionados com comidas e bebidas.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class FoodSubMenu implements ActionListener, ListSelectionListener {
	
	private JFrame window;
	private JLabel title;
	private JButton createSnack;
	private JButton createBeverage;
	private JButton updateFood;
	private static DataControl data;
	private JList<String> listSnacks;
	private JList<String> listBeverages;
	private String[] snacksNames = new String[100];
	private String[] beveragesNames = new String[100];
	
	/**
	 * Geração do submenu de comidas e bebidas.
	 * (1) Permite adicionar novas comidas ou bebidas
	 * (2) Permite atualizar a tela, para mostrar novos itens cadastrados
	 * (3) Permite editar itens já cadastrados
	 * (4) Permite excluir itens já cadastrados
	 * @param d Passagem dos dados já cadastrados no início da aplicação.
	 */
	public void showData(DataControl d){
		data = d;

			snacksNames = new SnackControl(data).getSnacksName();
			listSnacks = new JList<String>(snacksNames);
			listSnacks.setLayoutOrientation(JList.VERTICAL);
			
			beveragesNames = new BeverageControl(data).getBeverageName();
			listBeverages = new JList<String>(beveragesNames);
			listBeverages.setLayoutOrientation(JList.VERTICAL);
			
			window = new JFrame("Lanches");
			title = new JLabel("Lanches Cadastrados");
			createSnack = new JButton("Novo Lanche");
			createBeverage = new JButton("Nova Bebida");
			updateFood = new JButton("Atualizar");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(150, 10, 250, 30);
			listSnacks.setBounds(100, 50, 150, 160);
			listSnacks.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listSnacks.setVisibleRowCount(30);
			listBeverages.setBounds(270, 50, 150, 160);
			listBeverages.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listBeverages.setVisibleRowCount(data.getBeverages().size());

			createSnack.setBounds(10, 250, 150, 30);
			createBeverage.setBounds(170, 250, 150, 30);
			updateFood.setBounds(330, 250, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listSnacks);
			window.add(listBeverages);
			window.add(createSnack);
			window.add(createBeverage);
			window.add(updateFood);

			window.setSize(500, 350);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			createSnack.addActionListener(this);
			createBeverage.addActionListener(this);
			updateFood.addActionListener(this);
			listSnacks.addListSelectionListener(this);
			listBeverages.addListSelectionListener(this);
			
	}

	/**
	 * Escuta por eventos de clique.
	 * (1) Cadastrar nova comida
	 * (2) Cadastrar nova bebida
	 * (3) Atualizar as listas existentes
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createSnack) {
			new FoodItem().addEdit(1, data, this, 0);
		}
		if(src == createBeverage) {
			new FoodItem().addEdit(2, data, this, 1);
		}
		//atualiza a lista de lanches
		if(src == updateFood) {
			listSnacks.setListData(new SnackControl(data).getSnacksName());
			listSnacks.updateUI();
			listBeverages.setListData(new BeverageControl(data).getBeverageName());
			listBeverages.updateUI();

		}
		
	}

	/**
	 * Escuta por eventos de cliques nas duas JLists definidas.
	 * (1) Abre o item especificado de comida. Permite edição e/ou exclusão.
	 * (2) Abre o item especificado de bebida. Permite edição e/ou exclusão.
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listSnacks) {
			new FoodItem().addEdit(3, data, this, 
			listSnacks.getSelectedIndex());
		}
		
		if(e.getValueIsAdjusting() && source == listBeverages) {
			new FoodItem().addEdit(4, data, this, 
			listBeverages.getSelectedIndex());
		}
		
	}

}

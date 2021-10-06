package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.DataControl;

/**
 * Menu para acesso as informações detalhadas de uma comida ou bebida.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class FoodItem implements ActionListener {
	private JFrame window;
	private JLabel labelName;
	private JTextField name;
	private JLabel labelPrice = new JLabel("Preço (R$): ");
	private JTextField price;
	private JLabel labelStock = new JLabel("Estoque: ");
	private JTextField stock;
	private JLabel labelBatch = new JLabel("Lote: ");
	private JTextField batch;
	private JCheckBox isSweet; 
	private JCheckBox isDiet; 
	private JCheckBox hasIce; 
	private JCheckBox hasStraw; 
	private JButton deleteSnack = new JButton("Excluir");
	private JButton saveSnack = new JButton("Salvar");
	private JButton deleteBeverage = new JButton("Excluir");
	private JButton saveBeverage = new JButton("Salvar");
	private String[] editedSnack = new String[6];
	private String[] newSnack = new String[5];
	private String[] editedBeverage = new String[8];
	private String[] newBeverage = new String[7];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	/**
	 * Execução da operação selecionada no FoodSubMenu
	 * (1) Cadastro de nova comida
	 * (2) Cadastro de nova bebida
	 * (3) edição/exclusão de comida
	 * (4) edição/exclusão de bebida
	 * @param op
	 * @param d Recebe todas as informações de dados já cadastrados no sistema.
	 * @param food 
	 * @param p Posição do item selecionado
	 */
	public void addEdit(int op, DataControl d, 
			FoodSubMenu food, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Lanche";
			labelName = new JLabel("Lanche: ");
		}
		if (op == 2) {
			windowLabel = "Cadastrar Bebida";
			labelName = new JLabel("Bebida: ");
		}
		if (op == 3) {
			windowLabel = "Lanche: Informações";
			labelName = new JLabel("Lanche: ");
		}
		if (op == 4) {
			windowLabel = "Bebida: Informações";
			labelName = new JLabel("Bebida: ");
		}
		
		window=new JFrame(windowLabel);
		
		if(op==1 || op==2) {
			name = new JTextField(200);
			price = new JTextField(200);
			stock = new JTextField(200);
			batch = new JTextField(200);
		}
		
		switch(op) {
		
		case 1:
			saveSnack.setBounds(245, 175, 115, 30);
			isSweet = new JCheckBox("Eh doce");
			
			isSweet.setBounds(30, 140, 150, 25);
			this.window.add(isSweet);
			this.window.add(saveSnack);
			
			break;
			
		case 2:
			saveBeverage.setBounds(245, 175, 115, 30);
			isDiet = new JCheckBox("Eh diet");
			hasIce = new JCheckBox("Acompanha gelo");
			hasStraw = new JCheckBox("Acompanha canudo");
			
			isDiet.setBounds(30, 140, 150, 25);
			hasIce.setBounds(30, 160, 150, 25);
			hasStraw.setBounds(30, 180, 150, 25);
			this.window.add(hasIce);
			this.window.add(hasStraw);
			this.window.add(isDiet);
			this.window.add(saveBeverage);
			break;
		
		case 3:
			name = new JTextField(data.getSnacks().get(p).getName(), 200);
			price = new JTextField(String.valueOf(data.getSnacks().get(p).getPrice()), 200);
			stock = new JTextField(String.valueOf(data.getSnacks().get(p).getStockQuantity()), 200);
			batch = new JTextField(String.valueOf(data.getSnacks().get(p).getBatch()), 200);
			isSweet = new JCheckBox("Eh doce?", data.getSnacks().get(p).getIsSweet());
			
			isSweet.setBounds(30, 140, 150, 25);
			saveSnack.setBounds(120, 175, 115, 30);
			deleteSnack.setBounds(245, 175, 115, 30);
			this.window.add(isSweet);
			this.window.add(saveSnack);
			this.window.add(deleteSnack);
			
			break;
			
		case 4:
			
			name = new JTextField(data.getBeverages().get(p).getName(), 200);
			price = new JTextField(String.valueOf(data.getBeverages().get(p).getPrice()), 200);
			stock = new JTextField(String.valueOf(data.getBeverages().get(p).getStockQuantity()), 200);
			batch = new JTextField(String.valueOf(data.getBeverages().get(p).getBatch()), 200);
			isDiet = new JCheckBox("Eh diet", data.getBeverages().get(p).getIsDiet());
			hasIce = new JCheckBox("Acompanha gelo", data.getBeverages().get(p).getHasIce());
			hasStraw = new JCheckBox("Acompanha canudo", data.getBeverages().get(p).getHasStraw());
			
			isDiet.setBounds(25, 140, 150, 35);
			hasIce.setBounds(25, 170, 150, 35);
			hasStraw.setBounds(25, 200, 250, 35);
			saveBeverage.setBounds(120, 250, 115, 30);
			deleteBeverage.setBounds(245, 250, 115, 30);
			this.window.add(hasIce);
			this.window.add(hasStraw);
			this.window.add(isDiet);
			this.window.add(saveBeverage);
			this.window.add(deleteBeverage);
			break;
		default:
			break;
		
		}
		
		labelName.setBounds(30, 20, 150, 25);
		name.setBounds(180, 20, 180, 25);
		labelPrice.setBounds(30, 50, 150, 25);
		price.setBounds(180, 50, 180, 25);
		labelStock.setBounds(30, 80, 150, 25);
		stock.setBounds(180, 80, 180, 25);
		labelBatch.setBounds(30, 110, 150, 25);
		batch.setBounds(180, 110, 180, 25);
		
		this.window.add(labelName);
		this.window.add(name);
		this.window.add(labelPrice);
		this.window.add(price);
		this.window.add(labelStock);
		this.window.add(stock);
		this.window.add(labelBatch);
		this.window.add(batch);

		this.window.setLayout(null);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		saveSnack.addActionListener(this);
		deleteSnack.addActionListener(this);
		saveBeverage.addActionListener(this);
		deleteBeverage.addActionListener(this);
		
	}
	
	
	/**
	 * Escuta pelos eventos de clique e concluí a operação. Atualizando os dados do sistema para refletirem em toda aplicação.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveSnack) {
			try {
				boolean added;
				if(option==1) { //cadastro
					newSnack[0] =  name.getText();
					newSnack[1] =  price.getText();
					newSnack[2] =  stock.getText();
					newSnack[3] =  batch.getText();
					newSnack[4] =  String.valueOf(isSweet.isSelected());
					added = data.addSnack(newSnack);
					
				} else {
					// edição
					editedSnack[0] = Integer.toString(position);
					
					editedSnack[1] =  name.getText();
					editedSnack[2] =  price.getText();
					editedSnack[3] =  stock.getText();
					editedSnack[4] =  batch.getText();
					editedSnack[5] =  String.valueOf(isSweet.isSelected());
					added = data.editSnack(editedSnack);
				}
				if (added) {
					JOptionPane.showMessageDialog(null, "Lanche Salvo!", null, 1);
					window.dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
							+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
							+ "2| Insira somente números nos campos de preço e estoque", null, 
							0);
				}
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
						+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
						+ "2| Insira somente números nos campos de preço, estoque e lote", null, 
						0);
			}
		}
		if(source == deleteSnack) {
			data.deleteSnack(position);
		}
		
		if(source == saveBeverage) {
			try {
				boolean added;
				if(option==2) { //cadastro
					newBeverage[0] =  name.getText();
					newBeverage[1] =  price.getText();
					newBeverage[2] =  stock.getText();
					newBeverage[3] =  batch.getText();
					newBeverage[4] =  String.valueOf(isDiet.isSelected());
					newBeverage[5] =  String.valueOf(hasIce.isSelected());
					newBeverage[6] =  String.valueOf(hasStraw.isSelected());
					
					added=data.addBeverage(newBeverage);
					
				} else {
					// edição
					editedBeverage[0] = Integer.toString(position);
					
					editedBeverage[1] =  name.getText();
					editedBeverage[2] =  price.getText();
					editedBeverage[3] =  stock.getText();
					editedBeverage[4] =  batch.getText();
					editedBeverage[5] =  String.valueOf(isDiet.isSelected());
					editedBeverage[6] =  String.valueOf(hasIce.isSelected());
					editedBeverage[7] =  String.valueOf(hasStraw.isSelected());
					
					added=data.editBeverage(editedBeverage);
				}
				if (added) {
					JOptionPane.showMessageDialog(null, "Bebida Salva!", null, 1);
					window.dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
							+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
							+ "2| Insira somente números nos campos de preço, estoque e lote", null, 
							0);
				}
			} catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
						+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
						+ "2| Insira somente números nos campos de preço, estoque e lote", null, 
						0);
			}
		}
		if(source == deleteBeverage) {
			data.deleteBeverage(position);
		}
		
	}
}

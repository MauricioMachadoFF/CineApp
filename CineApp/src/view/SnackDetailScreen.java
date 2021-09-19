package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.*;


public class SnackDetailScreen implements ActionListener {
	private JFrame window;
	private JLabel labelName = new JLabel("Lanche: ");
	private JTextField name;
	private JLabel labelPrice = new JLabel("Preço (R$): ");
	private JTextField price;
	private JLabel labelStock = new JLabel("Estoque: ");
	private JTextField stock;
	private JLabel labelBatch = new JLabel("Lote: ");
	private JTextField batch;
	private JCheckBox isSweet; 
	private JButton deleteButton = new JButton("Excluir");
	private JButton saveButton = new JButton("Salvar");
	private String[] editedData = new String[6];
	private String[] newData = new String[5];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	public void addEdit(int op, DataControl d, 
			SnackScreen snack, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Lanche";
		}
		if (op == 2) {
			windowLabel = "Lanche: Informações";
		}
		
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 2:
			
			name = new JTextField(data.getSnacks().get(p).getName(), 200);
			price = new JTextField(String.valueOf(data.getSnacks().get(p).getPrice()), 200);
			stock = new JTextField(String.valueOf(data.getSnacks().get(p).getStockQuantity()), 200);
			batch = new JTextField(String.valueOf(data.getSnacks().get(p).getBatch()), 200);
			isSweet = new JCheckBox("Eh doce?", data.getSnacks().get(p).getIsSweet());
			
			saveButton.setBounds(120, 175, 115, 30);
			deleteButton.setBounds(245, 175, 115, 30);
			this.window.add(saveButton);
			this.window.add(deleteButton);
			
			break;
		default:
			
			name = new JTextField(200);
			price = new JTextField(200);
			stock = new JTextField(200);
			batch = new JTextField(200);
			saveButton.setBounds(245, 175, 115, 30);
			this.window.add(saveButton);
			
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
		isSweet.setBounds(30, 140, 150, 25);
		
		this.window.add(labelName);
		this.window.add(name);
		this.window.add(labelPrice);
		this.window.add(price);
		this.window.add(labelStock);
		this.window.add(stock);
		this.window.add(labelBatch);
		this.window.add(batch);
		this.window.add(isSweet);

		this.window.setLayout(null);

		this.window.setSize(400, 250);
		this.window.setVisible(true);

		saveButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveButton) {
			if(option==1) { //cadastro de um lanche
				newData[0] =  name.getText();
				newData[1] =  price.getText();
				newData[2] =  stock.getText();
				newData[3] =  batch.getText();
				newData[4] =  String.valueOf(isSweet.isSelected());
				data.addSnack(newData);
				
			} else {
				// edição de um lanche cadastrado
				editedData[0] = Integer.toString(position);
				
				editedData[1] =  name.getText();
				editedData[2] =  price.getText();
				editedData[3] =  stock.getText();
				editedData[4] =  batch.getText();
				editedData[5] =  String.valueOf(isSweet.isSelected());
				data.editSnack(editedData);
			}
		}
		if(source == deleteButton) {
			data.deleteSnack(position);
		}
		
	}

}

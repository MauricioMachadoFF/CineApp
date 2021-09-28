package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.DataControl;

public class FinishSaleItem implements ActionListener {
	private JFrame window;
	private String title = "Finalizar Venda";
	private JLabel labelClientCPF= new JLabel("CPF do cliente: ");
	private JTextField clientCPF;
	private JLabel labelTotal = new JLabel("Total: ");
	private JTextField total;
	private JLabel labelPaymentMethod = new JLabel("Método de Pagamento:");
	private JRadioButton debitMethod = new JRadioButton("Débito");
	private JRadioButton creditMethod = new JRadioButton("Crédito");
	private JRadioButton cashMethod = new JRadioButton("Dinheiro");
	private JButton cancelSale = new JButton("Cancelar Compra");
	private JButton saveSale = new JButton("Salvar");
	private String[] editedEmployee= new String[5];
	private String[] newEmployee = new String[4];
	private static DataControl data;
	private int position;
	private int option;
	
	public void addEdit(DataControl d, 
			AddSaleItem sale, int p) {
		
		data=d;
		position=p;
		
		ButtonGroup paymentMethod = new ButtonGroup();
		paymentMethod.add(debitMethod);
		paymentMethod.add(creditMethod);
		paymentMethod.add(cashMethod);
		
		window=new JFrame(title);
		
		clientCPF = new JTextField(200);
		total = new JTextField(200);
		
		labelClientCPF.setBounds(30, 20, 150, 25);
		clientCPF.setBounds(180, 20, 180, 25);
		labelTotal.setBounds(30, 50, 150, 25);
		total.setBounds(180, 50, 180, 25);
		labelPaymentMethod.setBounds(30, 80, 150, 25);
		debitMethod.setBounds(30, 100, 150, 25);
		creditMethod.setBounds(30, 120, 150, 25);
		cashMethod.setBounds(30, 140, 150, 25);
		saveSale.setBounds(245, 175, 115, 30);
		cancelSale.setBounds(30, 175, 175, 30);
		
		this.window.add(labelClientCPF);
		this.window.add(clientCPF);
		this.window.add(labelTotal);
		this.window.add(total);
		this.window.add(labelPaymentMethod);
		this.window.add(debitMethod);
		this.window.add(creditMethod);
		this.window.add(cashMethod);
		this.window.add(saveSale);
		this.window.add(cancelSale);

		this.window.setLayout(null);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		cancelSale.addActionListener(this);
		saveSale.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
//		if(source == saveEmployee) {
//			if(option==1) { //cadastro de um lanche
//				newEmployee[0] =  name.getText();
//				newEmployee[1] =  cellphone.getText();
//				newEmployee[2] =  cpf.getText();
//				newEmployee[3] =  empCode.getText();
//				data.addEmployee(newEmployee);
//				
//			} else {
//				// edição de um lanche cadastrado
//				editedEmployee[0] = Integer.toString(position);
//				
//				editedEmployee[1] =  name.getText();
//				editedEmployee[2] =  cellphone.getText();
//				editedEmployee[3] =  cpf.getText();
//				editedEmployee[4] =  empCode.getText();
//				data.editEmployee(editedEmployee);
//			}
//		}
//		if(source == deleteEmployee) {
//			data.deleteEmployee(position);
//		}
	}
}

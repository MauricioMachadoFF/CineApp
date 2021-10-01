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
	private JLabel labelEmployeeCode= new JLabel("Código do Funcionário: ");
	private JTextField employeeCode;
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
	private String[] saleData= new String[5];
	private String[] newEmployee = new String[4];
	private static DataControl data;
	private int position;
	private int option;
	private int salePos;
	
	public void addEdit(DataControl d, 
			AddSaleItem sale, int p, int salePos) {
		
		data=d;
		position=p;
		this.salePos = salePos;
		System.out.println("Finalizar compra numero" + this.salePos);
//		System.out.println(data.getSales().get(this.salePos).toString());
		ButtonGroup paymentMethod = new ButtonGroup();
		paymentMethod.add(debitMethod);
		paymentMethod.add(creditMethod);
		paymentMethod.add(cashMethod);
		
		window=new JFrame(title);
		
		clientCPF = new JTextField(200);
		
		employeeCode = new JTextField(200);
		
		//Algo errado no cálculo do total, verificar!!!
		//data.getSales().get(this.salePos).setTotal(data.getSnacks() ,data.getBeverages(), data.getSession());
		
		total = new JTextField(String.valueOf(data.getSales().get(this.salePos).getTotal()));
		total.setEditable(false);
		
		labelClientCPF.setBounds(30, 20, 150, 25);
		clientCPF.setBounds(180, 20, 180, 25);
		labelEmployeeCode.setBounds(30, 50, 150, 25);
		employeeCode.setBounds(180, 50, 180, 25);
		labelTotal.setBounds(30, 80, 150, 25);
		total.setBounds(180, 80, 180, 25);
		labelPaymentMethod.setBounds(30, 100, 150, 25);
		debitMethod.setBounds(30, 120, 150, 25);
		creditMethod.setBounds(30, 140, 150, 25);
		cashMethod.setBounds(30, 160, 150, 25);
		saveSale.setBounds(245, 180, 115, 30);
		cancelSale.setBounds(30, 180, 175, 30);
		
		
		this.window.add(labelClientCPF);
		this.window.add(clientCPF);
		this.window.add(labelEmployeeCode);
		this.window.add(employeeCode);
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
		if(source == saveSale) {
				System.out.println();
				System.out.println("Visão Geralll");
				System.out.println();
			
				data.getSales().get(this.salePos).setClientCPF(clientCPF.getText());
				data.getSales().get(this.salePos).setEmployee(data.getEmployeeByCode(Integer.parseInt(employeeCode.getText())));
//				data.getSales().get(this.salePos).setTotal(data.getSnacks() ,data.getBeverages(), data.getSession());
				
				System.out.println(data.getSales().get(this.salePos).toString());
		}
		else if(source == cancelSale) {
			data.deleteSale(this.salePos);
			
			//Tem que fazer um pouco mais
			//quando cancelar a venda as janelas devem ser fechadas até a janela
			//de gerenciamento de vendas onde pode começar outra venda
		}
	}
	
}

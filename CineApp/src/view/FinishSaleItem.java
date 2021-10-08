package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.DataControl;

/**
 * Menu para finalização de uma venda.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
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
	private static DataControl data;
	private int salePos;
	
	/**
	 * Geração do menu e controle do preenchimento das informações finais.
	 * @param d Dados cadastrados na aplicação até o momento
	 * @param s
	 * @param p 
	 * @param salePos Posição da venda selecionada
	 */
	public void addEdit(DataControl d, 
			AddSaleItem s, int p, int salePos) {
		
		data=d;
		this.salePos = salePos;
		ButtonGroup paymentMethod = new ButtonGroup();
		
		paymentMethod.add(debitMethod);
		paymentMethod.add(creditMethod);
		paymentMethod.add(cashMethod);
		
		window=new JFrame(title);
		clientCPF = new JTextField(200);
		employeeCode = new JTextField(200);
		
		total = new JTextField(String.valueOf(data.getSales().get(this.salePos).getTotal()));
		total.setEditable(false);
		
		labelClientCPF.setBounds(30, 20, 150, 25);
		clientCPF.setBounds(200, 20, 180, 25);
		labelEmployeeCode.setBounds(30, 50, 200, 25);
		employeeCode.setBounds(200, 50, 180, 25);
		labelTotal.setBounds(30, 80, 150, 25);
		total.setBounds(200, 80, 180, 25);
		labelPaymentMethod.setBounds(30, 110, 250, 25);
		debitMethod.setBounds(30, 130, 150, 25);
		creditMethod.setBounds(30, 150, 150, 25);
		cashMethod.setBounds(30, 170, 150, 25);
		saveSale.setBounds(245, 200, 115, 30);
		cancelSale.setBounds(30, 200, 175, 30);
		
		
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
	
	
	/**
	 * Escuta eventos de botões.
	 * || (1) Finalizar Venda
	 * || (2) Cancelar Venda
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveSale) {
				//System.out.println();
				//System.out.println("Visão Geral");
				//System.out.println();
			
				data.getSales().get(this.salePos).setClientCPF(clientCPF.getText());
				data.getSales().get(this.salePos).setEmployee(data.getEmployeeByCode(Integer.parseInt(employeeCode.getText())));
				
					if(debitMethod.isSelected()){
						data.getSales().get(this.salePos).setPaymentMethod(debitMethod.getText());	
					} else if(creditMethod.isSelected()){
						data.getSales().get(this.salePos).setPaymentMethod(creditMethod.getText());	
					} else if(cashMethod.isSelected()) {
						data.getSales().get(this.salePos).setPaymentMethod(creditMethod.getText());	
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum método de pagamento selecionado", "Erro", 0);
					}
								
				//System.out.println(data.getSales().get(this.salePos).toString());
				this.window.dispose();
		}
		else if(source == cancelSale) {
			data.deleteSale(this.salePos);
		}
	}
	
}

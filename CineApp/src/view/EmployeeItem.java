package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.DataControl;

public class EmployeeItem implements ActionListener {
	private JFrame window;
	private JLabel labelName= new JLabel("Nome: ");
	private JTextField name;
	private JLabel labelCellphone = new JLabel("Número de celular: ");
	private JTextField cellphone;
	private JLabel labelCpf = new JLabel("CPF: ");
	private JTextField cpf;
	private JLabel labelEmpCode = new JLabel("Código do funcionário: ");
	private JTextField empCode;
	private JButton deleteEmployee = new JButton("Excluir");
	private JButton saveEmployee = new JButton("Salvar");
	private String[] editedEmployee= new String[5];
	private String[] newEmployee = new String[4];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	public void addEdit(int op, DataControl d, 
			EmployeeSubMenu employee, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Filme";
			labelName = new JLabel("Nome: ");
		}
		if (op == 2) {
			windowLabel = "Filme: Informações";
			labelName = new JLabel("Nome: ");
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			name = new JTextField(200);
			cellphone = new JTextField(200);
			cpf = new JTextField(200);
			empCode = new JTextField(200);
			saveEmployee.setBounds(245, 175, 115, 30);
			this.window.add(saveEmployee);
			
			break;
			
		case 2:
			name = new JTextField(data.getEmployees().get(p).getName(), 200);
			cellphone = new JTextField(data.getEmployees().get(p).getCellphone(), 200);
			cpf = new JTextField(data.getEmployees().get(p).getCPF(), 200);
			empCode = new JTextField(String.valueOf(data.getEmployees().get(p).getEmployeeCode()), 200);
			
			saveEmployee.setBounds(120, 175, 115, 30);
			deleteEmployee.setBounds(245, 175, 115, 30);
			
			this.window.add(saveEmployee);
			this.window.add(deleteEmployee);
			
			break;
		
		default:
			break;
		
		}
		
		labelName.setBounds(30, 20, 150, 25);
		name.setBounds(180, 20, 180, 25);
		labelCellphone.setBounds(30, 50, 150, 25);
		cellphone.setBounds(180, 50, 180, 25);
		labelCpf.setBounds(30, 80, 150, 25);
		cpf.setBounds(180, 80, 180, 25);
		labelEmpCode.setBounds(30, 110, 150, 25);
		empCode.setBounds(180, 110, 180, 25);
		
		this.window.add(labelName);
		this.window.add(name);
		this.window.add(labelCellphone);
		this.window.add(cellphone);
		this.window.add(labelCpf);
		this.window.add(cpf);
		this.window.add(labelEmpCode);
		this.window.add(empCode);

		this.window.setLayout(null);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		deleteEmployee.addActionListener(this);
		saveEmployee.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveEmployee) {
			if(option==1) { //cadastro de um lanche
				newEmployee[0] =  name.getText();
				newEmployee[1] =  cellphone.getText();
				newEmployee[2] =  cpf.getText();
				newEmployee[3] =  empCode.getText();
				data.addEmployee(newEmployee);
				
			} else {
				// edição de um lanche cadastrado
				editedEmployee[0] = Integer.toString(position);
				
				editedEmployee[1] =  name.getText();
				editedEmployee[2] =  cellphone.getText();
				editedEmployee[3] =  cpf.getText();
				editedEmployee[4] =  empCode.getText();
				data.editEmployee(editedEmployee);
			}
		}
		if(source == deleteEmployee) {
			data.deleteEmployee(position);
		}
	}
}

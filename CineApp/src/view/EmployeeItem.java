package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.DataControl;

/**
 * Menu/Janela com informação detalhada do funcionário selecionado no EmployeeSubMenu.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
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
	
	/**
	 * Execução da operação selecionada no EmployeeSubMenu
	 * || (1) Cadastrar novo funcionário
	 * || (2) Editar funcionário
	 * || (3) Excluir funcionário
	 * @param op
	 * @param d Recebe todas as informações de dados já cadastrados no sistema.
	 * @param employee
	 * @param p Posição do item selecionado
	 */
	public void addEdit(int op, DataControl d, 
			EmployeeSubMenu employee, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Funcionario";
			labelName = new JLabel("Nome: ");
		}
		if (op == 2) {
			windowLabel = "Funcionario: Informações";
			labelName = new JLabel("Nome: ");
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			name = new JTextField(200);
			cellphone = new JTextField(200);
			cpf = new JTextField(200);
			empCode = new JTextField(200);
			saveEmployee.setBounds(260, 175, 115, 30);
			this.window.add(saveEmployee);
			
			break;
			
		case 2:
			name = new JTextField(data.getEmployees().get(p).getName(), 200);
			cellphone = new JTextField(data.getEmployees().get(p).getCellphone(), 200);
			cpf = new JTextField(data.getEmployees().get(p).getCPF(), 200);
			empCode = new JTextField(String.valueOf(data.getEmployees().get(p).getEmployeeCode()), 200);
			
			saveEmployee.setBounds(135, 175, 115, 30);
			deleteEmployee.setBounds(260, 175, 115, 30);
			
			this.window.add(saveEmployee);
			this.window.add(deleteEmployee);
			
			break;
		
		default:
			break;
		
		}
		
		labelName.setBounds(30, 20, 150, 25);
		name.setBounds(200, 20, 280, 25);
		labelCellphone.setBounds(30, 50, 150, 25);
		cellphone.setBounds(200, 50, 280, 25);
		labelCpf.setBounds(30, 80, 150, 25);
		cpf.setBounds(200, 80, 280, 25);
		labelEmpCode.setBounds(30, 110, 175, 25);
		empCode.setBounds(200, 110, 280, 25);
		
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
	
	
	/**
	 * Escuta pelos eventos de clique e concluí a operação. Atualizando os dados do sistema para refletirem em toda aplicação.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveEmployee) {
			try {
				boolean added;
				if(option==1) { //cadastro
					newEmployee[0] =  name.getText();
					newEmployee[1] =  cellphone.getText();
					newEmployee[2] =  cpf.getText();
					newEmployee[3] =  empCode.getText();
					added = data.addEmployee(newEmployee);
					
				} else {
					// edição
					editedEmployee[0] = Integer.toString(position);
					
					editedEmployee[1] =  name.getText();
					editedEmployee[2] =  cellphone.getText();
					editedEmployee[3] =  cpf.getText();
					editedEmployee[4] =  empCode.getText();
					added = data.editEmployee(editedEmployee);
				}
				if (added) {
					JOptionPane.showMessageDialog(null, "Dados salvos!", null, 1);
					window.dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
							+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
							+ "2| Insira somente números no campo de código do funcionário", null, 
							0);
				}
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
						+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
						+ "2| Insira somente números no campo de código do funcionário", null, 
						0);
			}
			window.dispose();
		}
		if(source == deleteEmployee) {
			data.deleteEmployee(position);
			window.dispose();
		}
	}
}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;

/**
 * Submenu para operações relacionados com funcionários.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class EmployeeSubMenu implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton addEmployee;
	private JButton refreshEmployee;
	private static DataControl data;
	private JList<String> listEmployees;
	private String[] employeesNames = new String[100];
	
	/**
	 * Geração do submenu de funcionários.
	 * (1) Permite adicionar novos funcionários
	 * (2) Permite atualizar a tela, para mostrar novos funcionários cadastrados
	 * (3) Permite editar funcionários já cadastrados
	 * (4) Permite excluir funcionários já cadastrados
	 * @param d Passagem dos dados já cadastrados no início da aplicação.
	 */
	public void showData(DataControl d){
		data = d;

			employeesNames = new EmployeeControl(data).getEmployeesName();
			listEmployees= new JList<String>(employeesNames);
			listEmployees.setLayoutOrientation(JList.VERTICAL);
			
			
			window = new JFrame("Funcionários");
			title = new JLabel("Funcionários Registrados");
			addEmployee = new JButton("Novo Funcionário");
			refreshEmployee = new JButton("Atualizar");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(150, 10, 250, 30);
			listEmployees.setBounds(100, 50, 150, 160);
			listEmployees.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listEmployees.setVisibleRowCount(30);

			addEmployee.setBounds(10, 250, 150, 30);
			refreshEmployee.setBounds(330, 250, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listEmployees);
			window.add(addEmployee);
			window.add(refreshEmployee);

			window.setSize(500, 350);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			addEmployee.addActionListener(this);
			refreshEmployee.addActionListener(this);
			listEmployees.addListSelectionListener(this);
	}
	
	/**
	 * Escuta por eventos de cliques em botões.
	 * (1) Adicionar novo funcionário
	 * (2) Atualizar lista
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == addEmployee) {
			new EmployeeItem().addEdit(1, data, this, 1);
		}
		//atualiza a lista de lanches
		if(src == refreshEmployee) {
			listEmployees.setListData(new EmployeeControl(data).getEmployeesName());
			listEmployees.updateUI();
		}
		
	}

	/**
	 * Escuta eventos de seleção na JList. Gera uma janela com mais informações detalhadas do funcionário selecionado.
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listEmployees) {
			new EmployeeItem().addEdit(2, data, this, 
				listEmployees.getSelectedIndex());
		}
		
	}
}

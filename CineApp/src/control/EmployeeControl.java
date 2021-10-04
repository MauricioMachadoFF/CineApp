package control;
import java.util.ArrayList;
import model.*;

/**
 * Controle das informações acerca da classe Employee
 * @author Mauricio Machado
 * @version 1.0 (Out 2020)
 */

public class EmployeeControl
{
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	
	/**
	 * Preencher a ArrayList employees com todos os funcionários existentes até o momento
	 * 
	 * @param data um objeto de classe DataControl que nos possibilita operar com todos os dados presentes na aplicação
	 */
	public EmployeeControl(DataControl data) {
		employees = data.getEmployees();
	}
	
	/**
	 * Gerar a lista de nomes de todos os funcionários 
	 * @return list - um array de Strings onde cada String é o nome de um funcionário
	 */
	public String[] getEmployeesName() {
		String[] list = new String[employees.size()];
		for(int n = 0; n < employees.size(); n++) {
			list[n] = employees.get(n).getName();
		}
		
		return list;
	}
}

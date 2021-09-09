package cinema;
import java.util.Scanner;

public class Employee {
	private Scanner ler = new Scanner(System.in).useDelimiter("\n");
	private String name;
	private String cellphone;
	private String CPF;
	private int employeeCode;
	
	//KInda like the create/registerEmployee
	public Employee(String name, String cellphone, String CPF, int employeeCode) {
		this.name = name;
		this.cellphone = cellphone;
		this.CPF = CPF;
		this.employeeCode = employeeCode;
	}
	
	
	//See Sale to understand how to deal better with this constructor
	public Employee() {
		this.name = null;
		this.cellphone = null;
		this.CPF = null;
		this.employeeCode = -1;
	}
	
	public String getName() {
		return name;
	}
	public String getCellphone() {
		return cellphone;
	}
	public String getCPF() {
		return CPF;
	}
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	
	//readEmployee
	public String toString() {
		return new String("Employee's Name: " + this.name)
				.concat("\nEmployee's Cellphone: " + this.cellphone)
				.concat("\nEmployee's CPF: " + this.CPF)
				.concat("\nEmployee's Code: ") + this.employeeCode;
	}
	
	//update employee information
	public void updateEmployee() {
		int auxiliar;
		System.out.println("Qual dado deseja editar?");
		System.out.println("1- Nome \n2- Número de celular \n3-CPF");
		auxiliar=ler.nextInt();
		
		switch(auxiliar) {
		case 1:
			System.out.println("\nDigite o novo nome:");
			ler.nextLine();
			name=ler.nextLine();
			setName(name);
			break;
			
		case 2:
			System.out.println("\nDigite o novo número de celular (sem espaços):");
			//ler.nextLine();
			cellphone=ler.next();
			setCellphone(cellphone);
			break;
			
		case 3:
			System.out.println("\nDigite o CPF atualizado (sem espaços ou digitos especiais):");
			//ler.nextLine();
			CPF=ler.next();
			setCPF(CPF);
			break;
			
		default:
			System.out.println("Opcao Invalida");
			break;
		}
		System.out.println(toString());
	}
	
}


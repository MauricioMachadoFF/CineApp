package model;

public class Employee {
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
	public void setCPF(String CPF) {
		this.CPF = CPF;
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
	
}

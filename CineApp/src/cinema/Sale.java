package cinema;

public class Sale {
	private int saleId=1;
	private Receipt receipt;
	private Employee employee;
	final int max = 10000;
	final int min = 1;

	public Sale(Receipt receipt, Employee employee) {
		this.saleId=(int)Math.floor(Math.random()*(max-min+1)+min);
		this.receipt = receipt;
		this.employee = employee;
		
	}
	
	public int getSaleId() {
		return saleId;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setSaleId(int saleId) {
		this.saleId = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String toString() {
		return new String("Venda nº: " + this.saleId + "\n")
			.concat("Valor: R$ " + receipt.getTotal() + "\n")
			.concat("Código do Vendedor: " + employee.getEmployeeCode() + "\n");
	}
}

package cinema;

public class Sale {
	private int saleId;
	private Receipt receipt = new Receipt();
	private Employee employee;
	
	public Sale(Employee employee, Receipt receipt) {
		final int max = 100000;
		final int min = 1;
		this.saleId = (int)Math.floor(Math.random()*(max-min+1)+min);
		this.receipt = receipt;
		this.employee = employee;
	}
	
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
}

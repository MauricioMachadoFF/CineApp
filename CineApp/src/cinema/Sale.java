package cinema;

public class Sale {
	private int saleId;
	private Receipt receipt = new Receipt();
	private Employee employee = new Employee();
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
}

package cinema;

public class Receipt {
	private String clientCPF;
	private double total;
	private String paymentMethod;
	private int id;
	private Ticket[] tickets = new Ticket[10];
	private Snack[] snacks = new Snack[50];
	private Beverage[] beverages = new Beverage[50];
	
	public String getClientCPF() {
		return clientCPF;
	}
	public double getTotal() {
		return total;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public int getId() {
		return id;
	}
	public void setClientCPF(String clientCPF) {
		this.clientCPF = clientCPF;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

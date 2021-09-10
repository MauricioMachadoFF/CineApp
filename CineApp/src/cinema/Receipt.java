package cinema;
import java.util.ArrayList;

public class Receipt {
	private String clientCPF;
	private double total;
	private String paymentMethod;
	private int id;
	private Ticket tickets;
	private Snack snacks;
	private Beverage beverages;
	final int max = 10000;
	final int min = 1;
	
	public Receipt(String clientCPF, double total, String paymentMethod) {
		this.clientCPF = clientCPF;
		this.total = total;
		this.paymentMethod = paymentMethod;
		this.id = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public Receipt(double total, String paymentMethod) {
		this.total = total;
		this.paymentMethod = paymentMethod;
		this.id = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
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

	public Ticket getTickets() {
		return tickets;
	}

	public Snack getSnacks() {
		return snacks;
	}

	public Beverage getBeverages() {
		return beverages;
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
		this.id = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public String toString() {
		return new String()
			.concat("------RESUMO DA COMPRA-------")
			
			.concat("\nValor: " + this.total +" reais")
			.concat("\nMétodo de pagamento: " + this.paymentMethod)
			;
	}
	
}

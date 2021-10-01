package model;

import java.util.ArrayList;

public class Sale {
	private int saleId;
	private Employee employee;
	private ArrayList<Session> tickets = new ArrayList<Session>();
	private ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	private ArrayList<Snack> snacks = new ArrayList<Snack>();
	private double total;
	private String paymentMethod;
	private String clientCPF;
	final int max = 10000;
	final int min = 1;

	public Sale(Employee employee, String clientCPF, double total, String paymentMethod, ArrayList<Beverage> beverages, ArrayList<Snack> snacks, Session tickets) {
		this.saleId=(int)Math.floor(Math.random()*(max-min+1)+min);
		this.employee = employee;
		this.clientCPF = clientCPF;
		this.total = total;
		this.paymentMethod = paymentMethod;
		this.beverages = beverages;
		this.snacks = snacks;		
		this.tickets.add(tickets);
	}
	
	public Sale() {
		this.saleId=(int)Math.floor(Math.random()*(max-min+1)+min);
	}

	public int getSaleId() {
		return saleId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public ArrayList<Snack> getSnacks() {
		return snacks;
	}

	public double getTotal() {
		return total;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public String getClientCPF() {
		return clientCPF;
	}
	

	public ArrayList<Session> getTickets() {
		return tickets;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}

	public void setSnacks(ArrayList<Snack> snacks) {
		this.snacks = snacks;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public void setClientCPF(String clientCPF) {
		this.clientCPF = clientCPF;
	}
	
	public void setTickets(ArrayList<Session> tickets) {
		this.tickets = tickets;
	}
	
	public void addTicket(Session ticket) {
		// TODO Auto-generated method stub
		this.tickets.add(ticket);
	} 
	
	public String toString() {
		return new String("Funcionário Responsável: " + this.employee)
			.concat("\nTickets: " + this.tickets)
//			.concat("\nComidas: " + this.beverages + this.snacks)
//			.concat("\nTotal: " + this.total)
			.concat("\nclientCPF: ") + this.clientCPF;
	}
}
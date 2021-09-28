package model;

import java.util.ArrayList;

public class Sale {
	private int saleId;
	private Employee employee;
//	private ArrayList<Ticket> tickets = new ArrayList<Ticket>;
	private ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	private ArrayList<Snack> snacks = new ArrayList<Snack>();
	private double total;
	private String paymentMethod;
	final int max = 10000;
	final int min = 1;

	public Sale(Employee employee) {
		this.saleId=(int)Math.floor(Math.random()*(max-min+1)+min);
		this.employee = employee;
		
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
	
}
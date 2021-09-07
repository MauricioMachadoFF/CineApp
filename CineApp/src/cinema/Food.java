package cinema;

import java.util.Date;

public abstract class Food {
	protected String name;
	protected double price;
	protected int stockQuantity;
	protected int batch;
	protected Date expirationDate;
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public int getBatch() {
		return batch;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}



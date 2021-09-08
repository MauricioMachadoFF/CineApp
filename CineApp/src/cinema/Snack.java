package cinema;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Snack extends Food {
	
	private boolean isSweet;
	

	public Snack(String nameSnack, 
				double snackPrice,
				int snackStockQuantity,
				int snackBatch,
				boolean sweetSnack)
	{
	
		name = nameSnack;
		price = snackPrice;
		stockQuantity = snackStockQuantity;
		batch = snackBatch;
		/*expirationDate = snackExpirationDate;*/
		isSweet = sweetSnack;
		
	}
	
	
	public String getName() {
		
		return super.getName();
	}


	public double getPrice() {
		
		return super.getPrice();
	}

	
	public int getStockQuantity() {
		
		return super.getStockQuantity();
	}

	
	public int getBatch() {
		
		return super.getBatch();
	}

	
	public Date getExpirationDate() {
		
		return super.getExpirationDate();
	}

	public boolean getIsSweet() {
		return isSweet;
	}

	
	
	public void setName(String name) {
		
		super.setName(name);
	}

	
	public void setPrice(double price) {
		
		super.setPrice(price);
	}

	
	public void setStockQuantity(int stockQuantity) {
		
		super.setStockQuantity(stockQuantity);
	}

	
	public void setBatch(int batch) {
		
		super.setBatch(batch);
	}


	public void setExpirationDate(Date expirationDate) {
		
		super.setExpirationDate(expirationDate);
	}

	public void setIsSweet(boolean isSweet) {
		this.isSweet = isSweet;
	}
	
	
	//readFood
	public String toString() {
		return new String("Nome: " + this.name + "\n")
				.concat("Valor: R$ " + this.price + "\n")
				.concat("Quantidade em estoque: " + this.stockQuantity + "\n")
				.concat("Lote: " + this.batch + "\n")
				.concat("Data de vencimento: " + this.expirationDate + "\n");
	}
	
}
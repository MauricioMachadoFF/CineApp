package cinema;

import java.util.Date;

public class Snack extends Food {
	private boolean isSweet;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice();
	}

	@Override
	public int getStockQuantity() {
		// TODO Auto-generated method stub
		return super.getStockQuantity();
	}

	@Override
	public int getBatch() {
		// TODO Auto-generated method stub
		return super.getBatch();
	}

	@Override
	public Date getExpirationDate() {
		// TODO Auto-generated method stub
		return super.getExpirationDate();
	}

	public boolean getIsSweet() {
		return isSweet;
	}

	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		super.setPrice(price);
	}

	@Override
	public void setStockQuantity(int stockQuantity) {
		// TODO Auto-generated method stub
		super.setStockQuantity(stockQuantity);
	}

	@Override
	public void setBatch(int batch) {
		// TODO Auto-generated method stub
		super.setBatch(batch);
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		// TODO Auto-generated method stub
		super.setExpirationDate(expirationDate);
	}

	public void setIsSweet(boolean isSweet) {
		this.isSweet = isSweet;
	}

}



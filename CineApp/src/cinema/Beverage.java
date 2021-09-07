package cinema;

import java.util.Date;

public class Beverage extends Food {
	
	private boolean hasIce;
	private boolean isDiet;
	private boolean hasStraw;
	private int size;
	

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
	
	public boolean getHasIce() {
		return hasIce;
	}

	public boolean getisDiet() {
		return isDiet;
	}

	public boolean getHasStraw() {
		return hasStraw;
	}

	public int getSize() {
		return size;
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

	public void setHasIce(boolean hasIce) {
		this.hasIce = hasIce;
	}

	public void setisDiet(boolean isDiet) {
		this.isDiet = isDiet;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setHasStraw(boolean hasStraw) {
		this.hasStraw = hasStraw;
	}
	
	
	
	
}

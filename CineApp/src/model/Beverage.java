package model;

public class Beverage extends Food {
	private boolean isDiet;
	private boolean hasIce;
	private boolean hasStraw;
	
	public Beverage(){
		super();
	}
	
	public Beverage(String nameB, double priceB, int stockQuantityB, int batchB, boolean diet, boolean ice, boolean straw){
		this.name = nameB;
		this.price = priceB;
		this.stockQuantity = stockQuantityB;
		this.batch = batchB;
		this.isDiet = diet;
		this.hasIce = ice;
		this.hasStraw = straw;
		
	}
	
	public String toString() {
		return new String("Nome: " + this.name + "\n")
				.concat("Valor: R$ " + this.price + "\n")
				.concat("Quantidade em estoque: " + this.stockQuantity + "\n")
				.concat("Lote: " + this.batch + "\n");
	}
	
	public boolean getHasIce() {
		return hasIce;
	}

	public boolean getHasStraw() {
		return hasStraw;
	}

	public boolean getIsDiet() {
		return isDiet;
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

	public void setHasIce(boolean hasIce) {
		this.hasIce = hasIce;
	}
	
	public void setHasStraw(boolean hasStraw) {
		this.hasStraw = hasStraw;
	}
	
	public void setDiet(boolean isDiet) {
		this.isDiet = isDiet;
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
}

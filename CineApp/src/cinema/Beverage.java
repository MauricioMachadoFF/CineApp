package cinema;

import java.util.Date;

public class Beverage extends Food {
	
	private boolean hasIce;
	private boolean isDiet;
	private boolean hasStraw;
	private int size;
	
	public Beverage(String nameDrink, 
				double drinkPrice,
				int drinkStockQuantity,
				int drinkBatch,
				boolean withIce,
				boolean dietDrink,
				boolean withStraw,
				int cupSize) 
	{
		name = nameDrink;
		price = drinkPrice;
		stockQuantity = drinkStockQuantity;
		batch = drinkBatch;
		hasIce = withIce;
		isDiet = dietDrink;
		hasStraw = withStraw;
		size = cupSize;
		/*expirationDate = drinkExpirationDate;*/
	}
	

	@Override
	public String getName() {
	
		return super.getName();
	}

	@Override
	public double getPrice() {
	
		return super.getPrice();
	}

	@Override
	public int getStockQuantity() {
	
		return super.getStockQuantity();
	}

	@Override
	public int getBatch() {

		return super.getBatch();
	}

	@Override
	public Date getExpirationDate() {

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

		super.setName(name);
	}

	@Override
	public void setPrice(double price) {

		super.setPrice(price);
	}

	@Override
	public void setStockQuantity(int stockQuantity) {

		super.setStockQuantity(stockQuantity);
	}

	@Override
	public void setBatch(int batch) {

		super.setBatch(batch);
	}

	@Override
	public void setExpirationDate(Date expirationDate) {

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
	
	//readFood
		public String toString() {
			return new String("Nome: " + this.name + "\n")
					.concat("Valor: R$ " + this.price + "\n")
					.concat("Quantidade em estoque: " + this.stockQuantity + " copos\n")
					.concat("Lote: " + this.batch + "\n")
					.concat("Data de vencimento: " + this.expirationDate + "\n")
					.concat("Com gelo? " + this.hasIce + "\n")
					.concat("Com canudo? " + this.hasStraw + "\n")
					.concat("Diet: " + this.isDiet + "\n")
					.concat("Tamanho " + this.size + " ml\n");
		}
	
	
}

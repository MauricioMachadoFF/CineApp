package model;

/**
 * Classe responsável pela criação de objetos do tipo Snack/comida
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 *
 */
public class Snack extends Food {
	private boolean isSweet;
	
	public Snack(){
		super();
	}
	
	public Snack(String nameSnack, double snackPrice, int snackStockQuantity, int snackBatch, boolean sweetSnack){
		this.name = nameSnack;
		this.price = snackPrice;
		this.stockQuantity = snackStockQuantity;
		this.batch = snackBatch;
		this.isSweet = sweetSnack;
		
	}
	
	/**
	 * Pega todos os dados relevantes do objetos e transforma em uma String.
	 */
	public String toString() {
		return new String("Nome: " + this.name + "\n")
				.concat("Valor: R$ " + this.price + "\n")
				.concat("Quantidade em estoque: " + this.stockQuantity + "\n")
				.concat("Lote: " + this.batch + "\n");
	}

	public boolean getIsSweet() {
		return isSweet;
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

	public void setSweet(boolean isSweet) {
		this.isSweet = isSweet;
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

package cinema;

import java.util.Date;
import java.util.Scanner;

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
	
		
	//update beverages information
	public void updateBeverages() {
		int option, qtyRegister, auxiliar;
		int iceOrNot, strawOrNot, dietOrNot, size;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Qual dado deseja editar?");
		System.out.println("1- Nome \n2- Preco \n3-Estoque \n4- Lote \n5- Gelo \n6- Canudo \n7- Diet \n8- Size");
		auxiliar=ler.nextInt();
					
		switch(auxiliar) {
			case 1:
				System.out.println("\nDigite o novo nome:");
				ler.nextLine();
				name=ler.nextLine();
				setName(name);
				break;
							
			case 2:
				System.out.println("\nDigite o novo preco:");
				ler.nextLine();
				price=ler.nextDouble();
				setPrice(price);
				break;
							
			case 3:
				System.out.println("\nDigite o novo estoque:");
				ler.nextLine();
				stockQuantity=ler.nextInt();
				setStockQuantity(stockQuantity);
				break;
							
				case 4:
				System.out.println("\nDigite o novo lote:");
				ler.nextLine();
				batch=ler.nextInt();
				setBatch(batch);
				break;
							
				case 5:
					do {
						System.out.println("A bebida vai acompanhada de gelo? |1|Sim |2|Não");
						iceOrNot = ler.nextInt();
								
						if (iceOrNot==1) {
							hasIce=true;
						} else if (iceOrNot==2) {
							hasIce=false;
						}
					} while (iceOrNot!=1 && iceOrNot!=2);
					setHasIce(hasIce);
					break;
							
				case 6:
					do {
						System.out.println("A bebida vai acompanhada de canudo? |1|Sim |2|Não");
						strawOrNot = ler.nextInt();
								
						if (strawOrNot==1) {
							hasStraw=true;
						} else if (strawOrNot==2) {
							hasStraw=false;
						}
					} while (strawOrNot!=1 && strawOrNot!=2);
					setHasStraw(hasStraw);
					break;
							
				case 7:
					do {
						System.out.println("A bebida é Diet? |1|Sim |2|Não");
						dietOrNot = ler.nextInt();
								
						if (dietOrNot==1) {
							isDiet=true;
						} else if (dietOrNot==2) {
							isDiet=false;
						}
					} while (dietOrNot!=1 && dietOrNot!=2);
					setisDiet(isDiet);
					break;
							
				case 8:
					System.out.println("Digite o novo tamanho da bebida (em ml)?");
					System.out.println("Tamanhos disponiveis: 300, 400 ou 500");
					size = ler.nextInt();
					setSize(size);
					break;
							
				default:
					System.out.println("Opcao Invalida");
					break;
		}
					
		System.out.println(toString());
	}
	
}

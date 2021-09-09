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
	
	//update snacks information
		public void updateSnacks() {
			int option, qtyRegister, auxiliar;
			int sweetOrNot;
			Scanner ler = new Scanner(System.in);
			
			
			System.out.println("Qual dado deseja editar?");
			System.out.println("1- Nome \n2- Preco \n3-Estoque \n4- Lote \n5- Doce ou Salgado");
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
					System.out.println("Esse alimento é: |1|Doce |2|Salgado");
					ler.nextLine();
					sweetOrNot = ler.nextInt();
					
					if (sweetOrNot==1) {
						isSweet=true;
					} else if (sweetOrNot==2) {
						isSweet=false;
					}
				} while (sweetOrNot!=1 && sweetOrNot!=2);
				setIsSweet(isSweet);
				break;
			default:
				System.out.println("Opcao Invalida");
				break;
			}
			
			System.out.println(toString());
		}
}
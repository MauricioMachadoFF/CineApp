package cinema;

import java.util.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int item;
		Scanner ler = new Scanner(System.in);
		//variables helpers 
		int idGenMin = 1;
		int idGenMax = 100000;
		
		//Objects 
		//Employee
//		Employee[] employees = new Employee[employeeLimiter];
		ArrayList<Employee> employee = new ArrayList<Employee>();
		employee.add(new Employee(
					"Ednaldo Pereira",
		        	"+45 999791110",
		        	"79748916430",
		        	342
				));
		employee.add( new Employee(
					"Roberto Carlos",
					"+61 941877487",
					"01907132411",
					617
				));
		employee.add( new Employee(
				"Steve Rogers",
		        "+61 911675293",
		        "82127519391",
		        147
			));
		employee.add( new Employee(
				"Pablo Escobar",
		        "+61 936070288",
		        "18172761160",
		        455
			));
		employee.add( new Employee(
				"Peter Parker",
		        "+61 973435068",
		        "25238410342",
		        887
			));
		
		//Snacks
		ArrayList<Snack> snacks = new ArrayList<Snack>();
				
		//Beverage
		ArrayList<Beverage> beverage = new ArrayList<Beverage>();
		
		//Data for the objects --> If Possible we should separate the prev data in a snigle file
		
		
		//Ids
		int id;
		
		
		
		do {
			System.out.print("\n**Menu**\n"
					+ "1- Do Something\n"
					+ "2- LANCHES\n"
					+ "3- Cadastrar bebidas\n"
					+ "4- EMPLOYEE'S SECTION\n"
					+ "7- Sair\n");
			System.out.print("O que você deseja fazer: ");
			item = ler.nextInt();
			
			switch(item) {
				case 1:
//					id = (int)Math.floor(Math.random()*(idGenMax-idGenMin+1)+idGenMin);
//					System.out.println(id);
//					
//					//register Employee
//					employees[2] = new Employee("Roberto", "24526", "7458340", 
//							(int)Math.floor(Math.random()*(idGenMax-idGenMin+1)+idGenMin));
//					System.out.println(employees[2].toString());
//					
//					//delete Employee
//					//employees[1].deleteEmployee();
//					
//					//Get Employee Info
//					for(int i = 0; i < 6; i++) {
//						System.out.println(employees[i].toString());
//					}
//					//System.out.println(employees[1].toString());
					
					
					break;
				case 2:
					//register Snack
					
					snackSession(snacks);
					
					//delete Snack
					//snacks.remove(0);
					//System.out.println(snacks);
					
					break;
				case 3:
					//register Beverage
					beverage.add(new Beverage("Suco", 3.70, 20, 555, true, false, true, 300));
					System.out.println(beverage);
					
					//delete Beverage
					beverage.remove(0);
					System.out.println(beverage);

					break;
				case 4:
					employeeSection(employee, idGenMax, idGenMin);
					break;
				case 7:
					System.out.println("Até mais");
					break;
				default:
					break;
			}
		} while (item != 7); 
	}
	
	public static void employeeSection(ArrayList<Employee> employeeList, int max, int min) {
		int option, employeeCode;
		Scanner ler = new Scanner(System.in);
		String name, cellphone, CPF;
		int id;
		
		do {
			System.out.print("\n** EMPLOYEE'S SECTION **\n"
					+ "1- Register User\n"
					+ "2- Get All Users\n"
					+ "3- Get User By Id\n"
					+ "4- Update User\n"
					+ "5- Delete User\n"
					+ "6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			option = ler.nextInt();
			switch(option) {
			
				case 1:
					System.out.print("Let's register a employee!!!\n");
					System.out.print("What's his/her name:\n");
					ler.nextLine();
					name = ler.nextLine();
					System.out.print("What's his/her cellphone (without white spaces):\n");
					cellphone = ler.nextLine();	
					System.out.print("What's his/her CPF:\n");
					CPF = ler.nextLine();
					
					employeeList.add( new Employee(name, cellphone, CPF, (int)Math.floor(Math.random()*(max-min+1)+min)));
					System.out.print("Employee created!!!");
					System.out.println(employeeList.get(employeeList.size()-1).toString());
					break;
					
				case 2:
					for(int i = 0; i < employeeList.size(); i++) {
						System.out.println(employeeList.get(i).toString() + "\n");
					}
					break;
				case 3:
					System.out.println("Whta's the employee code?");
					employeeCode = ler.nextInt();
					
					for(int i = 0; i < employeeList.size(); i++) {
						if(employeeList.get(i).getEmployeeCode() == employeeCode) {
							System.out.println(employeeList.get(i).toString());
						}
					}
					break;
				case 5:
					System.out.println("Whta's the employee code you want to delete?");
					employeeCode = ler.nextInt();
					for(int i = 0; i < employeeList.size(); i++) {
						if(employeeList.get(i).getEmployeeCode() == employeeCode) {
							employeeList.remove(i);
						}
					}
					break;
				case 6:
					System.out.println("Voltando ao menu principal ...");
					break;
			} 
			
		}
		while(option != 6);
	}
	
	
	public static void snackRegister(ArrayList<Snack> snacks) {
		int option, qtyRegister;
		String name;
		double price;
		int stock, batch, sweetOrNot;
		boolean isSweet=true;
		Scanner ler = new Scanner(System.in);
		
		
	}
	
	public static void snackSession(ArrayList<Snack> snacks) {
		int option, qtyRegister, auxiliar;
		String name, editName;
		double price;
		int stock, batch, sweetOrNot;
		boolean isSweet=true;
		Scanner ler = new Scanner(System.in);
		
		
		do {
			System.out.print("\n** LANCHES **\n"
					+ "1- Cadastrar Lanche\n"
					+ "2- Atualizar Lanche\n"
					+ "3- Apagar Lanche\n"
					+ "4- Imprimir lanches disponíveis\n"
					+ "5- Vender\n"
					+ "6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			option = ler.nextInt();
			switch(option) {
			
				case 1:
					System.out.println("Quantos lanches você deseja cadastrar?");
					qtyRegister = ler.nextInt();
					for (int i = 0; i<qtyRegister; i++) {
						
						System.out.println("\nQual é o nome do alimento?");
						ler.nextLine();
						name = ler.nextLine();
						
						System.out.println("Qual é o preço? (Utilize . para separar os decimais)");
						price = ler.nextDouble();
						
						System.out.println("Qual é a quantidade em estoque?");
						stock = ler.nextInt();
						
						System.out.println("Qual é o lote?");
						batch = ler.nextInt();
						
						System.out.println("Qual é a data de vencimento?");
						//ler data
						do {
							System.out.println("Esse alimento é: |1|Doce |2|Salgado");
							sweetOrNot = ler.nextInt();
							
							if (sweetOrNot==1) {
								isSweet=true;
							} else if (sweetOrNot==2) {
								isSweet=false;
							}
						} while (sweetOrNot!=1 && sweetOrNot!=2);
						
						snacks.add(new Snack(name, price, stock, batch, isSweet));
						System.out.println("Cadastro realizado!");
						System.out.println(snacks.get(snacks.size()-1).toString());
						System.out.println("");
					}
					break;
					
				case 2:
					
					System.out.println("\nQual é o nome do alimento que deseja editar?");
					ler.nextLine();
					name=ler.nextLine();
					System.out.println("Qual dado deseja editar?");
					System.out.println("1- Nome \n2- Preco \n3-Estoque \n4- Lote \n5- Doce ou Salgado");
					auxiliar=ler.nextInt();
					
					for(int i = 0; i < snacks.size(); i++) {
						if(snacks.get(i).getName().equals(name)) {
							
							switch(auxiliar) {
							case 1:
								System.out.println("\nDigite o novo nome:");
								ler.nextLine();
								name=ler.nextLine();
								snacks.get(i).setName(name);
								break;
								
							case 2:
								System.out.println("\nDigite o novo preco:");
								ler.nextLine();
								price=ler.nextDouble();
								snacks.get(i).setPrice(price);
								break;
								
							case 3:
								System.out.println("\nDigite o novo estoque:");
								ler.nextLine();
								stock=ler.nextInt();
								snacks.get(i).setStockQuantity(stock);
								break;
								
							case 4:
								System.out.println("\nDigite o novo lote:");
								ler.nextLine();
								batch=ler.nextInt();
								snacks.get(i).setBatch(batch);
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
								snacks.get(i).setIsSweet(isSweet);
								break;
							default:
								System.out.println("Opcao Invalida");
								break;
							}
							
						}
					}
					
					System.out.println(snacks.get(snacks.size()-1).toString());
					
					break;
				case 3:

					System.out.println("\nQual é o nome do lanche que deseja deletar?");
					ler.nextLine();
					name=ler.nextLine();
					
					for(int i = 0; i < snacks.size(); i++) {
						if(snacks.get(i).getName().equals(name)) {
							snacks.remove(i);
							System.out.println("\nLanche deletado!");
						}
					}
					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				default:
					System.out.println("Opcao Invalida");
					break;
			} 
			
		}
		while(option != 6);
	}
	
}

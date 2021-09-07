package cinema;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int item;
		Scanner ler = new Scanner(System.in);
		//variables helpers
		int employeeLimiter = 50; 
		int employeeCount = 5;
		int idGenMin = 1;
		int idGenMax = 100000;
		
		//Objects 
		//Employee
		Employee[] employees = new Employee[employeeLimiter];
		employees[0] = new Employee(
					"Ednaldo Pereira",
		        	"+45 999791110",
		        	"79748916430",
		        	342
				);
		employees[1] = new Employee(
					"Roberto Carlos",
					"+61 941877487",
					"01907132411",
					617
				);
		employees[2] = new Employee(
				"Steve Rogers",
		        "+61 911675293",
		        "82127519391",
		        147
			);
		employees[3] = new Employee(
				"Pablo Escobar",
		        "+61 936070288",
		        "18172761160",
		        455
			);
		employees[4] = new Employee(
				"Peter Parker",
		        "+61 973435068",
		        "25238410342",
		        887
			);
		
		//Data for the objects --> If Possible we should separate the prev data in a snigle file
		//Employee
		
		
		//Ids
		int id;
		
		
		
		do {
			System.out.print("\n**Menu**\n"
					+ "1- Do Something\n"
					+ "2- EMPLOYEE'S SECTION\n"
					+ "7- Sair\n");
			System.out.print("O que você deseja fazer: ");
			item = ler.nextInt();
			
			switch(item) {
				case 1:
					id = (int)Math.floor(Math.random()*(idGenMax-idGenMin+1)+idGenMin);
					System.out.println(id);
					
					//register Employee
					employees[2] = new Employee("Roberto", "24526", "7458340", 
							(int)Math.floor(Math.random()*(idGenMax-idGenMin+1)+idGenMin));
					System.out.println(employees[2].toString());
					
					//delete Employee
					//employees[1].deleteEmployee();
					
					//Get Employee Info
					for(int i = 0; i < 6; i++) {
						System.out.println(employees[i].toString());
					}
					//System.out.println(employees[1].toString());
					
					
					break;
					
				case 2:
					employeeCount = employeeSection(employees, employeeCount, idGenMax, idGenMin);
					break;
				case 7:
					System.out.println("Até mais");
					break;
				default:
					break;
			}
		} while (item != 7); 
	}
	
	public static int employeeSection(Employee[] employees, int count, int max, int min) {
		int option;
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
					+ "7- Sair\n");
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
					
					employees[count + 1] = new Employee(name, cellphone, CPF, (int)Math.floor(Math.random()*(max-min+1)+min));
					System.out.print("Employee created!!!");
					System.out.println(employees[count +1].toString());
					count++;
					break;
			
				case 7:
					System.out.println("Voltando ao menu principal ...");
					break;
				
			
			} 
			
		}
		while(option != 7);
		
		return count;
	}
	
}

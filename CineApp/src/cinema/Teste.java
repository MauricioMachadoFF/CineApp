package cinema;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int item;
		Scanner ler = new Scanner(System.in);
		//variables helpers
		int employeeLimiter = 50; 
		int employeeCount = 0;
		int idGenMin = 1;
		int idGenMax = 100000;
		
		//Objects 
		//Employee
		Employee[] employees = new Employee[employeeLimiter];
		employees[1] = new Employee();
		
		//Data for the objects --> If Possible we should separate the prev data in a snigle file
		//Employee
		
		
		//Ids
		int id;
		
		
		
		do {
			System.out.print("\n**Menu**\n"
					+ "1- Do Something\n"
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
					System.out.println(employees[1].toString());
					
					
					break;
				case 7:
					System.out.println("Até mais");
					break;
				default:
					break;
			}
		} while (item != 7); 
	}

}

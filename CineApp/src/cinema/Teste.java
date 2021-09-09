package cinema;

import java.text.ParseException;
import java.util.*;
import java.util.function.Predicate;

public class Teste {

	public static void main(String[] args) throws ParseException {
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
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add( new Movie(
				"Creed",
				2015,
				"Action",
				"The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
				10
			));
		movies.add( new Movie(
				"Attack on Titan",
				2014,
				"Anime",
				"After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.",
				56
			));
		movies.add( new Movie(
				"Room",
				2016,
				"Horror",
				"Held captive for 7 years in an enclosed space, a woman and her young son finally gain their freedom, allowing the boy to experience the outside world for the first time.",
				34
			));
		
		//MovieRoom
		ArrayList<MovieRoom> rooms = new ArrayList<MovieRoom>();
		rooms.add( new MovieRoom(
					1
				));
		
		//Session
		ArrayList<Session> sessions = new ArrayList<Session>();
		sessions.add( new Session(
					"2009-12-24 12:30",
					rooms.get(0),
					movies.get(0)
				));
		
		
		
		//Snacks
		ArrayList<Snack> snacks = new ArrayList<Snack>();
				
		//Beverage
		ArrayList<Beverage> beverage = new ArrayList<Beverage>();
		
		//MovieRoom
		ArrayList<Ticket> ticket = new ArrayList<Ticket>();
		
		//Data for the objects --> If Possible we should separate the prev data in a snigle file
		
		
		//Ids
		int id;
		
		
		
		do {
			System.out.print("\n**Menu**\n"
					+ "1- FILMES\n"
					+ "2- LANCHES\n"
					+ "3- BEBIDAS\n"
					+ "4- FUNCIONARIOS\n"
					+ "5- SESSOES\n"
					+ "6- MOVIE ROOM\n"
					+ "7- INGRESSO\n"
					+ "8- RECIBO TOTAL\n"
					+ "9- Sair\n"
					);
			System.out.print("O que você deseja fazer: ");
			item = ler.nextInt();
			
			switch(item) {
				case 1:
					moviesSection(movies);
					break;
				case 2:
					snackSession(snacks);
					break;
				case 3:
					beverageSession(beverage);
					break;
				case 4:
					employeeSection(employee, idGenMax, idGenMin);
					break;
					
				case 5:
					System.out.println(sessions.get(0).toString());
					break;
					
				case 6:
					roomSection(rooms);
					break;
					
				case 7:
					ticketSession(ticket, sessions);
					
					break;
					
				case 8:
					
					break;
					
				case 9:
					System.out.println("Até mais");
					break;
				default:
					break;
			}
		} while (item != 9); 
	}
	
	public static void roomSection(ArrayList<MovieRoom> rooms) {
		int option;
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		do {
			System.out.print("\n** SALAS **\n"
					+ "1- Registrar Nova Sala\n"
					+ "2- Ver Todas Salas\n"
					+ "4- Atualizar Filme\n"
					+ "5- Deletar Sala\n"
					+ "6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			option = ler.nextInt();
			
			switch(option) {
				
				case 1:
			
					break;
					
				case 2:
					
				case 3:

					break;
					
				case 4:
					break;
				
				case 5:

					break;
					
				case 6:
					System.out.println("Voltando ao menu principal!");
					break;
					
				default:
					System.out.println("Opcao Invalida");
					break;
			}
			
		} while(option != 6);
		
	}
	
	public static void moviesSection(ArrayList<Movie> movies) {
		int option, movieId, auxiliar, posMovie = 0;
		Scanner ler = new Scanner(System.in).useDelimiter("\n");
		do {
			System.out.print("\n** FILMES **\n"
					+ "1- Registrar Novo Filme\n"
					+ "2- Ver Todos Filmes\n"
					+ "3- Procurar Filme por Id\n"
					+ "4- Atualizar Filme\n"
					+ "5- Deletar Filme\n"
					+ "6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			option = ler.nextInt();
			
			switch(option) {
				
				case 1:
					movies.add( new Movie());
					System.out.println(movies.get(movies.size()-1).toString());
					break;
					
				case 2:
					for(Movie movie : movies) {
						System.out.println(movie.toString());
						System.out.println();
					} 
					break;
					
				case 3:
					System.out.println("Id do filme: ");
					movieId = ler.nextInt();
					for(Movie movie: movies) {
						if(movie.getMovieId() == movieId) {
							System.out.println(movie.toString());
						}
					}
					break;
					
				case 4:
					System.out.println("\nQual o código do filme que você deseja editar?");
					//ler.nextLine();
					movieId=ler.nextInt();
					for(Movie movie : movies) {
						if(movie.getMovieId() == movieId) {
							movie.updateMovie();
						}
					}
					break;
				
				case 5:
					System.out.println("Id do filme: ");
					movieId = ler.nextInt();
					for(int i = 0; i < movies.size(); i++) {
						if(movies.get(i).getMovieId() == movieId) {
							movies.remove(i);
						}
					}
					System.out.println("Filme deletado!");
					break;
					
				case 6:
					System.out.println("Voltando ao menu principal!");
					break;
					
				default:
					System.out.println("Opcao Invalida");
					break;
			}
			
		} while(option != 6);
	}
	
	public static void employeeSection(ArrayList<Employee> employeeList, int max, int min) {
		int option, employeeCode, auxiliar, posEmployee=0;
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
					System.out.print("Vamos registrar um funcionário!!!\n");
					System.out.print("Nome:\n");
					ler.nextLine();
					name = ler.nextLine();
					System.out.print("Número de celular (sem espaços):\n");
					cellphone = ler.nextLine();	
					System.out.print("CPF:\n");
					CPF = ler.nextLine();
					
					employeeList.add( new Employee(name, cellphone, CPF, (int)Math.floor(Math.random()*(max-min+1)+min)));
					System.out.print("Funcionário criado!!!");
					System.out.println(employeeList.get(employeeList.size()-1).toString());
					break;
					
				case 2:
					for(int i = 0; i < employeeList.size(); i++) {
						System.out.println(employeeList.get(i).toString() + "\n");
					}
					break;
				case 3:
					System.out.println("Código do funcionário: ");
					employeeCode = ler.nextInt();
					
					for(int i = 0; i < employeeList.size(); i++) {
						if(employeeList.get(i).getEmployeeCode() == employeeCode) {
							System.out.println(employeeList.get(i).toString());
						}
					}
					break;
				case 4:
					System.out.println("\nQual o código do funcionário que você deseja editar?");
					//ler.nextLine();
					employeeCode=ler.nextInt();
					for(Employee employee : employeeList) {
						if(employee.getEmployeeCode() == employeeCode) {
							employee.updateEmployee();
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
					System.out.println("Funcionario deletado!");
					break;
				case 6:
					System.out.println("Voltando ao menu principal ...");
					break;
			} 
			
		}
		while(option != 6);
	}
	
	public static void snackSession(ArrayList<Snack> snacks) {
		int option, qtyRegister, auxiliar;
		String name, editName;
		double price;
		int stock, batch, sweetOrNot, sale;
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
					
					for(int i = 0; i < snacks.size(); i++) {
						if(snacks.get(i).getName().equals(name)) {
							snacks.get(i).updateSnacks();
			
							System.out.println(snacks.get(snacks.size()-1).toString());
						}
					}
			
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
					System.out.println("\nLanches com estoque disponível:");
					for(int i = 0; i < snacks.size(); i++) {
						if(snacks.get(i).getStockQuantity()>0) {
							System.out.println(snacks.get(i).getName());
						}
					}
					
					break;
				case 5:
					System.out.println("\n**SISTEMA DE VENDAS**");
					System.out.println("Digite o nome do lanche:");
					ler.nextLine();
					name=ler.nextLine();
					
					for(int i = 0; i < snacks.size(); i++) {
						if(snacks.get(i).getName().equals(name)) {
							if(snacks.get(i).getStockQuantity()>0) {
								do {
									System.out.println("Quantidade vendida:");
									sale=ler.nextInt();
									if(sale>snacks.get(i).getStockQuantity()) {
										System.out.println("Quantidade em estoque: " + snacks.get(i).getStockQuantity());
										System.out.println("Insira uma quantidade válida");
									}
								}while(sale>snacks.get(i).getStockQuantity());
								
								snacks.get(i).setStockQuantity(snacks.get(i).getStockQuantity()-sale);
								System.out.println("Venda Efetuada");
							} else {System.out.println("Produto esgotado!");}
							
						}
					}
					break;
				case 6:
					System.out.println("Voltando ao menu principal ...");
					break;
				default:
					System.out.println("Opcao Invalida");
					break;
			} 
			
		}
		while(option != 6);
	}
	

	public static void beverageSession(ArrayList<Beverage> beverages) {
		int option, qtyRegister, auxiliar, size;
		String name, editName;
		double price;
		int stock, batch, iceOrNot, strawOrNot, dietOrNot, sale;
		boolean whithIce=true, whithStraw=false, isDiet=false;
		Scanner ler = new Scanner(System.in);
		
		
		do {
			System.out.print("\n** BEBIDAS **\n"
					+ "1- Cadastrar Bebida\n"
					+ "2- Atualizar Bebida\n"
					+ "3- Apagar Bebida\n"
					+ "4- Imprimir Bebidas Disponíveis\n"
					+ "5- Vender\n"
					+ "6- Sair\n");
			System.out.print("O que você deseja fazer: ");
			option = ler.nextInt();
			switch(option) {
			
				case 1:
					System.out.println("Quantas bebidas você deseja cadastrar?");
					qtyRegister = ler.nextInt();
					for (int i = 0; i<qtyRegister; i++) {
						
						System.out.println("\nQual é o nome da bebida?");
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
							System.out.println("A bebida vai acompanhada de gelo? |1|Sim |2|Não");
							iceOrNot = ler.nextInt();
							
							if (iceOrNot==1) {
								whithIce=true;
							} else if (iceOrNot==2) {
								whithIce=false;
							}
						} while (iceOrNot!=1 && iceOrNot!=2);
						
						do {
							System.out.println("A bebida vai acompanhada de canudo? |1|Sim |2|Não");
							strawOrNot = ler.nextInt();
							
							if (strawOrNot==1) {
								whithStraw=true;
							} else if (strawOrNot==2) {
								whithStraw=false;
							}
						} while (iceOrNot!=1 && iceOrNot!=2);
						
						do {
							System.out.println("A bebida é Diet? |1|Sim |2|Não");
							dietOrNot = ler.nextInt();
							
							if (dietOrNot==1) {
								isDiet=true;
							} else if (dietOrNot==2) {
								isDiet=false;
							}
						} while (dietOrNot!=1 && dietOrNot!=2);
						
						System.out.println("Qual é o tamanho da bebida (em ml)?");
						System.out.println("Tamanhos disponiveis: 300, 400 ou 500");
						size = ler.nextInt();
						
						
						beverages.add(new Beverage(name, price, stock, batch, whithIce, isDiet, whithStraw, size));
						
						System.out.println("Cadastro realizado!");
						System.out.println(beverages.get(beverages.size()-1).toString());
						System.out.println("");
					}
					break;
					
				case 2:
					System.out.println("\nQual é o nome da bebida que deseja editar?");
					ler.nextLine();
					name=ler.nextLine();
					
					for(int i = 0; i < beverages.size(); i++) {
						if(beverages.get(i).getName().equals(name)) {
							beverages.get(i).updateBeverages();
			
							System.out.println(beverages.get(beverages.size()-1).toString());
						}
					}
			
					break;
				case 3:
					System.out.println("\nQual é o nome da bebida que deseja deletar?");
					ler.nextLine();
					name=ler.nextLine();
					
					for(int i = 0; i < beverages.size(); i++) {
						if(beverages.get(i).getName().equals(name)) {
							beverages.remove(i);
							System.out.println("\nBebida deletada!");
						}
					}
					break;
					
				case 4:
					System.out.println("\nBebidas com estoque disponível:");
					for(int i = 0; i < beverages.size(); i++) {
						if(beverages.get(i).getStockQuantity()>0) {
							System.out.println(beverages.get(i).getName());
						}
					}
					
					break;
				case 5:
					System.out.println("\n**SISTEMA DE VENDAS**");
					System.out.println("Digite o nome da bebida:");
					ler.nextLine();
					name=ler.nextLine();
					
					for(int i = 0; i < beverages.size(); i++) {
						if(beverages.get(i).getName().equals(name)) {
							if(beverages.get(i).getStockQuantity()>0) {
								do {
									System.out.println("Quantidade vendida:");
									sale=ler.nextInt();
									if(sale>beverages.get(i).getStockQuantity()) {
										System.out.println("Quantidade em estoque: " + beverages.get(i).getStockQuantity());
										System.out.println("Insira uma quantidade válida");
									}
								}while(sale>beverages.get(i).getStockQuantity());
								
								beverages.get(i).setStockQuantity(beverages.get(i).getStockQuantity()-sale);
								System.out.println("Venda Efetuada");
							} else {System.out.println("Produto esgotado!");}
							
						}
					}
					break;
				case 6:
					System.out.println("Voltando ao menu principal ...");
					break;
				default:
					System.out.println("Opcao Invalida");
					break;
			} 
			
		}while(option != 6);
	
	}
	
	public static void ticketSession(ArrayList<Ticket> ticket, ArrayList<Session> session) {
		int option, qtyRegister, sessionChosen;
		String is3D, seatChosen;
		Scanner ler = new Scanner(System.in);
		
		//teste
		
		do {
			System.out.print("\n** INGRESSOS **\n"
					+ "1- Vender Ingresso\n"
					+ "2- Atualizar Ingresso\n"
					+ "3- Apagar Ingresso\n"
					+ "4- Imprimir Ingressos Comprados\n"
					+ "5- Sair\n");
			System.out.print("O que você deseja fazer: ");
			option = ler.nextInt();
			switch(option) {
			
				case 1:
					
					System.out.println("\nSessões Disponíveis:");
					for(int n = 0; n < session.size(); n++) {
						
						if(session.get(n).getRoom().getIsRoomType() == true) {
							is3D="Sim";
						} else {
							is3D="Não";
						}
						
						System.out.println((n+1)+"- "
												+ session.get(n).getMovie().getName() + "\n"
												+ "Horário: " + session.get(n).getSchedule() + "\n"
												+ "3D: " + is3D  + "\n");
					}
					System.out.println("Digite o numero correspondente a sessao escolhida:");
					sessionChosen=ler.nextInt();
					
					System.out.println("Mapa de Assento:");
					session.get(sessionChosen).getRoom().printSeatMap();
					System.out.println("Digite o assento escolhido");
					ler.nextLine();
					seatChosen=ler.nextLine();
					//validar a escolha do assento
					
					ticket.add(new Ticket(seatChosen, session.get(sessionChosen)));
					
					System.out.println("Venda Realizada com Sucesso!\nConfira os detalhes abaixo:");
					System.out.println(ticket.get(ticket.size()-1).toString());
					
					break;
					
				case 2:
					
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					System.out.println("Voltando ao menu principal ...");
					
					break;
					
				default:
					System.out.println("Opcao Invalida");
					break;
			} 
			
		}while(option != 5);
	
	}
}

package control;

import java.text.ParseException;
import java.util.ArrayList;
import model.*;

/**
 * Controle de todos os tipos de dados disponíveis na aplicação
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */

public class DataControl {
	private Data data = new Data();
	
	public DataControl() {
		try {
			data.fillWithRandomData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public ArrayList<Snack> getSnacks() {
		return this.data.getSnacks();
	}
	
	public ArrayList<Beverage> getBeverages() {
		return this.data.getBeverages();
	}
	
	public ArrayList<Movie> getMovies() {
		return this.data.getMovies();
	}
	
	public ArrayList<Employee> getEmployees() {
		return this.data.getEmployees();
	}
	
	public ArrayList<MovieRoom> getRooms() {
		return this.data.getRooms();
	}
	
	public ArrayList<Session> getSession() {
		return this.data.getSessions();
	}
	
	public ArrayList<Sale> getSales() {
		return this.data.getSales();
	}
	
	/**
	 * Pesquisar um funcionário pelo seu código
	 * @param empCode Número inteiro que precisa ser UM CÓDIGO JÁ EXISTENTE para buscar ser positiva
	 * @return Retorna o objeto employee encontrado caso busca seja positiva e retorna null se não encontrar o código usado como parâmetro
	 */
	public Employee getEmployeeByCode(int empCode) {
		for(Employee employee: data.getEmployees()) {
			if (employee.getEmployeeCode() == empCode) {
				return employee;
			} 
		}
		return null;
	}
	 
	/**
	 * Editar um snack já cadastrado
	 * @param snackData Array de String, onde cada posição é uma variável/informação do snack
	 * @return Retorna verdadeiro se a operação foi bem-sucedida
	 */
	public boolean editSnack(String[] snackData) {
		try {
		Snack snacks = new Snack(snackData[1], Double.valueOf(snackData[2]),
				Integer.parseInt(snackData[3]), Integer.parseInt(snackData[4]), Boolean.valueOf(snackData[5]));
		
		data.updateSnack(Integer.parseInt(snackData[0]), snacks);
		
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Editar uma bebida já cadastrada
	 * @param beverageData - Array de String, onde cada posição é uma variável/informação da comida
	 * @return Retorna verdadeiro se a operação foi bem-sucedida
	 */
	public boolean editBeverage(String[] beverageData) {
		try {
			Beverage beverages = new Beverage(beverageData[1], Double.valueOf(beverageData[2]),
					Integer.parseInt(beverageData[3]), Integer.parseInt(beverageData[4]), Boolean.valueOf(beverageData[5]),
					Boolean.valueOf(beverageData[6]), Boolean.valueOf(beverageData[7]));
			data.updateBeverage(Integer.parseInt(beverageData[0]), beverages);
			
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Editar um filme já cadastrado
	 * @param movieData - Array de String, onde cada posição é uma variável/informação do filme
	 * @return Retorna verdadeiro se a operação foi bem-sucedida
	 */
	public boolean editMovie(String[] movieData) {
		try {
			Movie movies = new Movie(movieData[1], Integer.parseInt(movieData[2]), movieData[3], movieData[4]);
			data.updateMovie(Integer.parseInt(movieData[0]), movies);
			
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Editar um funcionário já cadastrado
	 * @param employeeData - Array de String, onde cada posição é uma variável/informação do funcionário
	 * @return Retorna verdadeiro se a operação foi bem-sucedida
	 */
	public boolean editEmployee(String[] employeeData) {
		try {
			Employee employees = new Employee(employeeData[1], employeeData[2], employeeData[3], Integer.parseInt(employeeData[4]));
			data.updateEmployee(Integer.parseInt(employeeData[0]), employees);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Editar uma sala já cadastrada
	 * @param roomData - Array de String, onde cada posição é uma variável/informação da sala
	 * @return Retorna verdadeiro se a operação foi bem-sucedida
	 */
	public boolean editRoom(String[] roomData) {
		try {
			MovieRoom rooms = new MovieRoom(
					Integer.parseInt(roomData[1]),
					Integer.parseInt(roomData[2]),
					Double.parseDouble(roomData[3]),
					Boolean.valueOf(roomData[4]),
					Boolean.valueOf(roomData[5])
			);
			data.updateRoom(Integer.parseInt(roomData[0]), rooms);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Editar uma sessão já cadastrada
	 * @param sessionData Array de String, onde cada posição é uma variável/informação da sala
	 * @param room Sala da sessão selecionada
	 * @param movie Filme da sessão selecionada
	 * @return Retorna verdadeiro se a operação foi bem-sucedida
	 */
	public boolean editSession(String[] sessionData, MovieRoom room, Movie movie) {
		try {
			Session sessions = new Session(
					sessionData[1],
					room,
					movie,
					Integer.parseInt(sessionData[2]));
			
			data.updateSession(Integer.parseInt(sessionData[0]), sessions);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Cadastrar um novo Snack
	 * @param snackData - Array de String onde cada posição é uma variável do snack. Possui 5 posições (String name, double price, int stock, int batch, boolean isSweet). 
	 * Os valores são passados todos como string, devido o uso de GUI.
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean addSnack(String[] snackData) {
		try {
			Snack snacks = new Snack(snackData[0], Double.valueOf(snackData[1]),
					Integer.parseInt(snackData[2]), Integer.parseInt(snackData[3]), Boolean.valueOf(snackData[4]));
			data.setSnacks(snacks);
			
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	/**
	 * Cadastrar uma nova bebida
	 * @param beverageData - Array de String onde cada posição é uma variável da beverage/bebida. Possui 6 posições (String name, double price, int stock, int batch, boolean isDiet, boolean hasIce, boolean hasStraw). 
	 * Os valores são passados todos como string, devido o uso de GUI.
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean addBeverage(String[] beverageData) {
		try {
			Beverage beverages = new Beverage(beverageData[0], Double.valueOf(beverageData[1]),
					Integer.parseInt(beverageData[2]), Integer.parseInt(beverageData[3]), Boolean.valueOf(beverageData[4]),
					Boolean.valueOf(beverageData[5]), Boolean.valueOf(beverageData[6]));
			data.setBeverages(beverages);
			
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Cadastrar um novo filme
	 * @param movieData - Array de String onde cada posição é uma variável do filme. Possui 4 posições (String name, int year, String genre, String synopsis). 
	 * Os valores são passados todos como string, devido o uso de GUI.
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean addMovie(String[] movieData) {
		try {
			Movie movies = new Movie(movieData[0], Integer.parseInt(movieData[1]), movieData[2], movieData[3]);
			data.setMovies(movies);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Cadastrar um novo funcionário
	 * @param employeeData - Array de String onde cada posição é uma variável do funcionário. Possui 4 posições (String name, String cellphone, String cpf, String empCode). 
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean addEmployee(String[] employeeData) {
		try {
			Employee employees = new Employee(employeeData[0], employeeData[1], employeeData[2], Integer.parseInt(employeeData[3]));
			data.setEmployees(employees);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean addSale() {
		try {
			Sale sale = new Sale();
			data.setSales(sale);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Cadastrar uma nova sala
	 * @param roomData - Array de String onde cada posição é uma variável da sala. Possui 5 posições (int seatAmount, int roomNumber, double price, boolean is3D, boolean acessability). 
	 * Os valores são passados todos como string, devido o uso de GUI.
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean addRoom(String[] roomData) {
		try {
			MovieRoom rooms = new MovieRoom(
					Integer.parseInt(roomData[0]),
					Integer.parseInt(roomData[1]),
					Double.parseDouble(roomData[2]),
					Boolean.valueOf(roomData[3]),
					Boolean.valueOf(roomData[4])
			);
			data.setRooms(rooms);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Cadastrar uma nova sessão
	 * @param sessionData - Array de String onde cada posição é uma variável da sessão. Possui 4 posições (Date sessionData, Room room, Movie movie, int sessionId). 
	 * Os valores são passados todos como string, devido o uso de GUI.
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean addSession(String[] sessionData){
		
		Session sessions;
		try {
			sessions = new Session(
					sessionData[0],
					data.getRooms().get(Integer.parseInt(sessionData[1])),
					data.getMovies().get(Integer.parseInt(sessionData[2])),
					Integer.parseInt(sessionData[3])
					);
			data.setSessions(sessions);
			return true;
		} catch (NumberFormatException | ParseException e) {
			return false;
		}
	}
	
	/**
	 * Excluir um snack
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteSnack(int i) {
		data.getSnacks().remove(i);
			return true;
	}
	
	/**
	 * Excluir uma bebida
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteBeverage(int i) {
		data.getBeverages().remove(i);
			return true;
	}
	
	/**
	 * Excluir um filme
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteMovie(int i) {
		data.getMovies().remove(i);
		
		return true;
	}
	
	/**
	 * Excluir um funcionário
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteEmployee(int i) {
		data.getEmployees().remove(i);
		return true;
	}
	
	/**
	 * Excluir uma sala
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteRoom(int i) {
		data.getRooms().remove(i);
		return true;
	}
	
	/**
	 * Excluir uma sessão
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteSession(int i) {
		data.getSessions().remove(i);
		return true;
	}
	
	/**
	 * Excluir uma venda
	 * @param i Posição do elemento dentro do arraylist
	 * @return Retorna true se a operação foi bem sucedida
	 */
	public boolean deleteSale(int i) {
		data.getSales().remove(i);
		return true;
	}

}

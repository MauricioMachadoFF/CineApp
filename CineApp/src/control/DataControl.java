package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.*;

public class DataControl {
	private Data data = new Data();
	
	public DataControl() {
		try {
			data.fillWithRandomData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
	
	public ArrayList<Ticket> getTickets() {
		return this.data.getTickets();
	}
	
	public ArrayList<Sale> getSales() {
		return this.data.getSales();
	}
	
	 
	public boolean editSnack(String[] snackData) {
		Snack snacks = new Snack(snackData[1], Double.valueOf(snackData[2]),
				Integer.parseInt(snackData[3]), Integer.parseInt(snackData[4]), Boolean.valueOf(snackData[5]));
		data.updateSnack(Integer.parseInt(snackData[0]), snacks);
		
		return true;
	}
	
	public boolean editBeverage(String[] beverageData) {
		Beverage beverages = new Beverage(beverageData[1], Double.valueOf(beverageData[2]),
				Integer.parseInt(beverageData[3]), Integer.parseInt(beverageData[4]), Boolean.valueOf(beverageData[5]),
				Boolean.valueOf(beverageData[6]), Boolean.valueOf(beverageData[7]));
		data.updateBeverage(Integer.parseInt(beverageData[0]), beverages);
		
		return true;
	}
	
	public boolean editMovie(String[] movieData) {
		Movie movies = new Movie(movieData[1], Integer.parseInt(movieData[2]), movieData[3], movieData[4]);
		data.updateMovie(Integer.parseInt(movieData[0]), movies);
		
		return true;
	}
	
	public boolean editEmployee(String[] employeeData) {
		Employee employees = new Employee(employeeData[1], employeeData[2], employeeData[3], Integer.parseInt(employeeData[4]));
		data.updateEmployee(Integer.parseInt(employeeData[0]), employees);
		return true;
	}
	
	public boolean editRoom(String[] roomData) {
		MovieRoom rooms = new MovieRoom(
				Integer.parseInt(roomData[1]),
				Integer.parseInt(roomData[2]),
				Double.parseDouble(roomData[3]),
				Boolean.valueOf(roomData[4]),
				Boolean.valueOf(roomData[5])
		);
		data.updateRoom(Integer.parseInt(roomData[0]), rooms);
		return true;
	}
	
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
	
	public boolean addSnack(String[] snackData) {
		Snack snacks = new Snack(snackData[0], Double.valueOf(snackData[1]),
				Integer.parseInt(snackData[2]), Integer.parseInt(snackData[3]), Boolean.valueOf(snackData[4]));
		data.setSnacks(snacks);
		
		return true;
	}
	
	public boolean addBeverage(String[] beverageData) {
		Beverage beverages = new Beverage(beverageData[0], Double.valueOf(beverageData[1]),
				Integer.parseInt(beverageData[2]), Integer.parseInt(beverageData[3]), Boolean.valueOf(beverageData[4]),
				Boolean.valueOf(beverageData[5]), Boolean.valueOf(beverageData[6]));
		data.setBeverages(beverages);
		
		return true;
	}
	
	public boolean addMovie(String[] movieData) {
		Movie movies = new Movie(movieData[0], Integer.parseInt(movieData[1]), movieData[2], movieData[3]);
		data.setMovies(movies);
		return true;
	}
	
	public boolean addEmployee(String[] employeeData) {
		Employee employees = new Employee(employeeData[0], employeeData[1], employeeData[2], Integer.parseInt(employeeData[3]));
		data.setEmployees(employees);
		return true;
	}
	public boolean addSale() {
		Sale sale = new Sale();
		data.setSales(sale);
		return true;
	}
	
	public boolean addRoom(String[] roomData) {
		MovieRoom rooms = new MovieRoom(
				Integer.parseInt(roomData[0]),
				Integer.parseInt(roomData[1]),
				Double.parseDouble(roomData[2]),
				Boolean.valueOf(roomData[3]),
				Boolean.valueOf(roomData[4])
		);
		data.setRooms(rooms);
		return true;
	}
	
	public boolean addSession(String[] sessionData) throws ParseException {
		
		Session sessions = new Session(
				sessionData[0],
				data.getRooms().get(Integer.parseInt(sessionData[1])),
				data.getMovies().get(Integer.parseInt(sessionData[2])),
				Integer.parseInt(sessionData[3])
				);
		data.setSessions(sessions);
		return true;
	}
	
	public boolean addTicket(String[] ticketData) {
		Ticket tickets = new Ticket(
				ticketData[0],
				data.getSessions().get(Integer.parseInt(ticketData[1]))
		);
		data.setTickets(tickets);
		return true;
	}
	
	public boolean deleteSnack(int i) {
		data.getSnacks().remove(i);
			return true;
	}
	
	public boolean deleteBeverage(int i) {
		data.getBeverages().remove(i);
			return true;
	}
	
	public boolean deleteMovie(int i) {
		data.getMovies().remove(i);
		
		return true;
	}
	
	public boolean deleteEmployee(int i) {
		data.getEmployees().remove(i);
		return true;
	}
	
	public boolean deleteRoom(int i) {
		data.getRooms().remove(i);
		return true;
	}
	
	public boolean deleteSession(int i) {
		data.getSessions().remove(i);
		return true;
	}
	
	public boolean deleteTicket(int i) {
		data.getTickets().remove(i);
		return true;
	}

}

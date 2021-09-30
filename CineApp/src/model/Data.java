package model;

import java.text.ParseException;
import java.util.*;

public class Data {
	private  ArrayList<Snack> snacks = new ArrayList<Snack>();
	private  ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	private  ArrayList<Movie> movies = new ArrayList<Movie>();
	private  ArrayList<Employee> employees = new ArrayList<Employee>();
	private  ArrayList<MovieRoom> rooms = new ArrayList<MovieRoom>();
	private  ArrayList<Session> sessions = new ArrayList<Session>();
	private  ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private  ArrayList<Sale> sales = new ArrayList<Sale>();
	final int max = 999;
	final int min = 100;
	final double maxVal = 100.00;
	final double minVal = 30.00; 
	
	public void fillWithRandomData() throws ParseException {
		boolean trueOrFalse = true;
		for(int i = 0; i < 5; i++) {
			snacks.add(new Snack("Lanche "+(i+1), i+2, i*10, (i+1)*6331, trueOrFalse));
			
			beverages.add(new Beverage("Bebida "+(i+1), i+10, i*7, (i+5)*65, trueOrFalse, !trueOrFalse, trueOrFalse ));
			
			employees.add(new Employee(
					"Funcionário " + (i + 1),
					String.valueOf((int)Math.floor(Math.random()*(max-min+1)+min)),
					String.valueOf((int)Math.floor(Math.random()*(max-min+1)+min)),
					(int)Math.floor(Math.random()*(max-min+1)+min)
			));
			
			movies.add( new Movie(
					"Filme "+(i+1),
					2000+i,
					"Action" + i,
					"Sinopse "+(i+1),
					i+7*3
				));
			
			rooms.add(new MovieRoom(
				(i + 45),
				(i +1),
				(i+15)*2,
				trueOrFalse,
				trueOrFalse	
			));
			
			sessions.add( new Session(
					"2021-12-24",
					rooms.get(i),
					movies.get(i),
					(int)Math.floor(Math.random()*(100)+1)
				));
			
			sales.add(new Sale(
				employees.get(i),
				"Cliente" + i,
				(i * 4.5),
				"Debit",
				beverages,
				snacks,
				sessions.get(i)
			));
			trueOrFalse =! trueOrFalse;
		}
	}

	public ArrayList<Snack> getSnacks() {
		return snacks;
	}
	
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	public ArrayList<MovieRoom> getRooms() {
		return rooms;
	}
	
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSnacks(Snack snack) {
		snacks.add(snack);
	}
	
	public void setBeverages(Beverage beverage) {
		beverages.add(beverage);
	}
	
	public void setMovies(Movie movie) {
		movies.add(movie);
	}
	
	public void setEmployees(Employee employee) {
		employees.add(employee);
	}
	
	public void setRooms(MovieRoom room) {
		rooms.add(room);
	}
	
	public void setSessions(Session session) {
		sessions.add(session);
	}
	
	public void setTickets(Ticket ticket) {
		tickets.add(ticket);
	}
	
	public void setSales(Sale sale) {
		sales.add(sale);
	}
	
	public void updateSnack(int index, Snack snack) {
	    this.snacks.set(index, snack);
	}
	
	public void updateBeverage(int index, Beverage beverage) {
	    this.beverages.set(index, beverage);
	}
	
	public void updateMovie(int index, Movie movie) {
		this.movies.set(index, movie);
	}
	
	public void updateEmployee(int index, Employee employee) {
		this.employees.set(index, employee);
	}
	
	public void updateRoom(int index, MovieRoom room) {
		this.rooms.set(index, room);
	}
	
	public void updateSession(int index, Session session) {
		this.sessions.set(index, session);
	}
}

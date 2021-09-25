package model;

import java.util.*;

public class Data {
	private  ArrayList<Snack> snacks = new ArrayList<Snack>();
	private  ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	private  ArrayList<Movie> movies = new ArrayList<Movie>();
	private  ArrayList<Employee> employees = new ArrayList<Employee>();
	private  ArrayList<MovieRoom> rooms = new ArrayList<MovieRoom>();
	final int max = 999999999;
	final int min = 100000000;
	final double maxVal = 100.00;
	final double minVal = 30.00; 
	
	public void fillWithRandomData() {
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
			
			rooms.add(new MovieRoom(
				(i +1),
				(double)Math.random()*(maxVal-minVal+1)+minVal,
				trueOrFalse,
				trueOrFalse	
			));
			
			trueOrFalse =! trueOrFalse;
		}
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
}

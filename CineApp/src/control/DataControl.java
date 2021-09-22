package control;

import java.util.ArrayList;
import model.*;

public class DataControl {
	private Data data = new Data();
	private SnackControl snackControl;
	
	public DataControl() {
		data.fillWithRandomData();
	}

	public Data getData() {
		return data;
	}
	
	public SnackControl getSnackControl() {
		return snackControl;
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

}
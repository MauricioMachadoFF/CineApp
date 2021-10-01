package model;

public class Movie {
	private String name;
	private int year;
	private String genre;
	private String synopsis;
	private int movieId;
	final int max = 10000;
	final int min = 1;
	
	public Movie(String name, int year, String genre, String synopsis, int movieId) {
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.synopsis = synopsis;
		this.movieId = movieId;
	}
	
	public Movie(String name, int year, String genre, String synopsis) {
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.synopsis = synopsis;
		this.movieId = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public String getGenre() {
		return genre;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public void setMovieId() {
		this.movieId = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public String toString() {
		return new String("Title: " + this.name)
			.concat("\nYear: " + this.year)
			.concat("\nGenero: " + this.genre)
			.concat("\nSinopse: " + this.synopsis)
			.concat("\nMovieId: ") + this.movieId;
	}
}
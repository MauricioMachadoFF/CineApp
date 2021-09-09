package cinema;

import java.util.Scanner;

//import java.awt.Image;

public class Movie {
	private Scanner ler = new Scanner(System.in).useDelimiter("\n");
	private String name;
	private int year;
	private String genre;
	private String synopsis;
	private int movieId;
	final int max = 10000;
	final int min = 1;
	//private Image poster;
	
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
	
	public Movie() {
		System.out.println("Nome do filme: ");
		setName(ler.next());
		System.out.println("Ano de Lancamento: ");
		setYear(ler.nextInt());
		System.out.println("Genero: ");
		setGenre(ler.next());
		System.out.println("Sinopse: ");
		setSynopsis(ler.next());
		setMovieId();
	}
	
	public String getName() {
		return name;
	}
	public int year() {
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
//	public Image getPoster() {
//		return poster;
//	}
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
	
//	public void setPoster(Image poster) {
//		this.poster = poster;
//	}
	
	public String toString() {
		return new String("Title: " + this.name)
			.concat("\nYear: " + this.year)
			.concat("\nGenero: " + this.genre)
			.concat("\nSinopse: " + this.synopsis)
			.concat("\nMovieId: ") + this.movieId;
	}
	
	public void updateMovie() {
		int auxiliar;
		System.out.println("\nQual o código do filme que você deseja editar?");
		System.out.println("Qual dado deseja editar?");
		System.out.println("1- Título \n2 - Ano de lancamento \n3 - Genero \n4 - Sinopse");
		auxiliar=ler.nextInt();
		
		switch(auxiliar) {
		case 1:
			System.out.println("\nDigite o novo nome:");
			setName(ler.next());
			break;
			
		case 2:
			System.out.println("\nDigite o ano de lançamento atualizado:");
			setYear(ler.nextInt());
			break;
			
		case 3:
			System.out.println("\nDigite o genero do filme:");
			setGenre(ler.next());
			break;
			
		case 4:
			System.out.println("\nDigite a sinopse do filme:");
			setSynopsis(ler.next());
			break;
			
		default:
			System.out.println("Opcao Invalida");
			break;
		}
		System.out.println(toString());
	}
}
















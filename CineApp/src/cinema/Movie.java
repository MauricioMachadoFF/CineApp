package cinema;

import java.awt.Image;

public class Movie {
	private String name;
	private String ageAdmitted;
	private String genre;
	private String synopsis;
	private Image poster;
	
	public String getName() {
		return name;
	}
	public String getAgeAdmitted() {
		return ageAdmitted;
	}
	public String getGenre() {
		return genre;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public Image getPoster() {
		return poster;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAgeAdmitted(String ageAdmitted) {
		this.ageAdmitted = ageAdmitted;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public void setPoster(Image poster) {
		this.poster = poster;
	}
}

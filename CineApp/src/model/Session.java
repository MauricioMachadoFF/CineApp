package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
	private Date schedule;
	private MovieRoom room;
	private Movie movie;
	private int sessionId;
	final int max = 100000;
	final int min = 1;
	
	public Session(String preSchedule, MovieRoom room, Movie movie) throws ParseException {
		setSchedule(preSchedule);
		this.room = room;
		this.movie = movie;
		this.sessionId = (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public Session(String preSchedule, MovieRoom room, Movie movie, int sessionId) throws ParseException {
		setSchedule(preSchedule);
		this.room = room;
		this.movie = movie;
		this.sessionId = sessionId;
	}
	
	
	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(String preSchedule) throws ParseException {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.schedule = dateFormat.parse(preSchedule);
	}

	public MovieRoom getRoom() {
		return room;
	}

	public Movie getMovie() {
		return movie;
	}	
	
	public int getSessionId() {
		return sessionId;
	}
	
	public String toString() {
		return new String("Nome do Filme: " + this.movie.getName())
				.concat("\nNumero da Sala: " + this.room.getRoomNumber())
				.concat("\nData da Sessao: " + this.schedule)
				.concat("\nValor do ingresso: " + this.room.getPrice() + " reais")
				.concat("\nId da Sessao: " + this.sessionId);
	}
}

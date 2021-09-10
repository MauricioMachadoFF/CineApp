package cinema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
	private Date schedule;
	private MovieRoom room;
	private Movie movie;
	
	public Session(String preSchedule, MovieRoom room, Movie movie) throws ParseException {
		setSchedule(preSchedule);
		this.room = room;
		this.movie = movie;
	}
	
	
	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(String preSchedule) throws ParseException {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.schedule = dateFormat.parse(preSchedule);
	}

	public MovieRoom getRoom() {
		return room;
	}

	public Movie getMovie() {
		return movie;
	}	
	
	public String toString() {
		return new String("Nome do Filme: " + this.movie.getName())
				.concat("\nNumero da Sala: " + this.room.getRoomNumber())
				.concat("\nData da Sessao: " + this.schedule)
				.concat("\nValor do ingresso: " + this.room.getPrice() + " reais");
	}
}

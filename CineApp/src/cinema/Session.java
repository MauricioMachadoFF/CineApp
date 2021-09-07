package cinema;

import java.util.Date;

public class Session {
	private Date schedule[];
	private Date days[];
	private MovieRoom[] rooms = new MovieRoom[10];
	private Movie[] movies = new Movie[50];
	
	public Date[] getSchedule() {
		return schedule;
	}
	public Date[] getDays() {
		return days;
	}
	public void setSchedule(Date[] schedule) {
		this.schedule = schedule;
	}
	public void setDays(Date[] days) {
		this.days = days;
	}
	
	
}

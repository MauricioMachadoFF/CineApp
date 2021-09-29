package model;

public class Ticket {
	private String seat;
	private Session session;
	
	public Ticket(String seat, Session session) {
		this.seat = seat;
		this.session = session;
	}

	public String getSeat() {
		return seat;
	}
	
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public Session getSession() {
		return session;
	}
	
	public String toString() {
		return new String("Nome do Filme: " + session.getMovie().getName())
				.concat("\nNumero da Sala: " + session.getRoom().getRoomNumber())
				.concat("\nData da Sessao: " + session.getSchedule())
				.concat("\nAssento: " + this.seat
						);
	}
}
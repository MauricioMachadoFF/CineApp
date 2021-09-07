package cinema;

public class Ticket {
	private boolean is3d;
	private String seat;
	private double price;
	private Session session = new Session();
	
	public boolean isIs3d() {
		return is3d;
	}
	public String getSeat() {
		return seat;
	}
	public double getPrice() {
		return price;
	}
	public void setIs3d(boolean is3d) {
		this.is3d = is3d;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

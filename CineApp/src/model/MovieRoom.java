package model;

public class MovieRoom {
	private int seatAmount;
	private boolean acessability;
	private boolean is3D;
	private int roomNumber;
	private double price;
	
	// Verificar esse tipo de sala como boolean

	public MovieRoom(int seatAmount, int roomNumber, double price, boolean is3D, boolean acessability) {
		this.seatAmount = seatAmount;
		this.roomNumber = roomNumber;
		this.price = price;
		this.is3D = is3D;
		this.acessability = acessability;
	}
	
	public MovieRoom(int roomNumber, double price) {
		this.acessability = true;
		this.is3D = true;
		this.roomNumber = roomNumber;
		this.price = price;
	}
	public boolean getIsAcessabilty() {
		return acessability;
	}
	public boolean getIs3D() {
		return is3D;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public double getPrice() {
		return price;
	}
	
	public int getSeatAmount() {
		return seatAmount;
	}
	
	public void setAcessability(boolean acessability) {
		this.acessability = acessability;
	}
	public void setIs3D(boolean is3D) {
		this.is3D = is3D;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public void setSeatAmount (int amount) {
		this.seatAmount = amount;
	}

	
	public String toString() {
		return new String("Numero da Sala: " + this.roomNumber)
				.concat("\nPreco da Sala: " + this.price)
				.concat("\nAcessibilidade: " + this.acessability)
				.concat("\nSala 3D: ") + this.is3D;
	}
}
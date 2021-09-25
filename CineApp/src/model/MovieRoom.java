package model;

public class MovieRoom {
	final String[][] seatMap = {
			{"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13", "A14", "A15"},
			{"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13", "B14", "B15"},
			{"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14", "C15"},
			{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13", "D14", "D15"},
			{"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "E11", "E12", "E13", "E14", "E15"},
			{"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "F13", "F14", "F15"},
			{"G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11", "G12", "G13", "G14", "G15"},
			{"H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13", "H14", "H15"},
			{"I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12", "I13", "I14", "I15"},
			{"J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10", "J11", "J12", "J13", "J14", "J15"}
			};
	private boolean acessability;
	private boolean is3D;
	private int roomNumber;
	private double price;
	
	// Verificar esse tipo de sala como boolean

	public MovieRoom(int roomNumber, double price, boolean is3D, boolean acessability) {
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
	public String[][] getSeatMap() {
		return seatMap;
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

	public void printSeatMap() {
		
		for (int l = 0; l < 10; l++){
			for (int c = 0; c < 15; c++){
				System.out.print(seatMap[l][c]+"	");
			}
			System.out.print("\n");
	    }
	}
	
	public String toString() {
		return new String("Numero da Sala: " + this.roomNumber)
				.concat("\nPreco da Sala: " + this.price)
				.concat("\nAcessibilidade: " + this.acessability)
				.concat("\nSala 3D: ") + this.is3D;
	}
}
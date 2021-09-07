package cinema;

public class MovieRoom {
	private String[] seatMap;
	private boolean acessabilty;
	private boolean roomType;
	// Verificar esse tipo de sala como boolean
	
	public String[] getSeatMap() {
		return seatMap;
	}
	public boolean getIsAcessabilty() {
		return acessabilty;
	}
	public boolean getIsRoomType() {
		return roomType;
	}
	public void setSeatMap(String[] seatMap) {
		this.seatMap = seatMap;
	}
	public void setAcessabilty(boolean acessabilty) {
		this.acessabilty = acessabilty;
	}
	public void setRoomType(boolean roomType) {
		this.roomType = roomType;
	}
	
	
}

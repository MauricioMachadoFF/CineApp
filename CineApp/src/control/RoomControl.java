package control;
import java.util.ArrayList;
import model.*;

public class RoomControl {
	private ArrayList<MovieRoom> rooms = new ArrayList<MovieRoom>();
	
	public RoomControl(DataControl data) {
		rooms = data.getRooms();
	}
	
	public String[] getRoomsNumber() {
		String[] list = new String[rooms.size()];
		for(int n = 0; n < rooms.size(); n++) {
			list[n] = String.valueOf(rooms.get(n).getRoomNumber());
		}
		
		return list;
	}
}

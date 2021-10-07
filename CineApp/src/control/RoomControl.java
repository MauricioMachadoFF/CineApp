package control;
import java.util.ArrayList;
import model.*;

/**
 * Controle das informações acerca da classe MovieRoom
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class RoomControl {
	private ArrayList<MovieRoom> rooms = new ArrayList<MovieRoom>();
	
	/**
     * Preencher a ArrayList rooms com todos as salas existentes até o momento
	 * @param data um objeto de classe DataControl que nos possibilita operar com todos os dados presentes na aplicação
	 */
	public RoomControl(DataControl data) {
		rooms = data.getRooms();
	}
	
	
	/**
	 * Gera uma lista com todas as salas pelo número delas
	 * @return list - Array de Strings onde cada String é o número de uma sala
	 */
	public String[] getRoomsNumber() {
		String[] list = new String[rooms.size()];
		for(int n = 0; n < rooms.size(); n++) {
			list[n] = "Sala "+String.valueOf(rooms.get(n).getRoomNumber());
		}
		
		return list;
	}
}

package control;

import java.util.ArrayList;
import model.*;

public class TicketControl {
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public TicketControl(DataControl data) {
		tickets = data.getTickets();
	}
	
	public String[] getTicketDetail() {
		String[] list = new String[tickets.size()];
		for(int n = 0; n < tickets.size(); n++) {
			list[n] = "Sessão " + String.valueOf(tickets.get(n).getSession().getSessionId()) +" - "+ tickets.get(n).getSeat();
		}
		
		return list;
	}
}

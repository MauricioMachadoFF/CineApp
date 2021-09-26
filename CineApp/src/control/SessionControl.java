package control;
import java.util.ArrayList;

import model.*;

public class SessionControl {
	ArrayList<Session> session = new ArrayList<Session>();
	
	public SessionControl(DataControl data) {
		session = data.getSession();
	}
	
	public String[] getSessionDetails() {
		String[] list = new String[session.size()];
		for(int n = 0; n < session.size(); n++) {
			list[n] = session.get(n).getMovie().getName() +" - sessão nº "+ String.valueOf(session.get(n).getSessionId());
		}
		
		return list;
	}
	
}
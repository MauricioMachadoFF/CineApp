package control;
import java.util.ArrayList;

import model.*;

/**
 * Controle das informações acerca da classe Session
 * @author Mauricio Machado
 * @version 1.0 (Out 2020)
 */
public class SessionControl {
	ArrayList<Session> session = new ArrayList<Session>();
	
	/**
     * Preencher a ArrayList session com todos as sessões existentes até o momento
	 * @param data um objeto de classe DataControl que nos possibilita operar com todos os dados presentes na aplicação
	 */
	public SessionControl(DataControl data) {
		session = data.getSession();
	}
	
	/**
	 * Gera a lista com os detalhes das sessões existentes
	 * @return list - um Array de Strings onde cada String é uma sessão disponível
	 */
	public String[] getSessionDetails() {
		String[] list = new String[session.size()];
		for(int n = 0; n < session.size(); n++) {
			list[n] = session.get(n).getMovie().getName() +" - sessão nº "+ String.valueOf(session.get(n).getSessionId());
		}
		
		return list;
	}
	
}
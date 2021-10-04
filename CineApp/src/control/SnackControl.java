package control;
import java.util.ArrayList;

import model.*;

/**
 * Controle das informações acerca da classe Snack
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class SnackControl {
	ArrayList<Snack> snacks = new ArrayList<Snack>();
	
	/**
     * Preencher a ArrayList session com todos os snacks existentes até o momento
	 * @param data um objeto de classe DataControl que nos possibilita operar com todos os dados presentes na aplicação
	 */
	public SnackControl(DataControl data) {
		snacks = data.getSnacks();
	}
	
	/**
	 * Gera a lista com o nome de todos os snacks existentes
	 * @return list - um Array de Strings onde cada String é um snack disponível
	 */
	public String[] getSnacksName() {
		String[] list = new String[snacks.size()];
		for(int n = 0; n < snacks.size(); n++) {
			list[n] = snacks.get(n).getName();
		}
		
		return list;
	}
	
}

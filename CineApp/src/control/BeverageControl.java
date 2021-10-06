package control;

import java.util.ArrayList;
import model.*;

/**
 * 
 * Controle das informações acerca da classe Beverage
 * @author Mauricio Machado
 * @version 1.0 (Out 2020)
 */
public class BeverageControl {
	ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	/**
     * Preencher a ArrayList session com todos as bebidas existentes até o momento
	 * @param data um objeto de classe DataControl que nos possibilita operar com todos os dados presentes na aplicação
	 */
	public BeverageControl(DataControl data) {
		beverages = data.getBeverages();
	}
	
	/**
	 * Gera a lista com o nome de todas as bebidas existentes
	 * @return list - um Array de Strings onde cada String é uma bebida disponível
	 */
	public String[] getBeverageName() {
		String[] list = new String[beverages.size()];
		for(int n = 0; n < beverages.size(); n++) {
			list[n] = beverages.get(n).getName();
		}
		
		return list;
	}
}

package control;

import java.util.ArrayList;
import model.*;

public class BeverageControl {
	ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	
	public BeverageControl(DataControl data) {
		beverages = data.getBeverages();
	}
	
	public String[] getBeverageName() {
		String[] list = new String[beverages.size()];
		for(int n = 0; n < beverages.size(); n++) {
			list[n] = beverages.get(n).getName();
		}
		
		return list;
	}
}

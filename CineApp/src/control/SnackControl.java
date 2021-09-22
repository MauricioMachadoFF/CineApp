package control;
import java.util.ArrayList;

import model.*;

public class SnackControl {
	ArrayList<Snack> snacks = new ArrayList<Snack>();
	
	public SnackControl(DataControl data) {
		snacks = data.getSnacks();
	}
	
	public String[] getSnacksName() {
		String[] list = new String[snacks.size()];
		for(int n = 0; n < snacks.size(); n++) {
			list[n] = snacks.get(n).getName();
		}
		
		return list;
	}
	
}

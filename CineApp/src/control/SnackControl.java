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
	
	public int getSnacksQuantity() {
		int qty = snacks.size();
		
		return qty;
	}
	
	public String getName(int index) {
		return snacks.get(index).getName();
	}

	public String getPrice(int index) {
		String price = String.valueOf(snacks.get(index).getPrice());
		return price;
	}

	public String getStockQuantity(int index) {
		String stock = String.valueOf(snacks.get(index).getStockQuantity());
		return stock;
	}

	public String getBatch(int index) {
		String batch = String.valueOf(snacks.get(index).getBatch());
		return batch;
	}
	
}

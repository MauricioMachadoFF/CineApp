package control;

import java.util.ArrayList;
import model.*;

public class DataControl {
	private Data data = new Data();
	
	public DataControl() {
		data.fillWithRandomData();
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public ArrayList<Snack> getSnacks() {
		return this.data.getSnacks();
	}
	
	public boolean editSnack(String[] snackData) {
		Snack snacks = new Snack(snackData[1], Double.valueOf(snackData[2]),
				Integer.parseInt(snackData[3]), Integer.parseInt(snackData[4]), Boolean.valueOf(snackData[5]));
		data.updateSnack(Integer.parseInt(snackData[0]), snacks); //snackData[0] is the index of the snack that will be updated
		
		return true;
	}
	
	public boolean addSnack(String[] snackData) {
		Snack snacks = new Snack(snackData[0], Double.valueOf(snackData[1]),
				Integer.parseInt(snackData[2]), Integer.parseInt(snackData[3]), Boolean.valueOf(snackData[4]));
		data.setSnacks(snacks);
		
		return true;
	}
	
	public boolean deleteSnack(int i) {
		data.getSnacks().remove(i);
			return true;
	}

}

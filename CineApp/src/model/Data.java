package model;

import java.util.*;

public class Data {
	private  ArrayList<Snack> snacks = new ArrayList<Snack>();
	
	public void fillWithRandomData() {
		boolean trueOrFalse = true;
		for(int i = 0; i < 5; i++) {
			snacks.add(new Snack("Lanche "+i, i+2, i*10, (i+1)*6331, trueOrFalse));
			trueOrFalse =! trueOrFalse;
		}
	}

	public ArrayList<Snack> getSnacks() {
		return snacks;
	}

	public void setSnacks(Snack snack) {
		snacks.add(snack);
	}
	
	public void updateSnack(int index, Snack snack) {
	    this.snacks.set(index, snack);
	}
}

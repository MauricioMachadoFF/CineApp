package model;

import java.util.*;

public class Data {
	private  ArrayList<Snack> snacks = new ArrayList<Snack>();
	private  ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	
	public void fillWithRandomData() {
		boolean trueOrFalse = true;
		for(int i = 0; i < 5; i++) {
			snacks.add(new Snack("Lanche "+(i+1), i+2, i*10, (i+1)*6331, trueOrFalse));
			
			beverages.add(new Beverage("Bebida "+(i+1), i+10, i*7, (i+5)*65, trueOrFalse, !trueOrFalse, trueOrFalse ));
			trueOrFalse =! trueOrFalse;
		}
	}

	public ArrayList<Snack> getSnacks() {
		return snacks;
	}
	
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public void setSnacks(Snack snack) {
		snacks.add(snack);
	}
	
	public void setBeverages(Beverage beverage) {
		beverages.add(beverage);
	}
	
	public void updateSnack(int index, Snack snack) {
	    this.snacks.set(index, snack);
	}
	
	public void updateBeverage(int index, Beverage beverage) {
	    this.beverages.set(index, beverage);
	}
}

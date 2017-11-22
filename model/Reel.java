package model;

import java.util.Random;

public class Reel {
	
	private Random random;
	private Symbols symbol;

	public Reel(Random random) {
		this.random = random;
	}

	public String getSymbol() {
		// TODO Auto-generated method stub
		return "000";
	}

	public void spin() {
		int symbolInt = random.nextInt(Symbols.values().length);
		symbol = Symbols.values()[symbolInt];
	}

}

package model;

import java.util.Random;

public class Reel {
	
	private Random random;
	private Symbols symbol;

	public Reel(Random random) {
		this.random = random;
		spin();
	}

	public String getSymbol() {
		return symbol.toString();
	}

	public void spin() {
		int symbolInt = random.nextInt(Symbols.values().length);
		symbol = Symbols.values()[symbolInt];
	}

	public int getwinTimesBet() {
		// TODO Auto-generated method stub
		return 0;
	}

}

package model;

import java.util.ArrayList;
import java.util.Collection;

public class SlotMachine {
	
	private int minBet;
	private int maxBet;
	private int credit;
	private int noOfReels;
	
	public SlotMachine(int minBet, int maxBet, int credit, int noOfReels) {
		this.minBet = minBet;
		this.maxBet = maxBet;
		this.credit = credit;
		this.noOfReels = noOfReels;
	}

	public int getMinBet() {
		return minBet;
	}

	public int getMaxBet() {
		return maxBet < credit ? maxBet : credit;
	}

	public int getCredit() {
		return credit;
	}

	public Collection<String> getSymbols() {
		ArrayList<String> symbols = new ArrayList<String>();
		for(int i=0; i<noOfReels; i++) {
			symbols.add("");
		}
		return symbols;
	}

}

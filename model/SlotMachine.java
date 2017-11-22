package model;

import java.util.Collection;

public class SlotMachine {
	
	private int minBet;
	private int maxBet;
	private int credit;
	
	public SlotMachine(int minBet, int maxBet, int credit, int noOfReels) {
		this.minBet = minBet;
		this.maxBet = maxBet;
		this.credit = credit;
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

	public Collection getSymbols() {
		// TODO Auto-generated method stub
		return null;
	}

}

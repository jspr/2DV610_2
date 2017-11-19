package model;

public class SlotMachine {
	
	private int minBet;
	private int maxBet;
	
	public SlotMachine(int minBet, int maxBet) {
		this.minBet = minBet;
		this.maxBet = maxBet;
	}

	public int getMinBet() {
		return minBet;
	}

	public int getMaxBet() {
		return maxBet;
	}

	public int getCredit() {
		return 10;
	}

}

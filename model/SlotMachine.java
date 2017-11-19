package model;

public class SlotMachine {
	
	private int minBet;
	private int maxBet;
	private int credit;
	
	public SlotMachine(int minBet, int maxBet, int credit) {
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

}

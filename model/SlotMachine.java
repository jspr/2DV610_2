package model;

import java.util.ArrayList;
import java.util.Collection;

public class SlotMachine {
	
	private int minBet;
	private int maxBet;
	private int credit;
	private Collection<Reel> reels;
	
	public SlotMachine(int minBet, int maxBet, int credit, Collection<Reel> reels) {
		this.minBet = minBet;
		this.maxBet = maxBet;
		this.credit = credit;
		this.reels = reels;
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
		for(Reel reel : reels) {
			symbols.add(reel.getSymbol());
		}
		return symbols;
	}

	public int spin(int bet) {
		if(bet > getMaxBet())
			throw new RuntimeException("Bet is bigger than max bet.");
		for(Reel reel : reels) {
			reel.spin();
		}
		return 0;
	}

}

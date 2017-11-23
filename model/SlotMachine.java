package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

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
		int winnings = 0;
		if(bet > getMaxBet())
			throw new RuntimeException("Bet is bigger than max bet.");
		credit -= bet;
		for(Reel reel : reels) {
			reel.spin();
		}
		HashSet<String> symbols = new HashSet<String>();
		for(String symbol : getSymbols()) {
			symbols.add(symbol);
		}
		if(symbols.size() == 1)
			winnings = bet * ((Reel) reels.toArray()[0]).getwinTimesBet();
		credit += winnings;
		return winnings;
	}

}

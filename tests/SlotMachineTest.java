package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Reel;
import model.SlotMachine;

public class SlotMachineTest {
	
	private SlotMachine sut;
	private Collection<Reel> reelMocks;

	@Before
	public void setUp() throws Exception {
		reelMocks = new ArrayList<Reel>();
		for(int i=0; i<3; i++) {
			reelMocks.add(mock(Reel.class));
		}
		sut = new SlotMachine(1,3,10,reelMocks);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnMinBet1() {
		int expected = 1;
		int actual = sut.getMinBet();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnMaxBet3() {
		int expected = 3;
		int actual = sut.getMaxBet();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnMaxBet1WhenCreditIs1() {
		SlotMachine sut = new SlotMachine(1,3,1,reelMocks);
		int expected = 1;
		int actual = sut.getMaxBet();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnCredit10() {
		int expected = 10;
		int actual = sut.getCredit();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnArrayWith3Symbols() {
		int expected = 3;
		int actual = sut.getSymbols().size();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_000_000_000() {	
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("000");
		strings.add("000");
		strings.add("000");
		shouldReturnCollectionWithSymbolStrings(strings);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_BAR_BAR_BAR() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("BAR");
		strings.add("BAR");
		strings.add("BAR");
		shouldReturnCollectionWithSymbolStrings(strings);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_000_FOO_BAR() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("000");
		strings.add("FOO");
		strings.add("BAR");
		shouldReturnCollectionWithSymbolStrings(strings);
	}
	
	
	@Test
	public void shouldCallSpinOnReels() {
		sut.spin(1);
		for(Reel reel : reelMocks) {
			verify(reel).spin();
		}
	}
	
	@Test
	public void shouldThrowRuntimeExceptionWhenBetIsBiggerThanMaxBet() {
		try {
			sut.spin(1000);
	        fail();
	    } catch(RuntimeException e) { }
	}
	
	@Test
	public void shouldReturn1Bet1Odds1() {
		shouldReturnBetTimesOdds(1,1,"000");
	}
	
	@Test
	public void shouldReturn6Bet3Odds2() {
		shouldReturnBetTimesOdds(3,2,"010");
	}
	
	@Test
	public void shouldReturn200Bet2Odds100() {
		shouldReturnBetTimesOdds(2,100,"BAR");
	}
	
	@Test
	public void shouldReturn0BetAndLoseAllReelsOff() {
		int i = 0;
		for(Reel reel : reelMocks) {
			if(i==0)
				when(reel.getSymbol()).thenReturn("BAR");
			else if(i==1)
				when(reel.getSymbol()).thenReturn("FOO");
			else
				when(reel.getSymbol()).thenReturn("000");
			i++;
		}
		int expected = 0;
		int actual = sut.spin(2);
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturn0BetAndLoseTwoReelsOff() {
		int i = 0;
		for(Reel reel : reelMocks) {
			if(i==0)
				when(reel.getSymbol()).thenReturn("BAR");
			else
				when(reel.getSymbol()).thenReturn("FOO");
			i++;
		}
		int expected = 0;
		int actual = sut.spin(2);
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldUpdateCreditTo9_LoseBet1() {
		int i = 0;
		for(Reel reel : reelMocks) {
			if(i==0)
				when(reel.getSymbol()).thenReturn("BAR");
			else
				when(reel.getSymbol()).thenReturn("FOO");
			i++;
		}
		int expected = 9;
		sut.spin(1);
		int actual = sut.getCredit();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldUpdateCreditTo108_Win200Bet2Odds100() {
		int expected = 108;
		for(Reel reel : reelMocks) {
			when(reel.getSymbol()).thenReturn("BAR");
			when(reel.getwinTimesBet()).thenReturn(100);
		}
		sut.spin(2);
		int actual = sut.getCredit();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldUpdateCreditTo13_Win6Bet3Odds2() {
		int expected = 13;
		for(Reel reel : reelMocks) {
			when(reel.getSymbol()).thenReturn("010");
			when(reel.getwinTimesBet()).thenReturn(2);
		}
		sut.spin(3);
		int actual = sut.getCredit();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldUpdateCreditTo10_Win1Bet1Odds1() {
		int expected = 10;
		for(Reel reel : reelMocks) {
			when(reel.getSymbol()).thenReturn("000");
			when(reel.getwinTimesBet()).thenReturn(1);
		}
		sut.spin(1);
		int actual = sut.getCredit();
		assertEquals(expected,actual);
	}
	
	private void shouldReturnCollectionWithSymbolStrings(Collection<String> strings) {
		int i=0;
		for(String s : strings) {
			when(((Reel) reelMocks.toArray()[i]).getSymbol()).thenReturn(s);
			i++;
		}
		Collection<String> symbolStrings = sut.getSymbols();
		i=0;
		for(String s : strings) {
			assertEquals(s,symbolStrings.toArray()[i]);
			i++;
		}
	}
	
	private void shouldReturnBetTimesOdds(int bet, int odds, String symbol) {
		for(Reel reel : reelMocks) {
			when(reel.getSymbol()).thenReturn(symbol);
			when(reel.getwinTimesBet()).thenReturn(odds);
		}	
		int expected = bet * odds;
		int actual = sut.spin(bet);
		assertEquals(expected,actual);
	}

}

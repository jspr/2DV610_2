package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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

}

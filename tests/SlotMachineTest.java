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
		String expected = "000";
		when(((Reel) reelMocks.toArray()[0]).getSymbol()).thenReturn("000");
		when(((Reel) reelMocks.toArray()[1]).getSymbol()).thenReturn("000");
		when(((Reel) reelMocks.toArray()[2]).getSymbol()).thenReturn("000");
		Collection<String> symbolStrings = sut.getSymbols();
		assertEquals(expected,symbolStrings.toArray()[0]);
		assertEquals(expected,symbolStrings.toArray()[1]);
		assertEquals(expected,symbolStrings.toArray()[2]);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_BAR_BAR_BAR() {
		String expected = "BAR";
		when(((Reel) reelMocks.toArray()[0]).getSymbol()).thenReturn("BAR");
		when(((Reel) reelMocks.toArray()[1]).getSymbol()).thenReturn("BAR");
		when(((Reel) reelMocks.toArray()[2]).getSymbol()).thenReturn("BAR");
		Collection<String> symbolStrings = sut.getSymbols();
		assertEquals(expected,symbolStrings.toArray()[0]);
		assertEquals(expected,symbolStrings.toArray()[1]);
		assertEquals(expected,symbolStrings.toArray()[2]);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_000_FOO_BAR() {
		when(((Reel) reelMocks.toArray()[0]).getSymbol()).thenReturn("000");
		when(((Reel) reelMocks.toArray()[1]).getSymbol()).thenReturn("FOO");
		when(((Reel) reelMocks.toArray()[2]).getSymbol()).thenReturn("BAR");
		Collection<String> symbolStrings = sut.getSymbols();
		assertEquals("000",symbolStrings.toArray()[0]);
		assertEquals("FOO",symbolStrings.toArray()[1]);
		assertEquals("BAR",symbolStrings.toArray()[2]);
	}

}

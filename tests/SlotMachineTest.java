package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.SlotMachine;
import model.Symbols;

public class SlotMachineTest {
	
	private SlotMachine sut;

	@Before
	public void setUp() throws Exception {
		 sut = new SlotMachine(1,3,10,3);
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
		SlotMachine sut = new SlotMachine(1,3,1,3);
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
		sut = new SlotMachine(1,3,10,3);
		int expected = 3;
		int actual = sut.getSymbols().size();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_000_000_000() {
		sut = new SlotMachine(1,3,10,3);
		String expected = "000";
		Collection<String> symbolStrings = sut.getSymbols();
		assertEquals(expected,symbolStrings.toArray()[0]);
		assertEquals(expected,symbolStrings.toArray()[1]);
		assertEquals(expected,symbolStrings.toArray()[2]);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_BAR_BAR_BAR() {
		sut = new SlotMachine(1,3,10,3);
		String expected = "BAR";
		Collection<String> symbolStrings = sut.getSymbols();
		assertEquals(expected,symbolStrings.toArray()[0]);
		assertEquals(expected,symbolStrings.toArray()[1]);
		assertEquals(expected,symbolStrings.toArray()[2]);
	}
	
	@Test
	public void shouldReturnArrayWithStrings_000_FOO_BAR() {
		sut = new SlotMachine(1,3,10,3);
		Collection<String> symbolStrings = sut.getSymbols();
		assertEquals("000",symbolStrings.toArray()[0]);
		assertEquals("FOO",symbolStrings.toArray()[1]);
		assertEquals("BAR",symbolStrings.toArray()[2]);
	}

}

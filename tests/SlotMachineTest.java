package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.SlotMachine;

public class SlotMachineTest {
	
	private SlotMachine sut;

	@Before
	public void setUp() throws Exception {
		 sut = new SlotMachine(1,3);
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
	public void shouldReturnCredit10() {
		int expected = 10;
		int actual = sut.getCredit();
		assertEquals(expected,actual);
	}

}

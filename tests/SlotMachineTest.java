package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.SlotMachine;

public class SlotMachineTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnMinBet1() {
		SlotMachine sut = new SlotMachine(1);
		int expected = 1;
		int actual = sut.getMinBet();
		assertEquals(expected,actual);
	}
	
	@Test
	public void shouldReturnMaxBet3() {
		SlotMachine sut = new SlotMachine(1);
		int expected = 3;
		int actual = sut.getMaxBet();
		assertEquals(expected,actual);
	}

}

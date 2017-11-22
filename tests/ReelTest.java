package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Reel;

public class ReelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnString000() {
		Reel sut = new Reel();
		assertEquals("000", sut.getSymbol());
	}
	


}

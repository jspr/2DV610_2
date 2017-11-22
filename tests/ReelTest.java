package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Reel;
import model.Symbols;

public class ReelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnString000() {
		Random random = mock(Random.class);	
		Reel sut = new Reel(random);
		assertEquals("000", sut.getSymbol());
	}
	
	@Test
	public void shouldGenerateRandomSymbol() {	
		Random random = mock(Random.class);	
		Reel sut = new Reel(random);
		sut.spin();
		verify(random).nextInt(Symbols.values().length);	
	}
	


}

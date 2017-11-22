package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeast;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Reel;
import model.Symbols;

public class ReelTest {
	
	private Reel sut;
	private Random random;

	@Before
	public void setUp() throws Exception {
		random = mock(Random.class);
		sut = new Reel(random);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnString000() {
		when(random.nextInt(Symbols.values().length)).thenReturn(0);
		sut.spin();
		assertEquals("000", sut.getSymbol());
	}
	
	@Test
	public void shouldReturnStringFOO() {
		when(random.nextInt(Symbols.values().length)).thenReturn(8);
		sut.spin();
		assertEquals("FOO", sut.getSymbol());
	}
	
	@Test
	public void shouldReturnStringBAR() {
		when(random.nextInt(Symbols.values().length)).thenReturn(9);
		sut.spin();
		assertEquals("BAR", sut.getSymbol());
	}
	
	@Test
	public void shouldGenerateRandomSymbol() {	
		sut.spin();
		verify(random, atLeast(1)).nextInt(Symbols.values().length);	
	}
	


}

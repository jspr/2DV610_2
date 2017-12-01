package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Symbols;

public class SymbolsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void shouldReturnString000() {
		assertEquals("000", Symbols.SYMBOL_1.toString());
	}

	@Test
	public void shouldReturnStringBAR() {
		assertEquals("BAR", Symbols.SYMBOL_10.toString());
	}
	
	@Test
	public void shouldReturnWinTimesBet1() {
		assertEquals(1, Symbols.SYMBOL_1.getWinTimesBet());
	}
	
	@Test
	public void shouldReturnWinTimesBet5() {
		assertEquals(5, Symbols.SYMBOL_6.getWinTimesBet());
	}
	
	@Test
	public void shouldReturnWinTimesBet10() {
		assertEquals(10, Symbols.SYMBOL_9.getWinTimesBet());
	}

	@Test
	public void shouldReturnWinTimesBet100() {
		assertEquals(100, Symbols.SYMBOL_10.getWinTimesBet());
	}
	
	@Test
	public void shouldReturnValueOfString000() {
		assertEquals(Symbols.SYMBOL_1, Symbols.valueOf("SYMBOL_1"));
	}
	
	@Test
	public void shouldReturnValueOfStringBAR() {
		assertEquals(Symbols.SYMBOL_10, Symbols.valueOf("SYMBOL_10"));
	}
	


}

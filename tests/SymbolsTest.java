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

}

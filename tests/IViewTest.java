package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import view.EnglishView;
import view.IView;
import view.SwedishView;

@RunWith(Parameterized.class)
public class IViewTest {
// testing interfaces and implementations:
// https://stackoverflow.com/questions/6724401/how-to-write-junit-tests-for-interfaces
// http://junit.sourceforge.net/javadoc/org/junit/runners/Parameterized.html
	
	private IView sut;
	private static PrintStream printStream = mock(PrintStream.class);
	private static BufferedReader bufferedReader = mock(BufferedReader.class);
	private static TimeUnit timeUnit = mock(TimeUnit.class);
	
	public IViewTest(IView iView) {
        this.sut = iView;
    }
	
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	
    	Object col[][] = new Object[][] {
    		new Object[]{new EnglishView(printStream, bufferedReader, timeUnit)},
    		new Object[]{new SwedishView(printStream, bufferedReader, timeUnit)}
    	};
    	
    	return Arrays.asList(col);
    }

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldDisplayWelcomeMessage() {
		sut.displayWelcomeMessage();
		verify(printStream).println(sut.getWelcomeMessage());
	}
	
	@Test
	public void shouldDisplayInstructions() {
		sut.displayInstructions();
		verify(printStream).printf(sut.getInstructions(),sut.getSpinCommand(),sut.getQuitCommand());
	}
	
	@Test
	public void shouldDisplayQuitMessage() {
		sut.displayQuitMessage();
		verify(printStream).println(sut.getQuitMessage());
	}
	
	@Test
	public void shouldDisplayBettingMessageMin1Max3() {
		sut.displayBettingMessage(1, 3);
		verify(printStream).printf(sut.getBettingMessage(),1,3);
	}
	
	@Test
	public void shouldReturnFalseWantsToQuitOnInputSpinCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn(sut.getSpinCommand());
		sut.collectValidCommand();
		assertFalse(sut.wantsToQuit());
	}
	
	@Test
	public void shouldReturnTrueWantsToQuitOnInputQuitCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn(sut.getQuitCommand());
		sut.collectValidCommand();
		assertTrue(sut.wantsToQuit());
	}
	
	@Test
	public void shouldReturnFalseWantsToQuitOnInputOtherCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn("Z");
		sut.collectValidCommand();
		assertFalse(sut.wantsToQuit());
	}
	
	@Test
	public void shouldReturnTrueCollectValidCommandOnInputSpinCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn(sut.getSpinCommand());
		assertTrue(sut.collectValidCommand());
	}
	
	@Test
	public void shouldReturnTrueCollectValidCommandOnInputQuitCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn(sut.getQuitCommand());
		assertTrue(sut.collectValidCommand());
	}
	
	@Test
	public void shouldReturnFalseCollectValidCommandOnInvalidCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn("Z");
		assertFalse(sut.collectValidCommand());
	}
	
	@Test
	public void shouldDisplayCredit() {
		sut.displayCredit(1);
		verify(printStream).println(sut.getCreditMessage(1));
		sut.displayCredit(10);
		verify(printStream).println(sut.getCreditMessage(10));
	}
	
	@Test
	public void shouldDisplayGameOverMessage() {
		sut.displayGameOverMessage();
		verify(printStream).println(sut.getGameOverMessage());
	}
	
	@Test
	public void shouldReturnCollectionStringForPrintoutFor1ReelBAR() {
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("BAR");
		String expected = System.lineSeparator() +
				"  #########  " + System.lineSeparator() +
				"  #       #  " + System.lineSeparator() +
				"  #  BAR  #  " + System.lineSeparator() +
				"  #       #  " + System.lineSeparator() +
				"  #########  " + System.lineSeparator() +
				System.lineSeparator();
		Collection<String> returnedCollection = sut.getReelMessages(inputCollection);
		assertEquals(returnedCollection.size(),1);
		assertEquals(expected,returnedCollection.toArray()[0]);
	}
	
	@Test
	public void shouldReturnCollectionStringForPrintoutFor2ReelsBAR_FOO() {
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("BAR");
		inputCollection.add("FOO");
		String expected1 = System.lineSeparator() +
				"  #########  " + System.lineSeparator() +
				"  #       #  " + System.lineSeparator() +
				"  #  BAR  #  " + System.lineSeparator() +
				"  #       #  " + System.lineSeparator() +
				"  #########  " + System.lineSeparator() +
				System.lineSeparator();
		String expected2 = System.lineSeparator() +
				"  #########    #########  " + System.lineSeparator() +
				"  #       #    #       #  " + System.lineSeparator() +
				"  #  BAR  #    #  FOO  #  " + System.lineSeparator() +
				"  #       #    #       #  " + System.lineSeparator() +
				"  #########    #########  " + System.lineSeparator() +
				System.lineSeparator();
		Collection<String> returnedCollection = sut.getReelMessages(inputCollection);
		assertEquals(returnedCollection.size(),2);
		assertEquals(expected1,returnedCollection.toArray()[0]);
		assertEquals(expected2,returnedCollection.toArray()[1]);
	}
	
	@Test
	public void shouldDisplayReelMessage() throws InterruptedException {
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("BAR");
		inputCollection.add("FOO");
		inputCollection.add("001");	
		Collection<String> returnedCollection = sut.getReelMessages(inputCollection);
		sut.displayReelMessage(inputCollection);
		for(String string : returnedCollection) {
			verify(printStream, atLeast(2)).println(string);
		}
	}
	
	@Test
	public void shouldPauseWhenDisplayingReels() throws InterruptedException {
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("BAR");
		inputCollection.add("FOO");
		inputCollection.add("001");	
		sut.displayReelMessage(inputCollection);
		verify(timeUnit, atLeast(4)).sleep(1);
	}
	
	@Test
	public void shouldDisplayWinMessage5Credits() {
		sut.displayWinMessage(5);
		verify(printStream).printf(sut.getWinMessage() + System.lineSeparator(), 5);
	}
	
	@Test
	public void shouldDisplayLoseMessage() {
		sut.displayLoseMessage();
		verify(printStream).println(sut.getLoseMessage());
	}
	
	
	@Test
	public void shouldReturnFalseCollectValidBetOnInputX() throws IOException {
		when(bufferedReader.readLine()).thenReturn("X");
		assertFalse(sut.collectValidBet(1,3));
	}
	
	@Test
	public void shouldReturnFalseCollectValidBetOnInput0() throws IOException {
		when(bufferedReader.readLine()).thenReturn("0");
		assertFalse(sut.collectValidBet(1,3));
	}
	
	@Test
	public void shouldReturnFalseCollectValidBetOnInput10() throws IOException {
		when(bufferedReader.readLine()).thenReturn("10");
		assertFalse(sut.collectValidBet(1,3));
	}
	
	@Test
	public void shouldReturnTrueCollectValidBetOnInput1() throws IOException {
		when(bufferedReader.readLine()).thenReturn("1");
		assertTrue(sut.collectValidBet(1,3));
	}
	
	@Test
	public void shouldReturnTrueCollectValidBetOnInput3() throws IOException {
		when(bufferedReader.readLine()).thenReturn("3");
		assertTrue(sut.collectValidBet(1,3));
	}

	@Test
	public void shouldReturnGetBet1() throws IOException {
		int expected = 1;
		when(bufferedReader.readLine()).thenReturn("1");
		sut.collectValidBet(1,3);
		assertEquals(expected,sut.getBet());
	}
	
	@Test
	public void shouldReturnGetBet3() throws IOException {
		int expected = 3;
		when(bufferedReader.readLine()).thenReturn("3");
		sut.collectValidBet(1,3);
		assertEquals(expected,sut.getBet());
	}
	

}

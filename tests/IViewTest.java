package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import view.EnglishView;
import view.IView;

@RunWith(Parameterized.class)
public class IViewTest {
// testing interfaces and implementations:
// https://stackoverflow.com/questions/6724401/how-to-write-junit-tests-for-interfaces
// http://junit.sourceforge.net/javadoc/org/junit/runners/Parameterized.html
	
	private IView sut;
	private static PrintStream printStream = mock(PrintStream.class);
	private static BufferedReader bufferedReader = mock(BufferedReader.class);
	
	public IViewTest(IView iView) {
        this.sut = iView;
    }
	
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	
    	Object col[][] = new Object[][] {
    		new Object[]{new EnglishView(printStream, bufferedReader)}
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
		assertFalse(sut.wantsToQuit());
	}
	
	@Test
	public void shouldReturnTrueWantsToQuitOnInputQuitCharacter() throws IOException {
		when(bufferedReader.readLine()).thenReturn(sut.getQuitCommand());
		assertTrue(sut.wantsToQuit());
	}
	
	@Test
	public void shouldDisplayCredit() {
		sut.displayCredit(1);
		verify(printStream).println(sut.getCreditMessage(1));
		sut.displayCredit(10);
		verify(printStream).println(sut.getCreditMessage(10));
	}


}

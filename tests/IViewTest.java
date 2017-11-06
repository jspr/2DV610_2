package tests;

import static org.mockito.Mockito.*;
import org.junit.runners.Parameterized;

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
	
	public IViewTest(IView iView) {
        this.sut = iView;
    }
	
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	
    	Object col[][] = new Object[][] {
    		new Object[]{new EnglishView(printStream)}
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
		verify(printStream).println(sut.getInstructions());
	}
	
	@Test
	public void shouldDisplayQuitMessage() {
		sut.displayQuitMessage();
		verify(printStream).println("Thank you for playing! Bye for now.");
	}

}
